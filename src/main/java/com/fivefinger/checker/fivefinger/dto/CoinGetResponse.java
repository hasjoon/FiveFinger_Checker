package com.fivefinger.checker.fivefinger.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class CoinGetResponse {
//보여주고 싶은 부분만 보여주기위해서 쓰임

    private Long id;
    //아이디를 넣어주는 이유는 리턴할때 아이디가 보이게 하기 위함
    private String name;
//    private String currency;
    private Long amount;

}
