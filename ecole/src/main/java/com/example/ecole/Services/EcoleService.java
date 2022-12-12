package com.example.ecole.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecole.Models.Ecole;
import com.example.ecole.Repositories.EcoleRepo;

@Service
public class EcoleService {

    final EcoleRepo ecoleRepo ; 
    
    @Autowired
    public EcoleService(EcoleRepo ecoleRepo){
        this.ecoleRepo = ecoleRepo;
    }

    public List<Ecole> getAll(){
        return ecoleRepo.findAll();
    }

    public Object findEcoleById(long id){
        Optional<Ecole> ecole = ecoleRepo.findById(id);
        if(!ecole.isPresent()){
            return "id not found!";
        }
        return ecole.get();
    }

    public void createEcole(Ecole ecole){
        if(ecoleRepo.findEcoleByEmail(ecole.getEmail()).isPresent()){
            throw new IllegalStateException("email taken!");
        }
        ecoleRepo.save(ecole);
    }

    public ResponseEntity<String> updateEcole(Ecole ecole , long id){
        Optional<Ecole> e = ecoleRepo.findById(id);
        if(!e.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
        }
        Ecole ee = e.get();

        ee.setAdresse(ecole.getAdresse());
        ee.setEmail(ecole.getEmail());
        ee.setNom(ecole.getNom());
        ee.setNum_fax(ecole.getNum_fax());
        ee.setNum_tel(ecole.getNum_tel());

        ecoleRepo.save(ee);

        return ResponseEntity.ok("updated!");
    }

    public String deleteEcole(long id){
        if(!ecoleRepo.existsById(id)){
            return "id not found!";
        }
        ecoleRepo.deleteById(id);
        return "deleted!";
    }
    
}
