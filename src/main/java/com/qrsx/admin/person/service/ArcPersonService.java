package com.qrsx.admin.person.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.qrsx.admin.company.data.ArcCompany;
import com.qrsx.admin.company.data.RespPageEntity;
import com.qrsx.admin.person.data.ArcPerson;
import com.qrsx.admin.person.mapper.ArcPersonMapper;
import com.qrsx.commence.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ArcPersonService {
    @Autowired
    private ArcPersonMapper arcPersonMapper;

    public RespPageEntity pageInfoArcPerson(Integer page, Integer pageSize, String fuzzy) {
        RespPageEntity pageEntity = new RespPageEntity();
        //默认从0开始
        if(page != null && pageSize != null){
            page = (page - 1) * pageSize;
        }
        List<ArcPerson> arcPersonList = arcPersonMapper.selectPerson(page, pageSize, fuzzy);
        pageEntity.setData(arcPersonList);
        //获取当前员工数量
        Long total = arcPersonMapper.selectTotal(fuzzy);
        pageEntity.setTotal(total);
        return pageEntity;
    }
    /**
    * Description:添加人员
    * date: 2021-04-16 20:46
    * @author: '徐方斌'
    */
    public void insertPerson(ArcPerson arcPerson) {
        arcPerson.setPersonId(UUID.randomUUID().toString());
        arcPerson.setDataCreateDateTime(DateUtil.now());
        arcPersonMapper.insert(arcPerson);
    }
    /**
    * Description:修改员工
    * date: 2021-04-16 20:48
    * @author: '徐方斌'
    */
    public void updatePerson(ArcPerson arcPerson) {
        if(StrUtil.isEmpty(arcPerson.getPersonId())){
            throw  new ServiceException("修改公司时,主键为空");
        }
        arcPerson.setDataModifyDateTime(DateUtil.now());
        arcPersonMapper.updateByPrimaryKey(arcPerson);
    }
    /**
    * Description:删除员工
    * date: 2021-04-16 20:51
    * @author: '徐方斌'
    */
    public void deletePerson(String personId) {
        if(StrUtil.isEmpty(personId)){
            throw new ServiceException("删除员工时,员工id为空");
        }
        String[] arr = personId.split(",");
        List<String> list = Arrays.asList(arr);
        Example example = new Example(ArcPerson.class);
        example.createCriteria().andIn("personId",list);
        arcPersonMapper.deleteByExample(example);
    }
    /**
    * Description: 通过社会代码查询企业员工信息
    * date: 2021-04-17 22:17
    * @author: '徐方斌'
    */
    public RespPageEntity pageInfoArcPersonByCode(Integer page, Integer pageSize, String fuzzy, String socialCode) {
        RespPageEntity pageEntity = new RespPageEntity();
        //默认从0开始
        if(page != null && pageSize != null){
            page = (page - 1) * pageSize;
        }
        List<ArcPerson> arcPersonList = arcPersonMapper.selectPersonByCode(page, pageSize, fuzzy, socialCode);
        pageEntity.setData(arcPersonList);
        //获取当前员工数量
        Long total = arcPersonMapper.selectTotalByCode(fuzzy, socialCode);
        pageEntity.setTotal(total);
        return pageEntity;
    }
}
