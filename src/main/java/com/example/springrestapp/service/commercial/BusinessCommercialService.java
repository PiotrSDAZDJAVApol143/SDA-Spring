package com.example.springrestapp.service.commercial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("prod")
public class BusinessCommercialService implements CommercialService{
    @Override
    public void sendCommercialOffer(String commercialContent) {
        log.info("Its an offer for buisness costumer " +commercialContent);
    }
}
