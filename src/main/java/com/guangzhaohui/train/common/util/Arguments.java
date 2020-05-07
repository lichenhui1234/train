package com.guangzhaohui.train.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李晨辉
 * @date 2019-10-01
 */
public class Arguments {

    public static boolean isNull(Object argument) {
        return argument == null;
    }

    public static boolean isNotNull(Object argument) {
        return !isNull(argument);
    }

    public static boolean isPositive(Integer argument) {
        return isNotNull(argument) && argument > 0;
    }

    public static boolean isNotPositive(Integer argument) {
        return !isPositive(argument);
    }

    public static List<String> getValidMsg(BindingResult bindingResult) {
        List<String> errorList = new ArrayList<String>();
        for (ObjectError allError : bindingResult.getAllErrors()) {
            errorList.add(allError.getDefaultMessage());
        }
        return errorList;
    }



}
