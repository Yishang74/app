<template>
	<view>
		<u-table style="padding: -20upx 0; " v-for="item in classInfo.slice(classkey,classkey+1)">
			<view class="title">
				<span>{{item.name}}</span>
				
			</view>
			<u-tr>
				<u-th>id</u-th>
				<u-th>Name</u-th>
				<u-th>Student ID</u-th>
				<u-th>Password</u-th>
				<u-th>Manage</u-th>
			</u-tr>
			<u-tr v-for="classitem in item.member">
				<u-td>{{classitem.id}}</u-td>
				<u-td>{{classitem.name}}</u-td>
				<u-td>{{classitem.stuid}}</u-td>
				<u-td>{{classitem.password}}</u-td>
				<u-td style="color: red;">{{classitem.manage}}</u-td>
			</u-tr>
		</u-table>
	</view>

</template>

<script>
	export default {
		data() {
			return {
				classkey: '',
				classInfo: [{
						name: 'class one',
						classid: 1,
						member: [{
							id: 1,
							name: 'Ethan',
							stuid: '001',
							password: 1234,
							manage: 'Delete',
						}, {
							id: 2,
							name: 'Amelia',
							stuid: '002',
							password: 1234,
							manage: 'Delete',
						}, {
							id: 3,
							name: 'Jace',
							stuid: '003',
							password: 1234,
							manage: 'Delete',
						}]
					},
					{
						name: 'class two',
						classid: 2,
						member: [{
							id: 1,
							name: 'David',
							stuid: '011',
							password: 1234,
							manage: 'Delete',
						}, {
							id: 2,
							name: 'Lena',
							stuid: '012',
							password: 1234,
							manage: 'Delete',
						}, {
							id: 3,
							name: 'Hena',
							stuid: '013',
							password: 1234,
							manage: 'Delete',
						}]
					}, {
						name: 'class Three',
						classid: 3,
						member: [{
							id: 1,
							name: 'Song',
							stuid: '111',
							password: 1234,
							manage: 'Delete',
						}, {
							id: 2,
							name: 'Yue',
							stuid: '112',
							password: 1234,
							manage: 'Delete',
						}, {
							id: 3,
							name: 'Ying',
							stuid: '113',
							password: 1234,
							manage: 'Delete',
						}]
					},
				]
			}
		},
		methods: {
			onLoad(options) {
				// if()
				this.classkey = this.$store.state.classinfo.classid-1
				console.log(this.classkey)
			}
		},

	}
</script>

<style>
	.title{
		font-size: 50upx;
		display: flex;
		justify-content: center;
		align-items: center;
	}
</style>
