package com.example.root.waslni;

public class DataModel {

    String name;
    String email;
    String state;

    public DataModel(String name, String state, String email) {
        this.name=name;
        this.email=email;
        this.state=state;

    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }


}