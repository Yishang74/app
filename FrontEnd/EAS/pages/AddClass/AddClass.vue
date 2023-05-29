<template>

	<view class="">
		<u-form :model="form" ref="uForm">

			<u-form-item label="班级名称" label-width="150">
				<u-input v-model="form.name" />
			</u-form-item>
			<u-form-item label="课程"  label-width="150">
				<u-input v-model="form.kecheng" @click="kechengShow = true" />
			</u-form-item>
			<u-form-item label="周" label-width="150" prop="form.week" >
				<checkbox-group @change="checkboxGroupChangeZhou">
					<checkbox  v-model="index" v-for="(item, index) in weekList" :key="index">
						{{item}}
					</checkbox>
				</checkbox-group>
			</u-form-item>
			<u-form-item label="星期" label-width="150" prop="form.day">
				<checkbox-group @change="checkboxGroupChangeXingqi">
					<checkbox v-model="index"  v-for="(item, index) in weekdayList" :key="index">
						{{item}}
					</checkbox>
				</checkbox-group>
			</u-form-item>
			<u-form-item label="时间段" label-width="150" prop="form.timeTable" >
				<checkbox-group @change="checkboxGroupChangeShijianduan">
					<checkbox v-model="index"  v-for="(item, index) in timeList" :key="index">
						{{item}}
					</checkbox>
				</checkbox-group>
			</u-form-item>
			<u-form-item label="老师"  label-width="150">
				<u-input v-model="form.laoshi" @click="laoshiShow = true" />
			</u-form-item>
			<u-form-item label="学生" label-width="150" prop="form.student">
				<u-checkbox-group @change="checkboxGroupChange">
					<u-checkbox v-model="item.checked" v-for="(item, index) in xsList" :key="index" :name="item.id">
						{{item.username}}</u-checkbox>
				</u-checkbox-group>
			</u-form-item>
			<u-form-item label="课程地点" label-width="150">
				<u-input v-model="form.didian" />
			</u-form-item>
			<view class="myop">
				<u-button @click="submit" class="add">Save</u-button>
				<u-button @click='back' class="back">Canel</u-button>
			</view>
		</u-form>
		<view>
			<u-select v-model="kechengShow" :list="kechengList" value-name="id" label-name="name"
				@confirm="selectkcConfirm"></u-select>
			<u-select v-model="laoshiShow" :list="laoshiList" value-name="id" label-name="username"
				@confirm="selectlsConfirm"></u-select>
		</view>
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
				id: '',
				dataInfo: {},
				type: '', //修改r
				kechengList: [],
				laoshiList: [],
				xsList: [],
				xsSelect: [],
				weekList: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],
				weekSelect: [],
				timeList: ['08:00-08:40','08:50-09:30','09:40-10:20','10:30-11:10','11:20-12:00','14:00-14:40','15:50-16:30','16:40-17:20','17:30-18:10','19:00-19:40','20:50-21:30','21:40-22:20'],
				timeSelect: [],
				weekdayList: [1,2,3,4,5,6,7],
				weekdaySelect: [],				
				url: 'http://127.0.0.1:8080',
				kechengShow: false,
				laoshiShow: false,
				form: {
					name: '',
					kecheng: '',
					laoshi: '',
					kechengId: '',
					laoshiId: '',
					didian: '',
					week:'',
					day:'',
					student:'',
					timeTable:''
				},

				rules: {

					name: [{
						required: true,
						message: '请输入班级名称',
						trigger: 'change'
					}],
					kecheng: [{
						required: true,
						message: '请选择课程',
						trigger: 'change'
					}],
					laoshi: [{
						required: true,
						message: '请选择老师',
						trigger: 'change'
					}],

				}
			};
		},
		onLoad(option) {
			if (option.type) {
				this.type = option.type
				this.id = option.id
				this.getInfo(option.id)
			} else {
				this.getLsData()
				this.getkcData()
				this.getxsData()
			}

		},
		methods: {
			getInfo(id) {
				uni.request({
					url: `${this.url}/admin/class/getClassInfo/${id}`,
					success: (e) => {
						if (e.data.code === 200) {
							this.dataInfo = e.data.data
							this.form.name = e.data.data.className
							this.getLsData()
							this.getkcData()
							this.getxsData()
							console.log(e.data.data)
						} else {
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
					}
				})
			},
			// 选中任一checkbox时，由checkbox-group触发
			checkboxGroupChange(e) {
				console.log(e)
				this.form.student = e;
			},
			checkboxGroupChangeZhou(e) {
				console.log(e.detail.value)
				// this.weekSelect = e.detail.value;
				this.form.week = e.detail.value
			},
			checkboxGroupChangeXingqi(e) {
				console.log(e.detail.value)
				this.form.day  = e.detail.value;
			},
			checkboxGroupChangeShijianduan(e) {
				console.log(e.detail.value)
				this.form.timeTable  = e.detail.value;
			},
			//获取课程
			getkcData() {
				let that = this
				uni.request({
					url: `${this.url}/admin/course/findAll`,
					success: (e) => {
						console.log(e.data)
						if (e.data.code === 200) {
							this.kechengList = e.data.data
							if (that.dataInfo.classCourse) {
								this.kechengList.map((item) => {
									if (item.id == that.dataInfo.classCourse.courseId) {
										console.log(item)
										that.form.kecheng = item.name;
										that.form.kechengId = item.id;
									}
								})
							}

						} else {
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
					}
				})
			},
			//获取老师
			getLsData() {
				let that = this
				uni.request({
					url: `${this.url}/admin/teacher/findAll`,
					success: (e) => {
						console.log(e.data)
						if (e.data.code === 200) {
							this.laoshiList = e.data.data
							if (that.dataInfo.classTeacher) {
								this.laoshiList.map((item) => {
									if (item.id == that.dataInfo.classTeacher.teacherId) {
										console.log(item)
										that.form.laoshi = item.username;
										that.form.laoshiId = item.id;
									}
								})
							}
						} else {
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
					}
				})
			},
			//获取学生
			getxsData() {
				let that = this
				uni.request({
					url: `${this.url}/admin/student/findAll`,
					success: (e) => {
						console.log(e.data)
						if (e.data.code === 200) {
							this.xsList = e.data.data
							let arrTmp = []
							if (that.dataInfo.classStudents) {
								that.dataInfo.classStudents.map((item) => {
									arrTmp.push(item.studentId)
								})
								that.xsSelect= arrTmp
								this.xsList = this.xsList.map((item) => {
									return {
										...item,
										checked: arrTmp.includes(item.id)
									}

								})
							}


						} else {
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
					}
				})
			},
			selectkcConfirm(e) {
				this.form.kecheng = '';
				this.form.kechengId = '';
				e.map((val, index) => {
					this.form.kecheng = val.label;
					this.form.kechengId = val.value;
				})
			},
			selectlsConfirm(e) {
				this.form.laoshi = '';
				this.form.laoshiId = '';
				e.map((val, index) => {
					this.form.laoshi = val.label;
					this.form.laoshiId = val.value;
				})
			},

			submit() {
				if (this.form.student.length == 0) {
					this.$refs.uToast.show({
						title: '请选择学生',
						type: 'info',
						duration: 1000
					})
					return;
				}
				this.$refs.uForm.validate(valid => {
					if (valid) {
						console.log(this.form)
						this.addClass()
					} else {
						console.log('验证失败');
					}
				});

			},
			addClass() {
				this.$axios.post("/admin/class/save",{
					className :this.form.name,
					courseId :this.form.kechengId,
					teacherId :this.form.laoshiId,
					week_no:this.form.week,
					day_no:this.form.day,
					location: this.form.didian,
					studentId:this.form.student,
					timeTableId:this.form.timeTable
					
				}).then(res=>{
					console.log(res)
					if(res.code=200){
						uni.switchTab({
							url:'/pages/class/class'
						})
					}
				})
			},
			addStudent(id) {
				uni.request({
					url: this.url + `/admin/class/doAssignStudent`,
					data: {
						"type":this.type,
						"classId": id,
						"studentIds": this.xsSelect
					},
					method: "POST",
					success: (e) => {
						if (e.data.code === 200) {
							this.$refs.uToast.show({
								title: '添加成功',
								type: 'success',
								duration: 1000
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
			addLaoshi(id) {
				uni.request({
					url: this.url + `/admin/class/doAssignTeacher`,
					data: {
						"type":this.type,
						"teacherIds": [this.form.laoshiId],
						"classId": id
					},
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
			addkecheng(id) {
				uni.request({
					url: this.url + `/admin/course/doAssign`,
					data: {
						"courseId": this.form.kechengId,
						"classId": id
					},
					method: "POST",
					success: (e) => {
						if (e.data.code === 200) {
							this.$refs.uToast.show({
								title: '添加成功',
								type: 'success',
								duration: 1000
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
			addZhou(id) {
				uni.request({
					url: this.url + `/admin/class/doAssignStudent`,
					data: {
						"type":this.type,
						"classId": id,
						"studentIds": this.weekSelect
					},
					method: "POST",
					success: (e) => {
						if (e.data.code === 200) {
							this.$refs.uToast.show({
								title: '添加成功',
								type: 'success',
								duration: 1000
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
			addXingqi(id) {
				uni.request({
					url: this.url + `/admin/class/doAssignStudent`,
					data: {
						"type":this.type,
						"classId": id,
						"studentIds": this.weekdaySelect
					},
					method: "POST",
					success: (e) => {
						if (e.data.code === 200) {
							this.$refs.uToast.show({
								title: '添加成功',
								type: 'success',
								duration: 1000
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
			addShijianduan(id) {
				uni.request({
					url: this.url + `/admin/class/doAssignStudent`,
					data: {
						"type":this.type,
						"classId": id,
						"studentIds": this.timeSelect
					},
					method: "POST",
					success: (e) => {
						if (e.data.code === 200) {
							this.$refs.uToast.show({
								title: '添加成功',
								type: 'success',
								duration: 1000
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
			addDidian(id) {
				uni.request({
					url: this.url + ``,
					data: {
						"DidianName": this.form.didian
					},
					method: "POST",
					success: (e) => {
						if (e.data.code === 200) {
							this.$refs.uToast.show({
								title: '添加成功',
								type: 'success',
								duration: 1000
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
					url:'/pages/class/class'
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
