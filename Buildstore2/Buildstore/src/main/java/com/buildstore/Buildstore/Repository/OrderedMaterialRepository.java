package com.buildstore.Buildstore.Repository;

import com.buildstore.Buildstore.Models.OrderedMaterials;
import org.springframework.data.repository.CrudRepository;

public interface OrderedMaterialRepository extends CrudRepository<OrderedMaterials ,Long> {
}
