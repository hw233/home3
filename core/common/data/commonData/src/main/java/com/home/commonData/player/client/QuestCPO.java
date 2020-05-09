package com.home.commonData.player.client;

import com.home.commonData.data.quest.QuestCompleteDO;
import com.home.commonData.data.quest.QuestDO;
import com.home.shineData.support.MapKeyInValue;

import java.util.Map;
import java.util.Set;

/** 任务数据 */
public class QuestCPO
{
	/** 客户端目标实例ID序号 */
	int clientTaskInstanceIDIndex;
	/** 已接任务组 */
	@MapKeyInValue("id")
	Map<Integer,QuestDO> accepts;
	/** 完成任务线组(key:lineID,value:questID) */
	Map<Integer,Integer> completeLines;
	/** 完成任务id组 */
	Set<Integer> completeIDs;
	/** 完成任务组(周期组) */
	@MapKeyInValue("id")
	Map<Integer,QuestCompleteDO> completeQuestsDic;
}
