package com.qrsx.admin.login.controller;

import com.qrsx.admin.login.data.SysUserInfo;
import com.qrsx.admin.login.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SysUserInfoController {
    @Autowired
    private SysUserInfoService sysUserInfoService;

    @GetMapping("/login")
    public Boolean login(SysUserInfo sysUserInfo){
        return sysUserInfoService.login(sysUserInfo);
    }
}
