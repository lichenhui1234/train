package com.guangzhaohui.train.web.controller.test;

import lombok.Data;

import java.util.List;

/**
 * @author 李晨辉
 * @date 2020-03-10
 */
@Data
public class TestDO<T> {
    private String people;
    private String device;
    private String value;
    private T more;

}
