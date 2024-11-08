package com.example.store.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhysicalItemDto.class, name = "physical"),
        @JsonSubTypes.Type(value = DigitalItemDto.class, name = "digital")
})
@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private String id;
    private String productName;
    private double cost;
    private String categoryName;
    private List<String> tags;
}
