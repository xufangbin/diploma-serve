package com.qrsx.commence.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 13:53
 */
@RestController
public class SysController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/getDic/{name}")
    public List<Map<String, String>> getDic(@PathVariable("name") String name){
        return (List<Map<String, String>>) redisTemplate.opsForValue().get("dic_" + name);
    }
}
