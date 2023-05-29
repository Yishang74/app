package com.mayikt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.Evaluation;
import com.mayikt.model.vo.EvaluationQueryVo;
import com.mayikt.service.EvaluationService;
import com.mayikt.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "评价管理")
@CrossOrigin
@RestController
public class EvaluationController extends BaseController {
    @Autowired
    private EvaluationService service;

    @Autowired
    private StudentService studentService;


    @ApiOperation("添加评价")
    @PostMapping("/evaluation/save")
    public Result save(@RequestBody Evaluation c){
        if("s".equals(c.getType())){
            //获取课时
            int courseHours = studentService.queryCourseHoursById(c.getUserId());
            if (courseHours<20){
                return fail("课时小于20");
            }
        }
        return service.save(c)?ok():fail();
    }


    @ApiOperation("查询所有评价")
    @GetMapping("/admin/evaluation/findAll")
    public Result findAll(){
        List<Evaluation> list = service.list();
        return ok(list);
    }


    @ApiOperation("查询班级评价")
    @GetMapping("/teacher/evaluation/findAll/{classId}")
    public Result findAllByClassId(@PathVariable Integer classId){
        List<Evaluation> list = service.findAllByClassId(classId);
        return ok(list);
    }


    @ApiOperation("条件分页查询")
    @GetMapping("/admin/evaluation/{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                EvaluationQueryVo vo){
        Page<Evaluation> pageParam = new Page<>(page,limit);

        LambdaQueryWrapper<Evaluation> wrapper = new LambdaQueryWrapper<>();
        String name = vo.getContent();
        if(!StringUtils.isEmpty(name)){
            wrapper.like(Evaluation::getContent,name);
        }
        IPage<Evaluation> pageModel = service.page(pageParam,wrapper);
        return ok(pageModel);
    }

    @ApiOperation("根据id查询")
    @GetMapping("/evaluation/get/{id}")
    public Result get(@PathVariable Long id){
        Evaluation c = service.getById(id);
        return ok(c);
    }


    @ApiOperation("根据id删除")
    @DeleteMapping("/admin/evaluation/remove/{id}")
    public Result remove(@PathVariable Long id){
        return service.removeById(id)?ok():fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/admin/evaluation/batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        return service.removeByIds(idList)?ok():fail();
    }

}
