package com.mayikt.common.result;

public class BaseController {
    public Result ok() {
        return Result.ok();
    }

    public Result fail() {
        return Result.fail();
    }

    public Result ok(Object data) {
        return Result.ok(data);
    }

    public Result fail(Object data){return Result.fail(data);}

}
