package com.xueyong.hourseservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xueyong.hourseservice.common.ResponseResult;
import com.xueyong.hourseservice.entity.District;
import com.xueyong.hourseservice.entity.HourseVo;
import com.xueyong.hourseservice.entity.House;
import com.xueyong.hourseservice.enums.DecorateEnum;
import com.xueyong.hourseservice.service.IDistrictService;
import com.xueyong.hourseservice.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xueyong
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/hourse/")
public class HouseController {

    @Value("${file.path}")
    private String filePath;
    @Value("${file.domain}")
    private String fileDomain;
    @Autowired
    IHouseService iHouseService;
    @Autowired
    IDistrictService iDistrictService;
    @GetMapping("list")
    public ResponseResult list(Page page, HourseVo hourseVo){
        //要返回的数据房屋介绍，房屋类型，面积，装修类型，朝向楼层，每月租金，图片
        IPage<HourseVo> info = iHouseService.getPageInfo(page,hourseVo);
        info.getRecords().forEach(res->{
            res.setFangwutype(res.getRoom()+"室"+res.getHall()+"厅"+res.getToilet());
            //装修类型
            switch (res.getDecorate()){
                case 1:
                   res.setZhuangxiutype(DecorateEnum.毛坯.name());break;
                case 2:
                    res.setZhuangxiutype(DecorateEnum.普通装修.name());break;
                default:
                    res.setZhuangxiutype(DecorateEnum.精装修.name());
            }
            //省市区
           res.setProvincename(iDistrictService.getBaseMapper().selectById(res.getProvince()).getName());
            res.setCityname(iDistrictService.getBaseMapper().selectById(res.getCity()).getName());
            res.setCountyname(iDistrictService.getBaseMapper().selectById(res.getCounty()).getName());

        });
        return ResponseResult.success(info);
    }
    @GetMapping("diqulist")
    public ResponseResult diqulist(){
        QueryWrapper<District> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("parent",33);
        List<District> districts = iDistrictService.getBaseMapper().selectList(objectQueryWrapper);
       return ResponseResult.success(districts);
    }
    @GetMapping("selectprovince")
    public ResponseResult selectprovince(Integer id){
        QueryWrapper<District> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("parent",id);
     return ResponseResult.success(iDistrictService.getBaseMapper().selectList(objectQueryWrapper));
    }
    @GetMapping("zhuangxiu")
    public DecorateEnum[] zhuangxiu(){
        DecorateEnum[] values = DecorateEnum.values();
        return values;
    }
    @PostMapping("posts")
    public ResponseResult upload(@RequestParam("file")MultipartFile file){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        String originalFilename = file.getOriginalFilename();
       String exname =  originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID()+exname;
        File file1 = new File(filePath, filename);
        try {
            file.transferTo(file1);
            //路径加名字刚好是路径
            objectObjectHashMap.put("url",fileDomain+filename);
            //名字
            objectObjectHashMap.put("pic",filename);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ResponseResult.success(objectObjectHashMap);
    }
    @PostMapping("addOrUpdate")
    public Boolean addOrUpdate(@RequestBody House house){
        if(house.getId()!=null){
            iHouseService.updateById(house);
            return false;
        }else{
            return iHouseService.save(house);
        }
    }
    @PostMapping("deleteOrdeletes")
    public Boolean deleteOrdeletes(@RequestBody HourseVo hourseVo){
        System.out.println(hourseVo.getIds());
        return iHouseService.removeByIds(hourseVo.getIds());
    }

 }
