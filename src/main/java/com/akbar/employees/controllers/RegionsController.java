package com.akbar.employees.controllers;

import com.akbar.employees.models.Regions;
import com.akbar.employees.services.RegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/regions/")
public class RegionsController {

    @Autowired
    private RegionsService regionsService;

    @GetMapping("getAll")
    public List<Regions> getAll() {
        return regionsService.getAll();
    }

    @GetMapping("getById/{id}")
    public Regions getById(@PathVariable(name = "id") int id) {
        return regionsService.getById(id);
    }

    @PostMapping("create")
    public Regions create(@RequestBody Regions regions) {
        return regionsService.create(regions);
    }

    @PostMapping("update")
    public Regions update(@RequestBody Regions regions) {
        return regionsService.update(regions);
    }

    @PostMapping("delete")
    public void delete(@RequestBody Regions regions) {
        regionsService.delete(regions);
    }

}
