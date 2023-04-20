<template>
    <view>
        <ly-curriculumtable  :weekTableState="true" :weekTableNumber="weekNumbers" 
         :controlWeek="controlWeek" :timetableType="timetableType" 
         :timetables="timetables" :startdDate="startdDate" :weekButton="weekButton" 
         @nextWeekClick="nextWeekClick" @lastWeekClick="lastWeekClick" 
         @courseClick="courseClick" @weekSelectClick="weekSelectClick" 
         @weekOpenClick="weekOpenClick">
         </ly-curriculumtable> 
    </view>
</template>
<script>
        export default {
            data() {
                return {
                    weekNumbers:20,//一共显示几周
                    controlWeek:1,//显示的第几周
                    weekButton:true,//开启上一周下一周按钮
                    startdDate:'', //开始时间  默认为当前时间
					// <view v-for="(u,index) in user" :key="index">
					// </view>
                    timetables: [
                      ['ML', 'ML', '', '', '', '', 'Project', 'Project',],
                      ['', '', 'SAT', 'SAT', '', 'SE', 'SE', '', '', '', '', ''],
                      ['WPS', 'WPS', 'HCI', 'HCI', '', '', '', '', ''],
                      ['', '', '', '', 'AE', 'AE', '', '', ''],
                      ['', '', 'IP', 'FOS', '', '', '', '', ''],
                    ],
                    timetableType:[ 
                       { index: '1', name: '08:00\n08:40' },
                       { index: '2', name: '08:50\n09:30' },
                       { index: '3', name: '09:40\n10:20' },
                       { index: '4', name: '10:30\n11:10' },
                       { index: '5', name: '11:20\n12:00' },
                       { index: '6', name: '14:00\n14:40' },
                       { index: '7', name: '15:50\n16:30' },
                       { index: '8', name: '16:40\n17:20' },
                       { index: '9', name: '17:30\n18:10' },
                       { index: '10', name: '19:00\n19:40'},
                       { index: '11', name: '20:50\n21:30'},
                       { index: '12', name: '21:40\n22:20'}]
                }
            },
			onReady() {
				let userInfoToken = uni.getStorageSync('uerInfo').token;
				console.log("userInfoTokenSync:", userInfoToken)
				uni.request({
					url: `http://127.0.0.1:8080/`,
					header: {
						"Content-Type": "application/x-www-form-urlencoded",
						'Authorization': userInfoToken
					},
					data: {},
					method: "GET",
					success: (e) => {
						console.log(e.data)
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
            methods:{
                courseClick(re){
                    console.log(re)
                },
                nextWeekClick(e){
                    console.log("Next Week",e)
                },
                lastWeekClick(e){
                    console.log("Last Week",e)
                },
                weekOpenClick(){
                    console.log("点击了第几周")
                },
                weekSelectClick(e){
                    console.log("您选择了",e)
                },

        },
    }
</script>
