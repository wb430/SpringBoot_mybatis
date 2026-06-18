 /*
  * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028  并保留所有权利。
  *Copyright 2021-2028, YCHS Information&Science Technology Co.,Ltd,
  * All rights reserved.
  */
 package com.example.SpringBoot.entity;/*
  *
  *@author wangbo
  *@version 1.0
  */

 import io.swagger.annotations.ApiModel;
 import io.swagger.annotations.ApiModelProperty;
 import org.hibernate.validator.constraints.Length;

 import javax.validation.constraints.Max;
 import javax.validation.constraints.Min;
 import javax.validation.constraints.NotBlank;
 import java.util.Date;


 @ApiModel(description = "用户实体类")
 public class User {
     @ApiModelProperty(value = "用户id",example = "0")
     @Min(value = 1, message = "用户id不能小于1")
     @Max(value = 99999999, message = "用户id长度不能超过8位数字")
     private int id;
     @ApiModelProperty(value = "用户姓名")
     @NotBlank(message = "用户姓名不能为空")
     private String name;
     @ApiModelProperty(value = "用户密码")
     @NotBlank(message = "用户密码不能为空")
     @Length(min = 6,max = 20,message = "密码长度在6-20之间")
     private String password;
     @ApiModelProperty(value = "用户邮箱")
     @NotBlank(message = "用户邮箱不能为空")
     private String email;
     @ApiModelProperty(value = "用户信息注册时间")
     private Date createTime;
     @ApiModelProperty(value = "用户信息最近更新时间")
     private Date updateTime;

     public User() {
     }

     public User(int id, String name, String password, String email, Date createTime, Date updateTime) {
         this.id = id;
         this.name = name;
         this.password = password;
         this.email = email;
         this.createTime = createTime;
         this.updateTime = updateTime;
     }

     /**
      * 获取
      * @return id
      */
     public int getId() {
         return id;
     }

     /**
      * 设置
      * @param id
      */
     public void setId(int id) {
         this.id = id;
     }

     /**
      * 获取
      * @return name
      */
     public String getName() {
         return name;
     }

     /**
      * 设置
      * @param name
      */
     public void setName(String name) {
         this.name = name;
     }

     /**
      * 获取
      * @return password
      */
     public String getPassword() {
         return password;
     }

     /**
      * 设置
      * @param password
      */
     public void setPassword(String password) {
         this.password = password;
     }

     /**
      * 获取
      * @return email
      */
     public String getEmail() {
         return email;
     }

     /**
      * 设置
      * @param email
      */
     public void setEmail(String email) {
         this.email = email;
     }

     /**
      * 获取
      * @return createTime
      */
     public Date getCreateTime() {
         return createTime;
     }

     /**
      * 设置
      * @param createTime
      */
     public void setCreateTime(Date createTime) {
         this.createTime = createTime;
     }

     /**
      * 获取
      * @return updateTime
      */
     public Date getUpdateTime() {
         return updateTime;
     }

     /**
      * 设置
      * @param updateTime
      */
     public void setUpdateTime(Date updateTime) {
         this.updateTime = updateTime;
     }

     public String toString() {
         return "User{id = " + id + ", name = " + name + ", password = " + password + ", email = " + email + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
     }
 }
