package com.example.ecole.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecole.Models.Ecole;
import com.example.ecole.Services.EcoleService;

@RestController
@RequestMapping(path="/api/ecole")
public class EcoleContoller {

    final EcoleService ecoleService;

    @Autowired
    public EcoleContoller(EcoleService ecoleService){
        this.ecoleService = ecoleService;
    }

    @GetMapping
    public List<Ecole> getAllEcole(){
        return ecoleService.getAll();
    }

    @GetMapping(path="/{id_ecole}")
    public Object findEcoleById(@PathVariable("id_ecole") long id){
        return ecoleService.findEcoleById(id);
    }

    @PostMapping
    public ResponseEntity<String> createEcole(@RequestBody Ecole ecole){
        try{
            ecoleService.createEcole(ecole);
            return ResponseEntity.ok("created successfully!");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong!");
        }
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<String> updateEcole(@RequestBody Ecole ecole , @PathVariable("id") long id){
        return ecoleService.updateEcole(ecole, id);
    }

    @DeleteMapping(path="/{id}")
    public String deleteEcole(@PathVariable("id") long id){
        try{
            return ecoleService.deleteEcole(id);
        }catch(Exception e){
            return "delete Eleve first!";
        }
        
    }
    
}
