package com.qrsx.admin.pubmenus.service;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.qrsx.admin.company.data.ArcCompany;
import com.qrsx.admin.company.data.RespPageEntity;
import com.qrsx.admin.pubmenus.data.DicPubList;
import com.qrsx.admin.pubmenus.mapper.DicPubListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    /**
    * @Description :添加字典信息
    * @Author : '徐方斌'
    * @Date: 2021/4/29 10:55
    * @Return
    */
    public void insertDicPubList(DicPubList dicPubList) {
        dicPubList.setCreateDateTime(DateUtil.now());
        dicPubList.setId(UUID.randomUUID().toString());
        dicPubListMapper.insert(dicPubList);
    }
    /**
    * @Description :修改字典信息
    * @Author : '徐方斌'
    * @Date: 2021/4/29 11:04
    * @Return
    */
    public void updateDicPubList(DicPubList dicPubList) {
        dicPubList.setModifyDateTime(DateUtil.now());
        dicPubListMapper.updateByPrimaryKey(dicPubList);
    }
}
