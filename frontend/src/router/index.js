import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../views/Home.vue'
import Actual from '../views/Actual.vue'
import Graphs from '../views/Graphs.vue'
import Varoa from '../views/Varoa.vue'
import Traffic from '../views/Traffic.vue'
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
    path: '/grafi',
    name: 'Graphs',
    component: Graphs
  },
  {
    path: '/promet',
    name: 'Promet',
    component: Traffic
  },
  {
    path: '/meritve',
    name: 'Meritve',
    component: Measurements
  },
  {
    path: '/nastavitve',
    name: 'Nastavitve',
    component: Settings
  },
  {
    path: '/varoa',
    name: 'Varoa',
    component: Varoa
  }

]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
