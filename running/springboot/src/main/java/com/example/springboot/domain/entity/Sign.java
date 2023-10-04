package com.example.springboot.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Sign {
    private int id;
    private String user;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String time;
    private String comment;
}
