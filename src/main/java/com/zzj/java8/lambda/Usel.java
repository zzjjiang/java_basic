package com.zzj.java8.lambda;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/22 17:58
 * @since JDK 1.8
 */
public class Usel {
	private Integer id;
	private String type;
	private String name;
	private String date;
	private Integer isOk;

	public Usel(Integer id, String name, String type, String date, Integer isOk) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.date = date;

		this.isOk = isOk;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getIsOk() {
		return isOk;
	}

	public void setIsOk(Integer isOk) {
		this.isOk = isOk;
	}
}
