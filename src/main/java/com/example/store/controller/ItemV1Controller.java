package com.example.store.controller;

import com.example.store.model.Item;
import com.example.store.service.IItemV1Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/item")
public class ItemV1Controller extends ItemController<Item> {
    public ItemV1Controller(IItemV1Service service) {
        super(service);
    }
}
