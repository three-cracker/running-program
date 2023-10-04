package com.example.springboot.controller;

import com.example.springboot.domain.result.PageResult;
import com.example.springboot.domain.result.Result;
import com.example.springboot.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/credit")
public class CreditController {
    @Autowired
    private CreditService creditService;
    @PostMapping("/add")
    public Result addCredits(Integer add){


        creditService.addCredit(add);
        return Result.success();
    }

    @GetMapping
    public Result<PageResult> searchAll(){

        PageResult pageResult = creditService.selectPage();
        return Result.success(pageResult);
    }




}
