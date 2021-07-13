package com.example.codegen.service.impl;

import com.example.codegen.entity.CodegenConfig;
import com.example.codegen.mapper.CodegenConfigMapper;
import com.example.codegen.service.CodegenConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 生成配置信息
 *
 * @Author zhangdongkang
 * @Date 2020-12-02 16:16:32
 */
@Service
public class CodegenConfigServiceImpl implements CodegenConfigService {

	@Resource
	private CodegenConfigMapper codegenConfigMapper;

	/**
	 * @Description: 获取数据源包含的表
	 * @Author zhangdongkang
	 * @Date 2020/12/2
	 */
	@Override
	public List<Map<String, Object>> getTableList(String dbName) {
		return codegenConfigMapper.getTableList(dbName);
	}

	/**
	 * @Description: 获取数据源的表详情
	 * @Author zhangdongkang
	 * @Date 2020/12/2
	 */
	@Override
	public List<Map<String, Object>> getTable(String dbName, String tableName) {
		return codegenConfigMapper.getTable(dbName, tableName);
	}

	/**
	 * @Description: 查询全部
	 * @Author zhangdongkang
	 * @Date 2021/1/14
	 */
	@Override
	public List<CodegenConfig> findAll() {
		return codegenConfigMapper.findAll();
	}
}
