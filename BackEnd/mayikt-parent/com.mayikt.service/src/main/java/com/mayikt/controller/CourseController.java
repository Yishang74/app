package com.mayikt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.Course;
import com.mayikt.entity.Timetable;
import com.mayikt.model.vo.AssginClassVo;
import com.mayikt.model.vo.CourseQueryVo;
import com.mayikt.service.CourseService;
import com.mayikt.service.TimetableService;
import com.mayikt.service.dto.ScheduleCourseResDto;
import com.mayikt.service.dto.SchedultResDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "课程管理")
@CrossOrigin
@RestController
public class CourseController extends BaseController {
    @Autowired
    private CourseService service;

    @Autowired
    private TimetableService timetableService;

    @ApiOperation("查询所有课程")
    @GetMapping("/admin/course/findAll")
    public Result findAll(){
        List<Course> list = service.list();
        return ok(list);
    }


    @ApiOperation("条件分页查询")
    @GetMapping("/admin/course/{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                CourseQueryVo vo){
        Page<Course> pageParam = new Page<>(page,limit);

        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        String name = vo.getName();
        if(!StringUtils.isEmpty(name)){
            wrapper.like(Course::getName,name);
        }
        IPage<Course> pageModel = service.page(pageParam,wrapper);
        return ok(pageModel);
    }

    @ApiOperation("添加课程")
    @PostMapping("/admin/course/save")
    public Result save(@RequestBody Course c){
        if(c.getType() == 1){
            c.setCount(1);
        }
        return service.save(c)?ok():fail();
    }

    @ApiOperation("根据id查询")
    @GetMapping("/admin/course/get/{id}")
    public Result get(@PathVariable Long id){
        Course c = service.getById(id);
        return ok(c);
    }

    @ApiOperation("修改课程信息")
    @PostMapping("/admin/course/update")
    public Result update(@RequestBody Course c){
        return service.updateById(c)?ok():fail();
    }

    @ApiOperation("根据id删除")
    @PostMapping("/admin/course/remove/{id}")
    public Result remove(@PathVariable Long id){
        return service.removeById(id)?ok():fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/admin/course/batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        return service.removeByIds(idList)?ok():fail();
    }

    @ApiOperation("为课程分配班级")
    @PostMapping("/admin/course/doAssign")
    public Result doAssign(@RequestBody AssginClassVo vo){
        service.doAssign(vo);
        return ok();
    }

    @ApiOperation("获取时间段")
    @GetMapping("/getTimetable")
    public Result getTimetable(){
        List<Timetable> list = timetableService.list();
        return ok(list);
    }

    @GetMapping("/getSchedult/{controlWeek}/{id}")
    public Result getSchedule(@PathVariable Integer controlWeek,@PathVariable Integer id){
        String s[][] = new String[7][12];
        for(int i = 0;i<7;i++){
            for (int j = 0;j<12;j++){
                s[i][j] = "";
            }
        }
        List<SchedultResDto> list = timetableService.getSchedule(controlWeek,id);
        int m,n;
        for (SchedultResDto dto:list) {
            m = dto.getDayNo()-1;
            n = dto.getTimetableId()-1;
            s[m][n] = dto.getCourseName();
        }
        return ok(s);
    }

    @GetMapping("/getScheduleCourse")
    public Result getScheduleCourse(@RequestParam Integer teacherId,@RequestParam String name){
        ScheduleCourseResDto dto = timetableService.getScheduleCourse(teacherId,name);
        return ok(dto);
    }

    @GetMapping("/getSchedultStudent/{controlWeek}/{id}")
    public Result getSchedultStudent(@PathVariable Integer controlWeek,@PathVariable Integer id){
        String s[][] = new String[7][12];
        for(int i = 0;i<7;i++){
            for (int j = 0;j<12;j++){
                s[i][j] = "";
            }
        }
        List<SchedultResDto> list = timetableService.getScheduleStudent(controlWeek,id);
        int m,n;
        for (SchedultResDto dto:list) {
            m = dto.getDayNo()-1;
            n = dto.getTimetableId()-1;
            s[m][n] = dto.getCourseName();
        }
        return ok(s);
    }

    @GetMapping("/getScheduleCourseStudent")
    public Result getScheduleCourseStudent(@RequestParam Integer studentId,@RequestParam String name){
        System.out.println(name);
        ScheduleCourseResDto dto = timetableService.getScheduleCourseStudent(studentId,name);
        return ok(dto);
    }
}
