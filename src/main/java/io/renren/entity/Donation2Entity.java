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
 * @date 2020-06-12 20:10:29
 */
@Data
@TableName("donation2")
public class Donation2Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String donater;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String size;
	/**
	 * 
	 */
	private String unit;
	/**
	 * 
	 */
	private String amount;

}
