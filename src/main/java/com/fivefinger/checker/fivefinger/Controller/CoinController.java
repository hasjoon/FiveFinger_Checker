package com.fivefinger.checker.fivefinger.Controller;

import com.fivefinger.checker.fivefinger.Entity.Coin;
import com.fivefinger.checker.fivefinger.Service.CoinService;
import com.fivefinger.checker.fivefinger.dto.CoinCreateRequest;
import com.fivefinger.checker.fivefinger.dto.CoinCreateResponse;
import com.fivefinger.checker.fivefinger.dto.CoinGetResponse;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinController {

    private final CoinService coinService;


    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/v1/coins/{id}")
    public CoinGetResponse getCoin(@PathVariable("id") Long id){
        CoinGetResponse oneResponse = coinService.getOne3(id);
        return oneResponse;
    }

    @GetMapping("/v1.5/coins/{id}")
    public Coin coinList(@PathVariable("id") Long id){
        return coinService.getOne(id);
    }

    @GetMapping("/v1/coins") //전체스캔 + 에러메세지 출력
    public ResponseEntity coinList(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("name","hyeonbo");
        ResponseEntity<List<Coin>> body = ResponseEntity.ok().headers(headers).body(coinService.getAllList());
        return body;
    }


    @GetMapping("/v2/coins") //전체스캔 v2
    public List<Coin> coinList2(){
        List<Coin> allList = coinService.getAllList();
        return allList;
    }


    @GetMapping("/v3/coins") //전체스캔 v3 CoinGetResponse return
    public List<CoinGetResponse> coinList3(){
        List<CoinGetResponse> allList = coinService.getAllList2();
        return allList;
    }

//    @GetMapping("/v1/coins/{id}")
//    public Coin coinList(@PathVariable("id") Long id){
//        return coinService.getOne(id);
//    }



    @PostMapping("/v1/coins")
    public CoinCreateResponse creat1(@RequestBody CoinCreateRequest re) {
        CoinCreateResponse response = coinService.creatCoin(re);
//        System.out.println(response.toString());
        return response;
    }

    @PostMapping("/v1/coins2")
    public CoinCreateResponse creat2(@RequestBody CoinCreateRequest re) {
        CoinCreateResponse response = coinService.creat2(re);
        System.out.println(response.toString());
        return response;
    }

    //info2로 바꿈
    @PutMapping("/v1/coins/{id}")
    public CoinCreateResponse modifyCoin(@PathVariable("id") Long id, @RequestBody CoinCreateRequest re){
        CoinCreateResponse coinCreateResponse = coinService.updateCoinInfo2(id, re);

        System.out.println(re);
        return coinCreateResponse;
    }

    @DeleteMapping("/v1/coins/{id}")
    public void deleteCoin(@PathVariable("id") Long id) {coinService.deleteCoin(id);}
}
