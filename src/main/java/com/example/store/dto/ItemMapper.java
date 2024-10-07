package com.example.store.dto;

import com.example.store.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        config = MapperCentralConfig.class,
        uses = { DigitalItemMapper.class, PhysicalItemMapper.class }
)
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDto toItemDto(Item item);

    Item toItem(ItemDto newItem);
}