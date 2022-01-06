package com.buildstore.Buildstore.Models;


import javax.persistence.*;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String ownername2;
    private  String ownersurname2;
    private  String address2;
    private String phone2;
    private  String name2;
    private String categories2;
    private String brand2;
    private int cost2;
    private int quantity;
    private  int costfordelivery;
    private  int total;
    public Basket() {

    }

    public String getOwnername2() {
        return ownername2;
    }

    public void setOwnername2(String ownername2) {
        this.ownername2 = ownername2;
    }

    public String getOwnersurname2() {
        return ownersurname2;
    }

    public void setOwnersurname2(String ownersurname2) {
        this.ownersurname2 = ownersurname2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCostfordelivery() {
        return costfordelivery;
    }

    public void setCostfordelivery(int costfordelivery) {
        this.costfordelivery = costfordelivery;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getCategories2() {
        return categories2;
    }

    public void setCategories2(String categories2) {
        this.categories2 = categories2;
    }

    public String getBrand2() {
        return brand2;
    }

    public void setBrand2(String brand2) {
        this.brand2 = brand2;
    }

    public int getCost2() {
        return cost2;
    }

    public void setCost2(int cost2) {
        this.cost2 = cost2;
    }

    public int costfordelivery(int quantity){
        return quantity*30;

    }
    public int total(int quantity){
        return quantity*30+cost2*quantity;

    }

    public Basket(long id, String ownername2, String ownersurname2, String address2, String phone2, String name2, String categories2, String brand2, int cost2, int quantity, int costfordelivery, int total) {
        this.id = id;
        this.ownername2 = ownername2;
        this.ownersurname2 = ownersurname2;
        this.address2 = address2;
        this.phone2 = phone2;
        this.name2 = name2;
        this.categories2 = categories2;
        this.brand2 = brand2;
        this.cost2 = cost2;
        this.quantity = quantity;
        this.costfordelivery = costfordelivery;
        this.total = total;
    }
}