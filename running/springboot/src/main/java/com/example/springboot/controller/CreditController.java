package com.example.springboot.controller;

import com.example.springboot.domain.result.PageResult;
import com.example.springboot.domain.result.Result;
import com.example.springboot.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/credit")
@CrossOrigin(origins="http://localhost:8080",allowCredentials = "true")
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
