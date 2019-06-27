package com.tw.api.unit.test.controller;

import com.tw.api.unit.test.services.ShowService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ShowControllerTest {


    @Autowired
    private ShowController showController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShowService showService;

    @Test
    public void loadContext() {
        Assert.assertNotNull(showController);
    }

    @Test
    public void getAll() throws Exception {

        //given
        when(showService.getShowLable()).thenReturn("a beauity tag");
        //when
        ResultActions result = mvc.perform(get("/shows"));
        //then
        result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", is("a beauity tag")));
    }
}