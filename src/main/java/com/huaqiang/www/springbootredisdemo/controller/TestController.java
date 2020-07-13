package com.huaqiang.www.springbootredisdemo.controller;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Controller
public class TestController {
   @Autowired
    private RedisTemplate redisTemplate;

   private   ValueOperations<String,Object>  getOperations(){
     return   this.redisTemplate.opsForValue();
   }

   @RequestMapping("/setTest")
    @ResponseBody
    public String setTest(@Param("name") String name){
       String s=null;

       if(this.redisTemplate.hasKey("name")){
           System.out.println("从缓存取");
           s = (String) getOperations().get("name");

       }else {
           getOperations().set("name",name,10000, TimeUnit.SECONDS);

           System.out.println("保存成功");
       }
       return s;
   }

}
