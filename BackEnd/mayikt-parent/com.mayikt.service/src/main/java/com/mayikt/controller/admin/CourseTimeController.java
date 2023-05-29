package com.mayikt.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.Coursetime;
import com.mayikt.service.CoursetimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "时间段管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/coursetime")
public class CourseTimeController extends BaseController {
    @Autowired
    private CoursetimeService service;

    @ApiOperation("查询所有时间段")
    @GetMapping("/findAll")
    public Result findAll(){
        List<Coursetime> list = service.list();
        return ok(list);
    }

    @ApiOperation("添加时间段")
    @PostMapping("save")
    public Result save(@RequestBody Coursetime c){
        return service.save(c)?ok():fail();
    }

    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Coursetime c = service.getById(id);
        return ok(c);
    }

    @ApiOperation("修改时间段信息")
    @PutMapping("update")
    public Result update(@RequestBody Coursetime c){
        return service.updateById(c)?ok():fail();
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        return service.removeById(id)?ok():fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        return service.removeByIds(idList)?ok():fail();
    }
}
