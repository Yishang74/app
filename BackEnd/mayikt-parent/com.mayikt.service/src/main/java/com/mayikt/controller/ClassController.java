package com.mayikt.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.*;
import com.mayikt.entity.Class;
import com.mayikt.model.vo.*;
import com.mayikt.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "班级管理")
@CrossOrigin
@RestController
public class ClassController extends BaseController {
    @Autowired
    private ClassService service;
    @Autowired
    private ClassTeacherService classTeacherService;
    @Autowired
    private ClassStudentService classStudentService;
    @Autowired
    private ClassCourseService classCourseService;
    @Autowired
    private WeekdayService weekdayService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ClassService classService;

    @ApiOperation("查询所有班级")
    @GetMapping("/admin/class/findAll")
    public Result findAll(){
        List<Class> list = service.list();
        return ok(list);
    }


    @ApiOperation("条件分页查询")
    @GetMapping("/admin/class/{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                ClassQueryVo sysRoleQueryVo){
        Page<Class> pageParam = new Page<>(page,limit);

        LambdaQueryWrapper<Class> wrapper = new LambdaQueryWrapper<>();
        String className = sysRoleQueryVo.getClassName();
        if(!StringUtils.isEmpty(className)){
            wrapper.like(Class::getClassName,className);
        }
        IPage<Class> pageModel = service.page(pageParam,wrapper);
        return ok(pageModel);
    }

    @ApiOperation("添加班级")
    @PostMapping("/admin/class/save")
    public Result save(@RequestBody ClassVo vo){
        LambdaQueryWrapper<Class> classLambdaQueryWrapper = new LambdaQueryWrapper<>();
        classLambdaQueryWrapper.eq(Class::getClassName,vo.getClassName());
        Class cl = classService.getOne(classLambdaQueryWrapper);
        if (cl==null){
            Class c = new Class();
            c.setClassName(vo.getClassName());
            if(service.save(c)){
                LambdaQueryWrapper<Class> classWrapper = new LambdaQueryWrapper<>();
                classWrapper.eq(Class::getClassName,vo.getClassName());
                c = service.getOne(classWrapper);
                ClassCourse classCourse = new ClassCourse();
                classCourse.setCourseId(vo.getCourseId());
                classCourse.setClassId(c.getId());
                classCourse.setLocation(vo.getLocation());
                if (classCourseService.save(classCourse)){
                    ClassTeacher classTeacher = new ClassTeacher();
                    classTeacher.setClassId(c.getId());
                    classTeacher.setTeacherId(vo.getTeacherId());
                    if(classTeacherService.save(classTeacher)){
                        for (Integer studentId:vo.getStudentId()) {
                            ClassStudent classStudent = new ClassStudent();
                            classStudent.setClassId(c.getId());
                            classStudent.setStudentId(studentId);
                            if(classStudentService.save(classStudent)){
                                for(Integer week:vo.getWeek_no()){
                                    for(Integer day:vo.getDay_no()){
                                        LambdaQueryWrapper<Weekday> weekdayLambdaQueryWrapper = new LambdaQueryWrapper<>();
                                        weekdayLambdaQueryWrapper.eq(Weekday::getWeekNo,week+1);
                                        weekdayLambdaQueryWrapper.eq(Weekday::getDayNo,day+1);
                                        Weekday weekday = weekdayService.getOne(weekdayLambdaQueryWrapper);
                                        for(Integer timetable:vo.getTimeTableId()){
                                            Schedule schedule = new Schedule();
                                            schedule.setCourseId(c.getId());
                                            schedule.setTimetableId(timetable+1);
                                            schedule.setWeekdayId(weekday.getId());
                                            scheduleService.save(schedule);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ok();
    }

    @ApiOperation("根据id查询")
    @GetMapping("/admin/class/get/{id}")
    public Result get(@PathVariable Long id){
        Class c = service.getById(id);
        return ok(c);
    }

    @ApiOperation("修改班级")
    @PostMapping("/admin/class/update")
    public Result update(@RequestBody Class c){
        return service.updateById(c)?ok():fail();
    }

    @ApiOperation("根据id删除")
    @PostMapping("/admin/class/remove/{id}")
    public Result remove(@PathVariable Long id){
        return service.removeById(id)?ok():fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/admin/class/batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        return service.removeByIds(idList)?ok():fail();
    }

    @ApiOperation("为班级重新分配老师")
    @PostMapping("/admin/class/doAssignTeacher")
    public Result doAssignTeacher(@RequestBody AssginTeacherVo vo){
        service.doAssignTeacher(vo);
        return ok();
    }

    @ApiOperation("为班级重新分配学生")
    @PostMapping("/admin/class/doAssignStudent")
    public Result doAssignStudent(@RequestBody AssginStudentVo vo){
        service.doAssignStudent(vo);
        return ok();
    }
    @ApiOperation("获取课程  老师 学生")
    @GetMapping("/admin/class/getClassInfo/{id}")
    public Result getClassInfo(@PathVariable int id){
        Map<String,Object> data = new HashMap<>();
        String className  = service.getById(id).getClassName();
        LambdaQueryWrapper<ClassStudent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ClassStudent::getClassId, id);
        List<ClassStudent> classStudents = classStudentService.list(wrapper);

        LambdaQueryWrapper<ClassTeacher> classTeacherLambdaQueryWrapper = new LambdaQueryWrapper<>();
        classTeacherLambdaQueryWrapper.eq(ClassTeacher::getClassId, id);
        ClassTeacher classTeacher = classTeacherService.getOne(classTeacherLambdaQueryWrapper);

        LambdaQueryWrapper<ClassCourse> classCourseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        classCourseLambdaQueryWrapper.eq(ClassCourse::getClassId, id);
        ClassCourse classCourse = classCourseService.getOne(classCourseLambdaQueryWrapper);
        data.put("className",className);
        data.put("classStudents",classStudents);
        data.put("classTeacher",classTeacher);
        data.put("classCourse",classCourse);
        return ok(data);
    }

    @ApiOperation("获取班级学生")
    @GetMapping("/teacher/class/getClassStudent/{id}")
    public Result getClassStudent(@PathVariable Integer id){
        List<Class> classList = service.getClassByTeacher(id);
        List<ClassInfo> list = new ArrayList<>();
        for (Class c : classList) {
            List<Student> studentList = service.getStudentByClass(c.getId());
            ClassInfo classInfo = new ClassInfo();
            classInfo.setClassName(c.getClassName());
            classInfo.setInfo(studentList);
            list.add(classInfo);
        }
        return ok(list);
    }


}
