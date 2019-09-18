package com.guangzhaohui.lrps.service;

import com.guangzhaohui.lrps.entity.MuscleEntity;
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

    public MuscleEntity insert(MuscleEntity entity) {
        return muscleDao.save(entity);
    }

}
