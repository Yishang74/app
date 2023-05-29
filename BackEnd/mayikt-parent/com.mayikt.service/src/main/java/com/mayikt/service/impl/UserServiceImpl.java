//package com.mayikt.service.impl;
//
//import com.mayikt.common.core.api.BaseApiService;
//import com.mayikt.common.core.api.BaseResponse;
//import com.mayikt.common.core.utils.MayiktBeanUtils;
//import com.mayikt.common.core.utils.RedisUtil;
//import com.mayikt.service.UserService;
//import com.mayikt.service.dto.UserResDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class UserServiceImpl extends BaseApiService implements UserService {
//    @Autowired(required = false)
//    private SysUserMapper sysUserMapper;
//
//    @Override
//    public BaseResponse<UserResDto> getByTokenUserInfo(String token) {
//        if (StringUtils.isEmpty(token)) {
//            return setResultError("token is null");
//        }
//        // 从redis中获取到对应的userid
//        String redisUserId = RedisUtil.getString(token);
//        if (StringUtils.isEmpty(redisUserId)) {
//            return setResultError("数据异常");
//        }
//        Integer userId = Integer.parseInt(redisUserId);
//        // 从db中查询到数据
//        SysUser sysdbUser = sysUserMapper.selectById(userId);
//        if (sysdbUser == null) {
//            setResultError("token错误!");
//        }
//        // do转化成dto
//        UserResDto userResDto = MayiktBeanUtils.doToDto(sysdbUser, UserResDto.class);
//        return setResultSuccessData(userResDto);
//    }
//}