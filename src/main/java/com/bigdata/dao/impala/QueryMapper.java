package com.bigdata.dao.impala;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface QueryMapper {
//    int deleteByPrimaryKey(String id);
//
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    User selectByPrimaryKey(String id);
//    
//    User selectByUsername(String username);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
    
    List<HashMap<String, Object>> superManagerSelect(String sql);
}