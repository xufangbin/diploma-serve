package com.qrsx.commence.system.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 9:59
 */
@Repository
public interface DictionaryMapper {
    List<String> listDicName();

    List<Map<String, String>> getDic(String name);
}
