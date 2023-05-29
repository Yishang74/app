package com.mayikt.controller.teacher;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.Student;
import com.mayikt.model.vo.StudentQueryVo;
import com.mayikt.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "学生管理")
@RestController
@CrossOrigin
@RequestMapping("/teacher/student")
public class StudentTController extends BaseController {
    @Autowired
    private StudentService service;

    @ApiOperation("查询我的学生")
    @GetMapping("/findAll/{teacherId}")
    public Result findAll(@PathVariable Integer teacherId) {
        List<Student> list = service.queryStudentByTeacher(teacherId);
        return ok(list);
    }


    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                StudentQueryVo vo) {
        Page<Student> pageParam = new Page<>(page, limit);

        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        String name = vo.getUsername();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(Student::getUsername, name);
        }
        IPage<Student> pageModel = service.page(pageParam, wrapper);
        return ok(pageModel);
    }

    @ApiOperation("添加学生")
    @PostMapping("save")
    public Result save(@RequestBody Student c) {
        return service.save(c) ? ok() : fail();
    }

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

    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        return service.removeById(id) ? ok() : fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        return service.removeByIds(idList) ? ok() : fail();
    }

}
