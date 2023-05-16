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
                    timetables: [],
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
			mounted() {
				// this.$axios.get("/getTimetable").then(res=>{
				// 	if(res.code = 200){
				// 		this.timetableType = res.data.data
				// 	}
				// }),
				var userInfo = JSON.parse(sessionStorage.getItem("userInfo"))
				this.$axios.get("/getSchedult/"+this.controlWeek+'/'+userInfo.id).then(res=>{
					if(res.code = 200){
						this.timetables = res.data.data
						
					}
				})
			},
            methods:{
                courseClick(re){
					var userInfo = JSON.parse(sessionStorage.getItem("userInfo"))
					console.log(re)
                     this.$axios.get("/getScheduleCourse",{
						 params:{
							 teacherId:userInfo.id,
							 name:re.name
						 }
					 }).then(res=>{
						
					 	console.log(res)
					 })
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
