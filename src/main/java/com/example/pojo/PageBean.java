package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * web-management
 * page
 *  分页查询结果封装类
 * @autor WH
 * @data 2023~04~25~21:54
 * @motto 不满足是向上的车轮！
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;//总记录数
    private List rows;//当前页数据列表
}
