
export default{
	state:{
		userInfo:{},
	},
	//变更状态
	mutations:{
		storeUserInfo(state,obj){
			state.userInfo=obj
			sessionStorage.setItem('qr_userinfo',JSON.stringify(state.userInfo))
		},
	},
	//派生，相当于computed
	getters:{
		
	},
	//提交mutations状态
	actions:{
		
	}
}
