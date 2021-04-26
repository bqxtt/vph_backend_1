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
@TableName("distribution")
public class DistributionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String acceptCompany;
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
	/**
	 * 
	 */
	@TableId
	private Integer id;

}
