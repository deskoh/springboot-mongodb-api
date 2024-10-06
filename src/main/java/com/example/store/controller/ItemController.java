package com.example.store.controller;

import com.example.store.service.IItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public abstract class ItemController<T> {
    protected final IItemService<T> service;

    public ItemController(IItemService<T> service) {
        this.service = service;
    }

    // GET /v1/item
    // GET /v1/item?type=digital
    @GetMapping(value = "")
    public List<T> getItemsByType(@RequestParam("type") Optional<String> type) {
        if (type.equals(Optional.of("digital"))) {
            return service.getDigtalItems();
        } else if (type.equals(Optional.of("physical"))) {
            return service.getPhysicalItems();
        }
        return service.getAllItems();
    }

    // GET /v1/item?id=xxxx
    @GetMapping(value = "", params = "id")
    public T getItemsById(@RequestParam("id") String id) {
        return service.getItemById(id);
    }

    @GetMapping(value = "", params = {"minPrice", "maxPrice"})
    public List<T> getItemsByPriceRange(
            @RequestParam("minPrice") float minPrice, @RequestParam("maxPrice")float maxPrice
    ) {
        return service.getItemByPriceBetween(minPrice, maxPrice);
    }
}
