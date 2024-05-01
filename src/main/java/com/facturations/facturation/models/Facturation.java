package com.facturations.facturation.models;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "facturation")
public class Facturation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facturationDate")
    @Temporal(TemporalType.DATE)
    private Date facturationDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "facturationcol")
    private String facturationId;

    @Column(name = "status")
    private String status;

    @Column(name = "company_id")
    private Long companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFacturationDate() {
        return facturationDate;
    }

    public void setFacturationDate(Date facturationDate) {
        this.facturationDate = facturationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFacturationId() {
        return facturationId;
    }

    public void setFacturationId(String facturationId) {
        this.facturationId = facturationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    
}