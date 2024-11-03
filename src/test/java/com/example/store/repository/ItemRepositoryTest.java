package com.example.store.repository;

import com.example.store.config.DatabaseSeeder;
import com.example.store.model.DigitalItem;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Import({DatabaseSeeder.class})
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @AfterAll
    public void teardown() {
        // itemRepository.deleteAll();
    }

    @Test
    void findByCategoryAndTagsIn() {
        var results = itemRepository.findByCategoryAndTagsIn("Books", List.of("PDF", "books"));
        assertThat(results.size()).isGreaterThan(0);

        for (var item: results) {
            assertThat(item.getCategory()).isEqualTo("Books");
            assertThat(item.getTags()).containsAnyOf("PDF", "books");
        }
    }

    @Test
    void findByCategoryInOrTagsIn() {
        var results = itemRepository.findByCategoryInOrTagsIn(
                List.of("Books", "Mobile Devices"),
                List.of("PDF", "audio")
        );
        assertThat(results.size()).isGreaterThan(0);
        assertThat(results).allMatch(item ->
            item.getCategory().equals("Books")
                    || item.getCategory().equals("Mobile Devices")
                    || item.getTags().contains("PDF")
                    || item.getTags().contains("audio")
        );
    }

    @Test
    void findByCategoryInOrFileTypesIn() {
        var results = itemRepository.findByCategoryInOrFileTypesIn(
                List.of("Books", "Mobile Devices"),
                List.of("MP3", "PDF")
        );
        assertThat(results.size()).isGreaterThan(0);
        assertThat(results).allMatch(item -> {
            var test = item.getCategory().equals("Books")
                    || item.getCategory().equals("Mobile Devices");
            if (test) return true;

            if (item instanceof DigitalItem digitalItem) {
                return digitalItem.getFileType().equals("MP3") || digitalItem.getFileType().equals("PDF");
            }
            return false;
        });
    }

    @Test
    void groupByCategories() {
        var results = itemRepository.groupByCategories();
        assertThat(results.size()).isEqualTo(11);
    }

    @Test
    void findAllCategories() {
        var results = itemRepository.findAllCategories();
        var expected = List.of(
                "Music",
                "Computers & Accessories",
                "Wearable Technology",
                "Movies & Entertainment",
                "Mobile Devices",
                "Computer Accessories",
                "Software",
                "Storage Devices",
                "Gaming",
                "Books",
                "Audio Accessories"
        );
        assertThat(results).containsAll(expected);
    }
}
