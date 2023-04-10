<template>
	<!-- <view class="">
		<u-form :model="form" ref="uForm">
			<u-form-item label="姓名" prop="name">
				<u-input v-model="form.name" />
			</u-form-item>
			<u-form-item label="简介" prop="intro">
				<u-input v-model="form.intro" />
			</u-form-item>
		</u-form>
		<u-button @click="submit">提交</u-button>
	</view> -->
	<view class="">
		<u-form :model="form" ref="uForm">
			<u-form-item label="id" prop="id">
				<u-input v-model="form.id" />
			</u-form-item>
			<u-form-item label="name" prop="name">
				<u-input v-model="form.name" />
			</u-form-item>
			<u-form-item label="studentNumber" prop="studentNumber">
				<u-input v-model="form.studentNumber" style="padding-left:150upx;" />
			</u-form-item>
			<view class="myop">
				<u-button @click="submit" class="add">Add</u-button>
				<u-button @click='back' class="back">Back</u-button>
			</view>
		</u-form>
		<u-toast ref="uToast" />
	</view>

</template>

<script>
	import {
		mapMutations
	} from 'vuex';
	export default {
		data() {
			return {
				form: {
					id: '',
					name: '',
					studentNumber: ''
				},
				
				rules: {
					id: [{
						required: true,
						message: 'input id',
						// 可以单个或者同时写两个触发验证方式 
						trigger: ['blur'],
					}],
					name: [{
						required: true,
						name: 'input name',
						// 可以单个或者同时写两个触发验证方式 
						trigger: ['blur'],
					}],
					studentNumber: [{
						required: true,
						name: 'input studentNumber',
						// 可以单个或者同时写两个触发验证方式 
						trigger: [ 'blur'],
					}]
				}
			};
		},
		methods: {
			submit() {
				console.log(event)
				
				this.$refs.uForm.validate(valid => {
					if (valid) {
						// console.log('this.form',this.form)
						// console.log('this.$store.state.classinfo',this.$store.state.classinfo)
						this.setNewClass(this.form)
						uni.$emit('addclass', this.$store.state.classinfo)
						this.$refs.uToast.show({
							title: '添加成功',
							type: 'success',
							duration: 1000
						})
						this.form={}
					} else {
						console.log('验证失败');
					}
				});

			},
			back() {
				// console.log(111)
				uni.switchTab({
					url: '/pages/class/class'
				})
				// uni.navigateTo({
				// 	url:'/pages/class/class'
				// })
			},
			...mapMutations(['setNewClass'])
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
