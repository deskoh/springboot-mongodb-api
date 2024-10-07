package com.example.store.dto;

import com.example.store.model.DigitalItem;
import com.example.store.model.Item;
import com.example.store.model.PhysicalItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemMapperTest {

    private DigitalItem getDigitalItemInstance() {
        var digitalItem = new DigitalItem();
        digitalItem.setName("Software Subscription");
        digitalItem.setPrice(199.99);
        digitalItem.setFileType("online");
        digitalItem.setFileSize("N/A");
        return digitalItem;
    }

    private PhysicalItem getPhysicalItemInstance() {
        var physicalItem = new PhysicalItem();
        physicalItem.setName("Book");
        physicalItem.setPrice(20.0);
        physicalItem.setWeight(0.8);
        physicalItem.setDimensions("9x6x1 inches");
        return physicalItem;
    }

    private DigitalItemDto getDigitalItemDtoInstance() {
        var digitalItemDto = new DigitalItemDto();
        digitalItemDto.setProductName("Software Subscription");
        digitalItemDto.setCost(199.99);
        digitalItemDto.setFileType("online");
        digitalItemDto.setFileSize("N/A");
        return digitalItemDto;
    }

    private PhysicalItemDto getPhysicalItemDtoInstance() {
        var physicalItemDto = new PhysicalItemDto();
        physicalItemDto.setProductName("Book");
        physicalItemDto.setCost(20.0);
        physicalItemDto.setWeight(0.8);
        physicalItemDto.setDimensions("9x6x1 inches");
        return physicalItemDto;
    }

    @Test
    void given_DigitalItem_mappedTo_DigitalItemDto_correctly() {
        var item = getDigitalItemInstance();

        ItemDto itemDto = ItemMapper.INSTANCE.toItemDto(item);
        assertTrue(itemDto instanceof DigitalItemDto);
        assertEquals(item.getName(), itemDto.getProductName());
        assertEquals(item.getPrice(), itemDto.getCost());
        assertEquals(item.getFileType(), ((DigitalItemDto) itemDto).getFileType());
        assertEquals(item.getFileSize(), ((DigitalItemDto) itemDto).getFileSize());
    }

    @Test
    void given_PhysicalItem_mappedTo_PhysicalItemDto_correctly() {
        var item = getPhysicalItemInstance();

        ItemDto itemDto = ItemMapper.INSTANCE.toItemDto(item);
        assertTrue(itemDto instanceof PhysicalItemDto);
        assertEquals(item.getName(), itemDto.getProductName());
        assertEquals(item.getPrice(), itemDto.getCost());
        assertEquals(item.getWeight(), ((PhysicalItemDto) itemDto).getWeight());
        assertEquals(item.getDimensions(), ((PhysicalItemDto) itemDto).getDimensions());
    }

    @Test
    void given_DigitalItemDto_mappedTo_DigitalItem_correctly() {
        var itemDto = getDigitalItemDtoInstance();
        Item item = ItemMapper.INSTANCE.toItem(itemDto);
        assertTrue(item instanceof DigitalItem);
        assertEquals(itemDto.getProductName(), item.getName());
        assertEquals(itemDto.getCost(), item.getPrice());
        assertEquals(itemDto.getFileType(), ((DigitalItem) item).getFileType());
        assertEquals(itemDto.getFileSize(), ((DigitalItem) item).getFileSize());
    }

    @Test
    void given_PhysicalItemDto_mappedTo_PhysicalItem_correctly() {
        var itemDto = getPhysicalItemDtoInstance();

        Item item = ItemMapper.INSTANCE.toItem(itemDto);
        assertTrue(item instanceof PhysicalItem);
        assertEquals(itemDto.getProductName(), item.getName());
        assertEquals(itemDto.getCost(), item.getPrice());
        assertEquals(itemDto.getWeight(), ((PhysicalItem) item).getWeight());
        assertEquals(itemDto.getDimensions(), ((PhysicalItem) item).getDimensions());
    }
}
