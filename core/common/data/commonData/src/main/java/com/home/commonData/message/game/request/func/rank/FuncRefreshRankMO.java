package com.home.commonData.message.game.request.func.rank;

import com.home.commonData.message.game.request.func.base.FuncSMO;

public class FuncRefreshRankMO extends FuncSMO
{
	/** 排行(-1为移除排行) */
	int rank;
	/** 排行值 */
	long value;
}
