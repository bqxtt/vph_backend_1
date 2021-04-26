package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-20 22:37:10
 */
@Data
@TableName("projectinfo")
public class ProjectinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 项目编号
	 */
	@TableId
	private Integer projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目类型
	 */
	private String projectType;
	/**
	 * 项目附件
	 */
	private String projectUrl;
	/**
	 * 项目小组
	 */
	private Integer projectGroupid;
	/**
	 * 指导老师
	 */
	private Integer projectTutorid;
	/**
	 * 评审老师
	 */
	private Integer projectJudgeid;
	/**
	 * 项目状态
	 */
	private Integer projectStmt;
	/**
	 * 指导建议
	 */
	private String projectSuggest;
	/**
	 * 项目成绩
	 */
	private Integer projectScore;
	/**
	 * 最终评价
	 */
	private String projectEva;

}
