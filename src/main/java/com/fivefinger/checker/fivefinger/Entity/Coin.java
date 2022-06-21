package com.fivefinger.checker.fivefinger.Entity;

import com.fivefinger.checker.fivefinger.dto.CoinCreateRequest;
import com.fivefinger.checker.fivefinger.dto.UserCreateRequest;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
