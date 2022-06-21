package com.fivefinger.checker.fivefinger.dto;

import com.fivefinger.checker.fivefinger.Entity.Apart;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartCreateRequest {

    private String sigungu;
    private String name;
    private String year;
    private String month;
    private String day;
    private Long cost;

    public static Apart of (ApartCreateRequest re){
        return Apart.builder()
            .sigungu(re.getSigungu())
            .name(re.getName())
            .year(re.getYear())
            .month(re.getMonth())
            .day(re.getDay())
            .cost(re.getCost())
            .build();
    }
}
