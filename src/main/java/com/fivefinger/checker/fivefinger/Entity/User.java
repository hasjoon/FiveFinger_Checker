package com.fivefinger.checker.fivefinger.Entity;


import com.fivefinger.checker.fivefinger.dto.UserCreateRequest;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
//setter을 선언하지 않아도 쓸 수 있음
public class User {
//20220609 User 과 Coin 차이점?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String job;


    public static User of (UserCreateRequest re){
        return User.builder()
            .name(re.getName())
            .job(re.getJob())
            .build();
    }
}
