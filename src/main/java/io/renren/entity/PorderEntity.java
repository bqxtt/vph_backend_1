package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-18 23:09:27
 */
@Data
@TableName("porder")
public class PorderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer accountId;
	/**
	 * 
	 */
	private Integer flightId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String personId;
	/**
	 * 
	 */
	private Double price;
	/**
	 * 
	 */
	private Integer seatType;
	/**
	 * 
	 */
	private Integer status;

}
