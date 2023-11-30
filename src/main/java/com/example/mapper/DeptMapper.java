package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /*
    * 查询全部部门数据
    * */
    @Select("select id,name,create_time,update_time from dept")
    List<Dept> list();
    //根据id删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
    /**
     * com.example.mapper.DeptMapper.insert():
     * 新增部门
     * @author WH
     * @date 2023/4/25~21:02
     No such property: code for class: Script1
     * @return void
     */
    @Insert("insert into dept(name, create_time, update_time)VALUES(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);
}
