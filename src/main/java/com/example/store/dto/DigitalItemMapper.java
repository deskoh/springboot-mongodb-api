package com.example.store.dto;

import com.example.store.model.DigitalItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DigitalItemMapper {
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "cost")
    @Mapping(target = "type", constant = "digital")
    DigitalItemDto toDigitalItemDto(DigitalItem digitalItem);
}
