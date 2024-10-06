package com.example.store.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@TestConfiguration
public class DatabaseSeeder {
    @Bean
    public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
        var factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setResources(new Resource[]{
                new ClassPathResource("seed/item.json")
        });
        return factory;
    }
}
