package com.example.store.dto;

import com.example.store.model.PhysicalItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperCentralConfig.class)
public interface PhysicalItemMapper {
    PhysicalItemDto toPhysicalItemDto(PhysicalItem digitalItem);
}
