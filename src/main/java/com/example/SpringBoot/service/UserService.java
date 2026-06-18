 /*
  * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028  并保留所有权利。
  *Copyright 2021-2028, YCHS Information&Science Technology Co.,Ltd,
  * All rights reserved.
  */
 package com.example.SpringBoot.service;/*
  *
  *@author wangbo
  *@version 1.0
  */

 import com.example.SpringBoot.Utils.AssertUtils;
 import com.example.SpringBoot.dao.UserDao;
 import com.example.SpringBoot.entity.User;
 import com.example.SpringBoot.query.UserQuery;
 import com.github.pagehelper.PageHelper;
 import com.github.pagehelper.PageInfo;
 import org.apache.commons.lang3.StringUtils;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;


 @Service
 public class UserService {
     @Autowired
     private UserDao ud;
     public User getUserById(int id) {
        return ud.getUserById(id);
     }

     public User getUserByName(String name) {
        return ud.getUserByName(name);
     }

     public void saveUser(User user){
         AssertUtils.isTrue(StringUtils.isBlank(user.getName()), "用户名不能为空");
         AssertUtils.isTrue(StringUtils.isBlank(user.getPassword()), "密码不能为空");

         User temp =ud.getUserByName(user.getName());

         AssertUtils.isTrue(temp != null, "用户已存在");
         AssertUtils.isTrue(ud.addUser(user)<1, "添加用户失败");
     }

     public void updateUser(User user){
         AssertUtils.isTrue(StringUtils.isBlank(user.getName()), "用户名不能为空");
         AssertUtils.isTrue(StringUtils.isBlank(user.getPassword()), "密码不能为空");

         User temp =ud.getUserById(user.getId());

         AssertUtils.isTrue(temp == null, "用户不存在");
         AssertUtils.isTrue(ud.updateUser(user)<1, "更新用户失败");
     }

     public void deleteUser(int id){
         AssertUtils.isTrue(ud.getUserById(id)==null, "用户不存在");
         int row =ud.deleteUser(id);
         AssertUtils.isTrue(row<1, "删除用户失败");
     }

     public PageInfo<User> queryUserByParams(UserQuery userQuery){
         PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
         return new PageInfo<User>(ud.selectUserByParams(userQuery));
     }
 }
