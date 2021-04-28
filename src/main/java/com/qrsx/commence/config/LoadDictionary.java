package com.qrsx.commence.config;

import com.qrsx.commence.system.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 9:49
 */
@Component
public class LoadDictionary implements CommandLineRunner {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        List<String> dicName = permissionService.listDicName();
        if(dicName != null){
            for(String name : dicName){
                List<Map<String,String>> dic = permissionService.getDic(name);
                redisTemplate.opsForValue().set("dic_" + name, dic);
            }
            System.out.println("字典加载完成");
        }
    }
}
