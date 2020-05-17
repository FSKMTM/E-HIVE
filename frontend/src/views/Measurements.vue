<template>
	<div>
		<h3>Vse meritve</h3>
        <div class="col col-sm-12 offset-sm-0 col-md-6 offset-md-3">
            <SelectPodnica
                v-if="podnice.length"
                @izbrana-podnica="izbranaPodnica"
                :podnice="podnice"
            >
            </SelectPodnica>
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
import SelectPodnica from '@/components/SelectPodnica'

export default {
	components: {
    SelectPodnica
  },
	props: {
		podnice: Array
	},
	data () {
    return {
            meritve: [],
            limit: 10,
            offset: 0,
            naloziVec: true,
            indeksIzbranePodnice: -1,
            totalCount: 100,
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
			fetch(global.restIp + "/meritve?filter=podnica.id:EQ:" + this.indeksIzbranePodnice + "&order=cas_meritve DESC&limit=" + this.limit + "&offset=" + this.offset, {
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
			}
		},

		izbranaPodnica(id) {
            this.indeksIzbranePodnice = id
			this.pridobiMeritve()
        }

	}


}
</script>

<style scoped>
.actual-container {
	margin-top:30px;
}
</style>

