import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../views/Home.vue'
import Actual from '../views/Actual.vue'
import Varoa from '../views/Varoa.vue'
import Measurements from '../views/Measurements.vue'
import Settings from '../views/Settings.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'E-HIVE',
    component: Home
  },
  {
    path: '/aktualno',
    name: 'Aktualno',
    component: Actual
  },
  {
    path: '/meritve',
    name: 'Meritve',
    component: Measurements
  },
  {
    path: '/varoa',
    name: 'Varoa',
    component: Varoa
  },
  {
    path: '/nastavitve',
    name: 'Nastavitve',
    component: Settings
  }


]

const router = new VueRouter({
  /* mode: 'history', */
  routes
})

export default router
