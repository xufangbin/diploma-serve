package com.qrsx.admin.person.mapper;

import com.qrsx.admin.company.data.ArcCompany;
import com.qrsx.admin.person.data.ArcPerson;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ArcPersonMapper extends Mapper<ArcPerson> {
    List<ArcPerson> selectPerson(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("fuzzy") String fuzzy);

    Long selectTotal(String fuzzy);

    List<ArcPerson> selectPersonByCode(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("fuzzy") String fuzzy, @Param("socialCode") String socialCode);

    Long selectTotalByCode(@Param("fuzzy") String fuzzy, @Param("socialCode") String socialCode);
}
