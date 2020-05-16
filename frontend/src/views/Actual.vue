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
				<b-form-select
					v-show="podnice.length"
					v-model="izbranaPodnica"
					:options="podnice"
					value-field="id"
					text-field="naziv"
					@change="pridobiZadnjeMeritve"
					>
				</b-form-select>
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

export default {
	props: {
		podnice: Array
	},
	data () {
    return {
			izbranaPodnica: -1,
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
		pridobiZadnjeMeritve: function () {
			fetch(global.restIp + "/meritve?filter=podnica.id:EQ:" + this.izbranaPodnica, {
				method: "get"
			})
				.then((response) => {
					return response.json()
				})
				.then((jsonData) => {
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
		}
	},
	watch: {
		podnice: function(newVal, oldVal) {
			if (oldVal.length === 0) {
				this.izbranaPodnica = newVal[0].id
				this.pridobiZadnjeMeritve()
			}
		}
	},
	created: function() {
		if (this.podnice.length) {
			this.izbranaPodnica = this.podnice[0].id
			this.pridobiZadnjeMeritve()
		}
	}

}
</script>

<style scoped>
.actual-container {
	margin-top:30px;
}
</style>

