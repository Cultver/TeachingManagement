package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //分页查询
    PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end) ;

    void delete(List<Integer> ids);

    void save(Emp emp);
    /**
     * com.example.service.EmpService.getById():
     * 根据ID查询员工信息
     * @author WH
     * @date 2023/12/1~0:28
     No such property: code for class: Script1
     * @return com.example.pojo.Emp
     */
    Emp getById(Integer id);
    /**
     * com.example.service.EmpService.update():
     * 更新员工信息
     * @author WH
     * @date 2023/12/1~0:47
     No such property: code for class: Script1
     * @return void
     */
    void update(Emp emp);
}
