package com.home.commonData.message.game.request.scene.scene;

import com.home.commonData.message.game.request.scene.base.SceneSMO;

/** 推送副本类场景状态信息 */
public class SendBattleStateMO extends SceneSMO
{
	/** 副本当前状态 */
	int state;
	/** 剩余tick时间(-1就是没在tick) */
	int timeTick;
}
