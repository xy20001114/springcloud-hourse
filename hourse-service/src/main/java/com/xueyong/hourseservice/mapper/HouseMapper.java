package com.xueyong.hourseservice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xueyong.hourseservice.entity.HourseVo;
import com.xueyong.hourseservice.entity.House;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xueyong
 * @since 2020-06-21
 */
public interface HouseMapper extends BaseMapper<House> {

    IPage<HourseVo> getPageInfo(Page page,@Param("hourseVo") HourseVo hourseVo);
}
