package com.guangzhaohui.lrps.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 锻炼所涉及的肌肉的关系表
 * @author 李晨辉
 * @date 2019-09-16
 */
@Data
@Entity
@Table(name = "action_muscle_relation")
public class ActionMuscleRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date gmtCreate;
    private Date gmtModifed;
    private Integer status;
    private Integer muscleId;
    private Integer actionId;

}
