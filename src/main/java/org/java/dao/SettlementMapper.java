package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Mapper
public interface SettlementMapper {
    void add(Map<String,Object> map);
    Map<String,Object> findAdvanceAdjustmentByInstanceId(@Param("processInstanceId") String processInstanceId);
}
