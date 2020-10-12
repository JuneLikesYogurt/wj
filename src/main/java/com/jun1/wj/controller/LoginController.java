package com.jun1.wj.controller;

import com.jun1.wj.dto.User;
import com.jun1.wj.result.Result;
import com.jun1.wj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


//import java.util.Objects;
/*Controller 负责数据交互，即接收前端发送的数据，
  通过调用 Service 获得处理后的数据并返回*/
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

//        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
//            String message = "账号密码错误";
//            System.out.println("test");
//            return new Result(400);
//        } else {
//            return new Result(200);
//        }
        User user = userService.get(username, requestUser.getPassword());
        if(null == user) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}

