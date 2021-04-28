package com.qrsx.commence.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 10:12
 */
@Component
public class DicUtil {

    private static RedisTemplate redisTemplate;

    @Autowired
    public static void setRedisTemplate(RedisTemplate redisTemplate){
        DicUtil.redisTemplate = redisTemplate;
    }
    /**
    * @Description :获取缓存中的字典
    * @Author : '徐方斌'
    * @Date: 2021/4/28 10:15
     * @param dic
     * @param key
    * @Return
    */
    public String getDic(String dic, String key){
        List<Map<String, String>> dics = (List<Map<String, String>>) redisTemplate.opsForValue().get("dic_" + dic);
        for(Map<String, String> map :dics){
            String code = map.get("code");
            if(code.equalsIgnoreCase(key)){
                return map.get("value");
            }
        }
        return "";
    }
}
