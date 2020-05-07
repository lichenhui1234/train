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
public class MuscleDTO {
    @ApiModelProperty(hidden = true)
    private Integer id;
    @NotBlank(message = "肌肉名称不能为空")
    @ApiModelProperty(value = "肌肉中文名", example = "肱二头肌", required = true)
    private String nameCn;
    @ApiModelProperty(value = "肌肉英文名", example = "Musculus biceps brachii")
    private String nameEn;
    @ApiModelProperty(value = "肌群id",hidden = true)
    private String groupId;
    @ApiModelProperty(value = "肌群名字")
    private String groupName;

}
