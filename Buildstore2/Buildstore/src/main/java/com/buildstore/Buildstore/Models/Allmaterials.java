package com.buildstore.Buildstore.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "allmaterials")
public class Allmaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name, categories, brand;
    private int cost;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public Allmaterials() {
    }


    public Allmaterials(String name, String categories, String brand, int cost) {
        this.name = name;
        this.categories = categories;
        this.brand = brand;
        this.cost = cost;
    }
}

