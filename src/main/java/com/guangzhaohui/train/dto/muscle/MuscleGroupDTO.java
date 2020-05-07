package com.guangzhaohui.train.dto.muscle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * 肌肉枚举
 *
 * @author 李晨辉
 * @date 2019-09-16
 */
@Data
public class MuscleGroupDTO {
    @ApiModelProperty(hidden = true)
    private Integer id;
    @NotBlank(message = "肌群名称不能为空")
    @ApiModelProperty(value = "肌群名字", example = "肩袖肌群")
    private String name;

}
