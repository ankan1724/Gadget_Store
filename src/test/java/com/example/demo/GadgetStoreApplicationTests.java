package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class GadgetStoreApplicationTests {
    @MockBean
    public Repository repository;
    @Autowired
    public Service service;

    @Test
    public void getGadgetsTest() {
        when(repository.findAll()).thenReturn(Stream.of(new Model(1, "Mobile", 32000.00),
                new Model(2, "Ac", 30000.00),
                new Model(3, "desktop", 55000.00)).collect(Collectors.toList()));
        assertEquals(3, service.getGadgets().size());

    }

    @Test
    public void getGadgetsbyIdTest() {
        int id=1;
        when(repository.findGadgetsById(id)).thenReturn(Stream.of(new Model(1, "Mobile", 32000.00))
                .collect(Collectors.toList()));
        assertEquals(1, service.getGadgetsbyId(id).size());

    }
    @Test
    public void addGadgets(){
        Model m= new Model(1,"Mobile",32000.00);
        when(repository.save(m)).thenReturn(m);
        assertEquals(m,service.addGadgets(m));
    }

}