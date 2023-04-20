<template>
	<form class='loginView' @submit="bindLogin">
		<view class="examine-role">
			<button @click="clickRole(0)" :class="[roleId==0?'role':'']">Student</button>
			<button @click="clickRole(1)" :class="[roleId==1?'role':'']">Teacher</button>
			<button @click="clickRole(2)" :class="[roleId==2?'role':'']">Adm</button>
		</view>
		<view class="input-view">
			<view class="label-view">
				<text class="label">Phone</text>
			</view>
			<input class="input" type="text" placeholder="enter the phone" name="nameValue" />
		</view>
		<view class="input-view">
			<view class="label-view">
				<text class="label">Psw</text>
			</view>
			<input class="input" password placeholder="enter the password" name="passwordValue" />
		</view>
		<view class="button-view">
			<button type="primary" :loading="loading" class="login" formType="submit">Login</button>
		</view>
	</form>
</template>

<script>
	import {
		mapMutations
	} from 'vuex';

	export default {
		data() {
			return {
				loading: false,
				roleId: 0
			}
		},
		onBackPress() {
			let hasLogin=uni.getStorage({
				key: 'hasLogin',
				success: function (res) {
				}
			});
				if(!hasLogin){
					return true;
				}
			},
		methods: {
			clickRole(roleId) {
				this.roleId = roleId
				console.log(this.roleId)
			},
			bindLogin(e) {
				console.log("login")
				this.loading = true;
				let name = e.detail.value.nameValue,
					password = e.detail.value.passwordValue;

				// if (!/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(name)) {
				//     this.loading = false;
				//     uni.showModal({
				//         content: "请输入正确邮箱",
				//         showCancel: false
				//     })
				//     return;
				// }

				// if (password.length < 6) {
				// 	this.loading = false;
				// 	uni.showModal({
				// 		content: "密码大于5位",
				// 		showCancel: false
				// 	})
				// 	return;
				// }

				uni.request({
					url: `http://127.0.0.1:8080/loginJwt`,
					header: {
						"Content-Type": "application/x-www-form-urlencoded"
					},
					data: {
						"phoneNumber": name,
						"password": password
					},
					method: "POST",
					success: (e) => {
						console.log(e.data)
						if (e.statusCode !== 200) {
							uni.showModal({
								content: "用户名密码错误！",
								showCancel: false
							});
							return;
						}
						if (e.data.code === 200) {
							console.log("e.data.data",e.data.data)
							this.login(e.data.data);
							this.setRoleId(this.roleId);
							
							// uni.navigateTo({
							// 	url: '/pages/index/index'
							// });
							if (this.roleId === 0) {
								uni.switchTab({
									url: '/pages/selfInfomation/selfInfomation',
									success() {
										location.reload();
									},
								});

							}
							if (this.roleId === 1) {
								console.log("page");
								uni.switchTab({
									url: '/pages/schedule/schedule',
									success() {
										location.reload();
									},
								});
							}
							if (this.roleId === 2) {
								console.log("page");
								uni.switchTab({
									url: '/pages/class/class',
									success() {
										location.reload();
									},
								});
							}
						} 
						else {
							uni.showModal({
								content: e.data.message,
								showCancel: false
							})
						}
					},
					fail: (e) => {
						uni.showModal({
							content: "请求失败，请重试！",
							showCancel: false
						})
					},
					complete: () => {
						this.loading = false;
					}
				})
			},
			...mapMutations(['login']),
			...mapMutations(['setRoleId'])
		}
	}
</script>

<style>
	view {
		display: flex;
	}
	.click-hover{

	background-color: #f5f5f5;

	}
	button{
		font-size: 10upx;
	}
	.loginView {
		display: flex;
		flex: 1;
		flex-direction: column;
		width: 750upx;
		padding-top: 30upx;
	}

	.input-view {
		border-bottom-style: solid;
		border-bottom-width: 3upx;
		border-bottom-color: #ddd;
		background-color: #fff;
		flex-direction: row;
		width: 750upx;
		padding: 20upx 20upx;
		box-sizing: border-box;
	}

	.label-view {
		width: 100upx;
		height: 60upx;
		align-items: center;
		margin-right: 30upx;
	}

	.label {
		flex: 1;
		line-height: 60upx;
		font-size: 34upx;
		color: #555;
		text-align: left;
	}

	.input {
		flex: 1;
		height: 60upx;
		font-size: 34upx;
		align-items: center;
	}

	.button-view {
		width: 750upx;
		margin-top: 50upx;
		padding: 0 20upx;
		box-sizing: border-box;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}

	button {
		width: 710upx;
		height: 80upx;
		line-height: 80upx;
		text-align: center;
		font-size: 34upx;
		margin-bottom: 30upx;
	}

	button.register {
		margin-top: 30upx;
		color: #ff80ab;
		background-color: #fff;
		border-color: #ff80ab;
		border-width: 2upx;
	}

	/* .register.hover,
    .login.hover {
        opacity: 0.6;
    } */
	.getPassword {
		color: #888888;
	}

	.examine-role {
		padding: 0 80rpx;
		box-sizing: border-box;
		width: 100%;
		height: 64rpx;
		margin-bottom: 20rpx;
		display: flex;
			
		span {
			flex: 1;
			display: inline-block;
			height: 64rpx;
			font-size: 28rpx;
			font-weight: bold;
			line-height: 64rpx;
			text-align: center;
			background: #E6E7EB;
			color: #666;



			&:first-child {
				border-radius: 14rpx 0 0 14rpx;
			}

			&:last-child {
				border-radius: 0 14rpx 14rpx 0;
			}
		}
	}
	.role {
			background-color: #43C2F5;
			background: linear-gradient(90deg, #328CFA 0%, #43C2F5 100%);
			color: #fff;
	}
</style>
