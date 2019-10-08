package com.guangzhaohui.lrps.web.controller;

import com.guangzhaohui.lrps.common.entity.ResultEntity;
import com.guangzhaohui.lrps.dto.action.ActionDTO;
import com.guangzhaohui.lrps.service.ActionService;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResultEntity addAction(ActionDTO actionDTO) {
        return actionService.insert(actionDTO);

    }
}
