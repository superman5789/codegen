package com.example.codegen.entity;

import lombok.Data;

/**
 * @Description: 生成配置
 * @Author zhangdongkang
 * @Date 2020/8/27
 */
@Data
public class GenConfig {

	/**
	 * 数据源name
	 */
	private String dsName;

	/**
	 * 库名
	 */
	private String dbName;

	/**
	 * 包名
	 */
	private String packageName;

	/**
	 * 作者
	 */
	private String author;

	/**
	 * 模块名称
	 */
	private String moduleName;

	/**
	 * 表前缀
	 */
	private String tablePrefix;

	/**
	 * 表名称
	 */
	private String tableName;

	/**
	 * 表备注
	 */
	private String comments;

	/**
	 * 代码风格 0 - avue 1 - element
	 */
	private String style;

	/**
	 * 生成模式：springboot/springcloud
	 */
	private String genType;

}
