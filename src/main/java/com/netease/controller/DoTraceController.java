package com.netease.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logInfo")
public class DoTraceController {

    private static final Logger LOG = LoggerFactory.getLogger(DoTraceController.class);

    @RequestMapping("")
    @ResponseBody
    String home() {
        LOG.info("这是DoTraceController test");
        return "Hello World!";
    }
}
