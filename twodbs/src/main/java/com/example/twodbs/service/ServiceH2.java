package com.example.twodbs.service;

import com.example.twodbs.model.EntityH2;
import com.example.twodbs.repository.RepoH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceH2 {
    @Autowired
    private RepoH2 repo;

    public EntityH2 create(EntityH2 user){
        return repo.save(user);
    }
    public EntityH2 find(Long id){
        return repo.findById(id).orElse(null);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
