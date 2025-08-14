package com.example.pet_adoption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    DotenvLoader.load();
    SpringApplication.run(DemoApplication.class, args);
  }
}
