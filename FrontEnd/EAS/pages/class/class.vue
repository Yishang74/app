<template>
	<view>
		<u-table style="padding: -20upx 0; ">
			<u-tr class="myclass">
				<u-th>id</u-th>
				<u-th>Name</u-th>
				<u-th>Student Number</u-th>
				<u-th>Manage</u-th>
			</u-tr>
			<u-tr v-for="item in allclass">
				<u-td>{{item.classid}}</u-td>
				<u-td style="color: #54b4ef;"><span @click="showClass(item)">{{item.Name}}</span></u-td>
				<u-td>{{item.StudentNumber}}</u-td>
				<u-td style="color: orangered;"><span @click="deleteClass(item)">{{item.Manage}}</span></u-td>
			</u-tr>
			<div class="myicon">
				<u-icon name="plus-circle-fill" style="float: right ;" size="100" color="#54b4ef" @click="showAdd()">
				</u-icon>
			</div>
		</u-table>
		<!-- <u-modal v-model="showwarning" :content="content"  show-cancel-button="true" title="Warning"></u-modal> -->
	</view>


</template>

<script>
	import queryParams from 'uview-ui/libs/function/queryParams';
	import {
		mapMutations
	} from 'vuex';
	export default {
		data() {
			return {
				allclass: [{
						classid: 1,
						Name: 'class one',
						StudentNumber: 3,
						Manage: 'Delete'
					},
					{
						classid: 2,
						Name: 'class two',
						StudentNumber: 3,
						Manage: 'Delete'
					},
					{
						classid: 3,
						Name: 'class three',
						StudentNumber: 3,
						Manage: 'Delete'
					},

				]
			}
		},
		methods: {

			showClass(item) {
				// uni.navigateTo({
				//     url: 'pages/classInfo'   /*这是跳转到的页面路径，？id=1这些都是传递的数据，可以直接在test页面接受
				// });
				uni.navigateTo({
					url: '/pages/classInfo/classInfo'
				});

				this.setClassId(item)

				console.log(this.$store.state.classinfo.classid, this.$store.state.classinfo.classname)
			},
			showAdd() {
				uni.navigateTo({
					url: '/pages/AddClass/AddClass'
				});
			},
			deleteClass(item) {
				// var id = item.id
				// // this.allclass.forEach(index=>{
				// // 	if(id == index.id){
				// // 		return true
				// // 	}
				// // })
				// // this.allclass.splice(id-1,1)
				// consol.log(id)
				// console.log(item.id)

				var i = this.allclass.length - 1
				for (i; i >= 0; i--) {
					if (this.allclass[i].classid === item.classid) {
						this.allclass.splice(i, 1);
					}
				}
			},
			...mapMutations(['setClassId'])
		},
		onLoad() { //创建全局监听自定义事件  改变内容
			uni.$on('addclass', classinfo => {
				// console.log(111)
				console.log('classinfo', classinfo)
				let newclassinfo={}
				newclassinfo.Manage = classinfo.Manage
				newclassinfo.Name = classinfo.Name
				newclassinfo.StudentNumber=classinfo.StudentNumber
				newclassinfo.classid=classinfo.classid
				this.allclass.push(newclassinfo)
				console.log('allclass', this.allclass)
			})
		},
		onUnload() {
			uni.$off('addclass');
		}
	}
</script>

<style>
	.myclass {
		margin-top: 40upx;
	}

	.myicon {
		margin-top: 40upx;
	}
</style>
