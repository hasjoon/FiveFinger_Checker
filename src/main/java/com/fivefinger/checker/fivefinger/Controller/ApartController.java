package com.fivefinger.checker.fivefinger.Controller;


import com.fivefinger.checker.fivefinger.Entity.Apart;
import com.fivefinger.checker.fivefinger.Repository.ApartRepository;
import com.fivefinger.checker.fivefinger.Service.ApartService;
import com.fivefinger.checker.fivefinger.dto.ApartCreateRequest;
import com.fivefinger.checker.fivefinger.dto.ApartCreateResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApartController {
    private final ApartService apartService;

    @GetMapping("/v1/aparts")
    public List<Apart> apartList() {
        return apartService.getAllList();
    }

    @GetMapping("/v1/aparts/{id}")
    public Apart apartList(@PathVariable("id") Long id) {
        return apartService.getOne(id);
    }

    @PostMapping("/v1/aparts")
    public ApartCreateResponse creat(@RequestBody ApartCreateRequest apartCreateRequest){
        System.out.println("시작");
        ApartCreateResponse response = apartService.creatApart(apartCreateRequest);
        System.out.println(response.toString());
        return response;
    }


}
