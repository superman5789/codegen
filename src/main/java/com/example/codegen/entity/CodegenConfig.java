package com.example.codegen.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 生成配置信息
 *
 * @Author zhangdongkang
 * @Date 2020-12-02 16:16:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_codegen_config")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "生成配置信息")
public class CodegenConfig extends Model<CodegenConfig> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(value = "主键")
	private Long configId;
	/**
	 * 配置名称
	 */
	@ApiModelProperty(value = "配置名称")
	private String configName;
	/**
	 * 数据库地址
	 */
	@ApiModelProperty(value = "数据库地址")
	private String dbName;
	/**
	 * 数据库用户名
	 */
	@ApiModelProperty(value = "数据库用户名")
	private String dbUserName;
	/**
	 * 数据库密码
	 */
	@ApiModelProperty(value = "数据库密码")
	private String dbPassword;
	/**
	 * 生成的包名
	 */
	@ApiModelProperty(value = "生成的包名")
	private String packageName;
	/**
	 * 生成模式：springboot/springcloud
	 */
	private String genType;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	/**
	 * 删除标识（1正常,0禁用,-1删除）
	 */
	@ApiModelProperty(value = "删除标识（1正常,0禁用,-1删除）")
	private Integer delFlag;
}
