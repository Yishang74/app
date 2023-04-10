package com.mayikt.service.impl;

import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.MayiktService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MayiktServiceImpl extends BaseApiService implements MayiktService {
    @Override
    public BaseResponse<String> getMayikt() {
        return setResultSuccess();
    }

    @Override
    public BaseResponse<String> getMayikt2(Integer age) {
        Integer j=1/age;
        return setResultSuccessData(j);
    }


}
