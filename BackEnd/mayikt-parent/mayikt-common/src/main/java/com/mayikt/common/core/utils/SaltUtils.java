package com.mayikt.common.core.utils;

import java.util.UUID;


public class SaltUtils {
    /**
     * 生成盐值
     *
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
