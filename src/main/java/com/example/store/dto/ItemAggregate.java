package com.example.store.dto;

import java.util.List;

public record ItemAggregate(String category, List<String> names) {
}
