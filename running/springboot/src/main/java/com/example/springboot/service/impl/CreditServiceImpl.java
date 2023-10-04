package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.common.BaseContext;
import com.example.springboot.domain.entity.Credit;
import com.example.springboot.domain.result.PageResult;
import com.example.springboot.service.CreditService;
import com.example.springboot.mapper.CreditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 小拼音胖木木
* @description 针对表【credit】的数据库操作Service实现
* @createDate 2023-10-02 14:13:58
*/
@Service
public class CreditServiceImpl extends ServiceImpl<CreditMapper, Credit>
    implements CreditService {

    @Autowired
    private CreditMapper creditMapper;
    /**
     * 查询所有用户的积分并排序
     * @return
     */
    public PageResult selectPage() {
        IPage<Credit> page = new Page<>(1,10);
        QueryWrapper<Credit> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("credits");
        creditMapper.selectPage(page,wrapper);
        return new PageResult(page.getTotal(),page.getRecords());
    }

    /**
     * 添加积分
     */
    public void addCredit(Integer add) {
        //根据id更新
        Credit credit = creditMapper.selectById(BaseContext.getCurrentId());
        credit.setCredits(credit.getCredits()+add);
        creditMapper.updateById(credit);
    }
}




