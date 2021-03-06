package io.beaniejoy.springdatajpa.data.specification;

import io.beaniejoy.springdatajpa.entity.cafe.Cafe;
import org.springframework.data.jpa.domain.Specification;

public interface CafeSearch {
    Specification<Cafe> toSpecification(CafeParam param);
}
