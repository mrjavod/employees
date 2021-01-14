package com.akbar.employees.services;

import com.akbar.employees.models.ContactTypes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactTypesService {

    private List<ContactTypes> contactTypes = load();

    private List<ContactTypes> load() {
        contactTypes = new ArrayList<>();
        contactTypes.add(new ContactTypes("email", "Pochta"));
        contactTypes.add(new ContactTypes("mobile", "Telfon"));
        return contactTypes;
    }

}
