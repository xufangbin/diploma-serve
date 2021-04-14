package com.qrsx.admin.company.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qrsx.admin.company.data.ArcCompany;
import com.qrsx.admin.company.data.RespPageEntity;
import com.qrsx.admin.company.mapper.ArcCompanyMapper;
import com.qrsx.commence.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ArcCompanyService {
    @Autowired
    private ArcCompanyMapper arcCompanyMapper;
    /**
    * Description:分页显示 公司信息
    * date: 2021-04-13 21:58
    * @author: '徐方斌'
    */
    public RespPageEntity pageInfoArcCompany(Integer page, Integer pageSize, String fuzzy) {
        RespPageEntity pageEntity = new RespPageEntity();
        //默认从0开始
        if(page != null && pageSize != null){
            page = (page - 1) * pageSize;
        }
        List<ArcCompany> arcCompanies = arcCompanyMapper.selectCompany(page, pageSize, fuzzy);
        pageEntity.setData(arcCompanies);
        //获取当前公司数量
        Long total = arcCompanyMapper.selectTotal(fuzzy);
        pageEntity.setTotal(total);
        return pageEntity;
    }
    /**
    * Description: 添加公司信息
    * date: 2021-04-13 21:58
    * @author: '徐方斌'
    */
    public void insertCompany(ArcCompany arcCompany) {
        arcCompany.setEnterpriseId(UUID.randomUUID().toString());
        arcCompany.setDataCreateDateTime(DateUtil.now());
        arcCompanyMapper.insert(arcCompany);
    }
    /**
    * Description:修改公司信息
    * date: 2021-04-13 22:24
    * @author: '徐方斌'
    */
    public void updateCompany(ArcCompany arcCompany) {
        if(StrUtil.isEmpty(arcCompany.getEnterpriseId())){
            throw  new ServiceException("修改公司时,主键为空");
        }
        arcCompany.setDataModifyDateTime(DateUtil.now());
        arcCompanyMapper.updateByPrimaryKey(arcCompany);
    }
    /**
    * Description:删除公司信息
    * date: 2021-04-13 22:33
    * @author: '徐方斌'
    */
    public void deleteCompany(String socialCode) {
        if(StrUtil.isEmpty(socialCode)){
            throw new ServiceException("删除公司时,主键为空");
        }
        String[] arr = socialCode.split(",");
        List<String> list = Arrays.asList(arr);
        Example example = new Example(ArcCompany.class);
        example.createCriteria().andIn("socialCode",list);
        arcCompanyMapper.deleteByExample(example);
    }
}
