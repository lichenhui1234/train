package com.guangzhaohui.lrps.controller;

import com.guangzhaohui.lrps.common.ResultEntity;
import com.guangzhaohui.lrps.entity.MuscleEntity;
import com.guangzhaohui.lrps.service.MuscleService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 肌肉相关操作
 *
 * @author 李晨辉
 * @date 2019-09-22
 */
@RestController
public class MuscleController {

    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @GetMapping("/muscle/add")
    public ResultEntity<MuscleEntity> insertMuscle(@Valid MuscleEntity muscle, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultEntity.failResult(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultEntity.successResult(muscleService.insert(muscle));
    }
}
