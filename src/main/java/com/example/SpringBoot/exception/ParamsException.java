 /*
  * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028  并保留所有权利。
  *Copyright 2021-2028, YCHS Information&Science Technology Co.,Ltd,
  * All rights reserved.
  */
 package com.example.SpringBoot.exception;/*
  *
  *@author wangbo
  *@version 1.0
  */

 public class ParamsException extends RuntimeException{
     private Integer code = 300;
     private String msg = "参数异常";

     public ParamsException() {
         super("参数异常");
     }

     public ParamsException(String msg) {
         super(msg);
         this.msg = msg;
     }

     public ParamsException(Integer code){
         super("参数异常");
         this.code = code;
     }

     public ParamsException(Integer code, String msg) {
         super(msg);
         this.code = code;
         this.msg = msg;
     }

     public Integer getCode() {
         return code;
     }

     public void setCode(Integer code) {
         this.code = code;
     }

     public String getMsg() {
         return msg;
     }

     public void setMsg(String msg) {
         this.msg = msg;
     }
 }
