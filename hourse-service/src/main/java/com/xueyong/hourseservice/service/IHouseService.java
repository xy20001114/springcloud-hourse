package com.xueyong.hourseservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xueyong.hourseservice.entity.HourseVo;
import com.xueyong.hourseservice.entity.House;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xueyong
 * @since 2020-06-21
 */
public interface IHouseService extends IService<House> {

    IPage<HourseVo> getPageInfo(Page page, HourseVo hourseVo);
}
