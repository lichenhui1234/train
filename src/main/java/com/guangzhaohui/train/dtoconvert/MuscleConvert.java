package com.guangzhaohui.train.dtoconvert;

import com.guangzhaohui.train.dto.muscle.MuscleDTO;
import com.guangzhaohui.train.dto.muscle.MuscleGroupDTO;
import com.guangzhaohui.train.entity.muscle.MuscleEntity;
import com.guangzhaohui.train.entity.muscle.MuscleGroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author 李晨辉
 * @date 2019-09-30
 */
@Mapper
public interface MuscleConvert {
    MuscleConvert INSTANCE = Mappers.getMapper(MuscleConvert.class);

    @Mappings(value = {
            @Mapping(target = "groupName", source = "group.name"),
            @Mapping(target = "groupId", source = "group.id")
    })
    MuscleDTO muscleToDto(MuscleEntity muscle);

    @Mappings(value = {
            @Mapping(target = "group.name", source = "groupName"),
            @Mapping(target = "group.id", source = "groupId")
    })
    MuscleEntity muscleToEntity(MuscleDTO muscle);

    MuscleGroupEntity muscleGroupToEntity(MuscleGroupDTO muscle);
    MuscleGroupDTO muscleGroupToDto(MuscleGroupEntity muscle);
}
