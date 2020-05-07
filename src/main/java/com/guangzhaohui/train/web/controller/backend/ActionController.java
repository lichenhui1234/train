package com.guangzhaohui.train.web.controller.backend;

import com.guangzhaohui.train.common.entity.ResultEntity;
import com.guangzhaohui.train.dto.action.ActionDTO;
import com.guangzhaohui.train.service.ActionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李晨辉
 * @date 2019-10-01
 */
@RestController
@RequestMapping("/action")
public class ActionController {

    private ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping("/add")
    public ResultEntity addAction(@Validated @RequestBody ActionDTO actionDTO) {
        return actionService.insert(actionDTO);

    }
}
