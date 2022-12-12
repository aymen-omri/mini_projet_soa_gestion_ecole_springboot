package com.example.ecole.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecole.Models.Eleve;
import com.example.ecole.Repositories.EcoleRepo;
import com.example.ecole.Repositories.EleveRepo;

@Service
public class EleveService {
    final EleveRepo eleveRepo;
    final EcoleRepo ecoleRepo ; 

    @Autowired
    public EleveService(EleveRepo eleveRepo,EcoleRepo ecoleRepo){
        this.eleveRepo = eleveRepo ;
        this.ecoleRepo = ecoleRepo ;  
    }

    public List<Eleve> getAll(){
        return eleveRepo.findAll();
    }

    public Object findEleveById(long id){
        Optional<Eleve> ecole = eleveRepo.findById(id);
        if(!ecole.isPresent()){
            return "id not found!";
        }
        return ecole.get();
    }

    public void createEleve(Eleve eleve , long id_ecole){
        if(!ecoleRepo.findById(id_ecole).isPresent()){
            throw new IllegalStateException("id ecole not found!");
        }
        if(eleveRepo.findEleveByEmail(eleve.getEmail()).isPresent()){
            throw new IllegalStateException("email taken!");
        }
        eleve.setEcole(ecoleRepo.findById(id_ecole).get());
        eleveRepo.save(eleve);
    }

    public ResponseEntity<String> updateEleve(Eleve eleve , long id_eleve){
        Optional<Eleve> e = eleveRepo.findById(id_eleve);
        if(!e.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
        }
        Eleve ee = e.get();

        ee.setAdresse(eleve.getAdresse());
        ee.setEmail(eleve.getEmail());
        ee.setNom(eleve.getNom());
        ee.setNum_tel_eleve(eleve.getNum_tel_eleve());
        ee.setDate_naiss(eleve.getDate_naiss());

        eleveRepo.save(ee);

        return ResponseEntity.ok("updated!");
    }

    public String deleteEleve(long id_eleve){
        if(!eleveRepo.existsById(id_eleve)){
            return "id not found!";
        }
        eleveRepo.deleteById(id_eleve);
        return "deleted!";
    }
    
}
