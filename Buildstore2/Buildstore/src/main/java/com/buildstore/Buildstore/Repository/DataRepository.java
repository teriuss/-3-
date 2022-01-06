package com.buildstore.Buildstore.Repository;

import com.buildstore.Buildstore.Models.Data;
import com.buildstore.Buildstore.Models.OrderedMaterials;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository< Data ,Long> {
}
