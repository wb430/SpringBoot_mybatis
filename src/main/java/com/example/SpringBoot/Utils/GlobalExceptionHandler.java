package com.example.SpringBoot.Utils;

import com.example.SpringBoot.entity.vo.ResultInfo;
import com.example.SpringBoot.exception.ParamsException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 表单无@RequestBody校验异常
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultInfo bindExceptionHandler(BindException e){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(500);
        resultInfo.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        return resultInfo;
    }

    // ==========新增这段，处理JSON @RequestBody校验报错==========
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultInfo validHandler(MethodArgumentNotValidException e){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(500);
        resultInfo.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        return resultInfo;
    }

    // 自定义参数异常单独捕获（优化，不要放在Exception分支里）
    @ExceptionHandler(ParamsException.class)
    @ResponseBody
    public ResultInfo paramsHandler(ParamsException e){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(e.getCode());
        resultInfo.setMessage(e.getMsg());
        return resultInfo;
    }

    // 兜底未知异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultInfo handleException(Exception e){
        e.printStackTrace(); // 打印堆栈，方便看真实异常
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMessage("操作失败");
        return resultInfo;
    }
}