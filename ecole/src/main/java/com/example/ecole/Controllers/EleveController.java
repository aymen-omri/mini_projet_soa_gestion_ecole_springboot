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

import com.example.ecole.Models.Eleve;
import com.example.ecole.Services.EleveService;

@RestController
@RequestMapping(path="/api/eleve")
public class EleveController {

    final EleveService eleveService;

    @Autowired
    public EleveController(EleveService eleveService){
        this.eleveService = eleveService;
    }

    @GetMapping
    public List<Eleve> getAllEcole(){
        return eleveService.getAll();
    }

    @GetMapping(path="/{id_eleve}")
    public Object findEleveById(@PathVariable("id_eleve") long id){
        return eleveService.findEleveById(id);
    }

    @PostMapping(path="/{id_ecole}")
    public ResponseEntity<String> createEleve(@RequestBody Eleve eleve,@PathVariable("id_ecole") long id){
        try{
            eleveService.createEleve(eleve,id);
            return ResponseEntity.ok("created successfully!");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong!");
        }
    }

    @PutMapping(path="/{id_eleve}")
    public ResponseEntity<String> updateEleve(@RequestBody Eleve eleve , @PathVariable("id_eleve") long id){
        return eleveService.updateEleve(eleve, id);
    }

    @DeleteMapping(path="/{id}")
    public String deleteEcole(@PathVariable("id") long id){
        return eleveService.deleteEleve(id);
    }
}
