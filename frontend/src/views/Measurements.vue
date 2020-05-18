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
						<b-alert
							:show="manjkajocePolje"
							variant="danger"
						>
							Izpolnite vsa polja!
						</b-alert>
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
                    <b-form-checkbox-group
											v-model="form.checked"
											id="checkboxes-tip"

										>
											<b-form-checkbox
												v-for="tip in tipi"
												:key="tip.koda"
												:value="tip.koda"
											>
													{{ tip.ime }}
											</b-form-checkbox>
                    </b-form-checkbox-group>
                </b-form-group>
								<!-- <div class="container datepicker-container"> -->
									<div class="row">
										<div class="col col-12 col-md-6">
											<b-form-group label="Od:">
												<DatePicker
													type="datetime"
													v-model="datepicker.datetimeFrom"
													:show-second="datepicker.showSecond"
													:format="datepicker.format"
													class="datepicker"
												>
												</DatePicker>
											</b-form-group>
										</div>
										<div class="col col-12 col-md-6">
											<b-form-group label="Do:">
												<DatePicker
													type="datetime"
													v-model="datepicker.datetimeTo"
													:show-second="datepicker.showSecond"
													:format="datepicker.format"
													class="datepicker"
												>
												</DatePicker>
											</b-form-group>
										</div>
									</div>
								<!-- </div> -->


                <b-button type="submit" variant="primary">Poišči meritve</b-button>
                </b-form>
        </div>
        <b-container class="measurements-container">
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
										<p
											v-else-if="vsajEnoPridobivanjeMeritev"
										>
											Nobena meritev ne ustreza iskalni zahtevi
										</p>
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
import DatePicker from 'vue2-datepicker'
import 'vue2-datepicker/index.css'
import 'vue2-datepicker/locale/sl'

export default {
	components: {
    DatePicker
  },
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
			vsajEnoPridobivanjeMeritev: false,
			manjkajocePolje: false,
			datepicker: {
				datetimeFrom: null,
				datetimeTo: null,
				showSecond: false,
				format: 'DD. MM. YYYY, HH:mm'
			},

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
						return moment(value, "YYYY-MM-DDTHH:mm:ssTZD").format('DD. MM. YYYY, HH:mm:ss')
					}
				}
			]
    }
  },
	methods: {
		pridobiMeritve: function () {
			fetch(global.restIp + "/meritve?" + this.iskalniNiz() + "&limit=" + this.limit + "&offset=" + this.offset + "&order=cas_meritve DESC", {
				method: "get"
			})
				.then((response) => {
          this.totalCount = parseInt(response.headers.get('x-total-count'))
					return response.json()
				})
				.then((jsonData) => {
					console.log(jsonData)
					this.vsajEnoPridobivanjeMeritev = true
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
			return "filter=podnica.id:EQ:" + this.form.indeksIzbranePodnice + " tip.koda:IN:[" + this.form.checked + "]" + " cas_meritve:LTE:'" + this.encodeDate(this.datepicker.datetimeTo) + "'" + " cas_meritve:GTE:'" + this.encodeDate(this.datepicker.datetimeFrom) + "'"
		},
		encodeDate(date) {
			return moment(date).format("YYYY-MM-DDThh:mm:ssZ").replace("+", "%2B")
		},
		search() {
			if (this.form.checked.length === 0 || this.indeksIzbranePodnice < 0 || this.datepicker.datetimeFrom === null || this.datepicker.datetimeTo === null) {
				this.manjkajocePolje = true
			} else {
				this.manjkajocePolje = false
				this.offset = 0
				this.meritve = []
				this.pridobiMeritve()
			}
		}
	},

	created: function () {
		this.datepicker.datetimeFrom = moment().subtract(30, "days").toDate()
		this.datepicker.datetimeTo = moment().toDate()
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
.datepicker {
	width: 100%
}
.measurements-container {
	margin-top:30px;
}
/* .datepicker-container {
	margin: 0px
} */

</style>

