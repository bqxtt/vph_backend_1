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
 * @date 2021-04-21 14:21:26
 */
@Data
@TableName("problems")
public class ProblemsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String rol;
	/**
	 * 
	 */
	private String problem;
	/**
	 * 
	 */
	private String answer;

	/**
	 *
	 */
	private String correct;

}
