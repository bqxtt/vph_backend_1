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
 * @date 2020-12-18 23:09:27
 */
@Data
@TableName("flight")
public class FlightEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Double businessPrice;
	/**
	 * 
	 */
	private Integer businessSeats;
	/**
	 * 
	 */
	private String destination;
	/**
	 * 
	 */
	private Double economyPrice;
	/**
	 * 
	 */
	private Integer economySeats;
	/**
	 * 
	 */
	private String endTime;
	/**
	 * 
	 */
	private Double firstPrice;
	/**
	 * 
	 */
	private Integer firstSeats;
	/**
	 * 
	 */
	private Integer planeId;
	/**
	 * 
	 */
	private String source;
	/**
	 * 
	 */
	private String startTime;
	/**
	 * 
	 */
	private Integer status;

}
