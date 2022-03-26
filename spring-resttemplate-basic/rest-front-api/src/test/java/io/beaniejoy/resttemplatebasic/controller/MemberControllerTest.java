package io.beaniejoy.resttemplatebasic.controller;

import io.beaniejoy.resttemplatebasic.application.RestTemplateFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    RestTemplateFacade facade;

    @Test
    @DisplayName("MemberRequestDto jackson binding 테스트")
    public void bindingDtoTest() throws Exception {
        String requestJson = "{\"id\": 1, " +
                "\"name\": \"beanie\", " +
                "\"address\": \"beanie address\", " +
                "\"email\": \"beanie@example.com\", " +
                "\"birthDate\": \"2000-10-25\"," +
                "\"createdAt\": \"2022-03-26T13:20:30\", " +
                "\"createdBy\": \"admin\"}";

        mvc.perform(
                post("/api/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1,\"name\":\"beanie\"")))
                .andDo(print());
    }
}