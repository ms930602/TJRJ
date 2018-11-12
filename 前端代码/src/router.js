export default [{
        path: '/login',
        name: 'login',
        component: function(resolve) {
            require(['./views/login.vue'], resolve)
        },
    },
    {
        path: '/',
        name: 'index',
        component: function(resolve) {
            require(['./views/index.vue'], resolve)
        },
        children: [{
                path: '/',
                name: 'homepage',
                meta: {
                    father: '首页',
                    name: '首页',
                },
                component: function(resolve) {
                    require(['./views/homepage.vue'], resolve)
                }
            },
            {
                path: '/user',
                name: 'user',
                meta: {
                    father: '用户管理',
                    name: '用户管理',
                },
                component: function(resolve) {
                    require(['./views/user.vue'], resolve)
                }
            },
            {
                path: '/user_role',
                name: 'userRole',
                meta: {
                    father: '用户管理',
                    name: '角色管理',
                },
                component: function(resolve) {
                    require(['./views/userRole.vue'], resolve)
                }
            },{
                path: '/personinfo',
                name: 'personinfo',
                meta: {
                    father: '基础信息',
                    name: '人员信息',
                },
                component: function(resolve) {
                    require(['./views/basic/personinfo.vue'], resolve)
                }
            }, {
                path: '/game',
                name: 'game',
                meta: {
                    father: '基础信息',
                    name: '游戏信息',
                },
                component: function(resolve) {
                    require(['./views/basic/game.vue'], resolve)
                }
            }, {
                path: '/departmentinfo',
                name: 'departmentinfo',
                meta: {
                    father: '基础信息',
                    name: '部门信息',
                },
                component: function(resolve) {
                    require(['./views/basic/departmentinfo.vue'], resolve)
                }
            }, 

            {
                path: '/dataCategory',
                name: 'dataCategory',
                meta: {
                    father: '系统管理',
                    name: '数据分类',
                },
                component: function(resolve) {
                    require(['./views/system/dataCategory.vue'], resolve)
                }
            },
            {
                path: '/dataDictionary',
                name: 'dataDictionary',
                meta: {
                    father: '系统管理',
                    name: '数据字典',
                },
                component: function(resolve) {
                    require(['./views/system/dataDictionary.vue'], resolve)
                }
            },
            {
                path: '/item',
                name: 'item',
                meta: {
                    father: '基本数据管理',
                    name: '物品管理',
                },
                component: function(resolve) {
                    require(['./views/dataResource/item.vue'], resolve)
                }
            }, 

            {
                path: '/',
                name: 'statisticalAnalysis',
                meta: {
                    father: '统计分析',
                    name: '统计分析',
                },
                component: function(resolve) {
                    require(['./views/statisticalAnalysis/inventoryStatistics.vue'], resolve)
                }
            },
            {
                path: '/inventoryStatistics',
                name: 'inventoryStatistics',
                meta: {
                    father: '统计分析',
                    name: '库存统计',
                },
                component: function(resolve) {
                    require(['./views/statisticalAnalysis/inventoryStatistics.vue'], resolve)
                }
            },
            //二手车路由配置 -----start
            {
                path: '/carInfoMain',
                name: 'carInfoMain',
                meta: {
                    father: '车辆信息',
                    name: '车辆信息',
                },
                component: function(resolve) {
                    require(['./views/twocar/carInfoMain.vue'], resolve)
                }
            },{
                path: '/consultationMain',
                name: 'consultationMain',
                meta: {
                    father: '咨询信息',
                    name: '咨询信息',
                },
                component: function(resolve) {
                    require(['./views/twocar/consultationMain.vue'], resolve)
                }
            },{
                path: '/estimateMain',
                name: 'estimateMain',
                meta: {
                    father: '估价信息',
                    name: '估价信息',
                },
                component: function(resolve) {
                    require(['./views/twocar/estimateMain.vue'], resolve)
                }
            },{
                path: '/carUserMain',
                name: 'carUserMain',
                meta: {
                    father: '卖车信息',
                    name: '卖车信息',
                },
                component: function(resolve) {
                    require(['./views/twocar/carUserMain.vue'], resolve)
                }
            },{
                path: '/carInfo/a',
                name: 'carInfoA',
                meta: {
                    father: '车辆信息',
                    name: '车辆信息新增',
                    fatherpath: 'carInfoMain'
                },
                component: function(resolve) {
                    require(['./views/twocar/carInfoAU.vue'], resolve)
                }
            },

            {
                path: '/carInfo/u',
                name: 'carInfoU',
                meta: {
                    father: '车辆信息',
                    name: '车辆信息修改',
                    fatherpath: 'carInfoMain'
                },
                component: function(resolve) {
                    require(['./views/twocar/carInfoAU.vue'], resolve)
                }
            },{
                path: '/carBrandMain',
                name: 'carBrandMain',
                meta: {
                    father: '品牌管理',
                    name: '品牌管理',
                },
                component: function(resolve) {
                    require(['./views/twocar/carBrandMain.vue'], resolve)
                }
            },
			

            //微信路由配置 -----start
            {
                path: '/merchantMain',
                name: 'merchantMain',
                meta: {
                    father: '商户管理',
                    name: '商户管理',
                },
                component: function(resolve) {
                    require(['./views/vxBase/merchantMain.vue'], resolve)
                }
            },
            {
                path: '/activitiesMain',
                name: 'activitiesMain',
                meta: {
                    father: '推广活动管理',
                    name: '推广活动管理',
                },
                component: function(resolve) {
                    require(['./views/vxBase/activitiesMain.vue'], resolve)
                }
            },{
                path: '/activities/a',
                name: 'activitiesA',
                meta: {
                    father: '推广活动管理',
                    name: '推广活动新增',
                    fatherpath: 'activitiesMain'
                },
                component: function(resolve) {
                    require(['./views/vxBase/activitiesAU.vue'], resolve)
                }
            },

            {
                path: '/activities/u',
                name: 'activitiesU',
                meta: {
                    father: '推广活动管理',
                    name: '推广活动修改',
                    fatherpath: 'activitiesMain'
                },
                component: function(resolve) {
                    require(['./views/vxBase/activitiesAU.vue'], resolve)
                }
            },
            {
                path: '/promotersMain',
                name: 'promotersMain',
                meta: {
                    father: '推广人信息',
                    name: '推广人信息',
                },
                component: function(resolve) {
                    require(['./views/vxBase/promotersMain.vue'], resolve)
                }
            },
            {
                path: '/buyInfoMain',
                name: 'buyInfoMain',
                meta: {
                    father: '购买人信息',
                    name: '购买人信息',
                },
                component: function(resolve) {
                    require(['./views/vxBase/buyInfoMain.vue'], resolve)
                }
            },
            //微信路由配置 -----end
        ]
    }
]