package io.beaniejoy.springdatajpa.service;

import io.beaniejoy.springdatajpa.entity.cafe.Cafe;
import io.beaniejoy.springdatajpa.repository.CafeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
class CafeServiceTest {
    @Autowired
    CafeService cafeService;

    @Autowired
    CafeRepository cafeRepository;

    @Test
    @DisplayName("기본적인 Spec 조건으로 Cafe 전체 조회 테스트")
    public void findAllTest() {
        Pageable pageable = PageRequest.of(0, 20);
        Page<Cafe> result = cafeService.getAllCafesWithNameOrAddress(null, "address", pageable);
        List<Cafe> content = result.getContent();

        assertEquals(result.getTotalElements(), 3);
        assertEquals(content.get(0).getName(), "test_cafe_1");
        assertEquals(content.get(0).getAddress(), "test_address_1");
    }
}