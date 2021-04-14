package com.qrsx.admin.company.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name = "arc_company")
public class ArcCompany implements Serializable {

    private static final long serialVersionUID = -3504692496243084905L;

    @Id
    @Column
    private String enterpriseId;
    @Column
    private String enterpriseName;
    @Column
    private String socialCode;
    @Column
    private String legalPerson;
    @Column
    private String legalCardType;
    @Column
    private String legalCard;
    @Column
    private String division;
    @Column
    private String address;
    @Column
    private String linkman;
    @Column
    private String phone;
    @Column
    private String establishDate;
    @Column
    private String enterpriseNature;
    @Column
    private String registerFund;
    @Column
    private String manageScope;
    @Column
    private String email;
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
