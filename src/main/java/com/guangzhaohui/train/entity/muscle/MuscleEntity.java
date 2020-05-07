package com.guangzhaohui.train.entity.muscle;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;


/**
 * 肌肉枚举
 *
 * @author 李晨辉
 * @date 2019-09-16
 */
@Data
@Entity
@Table(name = "muscle",uniqueConstraints=@UniqueConstraint(columnNames = "nameCn"))
public class MuscleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "肌肉名称不能为空")
    @Column(length = 32)
    private String nameCn;
    @Column(length = 32)
    private String nameEn;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "group_id",foreignKey= @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @JoinColumn(foreignKey= @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private MuscleGroupEntity group;

}
