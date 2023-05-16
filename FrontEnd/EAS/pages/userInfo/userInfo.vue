<template>
	<view>
		<u-search placeholder="类型" v-model="type" @click="kechengShow = true" :disabled="disabled" search-icon=""
			action-text="类型"></u-search>
		<u-search placeholder="姓名" v-model="keyword" @search="search" @custom="search"></u-search>
		<u-table style="padding: -20upx 0; ">
			<u-tr class="myclass">
				<u-th>id</u-th>
				<u-th>姓名</u-th>
				<u-th>电话</u-th>
				<u-th>操作</u-th>
			</u-tr>
			<u-tr v-for="item in allclass">
				<u-td>{{item.id}}</u-td>
				<u-td style="color: #54b4ef;"><span @click="showClass(item)">{{item.username}}</span></u-td>
				<u-td>{{item.phone}}</u-td>
				<u-td style="color: orangered;"><span @click="deleteClass(item)">删除</span></u-td>
			</u-tr>

		</u-table>
		<view class="uni-pagination-box">
			<uni-pagination show-icon :page-size="pageSize" :current="pageCurrent" :total="total" @change="change" />
		</view>
		<div class="myicon">
			<u-icon name="plus-circle-fill" style="float: right ;" size="100" color="#54b4ef" @click="showAdd()">
			</u-icon>
		</div>
		<view>
			<u-select v-model="kechengShow" :list="kechengList" @confirm="selectkcConfirm"></u-select>
		</view>
		<u-button type="primary" @click="bindLogout">退出</u-button>
		<!-- <u-modal v-model="showwarning" :content="content"  show-cancel-button="true" title="Warning"></u-modal> -->
	</view>


</template>

<script>
	export default {
		data() {
			return {
				disabled: true,
				showAction: false,
				kechengShow: false,
				type: '学生',
				typeVal: 'student',
				url: 'http://127.0.0.1:8080',
				keyword: '',
				pageSize: 20,
				pageCurrent: 1,
				// 数据总量
				total: 0,
				allclass: [

				],
				kechengList: [{
						value: 'student',
						label: '学生'
					},
					{
						value: 'teacher',
						label: '老师'
					}
				],
			}
		},
		methods: {
			selectkcConfirm(e) {
				this.type = '';
				e.map((val, index) => {
					this.type = val.label;
					this.typeVal = val.value;
				})
				this.search()
			},
			change(e) {
				this.search(e.current)
			},
			search() {
				uni.request({
					url: `${this.url}/admin/${this.typeVal}/${this.pageCurrent}/${this.pageSize}`,
					data: {
						name: this.keyword
					},
					success: (e) => {
						console.log(e.data)
						if (e.data.code === 200) {
							this.allclass = e.data.data.records
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
			showClass(item) {
				if (this.type == '学生') {
					uni.navigateTo({
						url: '/pages/studentInfo/studentInfo?id=' + item.id
					});
				} else {
					uni.navigateTo({
						url: '/pages/studentInfo/teacherInfo?id=' + item.id
					});
				}
			},
			showAdd() {
				if (this.type == '学生') {
					uni.navigateTo({
						url: '/pages/studentInfo/studentInfo'
					});
				} else {
					uni.navigateTo({
						url: '/pages/studentInfo/teacherInfo'
					});
				}

			},
			deleteClass(item) {
				uni.request({
					method: "POST",
					url: `${this.url}/admin/${this.typeVal}/remove/${item.id}`,
					data: {

					},
					success: (e) => {
						if (e.data.code === 200) {
							uni.showModal({
								content: '删除成功',
								showCancel: false
							})
							this.search()
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
			bindLogout() {
				uni.removeStorageSync("hasLogin")
				uni.reLaunch({
					url: '/pages/login/login'
				})
			}
		},
		onShow() { //创建全局监听自定义事件  改变内容
			this.search()
		},

	}
</script>

<style>
	.myicon {
		margin-top: 40upx;
	}
</style>
