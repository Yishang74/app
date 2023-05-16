<template>
	<view>
		<u-form :model="form" ref="uForm" style="margin-left: 10px;">

			<u-form-item label="姓名" prop="username" label-width="150">
				<u-input v-model="form.username" placeholder="请输入姓名" />
			</u-form-item>
			<u-form-item label="年龄" prop="age" label-width="150">
				<u-input v-model="form.age" type="number" placeholder="请输入年龄" />
			</u-form-item>
			<u-form-item label="手机号" prop="phone" label-width="150">
				<u-input v-model="form.phone" type="number" placeholder="请输入手机号" />
			</u-form-item>
			<u-form-item label="密码" prop="password">
				<u-input :password-icon="true" type="password" v-model="form.password" placeholder="请输入密码"></u-input>
			</u-form-item>
			<u-form-item label="毕业学校" prop="university" label-width="150">
				<u-input v-model="form.university" placeholder="请输入学校" />
			</u-form-item>

			<view class="myop">
				<u-button @click="submit" class="add">保存</u-button>
				<u-button @click='back' class="back">取消</u-button>
			</view>
		</u-form>
		<u-toast ref="uToast" />
	</view>
</template>

<script>
	export default {
		data() {
			return {
				url: 'http://127.0.0.1:8080',
				id: '',
				kechengShow: false,
				form: {
					username: '',
					age: '',
					phone: '',
					university: '',
					password: '',
				},

				rules: {

					username: [{
						required: true,
						message: '请输入名称',
						trigger: 'change'
					}],
					age: [{
						required: true,
						message: '请输入年龄',
						trigger: 'change'
					}],
					phone: [{
						required: true,
						message: '请输入手机号',
						trigger: 'change'
					}],
					password: [{
						required: true,
						message: '请输入密码',
						trigger: 'change'
					}]

				}
			}
		},
		onLoad(option) {
			if (option.id) {
				this.id = option.id
				this.getInfo(option.id)
			}

		},
		methods: {
			getInfo(id) { //获取级别信息
				uni.request({
					url: this.url + '/admin/teacher/get/' + id,
					data: {},
					success: (e) => {
						if (e.data.code === 200) {
							this.form = e.data.data
						} else {
							uni.showModal({
								content: e.data.message,
								showCancel: false
							})
						}
					}
				})
			},
			selectkcConfirm(e) {
				this.form.sex = '';
				this.form.sexname = '';
				e.map((val, index) => {
					this.form.sexname = val.label;
					this.form.sex = val.value;
				})
			},
			submit() {

				this.$refs.uForm.validate(valid => {
					if (valid) {
						this.addClass()
					} else {
						console.log('验证失败');
					}
				});

			},
			addClass() {
				let that = this
				let subUrl = `/admin/teacher/save`

				if (that.id) {
					subUrl = `/admin/teacher/update`
				}
				uni.request({
					url: that.url + subUrl,
					data: this.form,
					method: "POST",
					success: (e) => {
						if (e.data.code === 200) {
							uni.showModal({
								content: '保存成功',
								showCancel: false
							})
						} else {
							uni.showModal({
								content: e.data.message,
								showCancel: false
							})
						}
					}
				})
			},
			back() {
				uni.switchTab({
					url: '/pages/userInfo/userInfo'
				})
			},
		},
		onReady() {
			this.$refs.uForm.setRules(this.rules);
		},
	}
</script>

<style>
	.u-btn {
		display: inline-block;
		/* flex-direction: column; */
	}

	.add {
		background-color: green;
		color: white;

	}

	.back {
		background-color: #302e32;
		color: white;
	}

	.myop {
		margin-top: 50upx;
		display: flex;
		justify-content: space-between;
	}
</style>
