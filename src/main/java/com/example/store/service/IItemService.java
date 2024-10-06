package com.example.store.service;

import java.util.List;

public interface IItemService<T> {

    List<T> getAllItems();

    List<T> getPhysicalItems();

    List<T> getDigtalItems();

    T getItemById(String id);

    List<T> getItemByPriceBetween(float minPrice, float maxPrice);
}
