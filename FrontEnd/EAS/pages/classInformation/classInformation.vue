<template>
	<view>
		// <view v-for="(u,index) in user" :key="index">
		// </view>
		<u-cell-group>
			<u-cell-group title="Class 1">
				<u-cell-item title="Bruce" @click='checkStuInfo'></u-cell-item>
				<u-cell-item title="Ben" ></u-cell-item>
				<u-cell-item title="Roger" ></u-cell-item>
				<u-cell-item title="Eric" ></u-cell-item>
			</u-cell-group>
			<u-gap height="15" bg-color="#f9f9f9"></u-gap>
			
			<u-cell-group title="Class 2">
				<u-cell-item title="Tom" @click='checkStuInfo'></u-cell-item>
				<u-cell-item title="Ned" ></u-cell-item>
				<u-cell-item title="Steve" ></u-cell-item>
				<u-cell-item title="Dena" ></u-cell-item>
			</u-cell-group>
			<u-gap height="15" bg-color="#f9f9f9"></u-gap>
			
			<u-cell-group title="Class 3">
				<u-cell-item title="Eli" @click='checkStuInfo'></u-cell-item>
				<u-cell-item title="Karl" ></u-cell-item>
				<u-cell-item title="Robin" ></u-cell-item>
				<u-cell-item title="Jason" ></u-cell-item>
			</u-cell-group>
			<u-gap height="15" bg-color="#f9f9f9"></u-gap>
		</u-cell-group>
		<button type="primary" @click="bindLogout">Log out</button>
	</view>
</template>

<script>
	import {
		mapState,
		mapMutations
	} from 'vuex';
	export default {
		computed:{
			getPhone(){
				var reg = /^(\d{3})\d{4}(\d{4})$/;
				return this.phone.replace(reg, "$1****$2");
			}
		},
		data() {
			return {
			}
		},
		onReady() {
			let userInfoToken = uni.getStorageSync('uerInfo').token;
			console.log("userInfoTokenSync:", userInfoToken)
			uni.request({
				url: `http://127.0.0.1:8080/ `,
				header: {
					"Content-Type": "application/x-www-form-urlencoded",
					'Authorization': userInfoToken
				},
				data: {},
				method: "GET",
				success: (e) => {
					console.log(e.data)
					if (e.data.code === 200) {
						
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
			checkStuInfo() {
				uni.navigateTo({
					url: '/pages/studentInfo/studentInfo',
					animationType: 'pop-in',
					animationDuration: 300
				})		
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
