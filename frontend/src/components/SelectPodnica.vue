<template>
    <div>
        <b-form-select
            v-show="podnice.length"
            v-model="izbranaPodnica"
            :options="podnice"
            value-field="id"
            text-field="naziv"
            @change="spremembaIzbranePodnice"
            >
        </b-form-select>
    </div>
</template>

<script>
export default {
  props: {
		podnice: Array
	},
	data () {
    return {
			izbranaPodnica: -1
    }
	},
	methods: {
		spremembaIzbranePodnice() {
			this.$emit('izbrana-podnica', this.izbranaPodnica)
		}
	},
	watch: {
		podnice: function(newVal, oldVal) {
			if (oldVal.length === 0) {
				this.izbranaPodnica = newVal[0].id
				this.spremembaIzbranePodnice()
			}
		}
	},
	created: function() {
		if (this.podnice.length) {
			this.izbranaPodnica = this.podnice[0].id
			this.spremembaIzbranePodnice()
		}
	}

}
</script>