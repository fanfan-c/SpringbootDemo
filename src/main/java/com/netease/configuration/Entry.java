package com.netease.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.netease")/* 表示将该类自动发现扫描组件。
个人理解相当于，如果扫描到有@Component、@Controller、 @Service等这些注解的类，并注册为Bean，可以自动收集所有的Spring组件，包括@Configuration类。我们经常使用 @ComponentScan注解搜索beans，并结合@Autowired注解导入。可以自动收集所有的Spring组件，包括 @Configuration类。如果没有配置的话，Spring Boot会扫描启动类所在包下以及子包下的使用了@Service,@Repository等注解的类。*/
public class Entry {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }
}


//package com.netease.controller;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@EnableAutoConfiguration
//public class SampleController {
//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    }
//
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SampleController.class, args);
//    }
//}
