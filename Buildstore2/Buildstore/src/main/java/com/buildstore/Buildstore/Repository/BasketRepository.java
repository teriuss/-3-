package com.buildstore.Buildstore.Repository;

import com.buildstore.Buildstore.Models.Basket;
import com.buildstore.Buildstore.Models.OrderedMaterials;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository< Basket ,Long> {

}
