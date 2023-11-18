import Vue from 'vue'
import VueRouter from 'vue-router'
import View from '@/views/View.vue'

Vue.use(VueRouter)


const routes = [
  {
      path: '/',
      component:View,
  }
]
const router = new VueRouter({
  routes,
  mode:'hash'
})

export default router
