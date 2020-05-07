package com.guangzhaohui.train.dtoconvert;

import com.guangzhaohui.train.dto.action.ActionDTO;
import com.guangzhaohui.train.entity.action.ActionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author 李晨辉
 * @date 2019-09-30
 */
@Mapper
public interface ActionConvert {
    ActionConvert INSTANCE = Mappers.getMapper(ActionConvert.class);

    ActionDTO actionToDto(ActionEntity action);

    ActionEntity actionToEntity(ActionDTO actionDTO);
}
