 /*
  * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028  并保留所有权利。
  *Copyright 2021-2028, YCHS Information&Science Technology Co.,Ltd,
  * All rights reserved.
  */
 package com.example.SpringBoot.dao;/*
  *
  *@author wangbo
  *@version 1.0
  */

 import com.example.SpringBoot.entity.User;
 import com.example.SpringBoot.query.UserQuery;

 import java.util.List;

 public interface UserDao {
     public User getUserById(int id);

     public User getUserByName(String name);

     public int addUser(User user);

     public int updateUser(User user);

     public int deleteUser(int id);

     public List<User> selectUserByParams(UserQuery userQuery);
 }
