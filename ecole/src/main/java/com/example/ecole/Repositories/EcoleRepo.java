package com.example.ecole.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecole.Models.Ecole;

@Repository
public interface EcoleRepo extends JpaRepository<Ecole,Long> {

    Optional<Ecole> findEcoleByEmail(String email);
    
}
