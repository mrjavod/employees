package com.akbar.employees.models;

import java.util.List;

public class Employees {

    private int id;
    private String first_name;
    private String last_name;
    private String second_name;
    private String birthday;
    private String passport_seria;
    private String passport_number;
    private int salary;
    private Position position;
    private Addresses address;
    private List<Contacts> contacts;

    public Employees() {
    }

    public Employees(int id, String first_name, String last_name, String second_name, String birthday,
                     String passport_seria, String passport_number, int salary,
                     Position position, Addresses address, List<Contacts> contacts) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.birthday = birthday;
        this.passport_seria = passport_seria;
        this.passport_number = passport_number;
        this.salary = salary;
        this.position = position;
        this.address = address;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassport_seria() {
        return passport_seria;
    }

    public void setPassport_seria(String passport_seria) {
        this.passport_seria = passport_seria;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }
}
