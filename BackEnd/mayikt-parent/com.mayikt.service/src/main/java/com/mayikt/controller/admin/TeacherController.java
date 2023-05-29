package com.mayikt.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.Teacher;
import com.mayikt.model.vo.StudentQueryVo;
import com.mayikt.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "教师管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/teacher")
public class TeacherController extends BaseController {
    @Autowired
    private TeacherService service;

    @ApiOperation("查询所有教师")
    @GetMapping("/findAll")
    public Result findAll(){
        List<Teacher> list = service.list();
        return ok(list);
    }


    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                StudentQueryVo vo){
        Page<Teacher> pageParam = new Page<>(page,limit);

        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        String name = vo.getUsername();
        if(!StringUtils.isEmpty(name)){
            wrapper.like(Teacher::getUsername,name);
        }
        IPage<Teacher> pageModel = service.page(pageParam,wrapper);
        return ok(pageModel);
    }

    @ApiOperation("添加教师")
    @PostMapping("save")
    public Result save(@RequestBody Teacher c){
        return service.save(c)?ok():fail();
    }

    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Teacher c = service.getById(id);
        return ok(c);
    }

    @ApiOperation("修改教师信息")
    @PostMapping("update")
    public Result update(@RequestBody Teacher c){
        return service.updateById(c)?ok():fail();
    }

    @ApiOperation("根据id删除")
    @PostMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        return service.removeById(id)?ok():fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        return service.removeByIds(idList)?ok():fail();
    }
}
