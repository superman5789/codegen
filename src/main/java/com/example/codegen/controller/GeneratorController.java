package com.example.codegen.controller;

import cn.hutool.core.io.IoUtil;
import com.example.codegen.entity.CodegenConfig;
import com.example.codegen.entity.GenConfig;
import com.example.codegen.service.CodegenConfigService;
import com.example.codegen.service.GeneratorService;
import com.example.codegen.util.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 */
@Slf4j
@Api(value = "generator", tags = "代码生成模块")
@RestController
public class GeneratorController {

	@Resource
	private GeneratorService generatorService;
	@Resource
	private CodegenConfigService codegenConfigService;

	/**
	 * @Description: 生成代码
	 * @Author zhangdongkang
	 * @Date 2020/12/2
	 */
	@PostMapping("generator/code")
	public void generatorCode(GenConfig genConfig, HttpServletResponse response) {
		try {
			byte[] data = generatorService.generatorCode(genConfig);
			response.reset();
			response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
					String.format("attachment; filename=%s.zip", genConfig.getModuleName()));
			response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
			response.setContentType("application/octet-stream; charset=UTF-8");

			IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: 获取数据源
	 * @Author zhangdongkang
	 * @Date 2020/12/2
	 */
	@GetMapping("generator/datasource/list")
	public Result<List<CodegenConfig>> getDatasource() {
		List<CodegenConfig> list = codegenConfigService.findAll();
		return Result.ok(list);
	}

	/**
	 * @Description: 获取数据源包含的表
	 * @Author zhangdongkang
	 * @Date 2020/12/2
	 */
	@GetMapping("generator/datasource/table/list")
	public Result<List<Map<String, Object>>> getTableList(String dbName) {
		List<Map<String, Object>> list = codegenConfigService.getTableList(dbName);
		return Result.ok(list);
	}

	/**
	 * @Description: 获取数据源的表详情
	 * @Author zhangdongkang
	 * @Date 2020/12/2
	 */
	@GetMapping("generator/datasource/table/detail")
	public Result<List<Map<String, Object>>> getTable(String dbName, String tableName) {
		List<Map<String, Object>> list = codegenConfigService.getTable(dbName, tableName);
		return Result.ok(list);
	}

}
