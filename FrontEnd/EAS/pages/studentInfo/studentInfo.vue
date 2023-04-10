<template>
	<view>
		<view>
			<u-cell-group>
				<view v-for="(u,index) in user" :key="index">
					<u-cell-item :title=index :value=u></u-cell-item>
<!-- 					<u-cell-item v-if="index=='studentSex'" :title=index :value="sex" @click='selectSex'></u-cell-item> -->
				</view>
			</u-cell-group>
		</view>
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
			console.log(getApp().globalData)

		},
		data() {
			return {
				headImg:'/static/logo.png',
				sex: '男',
				user: []
			}
		},
		onReady() {
			let userInfoToken = uni.getStorageSync('uerInfo').token;
			console.log("userInfoTokenSync:", userInfoToken)
			uni.request({
				url: `http://127.0.0.1:8080/getStudentInfo`,
				header: {
					"Content-Type": "application/x-www-form-urlencoded",
					'Authorization': userInfoToken
				},
				data: {},
				method: "GET",
				success: (e) => {
					console.log(e.data)
					if (e.data.code === 200) {
						this.user = e.data.data;
						console.log("user", this.user)
					} else {
						uni.showModal({
							content: e.data.message,
							showCancel: false
						})
					}
				}
			})
		},
		methods: {
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
