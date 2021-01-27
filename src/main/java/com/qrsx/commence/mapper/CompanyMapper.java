package com.qrsx.commence.mapper;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description :‘公司’的数据持久层
 * @Author : 'xfb'
 * @Date: 2021/1/27 9:53
 */
@Repository
public interface CompanyMapper {
    List<Map<String, Object>> selectCompanyList();
}
