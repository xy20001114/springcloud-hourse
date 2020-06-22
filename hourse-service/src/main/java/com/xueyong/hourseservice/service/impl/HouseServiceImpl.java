package com.xueyong.hourseservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xueyong.hourseservice.entity.HourseVo;
import com.xueyong.hourseservice.entity.House;
import com.xueyong.hourseservice.mapper.HouseMapper;
import com.xueyong.hourseservice.service.IHouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xueyong
 * @since 2020-06-21
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {

    @Override
    public IPage<HourseVo> getPageInfo(Page page, HourseVo hourseVo) {
        return this.getBaseMapper().getPageInfo(page,hourseVo);
    }
}
