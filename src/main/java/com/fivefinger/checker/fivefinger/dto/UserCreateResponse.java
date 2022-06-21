package com.fivefinger.checker.fivefinger.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class UserCreateResponse {

    private Long id;
    private String name;
}
