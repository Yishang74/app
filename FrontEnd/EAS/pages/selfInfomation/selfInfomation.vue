<template>
	<view>
		<view>
			<view class="u-flex-col u-p-30 u-col-center">
				<u-image width='150rpx' height='150rpx' :src="headImg" shape="circle"></u-image>
				<text class="u-p-t-10 change"></text>
			</view>
			<u-cell-group>
				<view v-for="(u,index) in user" :key="index">
					<u-cell-item :title=index :value=u @click='checkStuInfo(u)'></u-cell-item>
				</view>
			</u-cell-group>
			
		</view>
		<view>

		</view>
		<button type="primary" @click="bindLogout">Log out</button>
		<!-- 		<view v-for="(user,index) in user":key="index">
			<view>user</view>
			<view>{{user.studentId}}</view>
		</view> -->
	</view>
</template>

<script>
	import {
		mapState,
		mapMutations
	} from 'vuex';
	
	export default {
		onShow() {


		},
		data() {
			return {
				headImg:'/static/logo.png',
				sex: '男',
				user: []
			}
		},
		onReady() {
			// let userInfoToken = uni.getStorageSync('uerInfo').token;
			// console.log("userInfoTokenSync:", userInfoToken)
			// var userInfo = JSON.parse(sessionStorage.getItem("userInfo"))
			
			// uni.request({
			// 	url: `http://127.0.0.1:8080/student/get/`+userInfo,
			// 	header: {
			// 		"Content-Type": "application/x-www-form-urlencoded",
			// 		'Authorization': userInfoToken
			// 	},
			// 	data: {},
			// 	method: "GET",
				
			// 	success: (e) => {
			// 		console.log(e.data)
			// 		if (e.data.code === 200) {
			// 			this.user = e.data.data;
			// 			console.log("user", this.user)
			// 		} else {
			// 			uni.showModal({
			// 				content: e.data.message,
			// 				showCancel: false
			// 			})
			// 		}
			// 	}
			// })
		},
		mounted() {
			var userInfo = JSON.parse(sessionStorage.getItem("userInfo"))
			this.$axios.get("student/get/" + userInfo.id).then(res => {
				if (res.code = 200) {
					this.user = res.data.data
					this.$delete(this.user,'password')
					this.$delete(this.user,'salt')
					console.log(this.user)
				}
			})
		},
		methods: {
			checkStuInfo(data) {
				var userInfo = JSON.parse(sessionStorage.getItem("userInfo"))
				uni.navigateTo({
					url: '/pages/studentInfo/studentInfo?id='+userInfo.id,
					animationType: 'pop-in',
					animationDuration: 300
				})
			},
			selectSex() {
				const arr = ['男', '女', '保密']
				uni.showActionSheet({
					itemList: arr,
					success: (res) => {
						this.sex = arr[res.tapIndex]
					},
					fail: function(res) {
						console.log(res.errMsg);
					}
				});
			},
			...mapMutations(['logout']),
			bindLogout() {
				this.logout()
				uni.navigateTo({
					url: '/pages/login/login'
				})
			}
		}
	}
</script>

<style>

</style>
