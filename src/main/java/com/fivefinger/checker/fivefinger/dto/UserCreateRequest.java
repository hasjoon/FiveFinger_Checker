package com.fivefinger.checker.fivefinger.dto;

import com.fivefinger.checker.fivefinger.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    private Long id;

    private String name;
    private String job;

    public static User of (UserCreateRequest re){
        return User.builder()
            .id(re.getId())
            .name(re.getName())
            .job(re.getJob())
            .build();
    }
}
