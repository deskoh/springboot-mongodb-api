package com.example.store.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhysicalItemDto.class, name = "physical"),
        @JsonSubTypes.Type(value = DigitalItemDto.class, name = "digital")
})
@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private String id;
    private String type;
    private String productName;
    private double cost;
}
