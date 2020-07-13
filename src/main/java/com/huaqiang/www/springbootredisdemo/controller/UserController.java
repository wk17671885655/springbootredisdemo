package com.huaqiang.www.springbootredisdemo.controller;

import com.huaqiang.www.springbootredisdemo.Utils.JwtUtils;
import com.huaqiang.www.springbootredisdemo.controller.shiro.RequiresRoles;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 列表
     * @return
     */
    @RequestMapping("/list")
    @RequiresRoles(value="admin")
    public Result list() {
        return Result.ok("十万亿个用户");
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login() throws Base64DecodingException {
        /**
         * 模拟登录过程并返回token
         */
        String token = JwtUtils.createJWT("101","爪哇笔记",1000*60*60);
        return Result.ok(token);
    }
}