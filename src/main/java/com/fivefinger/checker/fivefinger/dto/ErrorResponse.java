package com.fivefinger.checker.fivefinger.dto;

import lombok.Data;

@Data
public class ErrorResponse {

    private String error_message;
    private String error_type;

}
