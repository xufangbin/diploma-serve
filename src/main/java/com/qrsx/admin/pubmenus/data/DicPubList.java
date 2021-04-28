package com.qrsx.admin.pubmenus.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description :
 * @Author : '徐方斌'
 * @Date: 2021/4/28 15:17
 */
@Data
@Table(name = "dic_pubList")
public class DicPubList implements Serializable {

    private static final long serialVersionUID = -3504692496243074904L;

    @Id
    @Column
    private String id;
    @Column
    private String name;
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
}
