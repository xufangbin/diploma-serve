package com.qrsx.admin.pubmenus.service;

import com.qrsx.admin.company.data.ArcCompany;
import com.qrsx.admin.company.data.RespPageEntity;
import com.qrsx.admin.pubmenus.data.DicPubList;
import com.qrsx.admin.pubmenus.mapper.DicPubListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 15:21
 */
@Service
public class DicPubListService {

    @Autowired
    private DicPubListMapper dicPubListMapper;

    /**
    * @Description :分页查询 字典信息
    * @Author : '徐方斌'
    * @Date: 2021/4/28 15:31
    * @Return
    */
    public RespPageEntity pageInfoDicPubList(Integer page, Integer pageSize, String fuzzy) {
        RespPageEntity pageEntity = new RespPageEntity();
        //默认从0开始
        if(page != null && pageSize != null){
            page = (page - 1) * pageSize;
        }
        List<DicPubList> dicPubLists = dicPubListMapper.selectPubList(page, pageSize, fuzzy);
        pageEntity.setData(dicPubLists);
        //获取当前字典数量
        Long total = dicPubListMapper.selectTotal(fuzzy);
        pageEntity.setTotal(total);
        return pageEntity;
    }
}
