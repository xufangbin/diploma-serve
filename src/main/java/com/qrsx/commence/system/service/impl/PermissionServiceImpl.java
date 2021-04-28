package com.qrsx.commence.system.service.impl;

import com.qrsx.commence.system.mapper.DictionaryMapper;
import com.qrsx.commence.system.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 9:55
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private DictionaryMapper dictionaryMapper;
    /**
    * @Description :获取字典名称
    * @Author : '徐方斌'
    * @Date: 2021/4/28 9:58
    * @Return
    */
    @Override
    public List<String> listDicName() {
        return dictionaryMapper.listDicName();
    }
    /**
    * @Description :获取字典
    * @Author : '徐方斌'
    * @Date: 2021/4/28 10:04
    * @Return
    */
    @Override
    public List<Map<String, String>> getDic(String name) {
        return dictionaryMapper.getDic(name);
    }
}
