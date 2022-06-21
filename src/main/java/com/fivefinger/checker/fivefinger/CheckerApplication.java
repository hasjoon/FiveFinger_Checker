package com.fivefinger.checker.fivefinger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  CheckerApplication {

	public static String getMembers2(){
		String members = "3";
		return members;
	}
	public static void main(String[] args) {
		String members = getMembers2();
		System.out.println("리턴 시험" + members.toString());
		SpringApplication.run(CheckerApplication.class, args);

	}
}
