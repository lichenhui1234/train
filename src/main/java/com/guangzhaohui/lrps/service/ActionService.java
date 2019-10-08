package com.guangzhaohui.lrps.service;

import com.guangzhaohui.lrps.common.entity.ResultEntity;
import com.guangzhaohui.lrps.common.util.Arguments;
import com.guangzhaohui.lrps.dto.action.ActionDTO;
import com.guangzhaohui.lrps.dtoconvert.ActionConvert;
import com.guangzhaohui.lrps.entity.action.ActionEntity;
import com.guangzhaohui.lrps.mapper.ActionDao;
import org.springframework.stereotype.Service;

/**
 * @author 李晨辉
 * @date 2019-10-01
 */
@Service
public class ActionService {
    private final ActionDao actionDao;

    public ActionService(ActionDao actionDao) {
        this.actionDao = actionDao;
    }

    public ResultEntity insert(ActionDTO actionDTO) {
        ActionEntity entity = ActionConvert.INSTANCE.actionToEntity(actionDTO);
        ActionEntity save = actionDao.save(entity);
        Integer id = save.getId();
        if (Arguments.isPositive(id)) {
            return ResultEntity.successResult(id);
        }
        return ResultEntity.failResult("插入失败");
    }

    
}
