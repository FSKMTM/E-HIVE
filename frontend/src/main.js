import Vue from 'vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import moment from 'moment'
import ScrollLoader from 'vue-scroll-loader'

import App from './App.vue'
import router from './router'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(ScrollLoader)

Vue.config.productionTip = false

Vue.prototype.moment = moment

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
