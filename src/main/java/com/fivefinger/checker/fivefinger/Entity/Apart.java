package com.fivefinger.checker.fivefinger.Entity;

import com.fivefinger.checker.fivefinger.dto.ApartCreateRequest;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Apart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String sigungu;
  private String name;
  private String year;
  private String month;
  private String day;
  private Long cost;


  public static Apart of(ApartCreateRequest re){
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
