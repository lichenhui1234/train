package com.guangzhaohui.lrps.web.controller;

import com.guangzhaohui.lrps.common.entity.ResultEntity;
import com.guangzhaohui.lrps.entity.muscle.MuscleEntity;
import com.guangzhaohui.lrps.service.MuscleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 肌肉相关操作
 *
 * @author 李晨辉
 * @date 2019-09-22
 */
@RestController
@Api(value = "MuscleController", description = "肌肉管理")
public class MuscleController {

    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @PostMapping("/muscle/add")
    @ApiOperation(value = "添加肌肉")
    public ResultEntity<MuscleEntity> insertMuscle(@Valid @RequestBody MuscleEntity entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultEntity.failResult(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultEntity.successResult(muscleService.insert(entity));
    }
}
