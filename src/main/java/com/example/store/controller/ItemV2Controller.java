package com.example.store.controller;

import com.example.store.dto.ItemDto;
import com.example.store.service.IItemV2Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/item")
public class ItemV2Controller extends ItemController<ItemDto> {
    public ItemV2Controller(IItemV2Service service) {
        super(service);
    }
}
