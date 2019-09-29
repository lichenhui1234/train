package com.guangzhaohui.lrps.entity.muscle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


/**
 * 肌肉枚举
 *
 * @author 李晨辉
 * @date 2019-09-16
 */
@Data
@Entity
@Table(name = "muscle")
public class MuscleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "肌肉名称不能为空")
    private String nameCn;
    private String nameEn;

}
