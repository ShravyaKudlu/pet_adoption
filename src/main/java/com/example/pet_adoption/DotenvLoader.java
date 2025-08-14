package com.example.pet_adoption;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvLoader {

  public static void load() {
    Dotenv dotenv = Dotenv.load();

    // Optionally set environment variables as system properties
    System.setProperty("DB_URL", dotenv.get("DB_URL"));
    System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
    System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
  }
}
