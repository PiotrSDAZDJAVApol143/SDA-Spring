package com.example.springrestapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
// tylko na czas zadania
public class WorkshopInfo {
 @Value("${Workshop.info.author}")
 private String author;
 @Value("${Workshop.info.name}")
 private String name;
 @Value("${Workshop.info.date}")
 private String date;
//
public void showDataFromProperties() {
    System.out.printf("Author: [%s], workshop name: [%s], year: [%s]", author, name, date);
}
}
