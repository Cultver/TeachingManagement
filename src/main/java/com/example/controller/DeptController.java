package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Intercepts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * web-management
 * dept
 *
 * @autor WH
 * @data 2023~04~25~19:53
 * @motto 不满足是向上的车轮！
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
//    private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;
    //指定请求方式为GET
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    //查询部门数据
    @GetMapping
    public Result list(){
        log.info("查询全部部门信息");
        //调用service查询部门数据
        List<Dept> deptList =  deptService.list();
        return Result.success(deptList);
    }

    //删除部门
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询部门数据:{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    //新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        //调用service新增部门
        deptService.add(dept);
        return Result.success();
    }
    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门信息:{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
