package com.guangzhaohui.lrps.web.controller;

import com.guangzhaohui.lrps.common.entity.ResultEntity;
import com.guangzhaohui.lrps.common.util.Arguments;
import com.guangzhaohui.lrps.dto.muscle.MuscleDTO;
import com.guangzhaohui.lrps.entity.muscle.MuscleEntity;
import com.guangzhaohui.lrps.service.MuscleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 肌肉相关操作
 *
 * @author 李晨辉
 * @date 2019-09-22
 */
@Controller
@Api(value = "MuscleController", description = "肌肉管理")
@RequestMapping("/muscle")
public class MuscleController {

    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加肌肉")
    public ResultEntity insertMuscle(@Valid @RequestBody MuscleDTO muscleDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultEntity.failDataResult(Arguments.getValidMsg(bindingResult));
        }
        return muscleService.insert(muscleDTO);
    }

    @GetMapping("/muscle")
    @ApiOperation(value = "添加肌肉页面")
    public String muscleView(MuscleDTO muscleDTO, Integer page, Integer pageSize, ModelMap model) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        Page<MuscleEntity> list = muscleService.listPagination(muscleDTO, page, pageSize);
        model.put("list", list);
        return "muscle/muscle";
    }
}

