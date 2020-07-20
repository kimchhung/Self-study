package com.example.myapp;

public class Product {
    private String id;
    private String name;
    private String bland;
    private String price;
    private String profile;

    public Product(String id, String name, String bland, String price, String profile) {
        this.id = id;
        this.name = name;
        this.bland = bland;
        this.price = price;
        this.profile = profile;
    }
    public Product(){
    }



    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBland() {
        return bland;
    }

    public void setBland(String bland) {
        this.bland = bland;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
