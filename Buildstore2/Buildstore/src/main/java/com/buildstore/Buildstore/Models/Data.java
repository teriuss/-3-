package com.buildstore.Buildstore.Models;

import javax.persistence.*;

@Entity
@Table(name = "data2")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String ownername3;
    private  String ownersurname3;
    private  String address3;
    private String phone3;
    private  String name3;
    private String categories3;
    private String brand3;
    private int cost3;
    private int quantity3;
    private  int costfordelivery3;
    private  int total3;

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getCategories3() {
        return categories3;
    }

    public void setCategories3(String categories3) {
        this.categories3 = categories3;
    }

    public String getBrand3() {
        return brand3;
    }

    public void setBrand3(String brand3) {
        this.brand3 = brand3;
    }

    public int getCost3() {
        return cost3;
    }

    public void setCost3(int cost3) {
        this.cost3 = cost3;
    }

    public int getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(int quantity3) {
        this.quantity3 = quantity3;
    }

    public int getCostfordelivery3() {
        return costfordelivery3;
    }

    public void setCostfordelivery3(int costfordelivery3) {
        this.costfordelivery3 = costfordelivery3;
    }

    public int getTotal3() {
        return total3;
    }

    public void setTotal3(int total3) {
        this.total3 = total3;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnername3() {
        return ownername3;
    }

    public void setOwnername3(String ownername3) {
        this.ownername3 = ownername3;
    }

    public String getOwnersurname3() {
        return ownersurname3;
    }

    public void setOwnersurname3(String ownersurname3) {
        this.ownersurname3 = ownersurname3;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public Data(long id, String ownername3, String ownersurname3, String address3, String phone3, String name3, String categories3, String brand3, int cost3, int quantity3, int costfordelivery3, int total3) {
        this.id = id;
        this.ownername3 = ownername3;
        this.ownersurname3 = ownersurname3;
        this.address3 = address3;
        this.phone3 = phone3;
        this.name3 = name3;
        this.categories3 = categories3;
        this.brand3 = brand3;
        this.cost3 = cost3;
        this.quantity3 = quantity3;
        this.costfordelivery3 = costfordelivery3;
        this.total3 = total3;
    }

    public Data() {
    }
}
