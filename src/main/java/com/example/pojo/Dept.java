package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * web-management
 * 部门
 *
 * @autor WH
 * @data 2023~04~25~19:31
 * @motto 不满足是向上的车轮！
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id; //ID
    private String name; //部门名称
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
