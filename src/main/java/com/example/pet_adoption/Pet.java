package com.example.pet_adoption;

import jakarta.persistence.*;
import java.time.LocalDate;

enum Species {
  DOG,
  CAT,
  BIRD,
  RABBIT,
  OTHER
}

enum AdoptionStatus {
  AVAILABLE,
  ADOPTED,
  PENDING
}

@Entity
@Table(name = "pets")
class Pet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Species species;

  @Column(length = 50)
  private String breed;

  private Integer age;

  @Enumerated(EnumType.STRING)
  @Column(name = "adoption_status", nullable = false)
  private AdoptionStatus adoptionStatus;

  @Column(name = "arrival_date", nullable = false)
  private LocalDate arrivalDate;

  @Column(length = 250)
  private String description;

  public Pet() {}

  public Pet(
      String name,
      Species species,
      String breed,
      Integer age,
      AdoptionStatus adoptionStatus,
      LocalDate arrivalDate,
      String description) {
    this.name = name;
    this.species = species;
    this.breed = breed;
    this.age = age;
    this.adoptionStatus = adoptionStatus;
    this.arrivalDate = arrivalDate;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name != null && name.length() > 50) {
      throw new IllegalArgumentException("Name must not exceed 50 characters.");
    }
    this.name = name;
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public AdoptionStatus getAdoptionStatus() {
    return adoptionStatus;
  }

  public void setAdoptionStatus(AdoptionStatus adoptionStatus) {
    this.adoptionStatus = adoptionStatus;
  }

  public LocalDate getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(LocalDate arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    if (description != null && description.length() > 250) {
      throw new IllegalArgumentException("Description must not exceed 250 characters.");
    }
    this.description = description;
  }
}
