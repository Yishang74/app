package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.common.core.utils.MD5Utils;
import com.mayikt.common.core.utils.RedisUtil;
import com.mayikt.entity.SysUser;
import com.mayikt.mapper.SysUserMapper;
import com.mayikt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;
@RestController
public class LoginServiceImpl extends BaseApiService implements LoginService {
    @Autowired(required = false)
    private SysUserMapper sysUserMapper;


    @Override
    public BaseResponse<String> login(String phoneNumber, String password) {
        // 1.验证参数
        if (StringUtils.isEmpty(phoneNumber)) {
            return setResultError("phoneNumber is null");
        }
        if (StringUtils.isEmpty(password)) {
            return setResultError("password is null");
        }
        // 2.将用户的密码加密 （根据手机号码查询 用户信息）
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("phone_number", phoneNumber);
        SysUser sysdbUser = sysUserMapper.selectOne(sysUserQueryWrapper);
        if (sysdbUser == null) {
            return setResultError("该手机号码或者密码错误!");
        }
        String dbPassword = sysdbUser.getPassword();
        String userPassword = MD5Utils.md5(password + sysdbUser.getSalt());
        if (!dbPassword.equals(userPassword)) {
            return setResultError("该手机号码或者密码错误!");
        }
        // 生成对应的用户令牌
        String token = UUID.randomUUID().toString().replace("-", "");
        Integer userId = sysdbUser.getId();
        // 存入到redis中
        RedisUtil.setString(token, userId + "");
        return setResultSuccessData(token);
    }
}