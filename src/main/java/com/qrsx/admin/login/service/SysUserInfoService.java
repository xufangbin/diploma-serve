package com.qrsx.admin.login.service;

import com.qrsx.admin.login.data.SysUserInfo;
import com.qrsx.admin.login.mapper.SysUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class SysUserInfoService {
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    public Boolean login(SysUserInfo sysUserInfo) {
        String account = sysUserInfo.getAccount();
        String password = sysUserInfo.getPassword();
        Example example = new Example(SysUserInfo.class);
        example.createCriteria().andEqualTo("account",account)
                                .andEqualTo("password",password);
        int count = sysUserInfoMapper.selectCountByExample(example);
        return count == 1 ? true : false;
    }
}
