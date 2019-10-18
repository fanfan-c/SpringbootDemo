package com.netease.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
////@ContextConfiguration(locations = { "classpath*:application.properties"})
//@SpringBootTest(classes = RestControllerTest.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestControllerTest.class)
@WebAppConfiguration
public class RestControllerTest {
    private MockMvc mockMvc;

//    private Environment environment;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(new RestControllers()).build();//创建一个视图通信（协议-代理）
    }
    @Test
    public void RestControllerMethod() throws Exception {
        RequestBuilder req = get("http://localhost:8080/rest/json/netease-java:");//创建一个请求,相当于在
        mockMvc.perform(req).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"netease-java:\",\"value\":\"Felix\"}"));
        /** 第一个andExpect：表示预期。status().isOk()表示返回码是200。 content().string("")表示返回的字符串 */
    }
}
