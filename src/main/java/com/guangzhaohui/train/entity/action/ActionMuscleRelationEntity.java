package com.guangzhaohui.train.entity.action;

import com.guangzhaohui.train.entity.muscle.MuscleEntity;
import lombok.Data;

import javax.persistence.CascadeType;
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
import java.util.Date;

/**
 * @author 李晨辉
 * @date 2019-10-21
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
    private short status;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(foreignKey= @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private ActionEntity action;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(foreignKey= @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private MuscleEntity muscle;

}
