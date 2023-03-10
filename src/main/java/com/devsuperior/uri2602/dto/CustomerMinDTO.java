package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.projections.CustmoerMinProjection;

import java.io.Serializable;
import java.util.List;

public class CustomerMinDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public CustomerMinDTO(){}


    public CustomerMinDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
