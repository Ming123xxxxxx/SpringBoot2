package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/27 15:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user") //若实体类和表名不同时，可用@TableName来指定操作的表名
public class UsInfo {

//    @TableField(exist = false):
//    若在实体类属性上标注@TableField(exist=false)则表明此属性在表中不存在，则不会查询此属性
    private int id;
    private String name;
    private int age;
    private String email;
}
