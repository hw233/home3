package com.home.commonData.message.game.request.scene.unit;

import com.home.commonData.message.game.request.scene.base.UnitSMO;

/** 单位刷新buff剩余次数消息 */
public class UnitRefreshBuffLastNumMO extends UnitSMO
{
	/** buff实例ID */
	int buffInstanceID;
	/** 剩余次数 */
	int lastNum;
}