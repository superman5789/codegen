package com.example.codegen.service;

import com.example.codegen.entity.GenConfig;

public interface GeneratorService {

	/**
	 * ็ๆไปฃ็ 
	 */
	byte[] generatorCode(GenConfig genConfig);

}
