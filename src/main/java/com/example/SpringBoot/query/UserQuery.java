 /*
  * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028  并保留所有权利。
  *Copyright 2021-2028, YCHS Information&Science Technology Co.,Ltd,
  * All rights reserved.
  */
 package com.example.SpringBoot.query;/*
  *
  *@author wangbo
  *@version 1.0
  */

 import io.swagger.annotations.ApiModel;
 import io.swagger.annotations.ApiModelProperty;

 @ApiModel(description = "用户模块的查询对象")
 public class UserQuery {
     @ApiModelProperty(value = "当前页码数",example = "1")
     private int pageNum =1;
     @ApiModelProperty(value = "每页显示数量",example = "10")
     private int pageSize = 10;
     @ApiModelProperty(value = "用户姓名")
     private String name;

     public int getPageNum() {
         return pageNum;
     }

     public void setPageNum(int pageNum) {
         this.pageNum = pageNum;
     }

     public int getPageSize() {
         return pageSize;
     }

     public void setPageSize(int pageSize) {
         this.pageSize = pageSize;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }
 }
