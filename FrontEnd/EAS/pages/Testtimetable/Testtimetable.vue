<template>
    <view>
        <ly-curriculumtable  :weekTableState="true" :weekTableNumber="weekNumbers" 
         :controlWeek="controlWeek" :timetableType="timetableType" 
         :timetables="timetables" :startdDate="startdDate" :weekButton="weekButton" 
         @nextWeekClick="nextWeekClick" @lastWeekClick="lastWeekClick" 
         @courseClick="courseClick" @weekSelectClick="weekSelectClick" 
         @weekOpenClick="weekOpenClick">

         </ly-curriculumtable> 
         <!-- 课程详情 -->
         <u-modal class="modal" :show="showMyModal"  title="课程详情" 
                        :closeOnClickOverlay="true" 
                        :showConfirmButton="false" @close="closeModal">
            <view class="slot-content">
                <u-cell-group>
                    <u-cell
                        v-for="(item,index) in modalItem" :key="index"
                        :title="item"
                        :icon="modalIcon[index]"
                                :iconStyle="{color: colorList()[index+1]}"
                        size="large"
                    ></u-cell>
                </u-cell-group>
            </view>
         </u-modal>
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
                    timetables: [
                      ['大学英语', '大学英语', '大学英语', '', '', '', '毛概', '毛概',],
                      ['', '', '信号与系统', '信号与系统', '模拟电子技术基础', '模拟电子技术基础', '模拟电子技术基础', '模拟电子技术基', '', '', '', '信号与系'],
                      ['大学体育', '大学体育', '形势与政策', '形势与政策', '', '', '', '', ''],
                      ['', '', '', '', '电装实习', '电装实习', '', '', ''],
                      ['', '', '数据结构与算法分析数据结构与算法分析', '数据结构与算法分析数据结构与算法分析', '', '', '', '', '信号与系'],
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
                       { index: '12', name: '21:40\n22:20'}],
                    //弹窗属性
                    showMyModal: false,//课程详情弹窗
                    modalIcon: ['calendar','home','server-man','clock'],//图标
                    modalItem: [],//依次是课程名、教室、教师、上课时间--为了适配渲染
                }

            },
            methods:{
                courseClick(re){
                    console.log(re)

                    //console.log(JSON.stringify(re))
                    this.modalItem[0]="课程: "+re.name;
                    this.modalItem[1]="教室: 213"
                    this.modalItem[2]="教师: 吴老师"
                    this.modalItem[3]="时间: 9:00-9:40";
                    this.showMyModal=true;
                    //console.log(",",JSON.stringify(this.modalItem))

                },
                nextWeekClick(e){
                    console.log("下一周",e)
                },
                lastWeekClick(e){
                    console.log("上一周",e)
                },
                weekOpenClick(){
                    console.log("点击了第几周")
                },
                weekSelectClick(e){
                    console.log("您选择了",e)
                },
                //关闭弹窗
                closeModal(){
                    this.showMyModal=this.showMyModal==true?false:true;
                },
                //返回颜色
                colorList() {
                    return [
                        "#ffffff", //0
                        "#ffaa00", //1
                        "#33CC99",
                        "#ff5500", //3
                        "#789262", //4
                        "#66CCCC", //5
                        "#9999FF", //6
                    ]
                },

        },
    }
</script>