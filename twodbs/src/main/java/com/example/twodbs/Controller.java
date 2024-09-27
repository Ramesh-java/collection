package com.example.twodbs;

import com.example.twodbs.model.EntityH2;
import com.example.twodbs.service.ServiceH2;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class Controller {
    @Autowired
    private ServiceH2 service;

    @PostMapping("/create")
    public EntityH2 create(@RequestBody EntityH2 user){
        return service.create(user);
    }

    @GetMapping("/{id}")
    public EntityH2 get(@PathVariable Long id){
        return service.find(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
