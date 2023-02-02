package com.example.eezaka.controller;

import com.example.eezaka.model.Enchere;
import com.example.eezaka.repository.EnchereAllrepository;
import com.example.eezaka.repository.EnchereDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/enchere")
public class EnchereController {
    @Autowired
    EnchereAllrepository enchereAllrepository;
    @Autowired
    EnchereDetailRepository enchereDetailrepository;
    //Findall
    @GetMapping("/listenchere")
    public List<Enchere> getAllenchere(){
        return (List<Enchere>) enchereAllrepository.findAll();
    }
    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<Enchere> getEnchereById(@PathVariable(value="id") String EnchereId){
        Enchere enchere = enchereDetailrepository.findById(EnchereId).orElse(null);
            if(enchere == null) {
                System.out.println("Tsy miexiste");
                }
            return ResponseEntity.ok().body(enchere);
            }
}