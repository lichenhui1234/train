package com.guangzhaohui.train.service;

import com.guangzhaohui.train.common.entity.ResultEntity;
import com.guangzhaohui.train.common.util.Arguments;
import com.guangzhaohui.train.dto.muscle.MuscleDTO;
import com.guangzhaohui.train.dto.muscle.MuscleGroupDTO;
import com.guangzhaohui.train.dtoconvert.MuscleConvert;
import com.guangzhaohui.train.entity.muscle.MuscleEntity;
import com.guangzhaohui.train.entity.muscle.MuscleGroupEntity;
import com.guangzhaohui.train.mapper.MuscleDao;
import com.guangzhaohui.train.mapper.MuscleGroupDao;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author 李晨辉
 * @date 2019-09-16
 */
@Service
public class MuscleService {

    private final MuscleDao muscleDao;
    private final MuscleGroupDao muscleGroupDao;

    public MuscleService(MuscleDao muscleDao, MuscleGroupDao muscleGroupDao) {
        this.muscleDao = muscleDao;
        this.muscleGroupDao = muscleGroupDao;
    }

    public ResultEntity insert(MuscleDTO muscleDTO) {
        MuscleEntity entity = MuscleConvert.INSTANCE.muscleToEntity(muscleDTO);
        MuscleEntity save = muscleDao.save(entity);
        Integer id = save.getId();
        if (Arguments.isPositive(id)) {
            return ResultEntity.successResult(id);
        }
        return ResultEntity.failResult("插入失败");
    }

    public Page<MuscleEntity> listPagination(MuscleDTO muscleDTO, Integer page, Integer pageSize) {
        MuscleEntity entity = MuscleConvert.INSTANCE.muscleToEntity(muscleDTO);
        Pageable pageable = PageRequest.of(page, pageSize, new Sort(Sort.Direction.DESC, "id"));
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("nameCn", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nameEn", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("id");
        Example<MuscleEntity> example = Example.of(entity, matcher);
        return muscleDao.findAll(example, pageable);
    }

    public ResultEntity insert(MuscleGroupDTO muscleGroupDTO) {
        MuscleGroupEntity muscleGroupEntity = MuscleConvert.INSTANCE.muscleGroupToEntity(muscleGroupDTO);
        MuscleGroupEntity save = muscleGroupDao.save(muscleGroupEntity);
        Integer id = save.getId();
        if (Arguments.isPositive(id)) {
            return ResultEntity.successResult(id);
        }
        return ResultEntity.failResult("插入失败");
    }

}
