package com.example.store.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

@NoArgsConstructor
@Getter
@Setter
public class DigitalItem extends Item {
    private String fileSize;
    private String fileType;
}
