package com.example.store.dto;

import com.example.store.model.DigitalItem;
import org.mapstruct.Mapper;

@Mapper(config = MapperCentralConfig.class)
public interface DigitalItemMapper {
    DigitalItemDto toDigitalItemDto(DigitalItem digitalItem);
}
