<template>
	<view>
		<u-table style="height:100upx;">
			<u-tr>
				<u-th>id</u-th>
				<u-th>Teaching class</u-th>
				<u-th>Course No</u-th>
				<u-th>Course Name</u-th>
				<u-th>Course Teacher</u-th>
			</u-tr>
			<u-tr v-for="item in allsubject" style='overflow:unset;'>
				<u-td>{{item.id}}</u-td>
				<u-td>{{item.TeachingClass}}</u-td>
				<u-td>{{item.CourseNo}}</u-td>
				<u-td >{{item.CourseName}}</u-td>
				<u-td>{{item.CourseTeacher}}</u-td>
			</u-tr>
			
		</u-table>
		<!-- <u-modal v-model="showwarning" :content="content"  show-cancel-button="true" title="Warning"></u-modal> -->
	</view>
</template>

<script>
	export default {
		data() {
			return {
				allsubject: [{
					id: '1',
					TeachingClass:'Class one and Class tow',
					CourseNo:'001',
					CourseName:'ML',
					CourseTeacher:'Amily'
				},
				{
					id: '2',
					TeachingClass:'Class one and Class Three',
					CourseNo:'002',
					CourseName:'Data structure',
					CourseTeacher:'Lily'
				},
				{
					id: '3',
					TeachingClass:'Class tow',
					CourseNo:'003',
					CourseName:'Database principle',
					CourseTeacher:'Neo'
				},{
					id: '4',
					TeachingClass:'Class tow and Class Three',
					CourseNo:'001',
					CourseName:'Computer network',
					CourseTeacher:'Sai'
				}]
			}
		},
		methods: {

		}
	}
</script>

<style>

</style>
