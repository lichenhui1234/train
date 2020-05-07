package com.guangzhaohui.train.common.aop;

import com.guangzhaohui.train.common.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 李晨辉
 * @date 2019-09-24
 */
@Slf4j
@RestControllerAdvice
public class ArgumentExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        assert fieldError != null;
        log.error("validExceptionHandler,{}:{}", fieldError.getField(), fieldError.getDefaultMessage());
        // 将错误的参数的详细信息封装到统一的返回实体
        return ResultEntity.failResult(bindingResult.getFieldError().getDefaultMessage());
    }
}
