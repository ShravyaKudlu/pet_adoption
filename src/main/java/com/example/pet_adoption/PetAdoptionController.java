package com.example.pet_adoption;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets") // Sets the base path for all endpoints in this controller
public class PetAdoptionController {

  private final PetRepository petRepository;

  @Autowired
  public PetAdoptionController(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @PostMapping
  public ResponseEntity<Pet> addPet(@RequestBody Pet newPet) {
    try {
      Pet savedPet = petRepository.save(newPet);
      return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping
  public List<Pet> getAllPets() {
    return petRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
    Optional<Pet> pet = petRepository.findById(id);
    return pet.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {
    return petRepository
        .findById(id)
        .map(
            pet -> {
              pet.setName(updatedPet.getName());
              pet.setSpecies(updatedPet.getSpecies());
              pet.setBreed(updatedPet.getBreed());
              pet.setAge(updatedPet.getAge());
              pet.setAdoptionStatus(updatedPet.getAdoptionStatus());
              pet.setArrivalDate(updatedPet.getArrivalDate());
              pet.setDescription(updatedPet.getDescription());
              Pet savedPet = petRepository.save(pet);
              return new ResponseEntity<>(savedPet, HttpStatus.OK);
            })
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PatchMapping("/{id}/adopt")
  public ResponseEntity<Pet> adoptPet(@PathVariable Long id) {
    return petRepository
        .findById(id)
        .map(
            pet -> {
              pet.setAdoptionStatus(AdoptionStatus.ADOPTED);
              Pet savedPet = petRepository.save(pet);
              return new ResponseEntity<>(savedPet, HttpStatus.OK);
            })
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePet(@PathVariable Long id) {
    if (petRepository.existsById(id)) {
      petRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
