package com.example.store.service;

import com.example.store.dto.ItemDto;
import com.example.store.dto.ItemMapper;
import com.example.store.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IItemV2Service implements IItemService<ItemDto> {

    private final ItemRepository repository;

    public IItemV2Service(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemDto> getAllItems() {
        return this.repository.findAll()
                .stream()
                .map(ItemMapper.INSTANCE::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> getPhysicalItems() {
        return this.repository.findAllPhysicalItems()
                .stream()
                .map(ItemMapper.INSTANCE::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> getDigtalItems() {
        return this.repository.findAllDigitalItems()
                .stream()
                .map(ItemMapper.INSTANCE::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(String id) {
        var result = this.repository.findById(id).orElse(null);
        return result == null ? null : ItemMapper.INSTANCE.toItemDto(result);
    }

    @Override
    public List<ItemDto> getItemByPriceBetween(float minPrice, float maxPrice) {
        return this.repository.findByPriceBetween(minPrice, maxPrice)
                .stream()
                .map(ItemMapper.INSTANCE::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto createItem(ItemDto newItem) {
        System.out.println(newItem.getClass());
        var result = this.repository.save(ItemMapper.INSTANCE.toItem(newItem));
        System.out.println(result.getClass());
        return ItemMapper.INSTANCE.toItemDto(result);
    }
}
