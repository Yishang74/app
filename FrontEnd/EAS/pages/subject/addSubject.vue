<template>
	<view>
		<u-form :model="form" ref="uForm" style="margin-left: 10px;">

			<u-form-item label="名称" prop="name" label-width="150">
				<u-input v-model="form.name" />
			</u-form-item>
			<u-form-item label="类型" prop="type" label-width="150">
				<u-input v-model="form.typename" @click="kechengShow = true" />
			</u-form-item>
<!-- 			<u-form-item label="开始时间" prop="starttime" label-width="150">
				<uni-datetime-picker v-model="form.starttime" :border="false" />
			</u-form-item>
			<u-form-item label="结束时间" prop="endtime" label-width="150">
				<uni-datetime-picker v-model="form.endtime" :border="false" />
			</u-form-item>
			<u-form-item label="地点" prop="didian" label-width="150">
				<u-input v-model="form.didian" />
			</u-form-item> -->
<!-- 			<u-form-item label="数量" prop="num" label-width="150">
				<u-input v-model="form.num" type="number"/>
			</u-form-item> -->
			<view class="myop">
				<u-button @click="submit" class="add">保存</u-button>
				<u-button @click='back' class="back">取消</u-button>
			</view>
		</u-form>
		<view>
			<u-select v-model="kechengShow" :list="kechengList" 
				@confirm="selectkcConfirm"></u-select>
		</view>
		<u-toast ref="uToast" />
	</view>
</template>

<script>
	export default {
		data() {
			return {
				url: 'http://127.0.0.1:8080',
				id:'',
				kechengShow:false,
				form: {
					name: '',
					type: '',
					typename:'',
					didian: '',
					starttime: '',
					endtime: '',
					num:'',
				},
				kechengList: [{
						value: '1',
						label: '小课'
					},
					{
						value: '2',
						label: '大课'
					}
				],
				rules: {
				
					name: [{
						required: true,
						message: '请输入名称',
						trigger: 'change'
					}],
					type: [{
						required: true,
						message: '请选择类型',
						trigger: 'change'
					}],
					starttime: [{
						required: true,
						message: '请选择开始时间',
						trigger: 'change'
					}],
					endtime: [{
						required: true,
						message: '请选择结束时间',
						trigger: 'change'
					}],
					didian: [{
						required: true,
						message: '请输入地点',
						trigger: 'change'
					}],
					num: [{
						required: true,
						message: '请输入数量',
						trigger: 'change'
					}],
				
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
			getInfo(id){ //获取级别信息
				
			},
			selectkcConfirm(e) {
				this.form.type = '';
				this.form.typename = '';
				e.map((val, index) => {
					this.form.typename = val.label;
					this.form.type = val.value;
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
				let subUrl = `/admin/course/save`
				let data = {
					name: this.form.name,
					type:this.form.type,
					count:this.form.num
				}
				if (that.type) {
					subUrl = `/admin/course/update`
					data = {
						name: that.form.name,
						type:that.form.type,
						count:that.form.num
					}
				}
				uni.request({
					url: that.url + subUrl,
					data: data,
					method: "POST",
					success: (e) => {
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
			back() {
				uni.switchTab({
					url:'/pages/subject/subject'
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
