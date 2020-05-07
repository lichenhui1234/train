package com.guangzhaohui.train.dto.action;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 锻炼动作
 *
 * @author 李晨辉
 * @date 2019-09-16
 */
@Data
public class ActionDTO {
    private Integer id;
    private Date gmtCreate;
    private Date gmtModifed;
    @ApiModelProperty(value = "动作名字", example = "深蹲", required = true)
    private String name;
    @ApiModelProperty(value = "动作描述", example = "深蹲是练大腿肌肉的王牌动作")
    private String description;
    @ApiModelProperty(value = "注意事项", example = "1.脚尖不能超过膝盖,2.盆骨不要后倾,3.防止腰部前后弯曲产生切力")
    private String tips;
    @ApiModelProperty(value = "动作图片", example = "/pic/action/1234.jpg")
    private String picUrl;

}
