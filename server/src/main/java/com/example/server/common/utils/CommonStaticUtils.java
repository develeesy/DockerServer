package com.example.server.common.utils;

import java.util.UUID;

public class CommonStaticUtils {
    public static String getUuId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
