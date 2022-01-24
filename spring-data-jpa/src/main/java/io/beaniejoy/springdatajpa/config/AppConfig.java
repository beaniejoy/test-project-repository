package io.beaniejoy.springdatajpa.config;

import io.beaniejoy.springdatajpa.data.CafeSearch;
import io.beaniejoy.springdatajpa.data.CafeSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class AppConfig {

    @Bean
    public CafeSearch cafeSearch() {
        return new CafeSpecification();
//        return new CafeSpecificationWithPredicate();
    }
}
