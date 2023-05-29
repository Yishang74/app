package com.mayikt.controller.admin;

import com.mayikt.common.result.BaseController;
import com.mayikt.common.result.Result;
import com.mayikt.entity.Admin;
import com.mayikt.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "管理员信息")
@CrossOrigin
@RestController
@RequestMapping("/admin/admin")
public class AdminController extends BaseController {
    @Autowired
    private AdminService service;

    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Admin c = service.getById(id);
        return ok(c);
    }

    @ApiOperation("修改信息")
    @PutMapping("update")
    public Result update(@RequestBody Admin c){
        return service.updateById(c)?ok():fail();
    }

}

