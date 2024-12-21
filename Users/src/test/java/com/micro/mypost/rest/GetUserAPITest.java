package com.micro.mypost.rest;

import com.micro.mypost.users.GetUserQuery;
import com.micro.mypost.users.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GetUserAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetUserQuery getUserQuery;


    @ParameterizedTest
    @CsvSource(textBlock = """ 
            0
            1
            -1
            g
            """)
    void success(String id) throws Exception {

        User user = new User().setNickname(UUID.randomUUID().toString())
                .setEmail(UUID.randomUUID().toString());
        when(getUserQuery.getById(id))
                .thenReturn(Optional.of(user));
        this.mockMvc.perform(get("/api/user/" + id)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.nickname").value(user.getNickname()));

    }

    @Test
    void notFound() throws Exception {
        String nickname = "queqe";
        when(getUserQuery.getById(nickname))
                .thenReturn(Optional.empty());
        this.mockMvc.perform(get("/api/user/" + nickname)).andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Не найден пользователь с nickname = queqe "));

    }
}
