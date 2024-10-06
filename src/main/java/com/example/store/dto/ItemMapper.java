package com.example.store.dto;

import com.example.store.model.DigitalItem;
import com.example.store.model.Item;
import com.example.store.model.PhysicalItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { DigitalItemMapper.class, PhysicalItemMapper.class })
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @SubclassMapping(source = DigitalItem.class, target = DigitalItemDto.class)
    @SubclassMapping(source = PhysicalItem.class, target = PhysicalItemDto.class)
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "cost")
    ItemDto toItemDto(Item item);
}