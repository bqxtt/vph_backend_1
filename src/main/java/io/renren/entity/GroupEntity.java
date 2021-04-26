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
@TableName("group")
public class GroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 小组编号
	 */
	@TableId
	private Integer groupId;
	/**
	 * 
	 */
	private Long groupOneid;
	/**
	 * 
	 */
	private String groupOnesno;
	/**
	 * 
	 */
	private String groupOnename;
	/**
	 * 
	 */
	private Long groupTwoid;
	/**
	 * 
	 */
	private String groupTwosno;
	/**
	 * 
	 */
	private String groupTwoname;
	/**
	 * 小组宣言
	 */
	private String groupShow;

}
