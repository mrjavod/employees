package com.akbar.employees.services;

import com.akbar.employees.models.Regions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionsService {

    private List<Regions> regions = load();

    private List<Regions> load() {
        regions = new ArrayList<>();
        regions.add(new Regions(1, "Toshkent"));
        regions.add(new Regions(2, "Samarqand"));
        regions.add(new Regions(3, "Buxoro"));
        regions.add(new Regions(4, "Andijon"));
        return regions;
    }

    public List<Regions> getAll() {
        return regions;
    }

    public Regions getById(int id) {
        return regions.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    public Regions create(Regions region) {
        int id = regions.get(regions.size() - 1).getId() + 1;
        regions.add(new Regions(id, region.getName()));
        region.setId(id);
        return region;
    }

    public Regions update(Regions region) {
        Regions oldRegion = getById(region.getId());
        if (oldRegion != null) {
            oldRegion.setName(region.getName());
        }
        return oldRegion;
    }

    public void delete(Regions region) {
        Regions deletedRegion = getById(region.getId());
        if (deletedRegion != null) {
            regions.remove(deletedRegion);
        }
    }
}
