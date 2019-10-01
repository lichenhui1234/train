package com.guangzhaohui.lrps.common.aop;

import com.guangzhaohui.lrps.common.entity.ResultEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李晨辉
 * @date 2019-09-24
 */
@RestControllerAdvice
public class ArgumentExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResultEntity<List<String>> bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<String> errorList = new ArrayList<>();
        for (ObjectError allError : bindingResult.getAllErrors()) {
            errorList.add(allError.getDefaultMessage());
        }
        return ResultEntity.failDataResult(errorList);
    }
}
