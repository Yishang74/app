<template>
	<view>
		<u-table>
			<u-tr>
				<u-th>id</u-th>
				<u-th>Name</u-th>
				<u-th>Tel</u-th>
				<u-th>Age</u-th>
				<u-th>Major</u-th>
			</u-tr>
			<u-tr v-for="item in allteacher" style='overflow:unset;'>
				<u-td>{{item.id}}</u-td>
				<u-td>{{item.Name}}</u-td>
				<u-td>{{item.Tel}}</u-td>
				<u-td >{{item.Age}}</u-td>
				<u-td>{{item.Major}}</u-td>
			</u-tr>
			
		</u-table>
		<button style="margin-top: 273px;" type="primary" @click="bindLogout">Log out</button>
	</view>
</template>

<script>
	import {
		mapState,
		mapMutations
	} from 'vuex';
	export default {
		data() {
			return {
				allteacher:[
					{
						id:'1',
						Name:'Amily',
						Tel:'1366',
						Age:'28',
						Major:'CS',
					},{
						id:'2',
						Name:'Lily',
						Tel:'1336',
						Age:'30',
						Major:'CS',
					},
					{
						id:'3',
						Name:'Amily',
						Tel:'1346',
						Age:'20',
						Major:'CS',
					},
					{
						id:'4',
						Name:'Sai',
						Tel:'1376',
						Age:'51',
						Major:'CS',
					}
				]
			}
		},
		methods: {
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
