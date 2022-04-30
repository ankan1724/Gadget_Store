package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    public Service service;

    @PostMapping("/add")
    public Model addGadgets(@RequestBody Model m) {
        return this.service.addGadgets(m);
    }

    @GetMapping("/gadgets")
    public List<Model> showGadgets() {
        return this.service.getGadgets();
    }

    @GetMapping("/gadgets/{id}")
    public List<Model> showGadgetsbyId(@PathVariable int id) {
        return this.service.getGadgetsbyId(id);
    }

}