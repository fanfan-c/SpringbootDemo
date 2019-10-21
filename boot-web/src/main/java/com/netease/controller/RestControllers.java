package com.netease.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController  // 会被解析成一个json格式的字符串
@RequestMapping(value = "/rest")
public class RestControllers {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    @Value("${com.netease.teacher}")
    private String value;

    private Map map;

    @RequestMapping(value = "/json/{name}")
    @ResponseBody
    public Map<Object,Object> show(@PathVariable String name) {
        map = new HashMap();
        map.put("name", name);
        map.put("value", value);
        return map;
    }
}
