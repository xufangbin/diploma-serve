package com.qrsx.commence.controller;

import com.qrsx.commence.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description :‘公司’的业务控制层
 * @Author : 'xfb'
 * @Date: 2021/1/27 9:48
 */
@RestController
public class CompanyController {
    @Autowired
    private CompanyMapper companyMapper;

    private List<Map<String,Object>> maps;
    @GetMapping("company")
    public List<Map<String,Object>> companyList(){
        maps = companyMapper.selectCompanyList();
        return maps;
    }
}
