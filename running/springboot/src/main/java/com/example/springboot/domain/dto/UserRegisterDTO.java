package com.example.springboot.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterDTO implements Serializable {
    private static final long serialVersionUID = 3191241716373120793L;

    private String username;

    private String password;

}
