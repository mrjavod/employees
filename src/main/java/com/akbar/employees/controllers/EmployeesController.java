package com.akbar.employees.controllers;

import com.akbar.employees.models.Addresses;
import com.akbar.employees.models.Contacts;
import com.akbar.employees.models.Employees;
import com.akbar.employees.models.Position;
import com.akbar.employees.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees/")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("getAll")
    public List<Employees> getAll() {
        return employeesService.getAll();
    }

    @GetMapping("getById/{id}")
    public Employees getById(@PathVariable(name = "id") int id) {
        return employeesService.getById(id);
    }

    @PostMapping("create")
    public Employees create(@RequestBody Employees employeesModel) {
        return employeesService.create(employeesModel);
    }

    @PostMapping("search")
    public List<Employees> search(@RequestBody Employees employeesModel) {
        return employeesService.search(employeesModel);
    }

    @GetMapping("getEmployeeContacts/{id}")
    public List<Contacts> getEmployeeContacts(@PathVariable(name = "id") int id) {
        return employeesService.getEmployeeContacts(id);
    }

    @GetMapping("getEmployeeAddress/{id}")
    public Addresses getEmployeeAddress(@PathVariable(name = "id") int id) {
        return employeesService.getEmployeeAddress(id);
    }

    @GetMapping("getEmployeePosition/{id}")
    public Position getEmployeePosition(@PathVariable(name = "id") int id) {
        return employeesService.getEmployeePosition(id);
    }

}
