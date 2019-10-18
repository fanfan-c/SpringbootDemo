package com.netease.controller;

import com.netease.domain.User;

import com.netease.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller  // 补充：当其RestController时，@RequestMapping下的方法返回值不会解析为路径，而是一个json字符串或者其他；
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(@RequestParam(value = "name", required=false) String name) { // 下面的对传入参数指定为aa，如果前端不传aa参数名，会报错 ;可以通过required=false或者true来要求@RequestParam配置的前端参数是否一定要传
        /** 需要注意：如果@requestParam注解的参数是int类型，并且required=false，此时如果不传参数的话，会报错。原因是，required=false时，不传参数的话，会给参数赋值null，这样就会把null赋值给了int，因此会报错。当然我们也可以用Integer代替int;
            required=false表示不传的话，会给参数赋值为null，required=true就是必须要有；

         最要的是，RequestParam是定参传值，；
         */
        User user = userService.findUserByName(name);

        if (null != user) {//null
            return user.getId() + "/" + user.getName() + "/" +
                    user.getPassword();
        } else {
            return "null";
        }
    }
    @RequestMapping(value = "/show/{personalPath}")
    @ResponseBody
    public String show2(@PathVariable String personalPath) {
        /** 需要注意：{name}中的name，要和show2函数参数name一致；
         */
        return "https://blog.csdn.net/" + personalPath;
    }
}
