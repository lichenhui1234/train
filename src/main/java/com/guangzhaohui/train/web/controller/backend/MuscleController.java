package com.guangzhaohui.train.web.controller.backend;

import com.guangzhaohui.train.common.entity.ResultEntity;
import com.guangzhaohui.train.common.util.Arguments;
import com.guangzhaohui.train.dto.muscle.MuscleDTO;
import com.guangzhaohui.train.dto.muscle.MuscleGroupDTO;
import com.guangzhaohui.train.entity.muscle.MuscleEntity;
import com.guangzhaohui.train.service.MuscleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public ResultEntity insertMuscle(@Validated @RequestBody MuscleDTO muscleDTO) {
        return muscleService.insert(muscleDTO);
    }

    @PostMapping("/add_group")
    @ApiOperation(value = "添加肌群")
    @ResponseBody
    public ResultEntity insertMuscleGroup(@Validated @RequestBody MuscleGroupDTO muscleGroupDTO) {
        return muscleService.insert(muscleGroupDTO);
    }

    @GetMapping("/muscle")
    @ApiOperation(value = "添加肌肉页面")
    public String muscle(MuscleDTO muscle, Integer page, Integer pageSize, ModelMap model) {
        page = page == null ? 0 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        Page<MuscleEntity> list = muscleService.listPagination(muscle, page, pageSize);
        model.put("list", list);
        return "muscle/muscle";
    }
}

