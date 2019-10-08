package com.guangzhaohui.lrps.dtoconvert;

import com.guangzhaohui.lrps.dto.action.ActionDTO;
import com.guangzhaohui.lrps.dto.muscle.MuscleDTO;
import com.guangzhaohui.lrps.entity.action.ActionEntity;
import com.guangzhaohui.lrps.entity.muscle.MuscleEntity;
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
