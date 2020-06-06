<template>
	<div>
		<h3>Najnovejše meritve</h3>
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
						<div v-if="src">
							<p>Posneto: {{varoa_ustvarjena}} </p>
							<b-img
							:src="src"
							fluid alt="Dnevni odpad varoe"
							></b-img>

						</div>

						<p v-else-if="tezave_slika">
							Pri nalaganju slike je prišlo do težave.
						</p>
						<img
							v-else
							src="../assets/loader.gif"
						>
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
			src: "",
			tezave_slika: false,
			varoa_ustvarjena: "",
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
						return moment(value, "YYYY-MM-DDThh:mm:ssTZD").format('DD. MM. YYYY, HH:mm:ss')
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
		pridobiZadnjoVaroo: function(id) {
			fetch(global.restIp + "/varoa/latest?filter=podnica.id:EQ:" + id + "&order=cas_meritve DESC", {
				headers: {
						'Content-Disposition': 'inline'
					},
					responseType: 'blob',
					method: "get"
			})
				.then((response) => {
					if (response.ok) {
						this.varoa_ustvarjena = response.headers.get('created')
						this.tezave_slika = false
						return new Response(response.body)
					} else {
						this.tezave_slika = true
					}
					})
					.then(response => response.blob())
					.then(blob => URL.createObjectURL(blob))
					.then(url => {
						this.src = url
					})
					.catch(err => {
						console.error(err)
						this.tezave_slika = true
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
			this.pridobiZadnjoVaroo(id)
		}
	}


}
</script>

<style scoped>
.actual-container {
	margin-top:30px;
}
</style>

