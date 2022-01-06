package com.buildstore.Buildstore.Models;

import javax.persistence.*;

@Entity
@Table(name = "orderedmaterials")
public class OrderedMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String ownername4;
    private  String ownersurname4;
    private  int costfordelivery4;
    private  int total4;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnername4() {
        return ownername4;
    }

    public void setOwnername4(String ownername4) {
        this.ownername4 = ownername4;
    }

    public int getCostfordelivery4() {
        return costfordelivery4;
    }

    public void setCostfordelivery4(int costfordelivery4) {
        this.costfordelivery4 = costfordelivery4;
    }

    public String getOwnersurname4() {
        return ownersurname4;
    }

    public void setOwnersurname4(String ownersurname4) {
        this.ownersurname4 = ownersurname4;
    }

    public int getTotal4() {
        return total4;
    }

    public void setTotal4(int total4) {
        this.total4 = total4;
    }

    public OrderedMaterials() {
    }

    public OrderedMaterials(long id, String ownername4, String ownersurname4, int costfordelivery4, int total4) {
        this.id = id;
        this.ownername4 = ownername4;
        this.ownersurname4 = ownersurname4;
        this.costfordelivery4 = costfordelivery4;
        this.total4 = total4;
    }
}
