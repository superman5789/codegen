package com.example.codegen.service;

import com.example.codegen.entity.GenConfig;

public interface GeneratorService {

	/**
	 * 生成代码
	 */
	byte[] generatorCode(GenConfig genConfig);

}
