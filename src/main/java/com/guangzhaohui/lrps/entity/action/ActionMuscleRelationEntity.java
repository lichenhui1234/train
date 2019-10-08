package com.guangzhaohui.lrps.entity.action;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 锻炼所涉及的肌肉的关系表
 *
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
    /**
     * 动作与肌肉的强弱关联,strong,weak
     * fixme:出个枚举类
     * 例如胸推,主练胸肌,顺带会练到肱三头肌
     * 那么胸肌是强关联,肱三头肌是弱关联
     */
    private String relationship;


}
