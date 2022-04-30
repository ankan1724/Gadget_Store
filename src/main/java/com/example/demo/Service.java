package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    public Repository repository;

    public Model addGadgets(Model m) {
        return this.repository.save(m);
    }

    public List<Model> getGadgets() {
        return this.repository.findAll();
    }

    public List<Model> getGadgetsbyId(int id) {
        return this.repository.findGadgetsById(id);
    }
}