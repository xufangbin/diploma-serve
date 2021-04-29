package com.qrsx.admin.pubmenus.mapper;

import com.qrsx.admin.pubmenus.data.DicPubList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 15:22
 */
@Repository
public interface DicPubListMapper extends Mapper<DicPubList> {
    List<DicPubList> selectPubList(@Param("page") Integer page, Integer pageSize, String fuzzy);

    Long selectTotal(String fuzzy);
}
