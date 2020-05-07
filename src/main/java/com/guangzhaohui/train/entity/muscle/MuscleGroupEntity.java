package com.guangzhaohui.train.entity.muscle;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 肌群枚举
 *
 * @author 李晨辉
 * @date 2019-09-22
 */
@Data
@Entity
@Table(name = "muscle_group", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class MuscleGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 32)
    private String name;
}
