package com.example.springrestapp.controller.commercial;

import com.example.springrestapp.service.commercial.CommercialService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commercial")
@RequiredArgsConstructor
public class CommercialController {
    private final CommercialService commercialService;

 //  public CommercialController(@Qualifier("businessCommercialService")
 //                              CommercialService commercialService) {
 //      this.commercialService = commercialService;
 //  }



    @PostMapping
    public ResponseEntity<Void> sendCommercial(@RequestBody String content){
        commercialService.sendCommercialOffer(content);
        return ResponseEntity.ok().build();
    }


}
