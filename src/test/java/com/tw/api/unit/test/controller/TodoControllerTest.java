package com.tw.api.unit.test.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.api.unit.test.controller.dto.ResourceWithUrl;
import com.tw.api.unit.test.domain.todo.Todo;
import com.tw.api.unit.test.domain.todo.TodoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoRepository todoRepository;

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void should_return_items_when_execute_getAll() {
        List<Todo> mockTodoList = Arrays.asList(
                new Todo(1, "abc", true, 1),
                new Todo(2, "efg", true, 2),
                new Todo(3, "hij", false, 3)
        );

        when(todoRepository.getAll()).thenReturn(mockTodoList);

        try {
            mockMvc.perform(get("/todos"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(
                            content().json(objectMapper.writeValueAsString(
                                    mockTodoList.stream().map(todo -> new ResourceWithUrl(todo)).collect(Collectors.toList())
                            ))
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}