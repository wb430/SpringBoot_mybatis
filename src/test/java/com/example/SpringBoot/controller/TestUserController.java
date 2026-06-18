 /*
  * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028  并保留所有权利。
  *Copyright 2021-2028, YCHS Information&Science Technology Co.,Ltd,
  * All rights reserved.
  */
 package com.example.SpringBoot.controller;/*
  *
  *@author wangbo
  *@version 1.0
  */



 import com.example.SpringBoot.SpringBootMybatisApplication;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.http.MediaType;
 import org.springframework.mock.web.MockHttpServletResponse;
 import org.springframework.test.context.junit4.SpringRunner;
 import org.springframework.test.web.servlet.MockMvc;
 import org.springframework.test.web.servlet.MvcResult;
 import org.springframework.test.web.servlet.ResultActions;
 import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
 import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

 @RunWith(SpringRunner.class)
 @SpringBootTest(classes = SpringBootMybatisApplication.class)
 @AutoConfigureMockMvc
 public class TestUserController {

     //使用日志
    Logger logger = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
   public void apiTest01() throws Exception {
     MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/getUserByid/1")
             .content( "text/html")
             .accept(MediaType.APPLICATION_JSON); //设置请求返回类型

     //发送请求
     ResultActions perform= mockMvc.perform(builder);
     //校验请求结果
     perform.andExpect(MockMvcResultMatchers.status().isOk());
     //获取请求结果
     MvcResult mvcResult = perform.andReturn();
     //得到执行后的响应
     MockHttpServletResponse response = mvcResult.getResponse();

        logger.info("响应状态码："+response.getStatus());
        logger.info("响应结果："+response.getContentAsString());

    }

    @Test
     public void apiTest02() throws Exception {
        MvcResult ra = mockMvc.perform(MockMvcRequestBuilders.get("/user/getUserByName/wb"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("远程分支操作");
        System.out.println("本地分支操作");
        logger.info("状态响应码{}:"+ra.getResponse().getStatus());
        logger.info("响应结果{}:"+ra.getResponse().getContentAsString());

     }

 }
