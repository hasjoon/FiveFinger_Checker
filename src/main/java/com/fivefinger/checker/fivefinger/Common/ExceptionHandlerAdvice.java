package com.fivefinger.checker.fivefinger.Common;

import com.fivefinger.checker.fivefinger.dto.ApartCreateResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private Object ApartCreateResponse;

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity exceptionMy() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("name","hyeonbo");

        return ResponseEntity.status(404).headers(headers).body(ApartCreateResponse);
        //Body에 response 만들어서 json으로 내리기
    }
}