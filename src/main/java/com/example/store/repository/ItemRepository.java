package com.example.store.repository;

import com.example.store.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findAll();

    @Query("{ '_class' : 'com.example.store.model.PhysicalItem' }")
    List<Item> findAllPhysicalItems();

    @Query("{ '_class' : 'com.example.store.model.DigitalItem' }")
    List<Item> findAllDigitalItems();

    List<Item> findByPriceBetween(float lower, float upper);
}
