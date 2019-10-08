package com.guangzhaohui.lrps.entity.muscle;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 肌群包含肌肉的关系表
 *
 * @author 李晨辉
 * @date 2019-09-16
 */
@Data
@Entity
@Table(name = "muscle_group_relation")
public class MuscleGroupRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer muscleId;
    private Integer groupId;
}
