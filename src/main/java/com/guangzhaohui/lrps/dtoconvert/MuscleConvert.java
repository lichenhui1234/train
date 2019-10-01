package com.guangzhaohui.lrps.dtoconvert;

import com.guangzhaohui.lrps.dto.muscle.MuscleDTO;
import com.guangzhaohui.lrps.entity.muscle.MuscleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author 李晨辉
 * @date 2019-09-30
 */
@Mapper
public interface MuscleConvert {
    MuscleConvert INSTANCE = Mappers.getMapper(MuscleConvert.class);

    MuscleDTO muscleToDto(MuscleEntity muscle);

    MuscleEntity muscleToEntity(MuscleDTO muscle);
}
