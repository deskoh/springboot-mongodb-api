package com.example.store.controller;

import com.example.store.config.DatabaseSeeder;
import com.example.store.service.IItemV1Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.everyItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ItemV1Controller.class)
@AutoConfigureDataMongo
@EnableMongoRepositories("com.example.store.repository")
@Import({IItemV1Service.class, DatabaseSeeder.class})
public class ItemDtoV1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private BasicJsonTester jsonTester = new BasicJsonTester(getClass());

     @Test
    public void shouldReturnAllItems() throws Exception {
        var response = mockMvc.perform(get("/v1/item"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(jsonTester.from(response)).isEqualToJson("item.all.json");
    }

     @Test
     public void shouldReturnDigitalItems() throws Exception {
         mockMvc.perform(get("/v1/item?type=digital"))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.*", hasSize(2)))
                 .andExpect(jsonPath("$..type", everyItem(equalTo("digital"))));
     }

    @Test
    public void shouldReturnPhysicalItems() throws Exception {
        mockMvc.perform(get("/v1/item?type=physical"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(3)))
                .andExpect(jsonPath("$..type", everyItem(equalTo("physical"))));
    }

    @Test
    public void shouldReturnItemById() throws Exception {
        mockMvc.perform(get("/v1/item?id=670229923087340944805012"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo("670229923087340944805012")));
    }

    @Test
    public void shouldReturnItemByPriceRange() throws Exception {
        mockMvc.perform(get("/v1/item?maxPrice=2000&minPrice=499"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$..price",
                        everyItem(allOf(
                                greaterThan(500.0),
                                lessThan(2000.0)
                        ))
                ));
    }

}
