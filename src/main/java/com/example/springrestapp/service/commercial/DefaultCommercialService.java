package com.example.springrestapp.service.commercial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
@Profile("!prod")
public class DefaultCommercialService implements CommercialService{
    @Override

    public void sendCommercialOffer(String commercialContent) {
        log.info("It's offer for default costumers " + commercialContent);
    }
}
