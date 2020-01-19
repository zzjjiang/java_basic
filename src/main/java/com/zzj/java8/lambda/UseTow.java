package com.zzj.java8.lambda;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/12/24 14:20
 * @since JDK 1.8
 */
public class UseTow {

	private Integer id;
	private Integer tagId;
	private Integer posterId;

	public UseTow(Integer id, Integer tagId, Integer posterId) {
		this.id = id;
		this.tagId = tagId;
		this.posterId = posterId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Integer getPosterId() {
		return posterId;
	}

	public void setPosterId(Integer posterId) {
		this.posterId = posterId;
	}
}
