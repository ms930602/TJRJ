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
      	{
      		path:'/car_buy',
      		name:'car_buy',
      		component: () => import('@/view/car/car_buy.vue')
      	},{
      		path:'/car_sell',
      		name:'car_sell',
      		component: () => import('@/view/car/car_sell.vue')
      	},{
      		path:'/car_discover',
      		name:'car_discover',
      		component: () => import('@/view/car/car_discover.vue')
      	},
      ]
    },
    {
      path: '/car_xq',
      name: 'car_xq',
      component: () => import('@/view/car/car_xq.vue')
    },{
      path: '/car_list',
      name: 'car_list',
      component: () => import('@/view/car/car_list.vue')
    },
    
  ]
})
