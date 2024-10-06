package com.example.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DigitalItemDto extends ItemDto {
    private String fileSize;
    private String fileType;
}
