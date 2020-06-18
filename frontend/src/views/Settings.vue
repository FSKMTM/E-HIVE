<template>
	<b-container class="settings-container">
		<h3>Nastavitve za podnice</h3>
			<br>
			<div class="col col-sm-12 offset-sm-0 col-md-8 offset-md-2">
				<b-table striped hover :items="podnice"></b-table>
				<b-button variant="info" v-b-modal.modal-dodaj>Dodaj podnico</b-button>
			</div>

			<b-modal
				id="modal-dodaj"
				ref="modal"
				title="Dodaj podnico"
				@show="resetModal"
				@hidden="resetModal"
				@ok="handleOk"
				cancel-title="Zapri"
				ok-variant="info"
			>
				<form ref="form" @submit.stop.prevent="handleSubmit">
					<b-form-group
						:state="stanjeNaziva"
						label="Naziv"
						label-for="naziv-input"
						invalid-feedback="Potrebno je vnesti naziv"
					>
						<b-form-input
							id="naziv-input"
							v-model="naziv"
							:state="stanjeNaziva"
							required
						></b-form-input>
					</b-form-group>
				</form>
			</b-modal>

	</b-container>
</template>

<script>
import global from '@/global'

export default {
	props: {
		podnice: Array
	},
	data () {
    return {
			naziv: '',
			stanjeNaziva: null
		}
	},
	methods: {
		checkFormValidity() {
			const valid = this.$refs.form.checkValidity()
			this.stanjeNaziva = valid
			return valid
		},
		resetModal() {
			this.naziv = ''
			this.stanjeNaziva = null
		},
		handleOk(bvModalEvt) {
			bvModalEvt.preventDefault()
			this.handleSubmit()
		},
		handleSubmit() {
			if (!this.checkFormValidity()) {
				return
			}
			this.ustvariPodnico()
			this.$nextTick(() => {
				this.$bvModal.hide('modal-dodaj')
			})
		},
		ustvariPodnico() {
			fetch(global.restIp + "/podnice", {
				method: "post",
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({
					naziv: this.naziv
				})
			})
				.then((response) => {
					return response.json()
				})
				.then((jsonData) => {
					/* console.log(jsonData) */
					this.podnice.push(jsonData)
				})
		}
	}
}
</script>

<style scoped>
.settings-container {
	margin-top:60px;
}

</style>