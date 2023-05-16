<template>
	<view>
		<u-cell-group v-for="item in classInfo">
			<u-cell-group :title="item.className">
				<u-cell-item v-for="student in item.info" :title="student.username" @click='checkStuInfo(student)'></u-cell-item>
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
		computed: {
			getPhone() {
				var reg = /^(\d{3})\d{4}(\d{4})$/;
				return this.phone.replace(reg, "$1****$2");
			}
		},
		data() {
			return {
				classInfo: []
			}
		},
		mounted() {
			var userInfo = JSON.parse(sessionStorage.getItem("userInfo"))
			this.$axios.get("/teacher/class/getClassStudent/" + userInfo.id).then(res => {
				if (res.code = 200) {
					this.classInfo = res.data.data
					console.log(this.classInfo)
				}
			})
		},
		methods: {
			checkStuInfo(data) {
				uni.navigateTo({
					url: '/pages/studentInfo/studentInfo?id='+data.id,
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