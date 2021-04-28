package com.qrsx.admin.person.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "arc_person")
public class ArcPerson implements Serializable {
    private static final long serialVersionUID = -3504692496243084905L;

    @Id
    @Column
    private String personId;
    @Column
    private String socialCode;
    @Column
    private String personName;
    @Column
    private String sex;
    @Column
    private String cardType;
    @Column
    private String idCard;
    @Column
    private String duty;
    @Column
    private String education;
    @Column
    private String phone;
    @Column
    private String entryDate;
    @Column
    private String leaveDate;
    @Column
    private String state;
    @Column
    private String dataCreator;
    @Column
    private String dataCreateDateTime;
    @Column
    private String dataModifier;
    @Column
    private String dataModifyDateTime;
    @Column
    private String remark;
}
