package com.mayikt.controller.teacher;

import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.Teacher;
import com.mayikt.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "教师管理")
@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherTController extends BaseController {
    @Autowired
    private TeacherService service;

    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Teacher c = service.getById(id);
        return ok(c);
    }

    @ApiOperation("修改教师信息")
    @PutMapping("update")
    public Result update(@RequestBody Teacher c){
        return service.updateById(c)?ok():fail();
    }
}
