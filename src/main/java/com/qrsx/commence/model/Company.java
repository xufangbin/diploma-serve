package com.qrsx.commence.model;

import lombok.Data;

import javax.persistence.*;


/**
 * @Description :’公司‘的实体类
 * @Author : 'xfb'
 * @Date: 2021/1/27 15:45
 */
@Data
@Entity
@Table(name = "xu_company")
public class Company {
    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String cname;
}
