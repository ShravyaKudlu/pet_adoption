package com.example.pet_adoption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// The repository interface for the Pet entity.
// JpaRepository<Pet, Long> specifies that this repository manages the
// Pet entity and that the primary key type is Long.
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {}
