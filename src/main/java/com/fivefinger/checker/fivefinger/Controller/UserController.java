package com.fivefinger.checker.fivefinger.Controller;

import com.fivefinger.checker.fivefinger.Entity.Apart;
import com.fivefinger.checker.fivefinger.Entity.Coin;
import com.fivefinger.checker.fivefinger.Entity.User;
import com.fivefinger.checker.fivefinger.Service.ApartService;
import com.fivefinger.checker.fivefinger.Service.CoinService;
import com.fivefinger.checker.fivefinger.Service.UserService;
import com.fivefinger.checker.fivefinger.dto.ApartCreateResponse;
import com.fivefinger.checker.fivefinger.dto.ApartCreateRequest;
import com.fivefinger.checker.fivefinger.dto.CoinCreateResponse;
import com.fivefinger.checker.fivefinger.dto.CoinCreateRequest;
import com.fivefinger.checker.fivefinger.dto.UserCreateRequest;
import com.fivefinger.checker.fivefinger.dto.UserCreateResponse;
import java.util.List;
import javax.websocket.server.PathParam;
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
public class UserController {

  private final UserService userService;

  public UserController(ApartService apartService,
      UserService userService, CoinService coinService) {
    this.userService = userService;
  }


  @GetMapping("/v1/users")
  public List<User> userList() {
    return userService.getAllList();
  }

  @GetMapping("/v1/users/{id}")
  public User userList(@PathVariable("id") Long id) {
    return userService.getOne(id);
  }

  @PostMapping("/v1/users")
  public void creat(@RequestBody UserCreateRequest userCreateRequest){
    UserCreateResponse response = userService.creatUser(userCreateRequest);
//    return response;
    System.out.println(response.toString());
  }

  //of 패턴 없는  POST User
  @PostMapping("/v1/users2")
  public User create(@RequestBody UserCreateRequest re){
    User request = userService.getRequest(re);
    System.out.println("of패턴 없는 포스트 메소드 반환"+ request.toString());
    return request;
  }

  @PutMapping("/v1/users/{id}")
  public void modify(@PathVariable("id") Long id, @RequestBody UserCreateRequest re){
    userService.updateUserInfo(id,re);
    System.out.println(re);
  }


  //DELETE Mappings
  @DeleteMapping("/v1/users/{id}") //하드딜리트
  public void delete(@PathVariable("id") Long id){
    userService.deleteUserById(id);
  }


}

