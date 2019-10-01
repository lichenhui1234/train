package com.guangzhaohui.lrps.service;

import com.guangzhaohui.lrps.dto.muscle.MuscleDTO;
import com.guangzhaohui.lrps.dtoconvert.MuscleConvert;
import com.guangzhaohui.lrps.entity.muscle.MuscleEntity;
import com.guangzhaohui.lrps.mapper.MuscleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李晨辉
 * @date 2019-09-16
 */
@Service
public class MuscleService {
    @Autowired
    private MuscleDao muscleDao;

    public Integer insert(MuscleDTO muscleDTO) {
        MuscleEntity entity = MuscleConvert.INSTANCE.muscleToEntity(muscleDTO);
        MuscleEntity save = muscleDao.save(entity);
        return save.getId();
    }

}
