package com.mayikt.controller.student;

import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.Student;
import com.mayikt.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "学生管理")
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController extends BaseController {
    @Autowired
    private StudentService service;

    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Student c = service.getById(id);
        return ok(c);
    }

    @ApiOperation("修改学生信息")
    @PutMapping("update")
    public Result update(@RequestBody Student c) {
        return service.updateById(c) ? ok() : fail();
    }

}
