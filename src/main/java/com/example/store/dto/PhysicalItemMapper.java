package com.example.store.dto;

import com.example.store.model.PhysicalItem;
import org.mapstruct.Mapper;

@Mapper(config = MapperCentralConfig.class)
public interface PhysicalItemMapper {
    PhysicalItemDto toPhysicalItemDto(PhysicalItem digitalItem);
}
