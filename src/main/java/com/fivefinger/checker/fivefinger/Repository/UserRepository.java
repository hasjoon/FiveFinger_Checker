package com.fivefinger.checker.fivefinger.Repository;


import com.fivefinger.checker.fivefinger.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
