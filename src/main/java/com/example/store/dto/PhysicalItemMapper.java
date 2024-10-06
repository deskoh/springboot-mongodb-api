package com.example.store.dto;

import com.example.store.model.PhysicalItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PhysicalItemMapper {
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "cost")
    @Mapping(target = "type", constant = "physical")
    PhysicalItemDto toPhysicalItemDto(PhysicalItem digitalItem);
}
