package com.example.codegen.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 */
public interface GeneratorMapper{

	/**
	 * 查询表信息
	 */
	Map<String, String> queryTable(@Param("tableName") String tableName, @Param("dbName") String dbName);

	/**
	 * 查询表列信息
	 */
	List<Map<String, String>> queryColumns(@Param("tableName") String tableName, @Param("dbName") String dbName);

}
