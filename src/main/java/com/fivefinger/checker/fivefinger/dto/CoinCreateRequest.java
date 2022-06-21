package com.fivefinger.checker.fivefinger.dto;

import com.fivefinger.checker.fivefinger.Entity.Coin;
import com.fivefinger.checker.fivefinger.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoinCreateRequest {

//    private Long id;
    private String name;
    private String currency;
    private Long amount;

    public static Coin of (CoinCreateRequest re){
        return Coin.builder()
            .name(re.getName())
            .currency(re.getCurrency())
            .amount(re.getAmount())
            .build();
    }
}
