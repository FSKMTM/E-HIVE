<template>
	<div>
		<h3>Vse meritve</h3>
        <div class="col col-sm-12 offset-sm-0 col-md-10 offset-md-1">
            <!-- <SelectPodnica
                v-if="podnice.length"
                @izbrana-podnica="izbranaPodnica"
                :podnice="podnice"
            >
            </SelectPodnica> -->
            <b-form @submit.prevent="search" >

                <b-form-group id="input-group-podnica" label="Izberi iskano podnico:" label-for="podnica">
                    <b-form-select
											v-show="podnice.length"
											v-model="form.indeksIzbranePodnice"
											:options="podnice"
											value-field="id"
											text-field="naziv"
											>
									</b-form-select>
                </b-form-group>

                <b-form-group id="input-group-tip" v-if="tipi.length" label="Izberi tip meritve:">
                    <b-form-checkbox-group v-model="form.checked" id="checkboxes-tip">
											<b-form-checkbox
											v-for="tip in tipi"
											:key="tip.koda"
											:value="tip.koda">{{ tip.ime }}</b-form-checkbox>
                    </b-form-checkbox-group>
                </b-form-group>

                <b-button type="submit" variant="primary">Poišči meritve</b-button>
                </b-form>
        </div>
        <b-container class="actual-container">
            <b-row>
                <b-col cols="12">
                    <b-table
                        striped
                        hover
                        :items="meritve"
                        :fields="fields"
                        v-if="meritve.length"
                    >
                    </b-table>
                </b-col>
            </b-row>
        </b-container>
        <scroll-loader
            v-if="meritve.length"
            v-show="naloziVec"
            :loader-method="pridobiMeritve"
            :loader-enable="naloziVec"

        >
        </scroll-loader>

	</div>
</template>

<script>
import global from '@/global'
import moment from 'moment'

export default {
	props: {
		podnice: Array
	},
	data () {
    return {
			meritve: [],
			tipi: [],
			limit: 10,
			offset: 0,
			naloziVec: true,
			totalCount: 100,
			form: {
          indeksIzbranePodnice: -1,
          checked: []
        },
			fields: [
				{
					key: "tip.koda",
					label: "Meritev",
					formatter: value => {
						return this.pridobiImeMeritve(value)
					}
				},
				{
					key: "vrednost",
					label: "Vrednost"
				},
				{
					key: "cas_meritve",
					label: "Čas",
					formatter: value => {
						return moment(value, "YYYY-MM-DDThh:mm:ssTZD").format('DD. MM. YYYY, hh:mm:ss')
					}
				}
			]
    }
  },
	methods: {
		pridobiMeritve: function () {
			console.log(global.restIp + "/meritve?" + this.iskalniNiz() + "&limit=" + this.limit + "&offset=" + this.offset + "&order=cas_meritve DESC")
			fetch(global.restIp + "/meritve?" + this.iskalniNiz() + "&limit=" + this.limit + "&offset=" + this.offset + "&order=cas_meritve DESC", {
				method: "get"
			})
				.then((response) => {
          this.totalCount = parseInt(response.headers.get('x-total-count'))
					return response.json()
				})
				.then((jsonData) => {
					console.log(jsonData)
					this.offset += this.limit
					this.meritve.push.apply(this.meritve, jsonData)
					if (this.meritve.length === this.totalCount) {
							this.naloziVec = false
					}
				})
		},
		pridobiImeMeritve: function(koda) {
			if (koda === "TEMP1") {
				return "Zunanja temperatura"
			} else if (koda === "TEMP2") {
				return "Notranja temperatura"
			} else if (koda === "VLA1") {
				return "Zunanja vlaga"
			} else if (koda === "VLA2") {
				return "Notranja vlaga"
			} else if (koda === "TEZA") {
				return "Teža"
			} else if (koda === "VAROA") {
				return "Varoa"
			}
		},

		izbranaPodnica(id) {
      this.form.indeksIzbranePodnice = id
			this.pridobiMeritve()
		},
		iskalniNiz() {
			return "filter=podnica.id:EQ:" + this.form.indeksIzbranePodnice + " tip.koda:IN:[" + this.form.checked + "]"
		},
		search() {
			this.offset = 0
			this.meritve = []
			this.pridobiMeritve()
		}

	},
	created: function () {
    fetch(global.restIp + "/tipi", {
      method: "get"
    })
      .then((response) => {
        return response.json()
      })
      .then((jsonData) => {
				const tipi = jsonData
				for (const i in tipi) {
					tipi[i].ime = this.pridobiImeMeritve(tipi[i].koda)
				}
				this.tipi = tipi
      })
  }


}
</script>

<style scoped>
.actual-container {
	margin-top:30px;
}
</style>

