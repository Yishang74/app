package com.mayikt.controller.admin;

import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.ClassCourse;
import com.mayikt.service.ClassCourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/classCourse")
public class ClassCourseController extends BaseController {

    @Autowired
    private ClassCourseService service;

    @ApiOperation("修改考试时间")
    @PutMapping("/update/examTime")
    public Result update(@RequestBody ClassCourse c){
        return service.updateByCourseClass(c)?ok():fail();
    }

    @ApiOperation("查询考试时间")
    @GetMapping("getExamTime/{courseId}/{classId}")
    public Result getExamTime(@PathVariable Integer courseId,@PathVariable Integer classId){
        ClassCourse c = service.getExamTimeById(courseId,classId);
        return ok(c);
    }
}
