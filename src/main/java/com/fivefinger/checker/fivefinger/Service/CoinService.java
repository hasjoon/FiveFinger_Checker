package com.fivefinger.checker.fivefinger.Service;

import com.fivefinger.checker.fivefinger.Common.NotFoundException;
import com.fivefinger.checker.fivefinger.Entity.Coin;
import com.fivefinger.checker.fivefinger.Repository.CoinRepository;
import com.fivefinger.checker.fivefinger.dto.CoinCreateResponse;
import com.fivefinger.checker.fivefinger.dto.CoinCreateRequest;
import com.fivefinger.checker.fivefinger.dto.CoinGetResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Builder
public class CoinService {

    private final CoinRepository coinRepository;

//    public CoinService(CoinRepository coinRepository) {
//        this.coinRepository = coinRepository;
//    }
    //@RequiredArgsConstructor 해주면 컨스트럭터 선언 필요없음

    public List<Coin> getAllList() {
        return coinRepository.findAll();
    }

    public List<CoinGetResponse> getAllList2() {
        List<Coin> newCoins = coinRepository.findAll();

        List<CoinGetResponse> coinGetResponses = new ArrayList<>();

        newCoins.forEach(row -> {
            CoinGetResponse response = CoinGetResponse.builder()
                .id(row.getId())
                .name(row.getName())
                .amount(row.getAmount())
                .build();

            coinGetResponses.add(response);
        });

//        List<CoinGetResponse> response = newCoins.stream()
//            .map(r -> {
//                CoinGetResponse.builder().amount(r.getAmount()).build();
//                CoinGetResponse.builder().amount(r.getAmount()).build();
//                return CoinGetResponse.builder().amount(r.getAmount()).build();
//            }) //map: change the form [reduce the fild]
//            .collect(Collectors.toList()); //스트림 = collect로 묶어주고 끝냄

        return coinGetResponses;
    }

    public Coin getOne(Long id){
        return coinRepository.findById(id).get();
    }

    public Coin getOne2(Long id) {
//        return coinRepository.findById(id).orElseThrow(MyException::new);
        //클래스 선언하는방법
        return coinRepository.findById(id).orElseThrow(() -> new NotFoundException());
        //functional programming
        //orElseThrow = 없다면 괄호안 해라
        //findBy 할때만 보통쓴다
        //찾으려고 했는데 찾지 못했을때 쓴다
        //orElse 무엇?
    }

    public CoinGetResponse getOne3(Long id) {
        Coin newCoin = coinRepository.getById(id);

        return CoinGetResponse.builder()
            .id(newCoin.getId())
            .amount(newCoin.getAmount())
            .name(newCoin.getName())
            .build();
    }
    //currency 를 넣어주지만 보이지 않음 포스트맨에서는

    public CoinCreateResponse creatCoin(CoinCreateRequest coinCreateRequest) {
        Coin newCoin = Coin.of(coinCreateRequest);
        Coin saveCoin = coinRepository.save(newCoin);

        //response 쓰는이유?
        return CoinCreateResponse.builder()
            //값이 없을때
            //postman 표시 = null
            //DB = Json으로 포스트 맨에서 넣어준 값은 저장됨
            //포스트 맨에서 눈으로만 보이지 않음
            .id(saveCoin.getId())
//            .name(saveCoin.getName())
            .currency(saveCoin.getCurrency())
            .amount(saveCoin.getAmount())
            .build();
    }

    public CoinCreateResponse creat2(CoinCreateRequest re) {
        Coin newCoin = new Coin(
            0L,
            re.getName(),
            re.getCurrency(),
            re.getAmount()
        );//꺼내오는 순서 맞춰줘야됨

        return CoinCreateResponse.builder()
            .name(newCoin.getName())
            .amount(newCoin.getAmount())
            .build();
    }

//    public void updateCoinInfo(Long id, CoinCreateRequest re){
//        Coin coin = coinRepository.findById(id).get();
//        System.out.println("코인 아이디 조회" + coin);
//
//       coin.setName(re.getName());
//       coin.setCurrency(re.getCurrency());
//       coin.setAmount(re.getAmount());
//
//       coinRepository.save(coin);
//    }

    public void updateCoinInfo(Long id, CoinCreateRequest re) {
        Coin coin = coinRepository.findById(id).orElseThrow(() -> new NotFoundException());

        coin.setName(re.getName());
        coin.setCurrency(re.getCurrency());
        coin.setAmount(re.getAmount());

        coinRepository.save(coin);
    }

    public CoinCreateResponse updateCoinInfo2(Long id, CoinCreateRequest re) {
        Coin coin = coinRepository.findById(id).orElseThrow(() -> new NotFoundException());
        coin.setName(re.getName());
        coin.setCurrency(re.getCurrency());
        coin.setAmount(re.getAmount());

        Coin save = coinRepository.save(coin);

        return CoinCreateResponse.builder()
            .name(coin.getName())
//            .amount(coin.getAmount())
            .currency(coin.getCurrency())
            .build();
    }
//예상 결과값: 포스트 맨에서 id = null/ amount = null;


    public void deleteCoin(Long id) {
        Coin coin = coinRepository.findById(id).get();
        coinRepository.delete(coin);
    }

}
