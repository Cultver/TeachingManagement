package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.PageBean;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * web-management
 * user
 *
 * @autor WH
 * @data 2023~04~25~19:48
 * @motto 不满足是向上的车轮！
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //获取总记录数
//        Long count = empMapper.count();
//        //获取分页查询结果列表
//        Integer start = (page -1) * pageSize;
//        List<Emp> empList = empMapper.page(start,pageSize);
//        //封装pagebean对象
//        PageBean pageBean = new PageBean(count,empList);
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1.设置分页参数
        PageHelper.startPage(page,pageSize);
        //2.run query
        List<Emp> empList = empMapper.list(name, gender, begin, end);
//        Page<Emp> p = (Page<Emp>) empList;
        //3.封装pagebean对象
//        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        PageBean pageBean = new PageBean((Long) new PageInfo(empList).getTotal(), empList);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
}
