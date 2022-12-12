package com.example.ecole.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecole.Models.Eleve;

@Repository
public interface EleveRepo extends JpaRepository<Eleve , Long> {
    Optional<Eleve> findEleveByEmail(String email);
}
