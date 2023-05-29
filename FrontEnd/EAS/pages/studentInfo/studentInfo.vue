<template>
	<view>
		<u-form :model="form" ref="uForm" style="margin-left: 10px;">

			<u-form-item label="Name" prop="username" label-width="150">
				<u-input v-model="form.username" placeholder="name" />
			</u-form-item>
			<u-form-item label="Sex" prop="sex" label-width="150">
				<u-input v-model="form.sexname" @click="kechengShow = true" placeholder="sex" />
			</u-form-item>
			<u-form-item label="Phone" prop="phone" label-width="150">
				<u-input v-model="form.phone" type="number" placeholder="phone" />
			</u-form-item>
			<!-- <u-form-item label="密码" prop="password">
				<u-input :password-icon="true" type="password" v-model="form.password" placeholder="请输入密码"></u-input>
			</u-form-item> -->
			<u-form-item label="School" prop="name" label-width="150">
				<u-input v-model="form.school" placeholder="school" />
			</u-form-item>
			<u-form-item label="Parent's phone" prop="form.parent_phone" label-width="150">
				<u-input v-model="form.parentPhone" type="number" placeholder="phone" />
			</u-form-item>
			<u-form-item label="Evaluate" prop="form.evaluate" label-width="150">
				<u-input v-model="form.evaluate" type="number" placeholder="Evaluate" />
			</u-form-item>			
			<view class="myop">
				<u-button @click="submit" class="add">save</u-button>
				<u-button @click='back' class="back">cancel </u-button>
			</view>
		</u-form>
		<view>
			<u-select v-model="kechengShow" :list="kechengList" @confirm="selectkcConfirm"></u-select>
		</view>
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
					sex: '',
					sexname: '',
					phone: '',
					school: '',
					password: '',
					parent_phone: '',
					evaluate: '',
				},
				kechengList: [{
						value: '1',
						label: '男'
					},
					{
						value: '2',
						label: '女'
					}
				],
				rules: {

					username: [{
						required: true,
						message: '请输入名称',
						trigger: 'change'
					}],
					sex: [{
						required: true,
						message: '请选择性别',
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
					url: this.url + '/admin/student/get/' + id,
					data: {},
					success: (e) => {
						if (e.data.code === 200) {
							this.form = e.data.data
							this.kechengList.map((item) => {
								if (item.value == this.form.sex) {
									this.form.sexname = item.label;
									this.form.sex = item.value;
								}
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
				let subUrl = `/admin/student/save`

				if (that.id) {
					subUrl = `/admin/student/update`
				}
				uni.request({
					url: that.url + subUrl,
					data: this.form,
					method: "POST",
					success: (e) => {
						if (e.data.code === 200) {
							uni.showModal({
								content: 'Successfully saved',
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
					url: '/pages/classInformation/classInformation'
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
