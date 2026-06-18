 /*
  * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028  并保留所有权利。
  *Copyright 2021-2028, YCHS Information&Science Technology Co.,Ltd,
  * All rights reserved.
  */
 package com.example.SpringBoot.Utils;/*
  *
  *@author wangbo
  *@version 1.0
  */

 import com.example.SpringBoot.exception.ParamsException;

 public class AssertUtils {
     public static void isTrue(boolean flag, String message) {
         if (flag) {
             throw new ParamsException(message);
         }
     }
 }
