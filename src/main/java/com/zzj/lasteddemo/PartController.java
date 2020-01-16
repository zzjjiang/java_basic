package com.zzj.lasteddemo;


import com.zzj.lasteddemo.pojo.DetailVO;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/5 19:43
 * @since JDK 1.8
 */
public class PartController {

	/**
	 * 1
	 * 聚会首页显示 type 1为进行中  2为已结束
	 */
	public Object page(int type, int curr, int size) {
		//默认显示的是进行中  --- 人数 头像 地点  时间 和名称 已结束聚会数
		//a 根据用户id查询参与者表，获取聚会id集合

		//判断List,该条聚会当前登陆者是否是创始人
		return null;
	}

	/**
	 * 2
	 * 创建聚会前置条件判断
	 */
	public boolean countParty() {
		//判断用户已创建的进行中的聚会是否大于50

		return false;
	}

	/**
	 * 3
	 * 创建聚会
	 */
	public boolean insert(Object object) {
		//并发控制  防止狂点
		// 开始时间是否早于当前系统时间？若早于，则toast提示“开始时间不得早于当前”
		//结束时间是否早于开始时间？若无开始时间，toast提示“请先选择开始时间”；若早于开始时间，toast提示“结束时间不得早于开始时间”
		//若已选择时间正常，提交时间并在时间选择按钮上显示已选择时间，关闭时间选择器

		//新增聚会表记录
		//新增地点信息
		//新增时间信息

		//新增一条参与者信息(创建者)
		//新增一条参与者备注
		return false;
	}

	/**
	 * 4
	 * 聚会结束   时间到了的  用定时器刷
	 */
	public boolean stopParty(String partId) {
		//聚会主表状态为结束1

		return false;
	}


//--------------------------------------------------

	/**
	 * 5
	 * 编辑聚会 id 为party表主键
	 */
	public boolean update(String partId) {
		//更新聚会表信息
		//更新时间  会有推送
		//更新地点会有推送
		return false;
	}

//-------------------------------------------------------

	/**
	 * 6
	 * 详情
	 */
	public DetailVO detail(Object object) {

		//权限判断
		//时间 地点变更都会出现在此处

		return null;
	}

	/**
	 * 7
	 * 二维码
	 */
	public Object qrcode() {
		return null;
	}

}
