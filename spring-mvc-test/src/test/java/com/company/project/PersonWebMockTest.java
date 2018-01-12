package com.company.project;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.company.project.PersonController;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
@EnableAutoConfiguration
public class PersonWebMockTest {
    @Autowired
    private MockMvc mockMvc;



    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        String requestJSON = "{\"name\":\"Nishant\",\"age\":36}";
        String responseJSON = "{\"name\":\"Nishant\",\"age\":36}";
        this.mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content(requestJSON)).andDo(print())
            .andExpect(status().isOk()).andExpect(content().json(responseJSON));

    }
}
