package com.akbar.employees.models;

public class Contacts {

    private int id;
    private int employee_id;
    private String contact_type;
    private String value;

    public Contacts() {
    }

    public Contacts(int id, int employee_id, String contact_type, String value) {
        this.id = id;
        this.employee_id = employee_id;
        this.contact_type = contact_type;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getContact_type() {
        return contact_type;
    }

    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
