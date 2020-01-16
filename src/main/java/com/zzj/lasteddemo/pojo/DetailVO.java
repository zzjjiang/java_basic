package com.zzj.lasteddemo.pojo;

import java.util.List;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/6 12:10
 * @since JDK 1.8
 */
public class DetailVO {

	private Integer partId;
	private String partName;
	private String address;
	private Integer count;
	private String latitude;
	private String longitude;
	private String startTime;
	private String endTime;
	private List<String> headUrls;
	/**
	 * 1 代表聚会创建人  2代表聚会成员  3围观者
	 */
	private Integer role;
}
