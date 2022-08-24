package br.com.si.CrudApp.service;

import br.com.si.CrudApp.model.PersonModel;
import br.com.si.CrudApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Optional<PersonModel> findById(long id){
        return repository.findById(id);
    }

    public List<PersonModel> findAll(){
        return repository.findAll();
    }

    public PersonModel save(PersonModel model){
        return repository.save(model);
    }

    public PersonModel update(PersonModel model){
        Optional<PersonModel> p = repository.findById(model.getId());
        if(p.isPresent()){
            p.get().setFullName(model.getFullName());
            p.get().setEmail(model.getEmail());
            p.get().setGender(model.getGender());
            return repository.save(p.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        Optional<PersonModel> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
        }
    }

    public List<PersonModel> findByName(String name){
        return repository.findByFullNameContainsIgnoreCaseOrderByFullName(name);
    }

}
