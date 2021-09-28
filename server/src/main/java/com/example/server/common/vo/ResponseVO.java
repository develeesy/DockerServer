package com.example.server.common.vo;

import lombok.Data;

@Data
public class ResponseVO {
    String status;
    String message;
    Object result;
}
