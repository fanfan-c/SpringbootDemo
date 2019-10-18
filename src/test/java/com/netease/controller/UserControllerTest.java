package com.netease.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserControllerTest.class)
@WebAppConfiguration
public class UserControllerTest {
    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();//创建一个视图通信（协议-代理）
    }

    @Test
    public void contextLoads() throws Exception {//ok
        RequestBuilder req = get("http://localhost:8080/user/index");//创建一个请求,相当于在
        mockMvc.perform(req).andExpect(status().isOk());
        /** 第一个andExpect：表示预期。status().isOk()表示返回码是200。 content().string("")表示返回的字符串 */
    }
    @Test
    public void selcetName() throws Exception {// NullPointerException: at com.netease.controller.UserController.show(UserController.java:36)
        RequestBuilder req = get("http://localhost:8080/user/show?name=cf");//创建一个请求,相当于在
        mockMvc.perform(req).andExpect(status().isOk());
        /** 第一个andExpect：表示预期。status().isOk()表示返回码是200。 content().string("")表示返回的字符串 */
    }
    @Test
    public void contextLoads3() throws Exception { //ok
        RequestBuilder req = get("http://localhost:8080/user/show/asdfa");//创建一个请求,相当于在
        mockMvc.perform(req).andExpect(status().isOk());
        /** 第一个andExpect：表示预期。status().isOk()表示返回码是200。 content().string("")表示返回的字符串 */
    }

}
