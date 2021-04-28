package com.qrsx.commence.system.service;

import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 9:54
 */
public interface PermissionService {

    /**
    * @Description :获取字典名称
    * @Author : '徐方斌'
    * @Date: 2021/4/28 9:57
    * @Return
    */
    List<String> listDicName();
    /**
    * @Description :获取字典
    * @Author : '徐方斌'
    * @Date: 2021/4/28 10:03
    * @Return
    */
    List<Map<String, String>> getDic(String name);
}
