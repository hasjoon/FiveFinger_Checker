package com.fivefinger.checker.fivefinger.Repository;

import com.fivefinger.checker.fivefinger.Entity.Coin;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {
    //JpaRepository에 있는 Coin 은 Entity의 Coin 으로 연결됨

}
