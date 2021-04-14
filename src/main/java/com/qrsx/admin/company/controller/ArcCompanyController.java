package com.qrsx.admin.company.controller;

import com.github.pagehelper.PageInfo;
import com.qrsx.admin.company.data.ArcCompany;
import com.qrsx.admin.company.data.RespPageEntity;
import com.qrsx.admin.company.service.ArcCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArcCompanyController {
    @Autowired
    private ArcCompanyService arcCompanyService;
    /**
     * Description:分页查询 公司信息
     * date: 2021-04-12 22:09
     * @author: '徐方斌'
     */
    @GetMapping("/company")
    public RespPageEntity pageInfoArcCompany(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String fuzzy){
        return arcCompanyService.pageInfoArcCompany(page, pageSize, fuzzy);
    }
    /**
    * Description:添加公司信息
    * date: 2021-04-13 21:56
    * @author: '徐方斌'
    */
    @PostMapping("/company/add")
    public void insertCompany(@RequestBody ArcCompany arcCompany){
        arcCompanyService.insertCompany(arcCompany);
    }
    /**
    * Description: 修改公司信息
    * date: 2021-04-13 22:23
    * @author: '徐方斌'
    */
    @PutMapping("/company/update")
    public void updateCompany(@RequestBody ArcCompany arcCompany){
        arcCompanyService.updateCompany(arcCompany);
    }
    /**
    * Description: 删除公司信息
    * date: 2021-04-13 22:31
    * @author: '徐方斌'
    */
    @DeleteMapping("/company/delete/{socialCode}")
    public void deleteCompany(@PathVariable("socialCode") String socialCode){
        arcCompanyService.deleteCompany(socialCode);
    }
}
