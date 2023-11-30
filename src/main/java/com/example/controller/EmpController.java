package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * web-management
 * user
 *
 * @autor WH
 * @data 2023~04~25~19:53
 * @motto 不满足是向上的车轮！
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired(required = false)
    private EmpService empService;
    //分页查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-mm-dd")LocalDate end){
        log.info("分页查询,参数:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
    //删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }
    //新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工,emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }
}
