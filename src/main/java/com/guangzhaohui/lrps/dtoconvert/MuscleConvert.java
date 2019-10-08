package com.guangzhaohui.lrps.dtoconvert;

import com.guangzhaohui.lrps.dto.muscle.MuscleDTO;
import com.guangzhaohui.lrps.entity.muscle.MuscleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 李晨辉
 * @date 2019-09-30
 */
@Mapper
public interface MuscleConvert {
    MuscleConvert INSTANCE = Mappers.getMapper(MuscleConvert.class);

    MuscleDTO muscleToDto(MuscleEntity muscle);

    List<MuscleDTO> muscleToDto(Page<MuscleEntity> list);

    MuscleEntity muscleToEntity(MuscleDTO muscle);
}
