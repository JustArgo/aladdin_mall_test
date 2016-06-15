package com.mi360.aladdin.mall.mapper;

import java.util.List;
import java.util.Map;

import com.mi360.aladdin.mall.domain.ServiceTest;

public interface ServiceTestMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ServiceTest record);

    int insertSelective(ServiceTest record);

    ServiceTest selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ServiceTest record);

    int updateByPrimaryKey(ServiceTest record);
    
    List<Map<String,Object>> selectAllService();
    
    List<ServiceTest> selectByServiceCode(String serviceCode);
}