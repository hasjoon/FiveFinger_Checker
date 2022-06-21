package com.fivefinger.checker.fivefinger.Service;


import com.fivefinger.checker.fivefinger.Entity.Apart;
import com.fivefinger.checker.fivefinger.Repository.ApartRepository;
import com.fivefinger.checker.fivefinger.dto.ApartCreateResponse;
import com.fivefinger.checker.fivefinger.dto.ApartCreateRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApartService {

  private final ApartRepository apartRepository;

  public List<Apart> getAllList() {
    return apartRepository.findAll();
  }

  public Apart getOne(Long id) {
    return apartRepository.findById(id).get();
  }

//  public Apart getRequest(ApartCreateRequest apartCreateRequest) {
//    Apart apart = new Apart(
//      0L,
//        apartCreateRequest.getSigungu(),
//        apartCreateRequest.getName(),
//        apartCreateRequest.getYear(),
//        apartCreateRequest.getMonth(),
//        apartCreateRequest.getDay(),
//        apartCreateRequest.getCost()
//    );
//    System.out.println(apart);
//    return apartRepository.save(apart);
//
//  }

  public ApartCreateResponse creatApart (ApartCreateRequest apartCreateRequest) {
    Apart newApart = Apart.of(apartCreateRequest);
    Apart saveApart = apartRepository.save(newApart);

    return ApartCreateResponse.builder()
        .id(saveApart.getId())
        .name(saveApart.getName())
        .cost(saveApart.getCost())
        .build();
  }
}

