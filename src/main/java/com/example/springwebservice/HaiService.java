package com.example.springwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HaiService {
    @Autowired
    private HaiRepository repository;
    public String delete(int id){
        String info=read(id).getName()+" has deleted";
        repository.deleteById(id);
        return info;
    }
    public Hai read(int id){
        return repository.getById(id);
    }
    public List<Hai> list(){
        return repository.findAll();
    }

    public Hai create(Hai hai){
        return repository.save(hai);
    }
}
