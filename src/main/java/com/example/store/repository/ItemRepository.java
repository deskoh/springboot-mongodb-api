package com.example.store.repository;

import com.example.store.dto.ItemAggregate;
import com.example.store.model.Item;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {
    @Query("{ '_class' : 'com.example.store.model.PhysicalItem' }")
    List<Item> findAllPhysicalItems();

    @Query("{ '_class' : 'com.example.store.model.DigitalItem' }")
    List<Item> findAllDigitalItems();

    List<Item> findByPriceBetween(double lower, double upper);

    List<Item> findByCategoryAndTagsIn(String category, Collection<String> tags);

    List<Item> findByCategoryInOrTagsIn(Collection<String> categories, Collection<String> tags);

    // Method cannot be generated as `fileType` field does not exist in `Item`
    @Query("{'$or': [{'category': { $in: ?1 }}, {'fileType': { $in: ?1 }}] }")
    List<Item> findByCategoryInOrFileTypesIn(List<String> categories, List<String> filetypes);

    @Aggregation("{ $group: { _id : $category, names : { $addToSet : $name } } }")
    List<ItemAggregate> groupByCategories();

    @Aggregation("{ $group: { _id : $category }}")
    List<String> findAllCategories();
}
