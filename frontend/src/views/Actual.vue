<template>
	<div>
		<h3>Najnovejše meritve</h3>
		<p>Izberite željeno podnico:</p>
		<!-- <b-dropdown id="dropdown-1" text="Podnica" class="m-md-2">
			<b-dropdown-item
				v-show="podnice.length"
				v-for="podnica in podnice"
				:key="podnica.id"
			>
				{{ podnica.naziv }}
			</b-dropdown-item> -->
			<!-- </b-dropdown> -->
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
					<b-col cols="12" md="6">
						<b-table
							striped
							hover
							:items="zadnjeMeritve"
							:fields="fields"
							v-if="zadnjeMeritve.length"
						>
						</b-table>
					</b-col>
					<b-col cols="12" md="6">
						<b-img src="https://picsum.photos/600/300/?image=41" fluid alt="Fluid image"></b-img>
					</b-col>
				</b-row>
			</b-container>


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
			zadnjeMeritve: [],
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
		pridobiZadnjeMeritve: function (id) {
			fetch(global.restIp + "/meritve/" + id + "/latest", {
				method: "get"
			})
				.then((response) => {
					return response.json()
				})
				.then((jsonData) => {
					console.log(jsonData)
					this.zadnjeMeritve = jsonData
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
			this.pridobiZadnjeMeritve(id)
		}
	}


}
</script>

<style scoped>
.actual-container {
	margin-top:30px;
}
</style>

