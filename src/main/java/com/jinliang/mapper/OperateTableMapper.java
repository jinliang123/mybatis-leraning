package com.jinliang.mapper;

import com.jinliang.domain.Column;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description
 *
 * @author liang.jin@hand-china.com 2018/09/12 15:05
 */
@Mapper
public interface OperateTableMapper {
    int createNewTable(@Param("createTable") String createTable);

    int updateTable(@Param("updateTable") String updateTable);

//    void createTable(@Param("tableName") String tableName, @Param("cloums")List<Column> colums);
    void createTable(@Param("cloums")String  colums);



}
