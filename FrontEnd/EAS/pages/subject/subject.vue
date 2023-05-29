<template>
	<view>
		<u-search placeholder="Subject name" v-model="keyword" @search="search" @custom="search"></u-search>
		<u-table style="padding: -20upx 0; ">
			<u-tr class="myclass">
				<u-th>id</u-th>
				<u-th>Subject name</u-th>
				<u-th>Subject type</u-th>
				<u-th>Operate</u-th>
			</u-tr>
			<u-tr v-for="item in allclass">
				<u-td>{{item.id}}</u-td>
				<u-td style="color: #54b4ef;"><span @click="showClass(item)">{{item.name}}</span></u-td>
				<u-td>{{item.type==2?'Big class':'Small class'}}</u-td>
				<u-td style="color: orangered;"><span @click="deleteClass(item)">delete</span></u-td>
			</u-tr>
			
		</u-table>
		<view class="uni-pagination-box">
			<uni-pagination show-icon :page-size="pageSize" :current="pageCurrent" :total="total" @change="change" />
		</view>
		<div class="myicon">
			<u-icon name="plus-circle-fill" style="float: right ;" size="100" color="#54b4ef" @click="showAdd()">
			</u-icon>
		</div>

		<!-- <u-modal v-model="showwarning" :content="content"  show-cancel-button="true" title="Warning"></u-modal> -->
	</view>


</template>

<script>
	export default {
		data() {
			return {
				url: 'http://127.0.0.1:8080',
				keyword: '',
				pageSize: 20,
				pageCurrent: 1,
				// 数据总量
				total: 0,
				allclass: [
	
				]
			}
		},
		methods: {
			change(e) {
				this.search(e.current)
			},
			search() {
				uni.request({
					url: `${this.url}/admin/course/${this.pageCurrent}/${this.pageSize}`,
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
				uni.navigateTo({
					url: '/pages/subject/addSubject?id='+item.id
				});
			},
			showAdd() {
				uni.navigateTo({
					url: '/pages/subject/addSubject'
				});
			},
			deleteClass(item) {
				uni.request({
					method: "POST",
					url: `${this.url}/admin/course/remove/${item.id}`,
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
		},
		onLoad() { //创建全局监听自定义事件  改变内容
			this.search()
		},
		
	}
</script>

<style>
.myicon {
		margin-top: 40upx;
	}
</style>
