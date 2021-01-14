package com.llk.api.model.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 业务bean
public class StudentParams {
    // start （必传的）
    // size (必传的)
    // name
    //  birthdaymin（yyyy-MM-dd）
    //  birthdaymax（yyyy-MM-dd）
    //agemin
    //agemax
        private String name;
        private  Integer start;
        private Integer size;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date birthdaymin;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date birthdaymax;
        private Integer agemin;
        private Integer agemax;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getBirthdaymin() {
        return birthdaymin;
    }

    public void setBirthdaymin(Date birthdaymin) {
        this.birthdaymin = birthdaymin;
    }

    public Date getBirthdaymax() {
        return birthdaymax;
    }

    public void setBirthdaymax(Date birthdaymax) {
        this.birthdaymax = birthdaymax;
    }

    public Integer getAgemin() {
        return agemin;
    }

    public void setAgemin(Integer agemin) {
        this.agemin = agemin;
    }

    public Integer getAgemax() {
        return agemax;
    }

    public void setAgemax(Integer agemax) {
        this.agemax = agemax;
    }
}
