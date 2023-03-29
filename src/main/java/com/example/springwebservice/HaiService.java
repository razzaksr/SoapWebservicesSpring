package com.example.springwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HaiService {
    @Autowired
    private HaiRepository repository;

    public Hai create(Hai hai){
        return repository.save(hai);
    }
}
