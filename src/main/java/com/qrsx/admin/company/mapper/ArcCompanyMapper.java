package com.qrsx.admin.company.mapper;

import com.qrsx.admin.company.data.ArcCompany;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface ArcCompanyMapper extends Mapper<ArcCompany> {
    List<ArcCompany> selectCompany(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("fuzzy") String fuzzy);

    Long selectTotal(String fuzzy);

    List<Map<String,Object>> selectEnterpriseName();
}
