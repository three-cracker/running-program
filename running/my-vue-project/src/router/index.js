import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    redirect:'/home',
    children:[
      {
        path:'/home',
        name:'home',
        component:()=>import('../views/home.vue')
      },
      {
        path:'/my',
        name:'my',
        component:()=>import('../views/my.vue')
      },
      {
        path:'/rank',
        name:'rank',
        component:()=>import('../views/rank.vue')
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: ()=>import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'register',
    component: ()=>import('../views/Register.vue')
  },
  {
    path: '/activity',
    name: 'activity',
    component: ()=>import('../views/Activity.vue')
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
