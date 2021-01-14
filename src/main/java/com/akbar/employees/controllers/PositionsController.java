package com.akbar.employees.controllers;

import com.akbar.employees.models.Position;
import com.akbar.employees.models.Regions;
import com.akbar.employees.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/positions/")
public class PositionsController {

    @Autowired
    private PositionService positionService;

    @GetMapping("getAll")
    public List<Position> getAll() {
        return positionService.getAll();
    }

    @GetMapping("getById/{id}")
    public Position getAll(@PathVariable(name = "id") int id) {
        return positionService.getById(id);
    }

    @PostMapping("create")
    public Position create(@RequestBody Position positions) {
        return positionService.create(positions);
    }

    @PostMapping("update")
    public Position update(@RequestBody Position positions) {
        return positionService.update(positions);
    }

    @PostMapping("delete")
    public void delete(@RequestBody Position positions) {
        positionService.delete(positions);
    }


}
