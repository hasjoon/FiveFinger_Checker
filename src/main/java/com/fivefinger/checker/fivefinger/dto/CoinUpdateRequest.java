package com.fivefinger.checker.fivefinger.dto;

import lombok.Data;

@Data
public class CoinUpdateRequest {

    private String name;
    private String Currency;
    private Long amount;
}
