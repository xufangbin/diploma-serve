package com.qrsx.admin.person.controller;

import com.qrsx.admin.company.data.ArcCompany;
import com.qrsx.admin.company.data.RespPageEntity;
import com.qrsx.admin.company.service.ArcCompanyService;
import com.qrsx.admin.person.data.ArcPerson;
import com.qrsx.admin.person.service.ArcPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ArcPersonController {
    @Autowired
    private ArcPersonService arcPersonService;

    @Autowired
    private ArcCompanyService arcCompanyService;

    /**
    * Description:分页查询 员工信息
    * date: 2021-04-16 20:26
    * @author: '徐方斌'
    */
    @GetMapping("/person")
    public RespPageEntity pageInfoArcPerson(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String fuzzy){
        return arcPersonService.pageInfoArcPerson(page, pageSize, fuzzy);
    }
    /**
    * Description:添加员工
    * date: 2021-04-16 20:44
    * @author: '徐方斌'
    */
    @PostMapping("/person/add")
    public void insertPerson(@RequestBody ArcPerson arcPerson){
        arcPersonService.insertPerson(arcPerson);
    }
    /**
    * Description: 修改员工
    * date: 2021-04-16 20:47
    * @author: '徐方斌'
    */
    @PutMapping("/person/update")
    public void updatePerson(@RequestBody ArcPerson arcPerson){
        arcPersonService.updatePerson(arcPerson);
    }
    /**
    * Description:删除员工
    * date: 2021-04-16 20:49
    * @author: '徐方斌'
    */
    @DeleteMapping("/person/delete/{personId}")
    public void deletePerson(@PathVariable("personId") String personId){
        arcPersonService.deletePerson(personId);
    }
    /**
    * Description:获取公司名称下拉框
    * date: 2021-04-17 21:22
    * @author: '徐方斌'
    */
    @GetMapping("/company/enterpriseName")
    public List<Map<String,Object>> selectEnterpriseName(){
        return arcCompanyService.selectEnterpriseName();
    }
}
