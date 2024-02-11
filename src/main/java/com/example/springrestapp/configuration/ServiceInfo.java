package com.example.springrestapp.configuration;

import com.example.springrestapp.DummyController;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class ServiceInfo implements CommandLineRunner {
    @Value("${service.info.name}")
    private String name;
    @Value("${service.info.establishmentDate}")
    private String establishmentDate;
    @Value("${service.info.owner}")
    private String owner;

    public void showCompanyInfo(){log.info(String.format("Company name: [%s], Establishment Date: [%s], Owner: [%s]", name, establishmentDate, owner));
    }

    @Override
    public void run(String... args) throws Exception {
showCompanyInfo();
    }
}
