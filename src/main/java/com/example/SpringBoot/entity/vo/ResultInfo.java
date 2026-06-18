 /*
  * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028  并保留所有权利。
  *Copyright 2021-2028, YCHS Information&Science Technology Co.,Ltd,
  * All rights reserved.
  */
 package com.example.SpringBoot.entity.vo;/*
  *
  *@author wangbo
  *@version 1.0
  */

 import io.swagger.annotations.ApiModel;
 import io.swagger.annotations.ApiModelProperty;

 @ApiModel(description = "响应结果类")
 public class ResultInfo {
  @ApiModelProperty(value = "响应状态码",example = "200")
     private int code =200;
  @ApiModelProperty(value = "响应消息")
     private String message = "操作成功";
  @ApiModelProperty(value = "响应对象")
     private Object ob;

  public int getCode() {
   return code;
  }

  public void setCode(int code) {
   this.code = code;
  }

  public String getMessage() {
   return message;
  }

  public void setMessage(String message) {
   this.message = message;
  }

  public Object getOb() {
   return ob;
  }

  public void setOb(Object ob) {
   this.ob = ob;
  }
 }
