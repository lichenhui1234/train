package com.guangzhaohui.lrps.service;

import com.guangzhaohui.lrps.common.entity.ResultEntity;
import com.guangzhaohui.lrps.common.util.Arguments;
import com.guangzhaohui.lrps.dto.muscle.MuscleDTO;
import com.guangzhaohui.lrps.dtoconvert.MuscleConvert;
import com.guangzhaohui.lrps.entity.muscle.MuscleEntity;
import com.guangzhaohui.lrps.mapper.MuscleDao;
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

    public MuscleService(MuscleDao muscleDao) {
        this.muscleDao = muscleDao;
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
                .withMatcher("nameCn", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withMatcher("nameEn", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withIgnorePaths("id");//忽略属性：是否关注。因为是基本类型，需要忽略掉
        Example<MuscleEntity> example = Example.of(entity, matcher);
        Page<MuscleEntity> all = muscleDao.findAll(example, pageable);
        return all;
    }

}
