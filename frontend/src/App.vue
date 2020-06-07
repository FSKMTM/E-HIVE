<template>
  <div id="app">
    <div>
      <Topbar></Topbar>
    </div>
    <div>
      <div class="app-container">
        <router-view :podnice="podnice"></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import Topbar from '@/components/Topbar.vue'
import global from '@/global'

export default {
  components: {
    Topbar
  },
  data () {
    return {
      podnice: []
    }
  },
  created: function () {
    fetch(global.restIp + "/podnice", {
      method: "get"
    })
      .then((response) => {
        return response.json()
      })
      .then((jsonData) => {
        this.podnice = jsonData
      })
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

/* h2 {
  text-align: left;
} */



</style>
