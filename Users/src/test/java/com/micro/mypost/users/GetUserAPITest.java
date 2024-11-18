package com.micro.mypost.users;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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
            " "
            """)
    void badRequest(String id) throws Exception {

        this.mockMvc.perform(get("/api/user/" + id)).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").isNotEmpty());

    }

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
                .thenReturn(user);
        this.mockMvc.perform(get("/api/user/" + id)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.nickname").value(user.getNickname()));

    }
}
