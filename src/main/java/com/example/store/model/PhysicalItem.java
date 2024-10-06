package com.example.store.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

@NoArgsConstructor
@Getter
@Setter
public class PhysicalItem extends Item {
    private double weight;
    private String dimensions;
}
