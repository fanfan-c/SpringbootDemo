import com.netease.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SpringbootTest {
    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();//创建一个视图通信（协议-代理）
    }

    @Test
    public void contextLoads() throws Exception {
        RequestBuilder req = get("http://localhost:8080/user/index");//创建一个请求,相当于在
        mockMvc.perform(req).andExpect(status().isOk()).andExpect(content().string(""));
        /** 第一个andExpect：表示预期。status().isOk()表示返回码是200。 content().string("")表示返回的字符串 */
    }
}
