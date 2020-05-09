package com.home.commonData.message.game.request.scene.unit;

import com.home.commonData.message.game.request.scene.base.UnitSMO;
import com.home.shineData.support.MessageDontCopy;

import java.util.Map;

/** 刷新单位状态 */
@MessageDontCopy
public class RefreshUnitStatusMO extends UnitSMO
{
	/** 改变的状态组 */
	Map<Integer,Boolean> status;
}
