package com.akbar.employees.services;

import com.akbar.employees.models.Contacts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactsService {

    private List<Contacts> contacts = new ArrayList<>();

    public void create(List<Contacts> contactsList, int employeeId) {
        int id = 1;
        for (Contacts contact : contactsList) {
            if (contacts.size() > 0) {
                id = contacts.get(contacts.size() - 1).getId() + 1;
            }
            contacts.add(new Contacts(id, employeeId, contact.getContact_type(),
                    contact.getValue()));
        }
    }

    public List<Contacts> getByEmployeeId(int employeeId) {
        return contacts.stream().filter(c -> c.getEmployee_id() == employeeId).collect(Collectors.toList());
    }

}
