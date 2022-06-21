package com.fivefinger.checker.fivefinger.Service;
import com.fivefinger.checker.fivefinger.Entity.User;
import com.fivefinger.checker.fivefinger.Repository.UserRepository;
import com.fivefinger.checker.fivefinger.dto.UserCreateRequest;
import com.fivefinger.checker.fivefinger.dto.UserCreateResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllList() {
        return userRepository.findAll();
    }

    public User getOne(Long id) {
        return userRepository.findById(id).get();
    }

    public UserCreateResponse creatUser (UserCreateRequest userCreateRequest){
        User newUser = User.of(userCreateRequest);
        User saveUser = userRepository.save(newUser);

        return UserCreateResponse.builder()
            .id(saveUser.getId())
            .name(saveUser.getName())
            .build();
    }

    public User getRequest (UserCreateRequest re){
        User newUser = new User(
            0L,
            re.getName(),
            re.getJob()
        );

        return userRepository.save(newUser);
        //리턴타입이 User 인가?
    }

    public void updateUserInfo(Long id, UserCreateRequest re){

//        User user = this.getOne(id);

        User user = userRepository.findById(id).get();
        System.out.println("유저조회" + user);

        user.setName(re.getName());
        user.setJob(re.getJob());

        System.out.println("서버에 올림" + user);

        userRepository.save(user);

        System.out.println("DB에 올라감" + user);



    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }
    //포스트맨 바디가 있어도 에러가 안뜸
}
