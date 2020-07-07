<template>
	<b-container class="settings-container">
		<h3>Nastavitve za podnice</h3>
			<br>
			<div class="col col-sm-12 offset-sm-0 col-md-8 offset-md-2">
				<b-table striped hover :items="items">
					<template v-slot:cell(uredi)="data">
						<button class="uredi" @click.prevent="modalUredi(data.item.uredi)">
							<b-icon icon="pencil-square"></b-icon>
						</button>

					</template>
				</b-table>
				<b-button variant="info" v-b-modal.modal-dodaj>Dodaj podnico</b-button>
			</div>

			<b-modal
				id="modal-dodaj"
				ref="modal"
				title="Dodaj podnico"
				@show="resetAddModal"
				@hidden="resetAddModal"
				@ok="handleAddOk"
				cancel-title="Zapri"
				ok-variant="info"
			>
				<form ref="form" @submit.stop.prevent="handleAddSubmit">
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

			<b-modal
				id="modal-uredi"
				ref="modal"
				title="Uredi podnico"
				@show="resetUpdateModal"
				@hidden="resetUpdateModal"
				@ok="handleUpdateOk"
				cancel-title="Zapri"
				ok-variant="info"
			>
				<form ref="form" @submit.stop.prevent="handleUpdateSubmit">
					<b-form-group
						:state="stanjeNaziva"
						label="Naziv"
						label-for="naziv-input"
						invalid-feedback="Potrebno je vnesti naziv"
					>
						<b-form-input
							id="naziv-update"
							v-model="nazivUredi"
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
			stanjeNaziva: null,
			items: [],
			index: -1,
			nazivUredi: ''
		}
	},
	methods: {
		checkAddFormValidity() {
			const valid = this.$refs.form.checkValidity()
			this.stanjeNaziva = valid
			return valid
		},
		resetAddModal() {
			this.naziv = ''
			this.stanjeNaziva = null
		},
		handleAddOk(bvModalEvt) {
			bvModalEvt.preventDefault()
			this.handleAddSubmit()
		},
		handleAddSubmit() {
			if (!this.checkAddFormValidity()) {
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
		},
		checkUpdateFormValidity() {
			const valid = this.$refs.form.checkValidity()
			this.stanjeNaziva = valid
			return valid
		},
		resetUpdateModal() {
			/* this.nazivUredi = '' */
			this.stanjeNaziva = null
		},
		handleUpdateOk(bvModalEvt) {
			bvModalEvt.preventDefault()
			this.handleUpdateSubmit()
		},
		handleUpdateSubmit() {
			if (!this.checkUpdateFormValidity()) {
				return
			}
			this.urediPodnico()
			this.$nextTick(() => {
				this.$bvModal.hide('modal-uredi')
			})
		},
		urediPodnico() {
			var id = this.items[this.index].id
			fetch(global.restIp + "/podnice/" + id, {
				method: "put",
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({
					naziv: this.nazivUredi
				})
			})
				.then((response) => {
					return response.json()
				})
				.then((jsonData) => {
					/* console.log(jsonData) */
					this.odstraniPodnico(id)
					this.podnice.push(jsonData)
				})
		},
		odstraniPodnico(id) {
			var index = -1
			for (var i = 0; i < this.podnice.length; i++) {
				if (this.podnice[i].id === id) {
					index = i
				}
			}
			this.podnice.splice(index, 1)
		},
		modalUredi(index) {
			this.index = index
			this.nazivUredi = this.items[index].naziv
			this.$bvModal.show('modal-uredi')

		},
		compare(podnica1, podnica2) {
			if (podnica1.id < podnica2.id) {
				return -1
			} else if (podnica1.id > podnica2.id) {
				return 1
			}
			return 0
		}

	},
	watch: {
		podnice: {
			handler: function(newVal, oldVal) {
				var tmp = newVal.slice().sort(this.compare)
				this.items = []
				for (var i = 0; i < tmp.length; i++) {
					var item = tmp[i]
					item.uredi = i
					this.items.push(item)
				}
			}
		},
		deep: true
	}
}
</script>

<style scoped>
.settings-container {
	margin-top:60px;
	margin-bottom:20px;
}
.uredi {
	border: solid 1px;
	border-radius: 3px;
}

</style>