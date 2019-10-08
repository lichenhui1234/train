package com.guangzhaohui.lrps.mapper;

import com.guangzhaohui.lrps.entity.action.ActionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author 李晨辉
 * @date 2019-09-16
 */
public interface ActionDao extends PagingAndSortingRepository<ActionEntity, Integer> {
}
