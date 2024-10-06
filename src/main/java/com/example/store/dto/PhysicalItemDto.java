package com.example.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PhysicalItemDto extends ItemDto {
    private double weight;
    private String dimensions;
}
