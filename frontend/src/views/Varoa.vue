<template>
	<b-container class="varoa-container">
		<h3>Dnevni odpad varoe</h3>
        <div class="col col-sm-12 offset-sm-0 col-md-10 offset-md-1">
					<div class="col col-12 col-md-6 offset-md-3">
            <SelectPodnica
                v-if="podnice.length"
                @izbrana-podnica="izbranaPodnica"
                :podnice="podnice"
            >
            </SelectPodnica>
					</div>
						<!-- <b-alert
							:show="manjkajocePolje"
							variant="danger"
						>
							Izpolnite vsa polja!
						</b-alert> -->
					<!-- <b-form-group id="input-group-podnica" label="Izberi iskano podnico:" label-for="podnica">
						<b-form-select
							v-show="podnice.length"
							v-model="form.indeksIzbranePodnice"
							:options="podnice"
							value-field="id"
							text-field="naziv"
							>
						</b-form-select>
					</b-form-group> -->





					<div class="col col-12 col-md-6 offset-md-3">
						<b-form-group label="Izberi dan:">
							<DatePicker
									v-model="datepicker.date"
									:format="datepicker.format"
									class="datepicker"
									@change="izbraniDatum"
							>
							</DatePicker>
						</b-form-group>
					</div>



        </div>
        <b-container class="varoa-container">
					<b-carousel
						v-if="varoaSlike.length"
						id="carousel"
						controls
						indicators
						background="#ababab"
						img-width="1024"
						img-height="480"
						style="text-shadow: 1px 1px 2px #333;"

					>
						<!-- Text slides with image -->
						<b-carousel-slide
							v-for="(varoa, index) in varoaSlike"
							:key="index"
							:caption="varoa.ustvarjeno"
							:img-src="varoa.src"
						></b-carousel-slide>

						<!-- Slide with blank fluid image to maintain slide aspect ratio -->
						<!-- <b-carousel-slide caption="Blank Image" img-blank img-alt="Blank image">
							<p>
								Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eros felis, tincidunt
								a tincidunt eget, convallis vel est. Ut pellentesque ut lacus vel interdum.
							</p>
						</b-carousel-slide> -->
					</b-carousel>
					<b-alert
							:show="tezave_slika"
							variant="danger"
						>
							Prišlo je do težave pri pridobivanju slike dnevnega odpada. Slika verjetno ne obstaja.
						</b-alert>
        </b-container>


	</b-container>
</template>
<script>
import global from '@/global'
import moment from 'moment'
import DatePicker from 'vue2-datepicker'
import 'vue2-datepicker/index.css'
import 'vue2-datepicker/locale/sl'
import SelectPodnica from '@/components/SelectPodnica'

export default {
	components: {
		DatePicker,
		SelectPodnica
	},
	props: {
		podnice: Array
	},
	data () {
    return {
			limit: 1,
			offset: 0,
			totalCount: 100,
			manjkajocePolje: false,
			izbranaPodnicaIndex: -1,
			varoa_ustvarjena: "",
			datepicker: {
				date: null,
				showSecond: false,
				format: 'DD. MM. YYYY'
			},
			varoaSlike: [],
			tezave_slika: false
		}
	},
	methods: {
		izbranaPodnica(id) {
			this.reset()
			this.izbranaPodnicaIndex = id
			this.pridobiVaroaSlike()
		},
		izbraniDatum() {
			this.reset()
			this.pridobiVaroaSlike()
		},
		pridobiVaroaSlike() {
			this.pridobiVaroo(this.izbranaPodnicaIndex)

		},
		reset() {
			this.varoaSlike = []
			this.offset = 0
			this.totalCount = 100
		},
		encodeDate(m) {
			return m.format("YYYY-MM-DDTHH:mm:ssZ").replace("+", "%2B")
		},
		zacetekDate(date) {
			return this.encodeDate(moment(date).startOf('day'))
		},
		konecDate(date) {
			return this.encodeDate(moment(date).add(1, "day").startOf('day'))
		},
		pridobiVaroo(id) {
			fetch(global.restIp + "/varoa?filter=podnica.id:EQ:" + id + " cas_meritve:GTE:'" + this.zacetekDate(this.datepicker.date) + "' cas_meritve:LT:'" + this.konecDate(this.datepicker.date) + "' &order=cas_meritve DESC&limit=1&offset=" + this.offset, {
				headers: {
						'Content-Disposition': 'inline'
					},
					responseType: 'blob',
					method: "get"
			})
			.then((response) => {
				this.offset += 1
				this.totalCount = response.headers.get('x-total-count')
				if (response.ok) {
					this.varoa_ustvarjena = response.headers.get('created')
					this.tezave_slika = false
					return new Response(response.body)
				} else {
					this.tezave_slika = true
					throw new Error("Težave pri pridobivanju slike")
				}
				})
				.then(response => response.blob())
				.then(blob => URL.createObjectURL(blob))
				.then(url => {
					var varoa = { src: url, ustvarjeno: this.varoa_ustvarjena }
					this.varoaSlike.push(varoa)
					if (this.offset < this.totalCount) {
						this.pridobiVaroaSlike()
					}
				})
				.catch(err => {
					console.error(err)
					this.tezave_slika = true
				})
		}
	},
	created: function () {
		this.datepicker.date = moment().toDate()
  }
}
</script>

<style scoped>
.datepicker {
	width: 100%
}
.varoa-container {
	margin-top:30px;
	margin-bottom:30px;
}

</style>