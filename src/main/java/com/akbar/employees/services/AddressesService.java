package com.akbar.employees.services;

import com.akbar.employees.models.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressesService {

    @Autowired
    RegionsService regionsService;

    private List<Addresses> addresses = new ArrayList<>();

    public Addresses create(Addresses address) {
        int id = 1;
        if (addresses.size() > 0) {
            id = addresses.get(addresses.size() - 1).getId() + 1;
        }

        String regionName = regionsService.getById(address.getRegion_id()).getName();
        Addresses newAddress = new Addresses(id, address.getRegion_id(), regionName, address.getHome_address());
        addresses.add(newAddress);
        return newAddress;
    }

    public Addresses getById(int id) {
        return addresses.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }
}
