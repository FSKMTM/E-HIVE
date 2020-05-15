<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="info">
            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
            <b-navbar-nav v-show="routes.length">
                <b-nav-item
									v-for="(route, index) in routes"
									:key="index"
								>
                    <router-link class="router-link" :to="route.path">
                        {{ route.name }}
                    </router-link>
                </b-nav-item>
            </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
export default {
	data() {
		return {
			routes: []
		}
	},
	created() {
		this.$router.options.routes.forEach(route => {
			this.routes.push({
				name: route.name,
				path: route.path
			})
		})
	}

}
</script>

<style scoped>
.router-link {
	color:white
}

</style>
