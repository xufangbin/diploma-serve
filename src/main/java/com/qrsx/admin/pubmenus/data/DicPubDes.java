package com.qrsx.admin.pubmenus.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 15:12
 */
@Data
@Table(name = "dic_pubDes")
public class DicPubDes {

    private static final long serialVersionUID = -3504692496243074905L;

    @Id
    @Column
    private String id;
    @Column
    private String code;
    @Column
    private String name;
    @Column
    private String dicName;
    @Column
    private String parentId;
    @Column
    private String createUserId;
    @Column
    private String createDateTime;
    @Column
    private String modifyUserId;
    @Column
    private String modifyDateTime;
    @Column
    private String note;
    @Column
    private String description;
    @Column
    private String state;
}
