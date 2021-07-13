package com.example.codegen.service;


import com.example.codegen.entity.CodegenConfig;

import java.util.List;
import java.util.Map;

/**
 * 生成配置信息
 * @Author zhangdongkang
 * @Date 2020-12-02 16:16:32
 */
public interface CodegenConfigService {

	/**
	 * @Description: 获取数据源包含的表
	 * @Author zhangdongkang
	 * @Date 2020/12/2
	 */
	List<Map<String, Object>> getTableList(String dbName);

	/**
	 * @Description: 获取数据源的表详情
	 * @Author zhangdongkang
	 * @Date 2020/12/2
	 */
	List<Map<String, Object>> getTable(String dbName, String tableName);

	/**
	 * @Description: 查询全部
	 * @Author zhangdongkang
	 * @Date 2021/1/14
	 */
	List<CodegenConfig> findAll();
}
