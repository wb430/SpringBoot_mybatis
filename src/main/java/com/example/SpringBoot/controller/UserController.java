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

 import com.example.SpringBoot.Utils.AssertUtils;
 import com.example.SpringBoot.entity.User;
 import com.example.SpringBoot.entity.vo.ResultInfo;
 import com.example.SpringBoot.exception.ParamsException;
 import com.example.SpringBoot.query.UserQuery;
 import com.example.SpringBoot.service.UserService;
 import com.github.pagehelper.PageInfo;
 import io.swagger.annotations.Api;
 import io.swagger.annotations.ApiImplicitParam;
 import io.swagger.annotations.ApiOperation;
 import io.swagger.annotations.ApiResponse;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.transaction.annotation.Propagation;
 import org.springframework.transaction.annotation.Transactional;
 import org.springframework.web.bind.annotation.*;
 import javax.validation.Valid;

 /*这里的
 使用Controller需要在每个方法中添加@ResponseBody注解
 使用RestController不需要添加@ResponseBody注解
  */

 /*api的使用
@Api作用在类上,用于说明该类的作用
@ApiOperation 作用在方法上
@ApiImplicitParams 用于方法上 说明一组参数
@ApiImplicitParam 用于说明单个参数
   name:表示参数名称
   value：表示汉字说明解释
   required:表示参数是否要传
   paramType:表示参数放在哪个地方
   dataType:参数类型
   defaultvalue:参数默认值
@ApiResponses 用于请求方法上，表示一组响应
@ApiResponse 在ApiResponses中，一般表示一组错误的响应
    code:数字，如400
    message：信息，请求参数没有填好
    response：抛出异常的类
@ApiModel 用在响应类上，用于返回响应类的属性
（一般用于Post,使用RequestBody这种，或者请求参数无法使用ApiImplicitParam进行描述）
@APiModelProperty:用在属性上，描述响应类属性

 * */
 @Api(tags = "用户模块 UserController")
 @RestController
 @RequestMapping("/user")
 public class UserController {
     @Autowired
     private UserService userService;

     /*通过用户id查找*/

     @ApiOperation(value="根据用户ID查找对象",notes="用户ID不能为空")
     @ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "path")
     @ApiResponse(code = 404,message = "访问路径不正确")
     @GetMapping("/getUserByid/{id}")
     @ResponseBody
     public User getUserById(@PathVariable ("id") int id){
         System.out.println("通过id查找用户");
         System.out.println(id);
         return userService.getUserById(id);
     }

     /*
     * 通过用户姓名查找*/
     @ApiOperation(value="根据用户名查找对象")
     @ApiImplicitParam(name = "name",value = "用户姓名",required = true,paramType = "path")
     @GetMapping("/getUserByName/{name}")
     @ResponseBody
     public User getUserByName(@PathVariable ("name") String name){
         return userService.getUserByName(name);
     }

     /*添加用户信息*/
     @Transactional(propagation = Propagation.REQUIRED)
     @ApiOperation(value="添加用户")
     @ApiImplicitParam(name = "user",value = "用户对象")
     @PutMapping("/addUser")
     public ResultInfo addUser(@RequestBody  User user){
         ResultInfo resultInfo = new ResultInfo();
         userService.saveUser(user);
         return resultInfo;
     }

     /*修改用户信息*/
     @Transactional(propagation = Propagation.REQUIRED)
     @ApiOperation(value="修改用户信息")
     @ApiImplicitParam(name = "user",value = "用户对象")
     @PostMapping("/updateUser")
     public ResultInfo updateUser(@RequestBody User user){
         ResultInfo resultInfo = new ResultInfo();
         try {
             userService.updateUser(user);
         }catch (ParamsException e){
             resultInfo.setCode(e.getCode());
             resultInfo.setMessage(e.getMsg());
             e.printStackTrace();
         }catch (Exception e){
             resultInfo.setCode(300);
             resultInfo.setMessage("操作失败");
         }
         return resultInfo;
     }

     @Transactional(propagation = Propagation.REQUIRED)
     @ApiOperation(value= "删除指定ID的用户信息")
     @ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "path")
     @DeleteMapping("/deleteUser/{id}")
      public ResultInfo deleteUser(@PathVariable ("id") int id){
         ResultInfo resultInfo = new ResultInfo();
         try {
             userService.deleteUser(id);
         }catch (ParamsException e){
             resultInfo.setCode(e.getCode());
             resultInfo.setMessage(e.getMsg());
             e.printStackTrace();
         }catch (Exception e){
             resultInfo.setCode(300);
             resultInfo.setMessage("操作失败");
         }
         return resultInfo;
     }

     @ApiOperation(value = "分页查询")
     @ApiImplicitParam(name = "userquery",value = "用户查询对象")
     @GetMapping("/List")
     public PageInfo<User> List(UserQuery userQuery){
         return userService.queryUserByParams(userQuery);
     }


     @ApiOperation(value="添加用户（异常测试）")
     @ApiImplicitParam(name = "user",value = "用户对象")
     // 测试接口
     @PutMapping("/addUser02")
     public ResultInfo addUser02(@Valid User user){
         ResultInfo resultInfo = new ResultInfo();
         userService.saveUser(user);
         return resultInfo;
     }
 }
