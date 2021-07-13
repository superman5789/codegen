package com.example.codegen.service.impl;

import cn.hutool.core.io.IoUtil;
import com.example.codegen.entity.GenConfig;
import com.example.codegen.mapper.GeneratorMapper;
import com.example.codegen.service.GeneratorService;
import com.example.codegen.util.CodeGenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

	@Resource
	private GeneratorMapper generatorMapper;

	@Resource
	private CodeGenUtils codeGenUtils;

	/**
	 * 生成代码
	 */
	@Override
	public byte[] generatorCode(GenConfig genConfig) {
		// 根据tableName 查询最新的表单配置
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		String tableName = genConfig.getTableName();
		String dbName = genConfig.getDbName();
		// 查询表信息
		Map<String, String> table = generatorMapper.queryTable(tableName, dbName);
		// 查询列信息
		List<Map<String, String>> columns = generatorMapper.queryColumns(tableName, dbName);
		// 生成代码
		codeGenUtils.generatorCode(genConfig, table, columns, zip);
		IoUtil.close(zip);
		return outputStream.toByteArray();
	}

}
