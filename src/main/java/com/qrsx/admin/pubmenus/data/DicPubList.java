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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(String modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
