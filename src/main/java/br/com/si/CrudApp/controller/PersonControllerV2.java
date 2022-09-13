package br.com.si.CrudApp.controller;

import br.com.si.CrudApp.model.PersonModelV2;
import br.com.si.CrudApp.service.PersonServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person/v2")
public class PersonControllerV2 {

    @Autowired
    private PersonServiceV2 service;

    @GetMapping("/{id}")
    public Optional<PersonModelV2> findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public PersonModelV2 save(@RequestBody PersonModelV2 model){
        return service.save(model);
    }

    @GetMapping
    public List<PersonModelV2> findAll(){
        return service.findAll();
    }

    @PutMapping
    public PersonModelV2 update(@RequestBody PersonModelV2 model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/name/{name}")
    public List<PersonModelV2> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

}
