package com.policysystem.springboot.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer folder;

    @Column
    private Integer op;

    @Column
    private String insuranceCompany;

    @Column
    private String insured;

    @Column
    private Integer policyNumber;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private Double amount;

    public Policy() {
    }

    public Policy(Long id, Integer folder, Integer op, String insuranceCompany, String insured, Integer policyNumber, LocalDate startDate, LocalDate endDate, Double amount) {
        this.id = id;
        this.folder = folder;
        this.op = op;
        this.insuranceCompany = insuranceCompany;
        this.insured = insured;
        this.policyNumber = policyNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFolder() {
        return folder;
    }

    public void setFolder(Integer folder) {
        this.folder = folder;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsured(){
        return insured;
    }

    public void setInsured(String insured){
        this.insured = insured;
    }

    public Integer getPolicyNumber(){
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber){
        this.policyNumber = policyNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
