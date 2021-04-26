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
 * @date 2021-04-21 14:21:26
 */
@Data
@TableName("cases")
public class CasesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String category;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String depict;
	/**
	 * 
	 */
	private String picture;
	/**
	 * 
	 */
	private String video;

}
