<script>
	import {
		mapMutations
	} from 'vuex';
	export default {
		onShow() {
			getApp().globalData.reviseTabbarByUserType();
		},
		globalData: {
			reviseTabbarByUserType: function() {
				let userType = uni.getStorageSync('roleId');
				console.log("vueapp",userType)
				if (userType == 2) {
					uni.setTabBarItem({
						index: 2,
						visible: false,
					})
					uni.setTabBarItem({
						index: 3,
						visible: false,
					})
					uni.setTabBarItem({
						index: 0,
						visible: false,
					})
					uni.setTabBarItem({
						index: 1,
						visible: false,
					})
				} 
				//权限1
				if (userType == 1) {
					uni.setTabBarItem({
						index: 2,
						visible: false,
					})
					uni.setTabBarItem({
						index: 3,
						visible: false,
					})
					uni.setTabBarItem({
						index: 4,
						visible: false,
					})
					uni.setTabBarItem({
						index: 5,
						visible: false,
					})
					uni.setTabBarItem({
						index: 6,
						visible: false,
					})
				} 
				if (userType == 0) {
					uni.setTabBarItem({
						index: 0,
						visible: false,
					})
					uni.setTabBarItem({
						index: 1,
						visible: false,
					})
					uni.setTabBarItem({
						index: 4,
						visible: false,
					})
					uni.setTabBarItem({
						index: 5,
						visible: false,
					})
					uni.setTabBarItem({
						index: 6,
						visible: false,
					})
				}
			}
		},
		onLaunch: function() {
			let hasLogin = uni.getStorage('hasLogin');
			let roleId = uni.getStorageSync('roleId');
			console.log("hasLogin：",hasLogin,"roleId：",roleId)
			if(hasLogin==null ){
				console.log("不存在则跳转至登录页")
			}
			    if (hasLogin) {
				    //存在则关闭启动页进入首页
					console.log("存在则关闭启动页进入首页：",roleId)
					if (roleId === 0) {
						uni.switchTab({
							url: '/pages/selfInfomation/selfInfomation',
							success: () => {
							    plus.navigator.closeSplashscreen();
							}
						});
					}
					if (roleId === 1) {
						uni.switchTab({
							url: '/pages/scheduleschedule/schedule',
							success: () => {
							    plus.navigator.closeSplashscreen();
							}
						});
					}
					if (roleId === 2) {
						uni.switchTab({
							url: '/pages/scheduleschedule/schedule',
							success: () => {
							    plus.navigator.closeSplashscreen();
							}
						});
					}
				
			    } else {
					//不存在则跳转至登录页
					console.log("不存在则跳转至登录页")
			        uni.reLaunch({
			            url: "/pages/login/login",
					    success: () => {
					        plus.navigator.closeSplashscreen();
					    }
			    	})
			    }

			
			// uni.getStorage({
			// 	key: 'uerInfo',
			// 	success: (res) => {
			// 		this.login(res.data);
			// 		// // 如果还需要重新校验或是想要刷新token的有效时间 就再联网请求一次
			// 		// uni.request({
			// 		// 	url: `${this.$serverUrl}/auth.php`,
			// 		// 	header: {
			// 		// 		"Content-Type": "application/x-www-form-urlencoded",
			// 		// 		"Token":res.data.token
			// 		// 	},
			// 		// 	data: {
			// 		// 		"username":res.data.user_name
			// 		// 	},
			// 		// 	method: "POST",
			// 		// 	success: (e) => {
			// 		// 		if (e.statusCode === 200 && e.data.code === 0) {
			// 		// 			this.login(e.data);
			// 		// 		}
			// 		// 	}
			// 		// })
			// 	}
			// });
		},
		methods: {
			...mapMutations(['login'])
		}
	}
</script>

<style lang="scss">
	/* 注意要写在第一行，同时给style标签加入lang="scss"属性 */
	@import "uview-ui/index.scss";
</style>
