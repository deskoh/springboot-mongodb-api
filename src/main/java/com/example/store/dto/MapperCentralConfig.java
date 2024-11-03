package com.example.store.dto;

import com.example.store.model.DigitalItem;
import com.example.store.model.Item;
import com.example.store.model.PhysicalItem;
import org.mapstruct.*;

@MapperConfig(
        uses = { DigitalItemMapper.class, PhysicalItemMapper.class },
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG
)
public interface MapperCentralConfig {

    @SubclassMapping(source = DigitalItemDto.class, target = DigitalItem.class)
    @SubclassMapping(source = PhysicalItemDto.class, target = PhysicalItem.class)
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "categoryName", target = "category")
    @Mapping(source = "cost", target = "price")
    Item anyDtoToEntity(ItemDto dto);

    @SubclassMapping(source = DigitalItem.class, target = DigitalItemDto.class)
    @SubclassMapping(source = PhysicalItem.class, target = PhysicalItemDto.class)
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category", target = "categoryName")
    @Mapping(source = "price", target = "cost")
    ItemDto entityToDto(Item item);
}
