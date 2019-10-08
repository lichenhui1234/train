package com.guangzhaohui.lrps.common.aop;

import com.guangzhaohui.lrps.common.entity.ResultEntity;
import com.guangzhaohui.lrps.common.util.Arguments;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        return ResultEntity.failDataResult(Arguments.getValidMsg(bindingResult));
    }
}
