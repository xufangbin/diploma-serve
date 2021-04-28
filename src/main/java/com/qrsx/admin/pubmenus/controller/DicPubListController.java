package com.qrsx.admin.pubmenus.controller;

import com.qrsx.admin.company.data.RespPageEntity;
import com.qrsx.admin.pubmenus.data.DicPubList;
import com.qrsx.admin.pubmenus.service.DicPubListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 15:11
 */
@RestController
public class DicPubListController implements Serializable {

    @Autowired
    private DicPubListService dicPubListService;

    /**
    * @Description :分页查询 字典信息
    * @Author : '徐方斌'
    * @Date: 2021/4/28 15:30
    * @Return
    */
    @GetMapping("/pubList")
    public RespPageEntity pageInfoDicPubList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, String fuzzy ){
        return dicPubListService.pageInfoDicPubList(page, pageSize, fuzzy);
    }
}
