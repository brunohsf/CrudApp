package br.com.si.CrudApp.controller;

import br.com.si.CrudApp.model.PersonModel;
import br.com.si.CrudApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/{id}")
    public Optional<PersonModel> findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public PersonModel save(@RequestBody PersonModel model){
        return service.save(model);
    }

    @GetMapping
    public List<PersonModel> findAll(){
        return service.findAll();
    }

    @PutMapping
    public PersonModel update(@RequestBody PersonModel model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/name/{name}")
    public List<PersonModel> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

}
