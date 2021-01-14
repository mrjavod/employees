package com.akbar.employees.models;

public class Addresses {

    private int id;
    private int region_id;
    private String region_name;
    private String home_address;

    public Addresses() {
    }

    public Addresses(int id, int region_id, String home_address) {
        this.id = id;
        this.region_id = region_id;
        this.home_address = home_address;
    }

    public Addresses(int id, int region_id, String region_name, String home_address) {
        this.id = id;
        this.region_id = region_id;
        this.region_name = region_name;
        this.home_address = home_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }
}
