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
            // {
            //     path: '/',
            //     name: 'user',
            //     meta: {
            //         father: '用户管理',
            //         name: '用户管理',
            //     },
            //     component: function(resolve) {
            //         require(['./views/user.vue'], resolve)
            //     }
            // },
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
            },

            // {
            //     path: '/',
            //     name: 'basic',
            //     meta: {
            //         father: '基础信息',
            //         name: '基础信息',
            //     },
            //     component: function(resolve) {
            //         require(['./views/basic/floorinfo.vue'], resolve)
            //     }
            // },
            {
                path: '/subversionMain',
                name: 'subversionMain',
                meta: {
                    father: '基础信息',
                    name: '版本管理',
                },
                component: function(resolve) {
                    require(['./views/basic/subversionMain.vue'], resolve)
                }
            },
            {
                path: '/floorinfo',
                name: 'floorinfo',
                meta: {
                    father: '基础信息',
                    name: '楼层管理',
                },
                component: function(resolve) {
                    require(['./views/basic/floorinfo.vue'], resolve)
                }
            },
            {
                path: '/areainfo',
                name: 'areainfo',
                meta: {
                    father: '基础信息',
                    name: '仓库区域',
                },
                component: function(resolve) {
                    require(['./views/basic/areainfo.vue'], resolve)
                }
            },
            {
                path: '/merchant',
                name: 'merchant',
                meta: {
                    father: '基础信息',
                    name: '客商管理',
                },
                component: function(resolve) {
                    require(['./views/basic/merchant.vue'], resolve)
                }
            },
            {
                path: '/locationInfo',
                name: 'locationInfo',
                meta: {
                    father: '基础信息',
                    name: '货位信息',
                },
                component: function(resolve) {
                    require(['./views/basic/locationInfo.vue'], resolve)
                }
            }, {
                path: '/passway',
                name: 'passway',
                meta: {
                    father: '基础信息',
                    name: '仓库通道',
                },
                component: function(resolve) {
                    require(['./views/basic/passway.vue'], resolve)
                }
            },
            {
                path: '/measureunit',
                name: 'measureunit',
                meta: {
                    father: '基础信息',
                    name: '计量单位',
                },
                component: function(resolve) {
                    require(['./views/basic/measureunit.vue'], resolve)
                }
            },
            {
                path: '/deviceVersionManager',
                name: 'deviceVersionManager',
                meta: {
                    father: '系统管理',
                    name: '系统版本管理',
                },
                component: function(resolve) {
                    require(['./views/basic/deviceVersionManager.vue'], resolve)
                }
            },
            {
                path: '/warehouseinfo',
                name: 'warehouseinfo',
                meta: {
                    father: '基础信息',
                    name: '仓库信息',
                },
                component: function(resolve) {
                    require(['./views/basic/warehouseinfo.vue'], resolve)
                }
            }, {
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
                path: '/packspec',
                name: 'packspec',
                meta: {
                    father: '基础信息',
                    name: '包装规格',
                },
                component: function(resolve) {
                    require(['./views/basic/packspec.vue'], resolve)
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
            }, {
                path: '/materialinfo',
                name: 'materialinfo',
                meta: {
                    father: '基础信息',
                    name: '物料信息',
                },
                component: function(resolve) {
                    require(['./views/basic/materialinfo.vue'], resolve)
                }
            },
            {
                path: '/materstorerules',
                name: 'materstorerules',
                meta: {
                    father: '基础信息',
                    name: '物料存放规则',
                },
                component: function(resolve) {
                    require(['./views/basic/materstorerules.vue'], resolve)
                }
            },
            {
                path: '/numcoderules',
                name: 'numcoderules',
                meta: {
                    father: '基础信息',
                    name: '单号编码规则',
                },
                component: function(resolve) {
                    require(['./views/basic/numcoderules.vue'], resolve)
                }
            },
            {
                path: '/discreterestructrules',
                name: 'discreterestructrules',
                meta: {
                    father: '基础信息',
                    name: '散盘重组规则',
                },
                component: function(resolve) {
                    require(['./views/basic/discreterestructrules.vue'], resolve)
                }
            }, {
                path: '/devpos',
                name: 'devpos',
                meta: {
                    father: '设备管理',
                    name: '手持终端',
                },
                component: function(resolve) {
                    require(['./views/equipment/devpos.vue'], resolve)
                }
            },

            {
                path: '/vehicleterminal',
                name: 'vehicleterminal',
                meta: {
                    father: '设备管理',
                    name: '车载终端',
                },
                component: function(resolve) {
                    require(['./views/equipment/devvehicleterminal.vue'], resolve)
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
                path: '/terminalConfig',
                name: 'terminalConfig',
                meta: {
                    father: '系统管理',
                    name: '终端配置管理',
                },
                component: function(resolve) {
                    require(['./views/system/terminalConfig.vue'], resolve)
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
                    require(['./views/equipment/hoist.vue'], resolve)
                }
            },
            {
                path: '/hoist',
                name: 'hoist',
                meta: {
                    father: '设备管理',
                    name: '提升机管理',
                },
                component: function(resolve) {
                    require(['./views/equipment/hoist.vue'], resolve)
                }
            },
            {
                path: '/fragileconsum',
                name: 'fragileconsum',
                meta: {
                    father: '设备管理',
                    name: '易损易耗件管理',
                },
                component: function(resolve) {
                    require(['./views/equipment/fragileconsum.vue'], resolve)
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
            }, {
                path: '/devLpr',
                name: 'devLpr',
                meta: {
                    father: '设备管理',
                    name: '车牌识别管理',
                },
                component: function(resolve) {
                    require(['./views/equipment/devLpr.vue'], resolve)
                }
            }, {
                path: '/devLed',
                name: 'devLed',
                meta: {
                    father: '设备管理',
                    name: 'LED显示器管理',
                },
                component: function(resolve) {
                    require(['./views/equipment/devLed.vue'], resolve)
                }
            },
            {
                path: '/',
                name: 'warehouse',
                meta: {
                    father: '仓库作业',
                    name: '仓库作业',
                },
                component: function(resolve) {
                    require(['./views/warehouse/cigaretteentry.vue'], resolve)
                }
            },
            {
                path: '/cigaretteentry',
                name: 'cigaretteentry',
                meta: {
                    father: '仓库作业',
                    name: '卷烟入库',
                },
                component: function(resolve) {
                    require(['./views/warehouse/cigaretteentry.vue'], resolve)
                }
            }, {
                path: '/positionadjustmain',
                name: 'positionadjustmain',
                meta: {
                    father: '仓库作业',
                    name: '货位调整',
                },
                component: function(resolve) {
                    require(['./views/warehouse/positionadjustmain.vue'], resolve)
                }
            }, {
                path: '/positionadjustmain/a',
                name: 'positionadjustmainA',
                meta: {
                    father: '货位调整',
                    name: '货位调整新增',
                    fatherpath: 'positionadjustmain'
                },
                component: function(resolve) {
                    require(['./views/warehouse/positionadjustmainAU.vue'], resolve)
                }
            }, {
                path: '/positionadjustmain/u',
                name: 'positionadjustmainU',
                meta: {
                    father: '货位调整',
                    name: '货位调整修改',
                    fatherpath: 'positionadjustmain'
                },
                component: function(resolve) {
                    require(['./views/warehouse/positionadjustmainAU.vue'], resolve)
                }
            }, {
                path: '/positionadjustmain/r',
                name: 'positionadjustmainR',
                meta: {
                    father: '货位调整',
                    name: '货位调整查看',
                    fatherpath: 'positionadjustmain'
                },
                component: function(resolve) {
                    require(['./views/warehouse/positionadjustmainAU.vue'], resolve)
                }
            }, {
                path: '/stockinventory',
                name: 'stockinventory',
                meta: {
                    father: '仓库作业',
                    name: '库存盘点',
                },
                component: function(resolve) {
                    require(['./views/warehouse/stockinventory.vue'], resolve)
                }
            }, {
                path: '/stockcheckmain/a',
                name: 'stockcheckmainA',
                meta: {
                    father: '库存盘点',
                    name: '盘点信息新增',
                    fatherpath: 'stockinventory'
                },
                component: function(resolve) {
                    require(['./views/warehouse/stockcheckmainAU.vue'], resolve)
                }
            }, 

            {
                path: '/stockcheckmain/u',
                name: 'stockcheckmainU',
                meta: {
                    father: '库存盘点',
                    name: '盘点信息修改',
                    fatherpath: 'stockinventory'
                },
                component: function(resolve) {
                    require(['./views/warehouse/stockcheckmainAU.vue'], resolve)
                }
            }, {
                path: '/stockcheckmain/r',
                name: 'stockcheckmainR',
                meta: {
                    father: '库存盘点',
                    name: '盘点信息查看',
                    fatherpath: 'stockinventory'
                },
                component: function(resolve) {
                    require(['./views/warehouse/stockcheckmainAU.vue'], resolve)
                }
            },
            {
                path: '/stockcheckmain/trim',
                name: 'stockcheckmainTrim',
                meta: {
                    father: '库存盘点',
                    name: '盘点信息录入',
                    fatherpath: 'stockinventory'
                },
                component: function(resolve) {
                    require(['./views/warehouse/stockcheckmainTrim.vue'], resolve)
                }
            },
            {
                path: '/addinventory',
                name: 'addinventory',
                meta: {
                    father: '卷烟入库',
                    name: '新增入库单',
                    fatherpath: 'cigaretteentry'
                },
                component: function(resolve) {
                    require(['./views/warehouse/addinventory.vue'], resolve)
                }
            },

            {
                path: '/updateinventory',
                name: 'updateinventory',
                meta: {
                    father: '卷烟入库',
                    name: '修改入库单',
                    fatherpath: 'cigaretteentry'
                },
                component: function(resolve) {
                    require(['./views/warehouse/updateinventory.vue'], resolve)
                }
            },
            {
                path: '/deliver',
                name: 'deliver',
                meta: {
                    father: '仓库作业',
                    name: '卷烟出库',
                },
                component: function(resolve) {
                    require(['./views/warehouse/deliver.vue'], resolve)
                }
            },
            {
                path: '/deliveradd',
                name: 'deliveradd',
                meta: {
                    father: '卷烟出库',
                    name: '添加出库信息',
                    fatherpath: 'deliver'
                },
                component: function(resolve) {
                    require(['./views/warehouse/deliveradd.vue'], resolve)
                }
            },
            {
                path: '/deliveredit',
                name: 'deliveredit',
                meta: {
                    father: '卷烟出库',
                    name: '编辑出库信息',
                    fatherpath: 'deliver'
                },
                component: function(resolve) {
                    require(['./views/warehouse/deliveredit.vue'], resolve)
                }
            },
            {
                path: '/deliversearch',
                name: 'deliversearch',
                meta: {
                    father: '卷烟出库',
                    name: '查看出库信息',
                    fatherpath: 'deliver'
                },
                component: function(resolve) {
                    require(['./views/warehouse/deliversearch.vue'], resolve)
                }
            },
            {
                path: '/processtracing',
                name: 'processtracing',
                meta: {
                    father: '仓库作业',
                    name: '过程追踪',
                },
                component: function(resolve) {
                    require(['./views/warehouse/processtracing.vue'], resolve)
                }
            }, {
                path: '/queryprocessinfo',
                name: 'queryprocessinfo',
                meta: {
                    father: '过程追踪',
                    name: '过程追踪详细信息',
                    fatherpath: 'processtracing'
                },
                component: function(resolve) {
                    require(['./views/warehouse/queryprocessinfo.vue'], resolve)
                }
            },
            {
                path: '/inventorywarning',
                name: 'inventorywarning',
                meta: {
                    father: '仓库作业',
                    name: '库存预警报警',
                },
                component: function(resolve) {
                    require(['./views/warehouse/inventorywarning.vue'], resolve)
                }
            },
            {
                path: '/unqualifiedproduct',
                name: 'unqualifiedproduct',
                meta: {
                    father: '仓库作业',
                    name: '不合格处理',
                },
                component: function(resolve) {
                    require(['./views/warehouse/unqualifiedproduct.vue'], resolve)
                }
            },
            {
                path: '/',
                name: 'comprehensivequery',
                meta: {
                    father: '综合查询',
                    name: '综合查询',
                },
                component: function(resolve) {
                    require(['./views/comprehensivequery/inventoryinformation.vue'], resolve)
                }
            },
            {
                path: '/inventoryinformation',
                name: 'inventoryinformation',
                meta: {
                    father: '综合查询',
                    name: '库存信息查询',
                },
                component: function(resolve) {
                    require(['./views/comprehensivequery/inventoryinformation.vue'], resolve)
                }
            },

            {
                path: '/Inventorywate',
                name: 'Inventorywate',
                meta: {
                    father: '综合查询',
                    name: '库存流水查询',
                },
                component: function(resolve) {
                    require(['./views/comprehensivequery/Inventorywate.vue'], resolve)
                }
            },

            {
                path: '/entrydetails',
                name: 'entrydetails',
                meta: {
                    father: '卷烟入库',
                    name: '查看入库详细信息',
                    fatherpath: 'cigaretteentry'
                },
                component: function(resolve) {
                    require(['./views/warehouse/entrydetails.vue'], resolve)
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
                path: '/locationinfoAll',
                name: 'locationinfoAll',
                meta: {
                    father: '统计分析',
                    name: '货位信息统计',
                },
                component: function(resolve) {
                    require(['./views/statisticalAnalysis/locationinfoAll.vue'], resolve)
                }
            },
            {
                path: '/stockcheckCountBy',
                name: 'stockcheckCountBy',
                meta: {
                    father: '统计分析',
                    name: '盘点统计',
                },
                component: function(resolve) {
                    require(['./views/statisticalAnalysis/stockcheckCountBy.vue'], resolve)
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
            {
                path: '/inventoryControlStatistics',
                name: 'inventoryControlStatistics',
                meta: {
                    father: '统计分析',
                    name: '存量控制统计',
                },
                component: function(resolve) {
                    require(['./views/comprehensivequery/inventoryControlStatistics.vue'], resolve)
                }
            },
            {
                path: '/',
                name: 'exceptionhandling',
                meta: {
                    father: 'FRID异常管理',
                    name: 'FRID异常管理',
                },
                component: function(resolve) {
                    require(['./views/exceptionhandling/locallabelexception.vue'], resolve)
                }
            },
            {
                path: '/locallabelexception',
                name: 'locallabelexception',
                meta: {
                    father: 'FRID异常管理',
                    name: '货位FRID异常管理',
                },
                component: function(resolve) {
                    require(['./views/exceptionhandling/locallabelexception.vue'], resolve)
                }
            },
			{
                path: '/entrystatistics',
                name: 'entrystatistics',
                meta: {
                    father: '统计分析',
                    name: '入库统计',
                },
                component: function(resolve) {
                    require(['./views/statisticalAnalysis/entrystatistics.vue'], resolve)
                }
            },
        ]
    }
]