package com.example.easybank_v4.Interfaces;

import java.util.List;
import java.util.Optional;

public interface DataInterface <Entity,IdType>  {

    Optional<Entity> save(Entity entity);
    int delete(Entity entity);
    Optional<Entity> update(Entity entity);
    Optional<Entity> findById(IdType id);
    List<Entity> showAll();
}
