package com.diayan.ICD10RESTProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "icdcodes")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "diagnosis_code")
    private String code;

    @Column(name = "diagnosis_title")
    private String title;

    public Diagnosis(Long id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Diagnosis(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public Diagnosis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
