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
                path: '/',
                name: 'equipment',
                meta: {
                    father: '设备管理',
                    name: '设备管理',
                },
                component: function(resolve) {
                    require(['./views/equipment/devicerun.vue'], resolve)
                }
            },
            {
                path: '/devicerun',
                name: 'devicerun',
                meta: {
                    father: '设备管理',
                    name: '设备运行管理',
                },
                component: function(resolve) {
                    require(['./views/equipment/devicerun.vue'], resolve)
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
        ]
    }
]