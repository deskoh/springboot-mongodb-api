package com.example.store.service;

import com.example.store.model.Item;
import com.example.store.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IItemV1Service implements IItemService<Item> {

    private final ItemRepository repository;

    public IItemV1Service(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> getAllItems() {
        return this.repository.findAll();
    }

    @Override
    public List<Item> getPhysicalItems() {
        return this.repository.findAllPhysicalItems();
    }

    @Override
    public List<Item> getDigtalItems() {
        return this.repository.findAllDigitalItems();
    }

    @Override
    public Item getItemById(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getItemByPriceBetween(float minPrice, float maxPrice) {
        return this.repository.findByPriceBetween(minPrice, maxPrice);
    }
}
