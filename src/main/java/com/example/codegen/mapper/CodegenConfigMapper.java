package com.example.codegen.mapper;

import com.example.codegen.entity.CodegenConfig;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 生成配置信息
 *
 * @Author zhangdongkang
 * @Date 2020-12-02 16:16:32
 */
public interface CodegenConfigMapper extends Mapper<CodegenConfig> {

	List<Map<String, Object>> getTableList(@Param("dbName") String dbName);

	List<Map<String, Object>> getTable(@Param("dbName") String dbName, @Param("tableName") String tableName);

	List<CodegenConfig> findAll();
}
