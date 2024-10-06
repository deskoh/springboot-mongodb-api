package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = PhysicalItem.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhysicalItem.class, name = "physical"),
        @JsonSubTypes.Type(value = DigitalItem.class, name = "digital")
})
@Getter
@NoArgsConstructor
@Setter
@Document(collection = "item")
@CompoundIndex(def = "{'_class': 1}")
public class Item {
    private String id;
    private String name;
    private double price;
}
