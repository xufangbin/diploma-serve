package com.qrsx.admin.login.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "sys_userInfo")
public class SysUserInfo implements Serializable {

    private static final long serialVersionUID = -3504692496243084906L;

    @Id
    @Column
    private String account;
    @Column
    private String password;
    @Column
    private String name;

}
