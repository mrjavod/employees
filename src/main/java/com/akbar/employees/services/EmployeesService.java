package com.akbar.employees.services;

import com.akbar.employees.models.Addresses;
import com.akbar.employees.models.Contacts;
import com.akbar.employees.models.Employees;
import com.akbar.employees.models.Position;
import com.akbar.employees.utils.Files;
import com.akbar.employees.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesService {

    @Autowired
    AddressesService addressesService;

    @Autowired
    ContactsService contactsService;

    @Autowired
    PositionService positionService;

    private List<Employees> employees = readEmpoyees();

    private List<Employees> readEmpoyees() {
        List<Employees> list = new ArrayList<>();
        try {
            String text = Files.read("employees.json");
            list = new ObjectMapper().readValue(text, new TypeReference<ArrayList<Employees>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Employees create(Employees employeesModel) {
        int id = 1;
        if (employees.size() > 0) {
            id = employees.get(employees.size() - 1).getId() + 1;
        }
        employeesModel.setId(id);

        int positionId = employeesModel.getPosition().getId();
        employeesModel.setPosition(positionService.getById(positionId));

        Addresses address = addressesService.create(employeesModel.getAddress());
        employeesModel.setAddress(address);

        contactsService.create(employeesModel.getContacts(), id);
        List<Contacts> contacts = contactsService.getByEmployeeId(employeesModel.getId());
        employeesModel.setContacts(contacts);

        employees.add(employeesModel);

        Files.write("employees.json", employees);

        return employeesModel;
    }

    public List<Employees> getAll() {
        return employees;
    }

    public Employees getById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Employees> search(Employees employeesModel) {

        List<Employees> list = employees;

        if (!Utils.isEmpty(employeesModel.getFirst_name())) {
            list = list.stream().filter(e -> e.getFirst_name().contains(employeesModel.getFirst_name()))
                    .collect(Collectors.toList());
        }

        if (!Utils.isEmpty(employeesModel.getSecond_name())) {
            list = list.stream().filter(e -> e.getSecond_name().contains(employeesModel.getSecond_name()))
                    .collect(Collectors.toList());
        }

        if (!Utils.isEmpty(employeesModel.getPassport_seria())) {
            list = list.stream().filter(e -> e.getPassport_seria().equals(employeesModel.getPassport_seria()))
                    .collect(Collectors.toList());
        }

        if (!Utils.isEmpty(employeesModel.getPassport_number())) {
            list = list.stream().filter(e -> e.getPassport_number().equals(employeesModel.getPassport_number()))
                    .collect(Collectors.toList());
        }

        return list;
    }

    public List<Contacts> getEmployeeContacts(int id) {
        Employees employees = getById(id);
        if (employees != null) {
            return employees.getContacts();
        }
        return null;
    }

    public Addresses getEmployeeAddress(int id) {
        Employees employees = getById(id);
        if (employees != null) {
            return employees.getAddress();
        }
        return null;
    }

    public Position getEmployeePosition(int id) {
        Employees employees = getById(id);
        if (employees != null) {
            return employees.getPosition();
        }
        return null;
    }
}
