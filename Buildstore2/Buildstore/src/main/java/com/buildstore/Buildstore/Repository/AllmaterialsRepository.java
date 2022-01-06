package com.buildstore.Buildstore.Repository;

import com.buildstore.Buildstore.Models.Allmaterials;
import com.buildstore.Buildstore.Models.OrderedMaterials;
import org.springframework.data.repository.CrudRepository;

public interface AllmaterialsRepository extends CrudRepository<Allmaterials,Long> {

}
