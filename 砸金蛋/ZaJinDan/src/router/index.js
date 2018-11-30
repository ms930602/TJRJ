import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [{
        name:'index',
        redirect:'index',
        path:'/',
        component: () => import('@/view/index.vue')
      },{
      path: '/index',
      name: 'index',
      component: () => import('@/view/index.vue'),
      children:[
      	{
      		path:'/index',
      		name:'car_index',
      		component: () => import('@/view/car/car_index.vue')
      	},
      ]
    },
    
  ]
})
