package com.example.records.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;





@Entity
@Table(name = "insurence")
public class InsurenceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String NIDAID;
    private String InsurenceID;


     // Getters and Setters
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNIDAID() {
        return NIDAID;
    }

    public void setNIDAID(String NIDAID) {
        this.NIDAID = NIDAID;
    }

    public String getInsurenceID() {
        return InsurenceID;
    }

    public void setInsurenceID(String InsurenceID) {
        this.InsurenceID = InsurenceID;
    }



}
