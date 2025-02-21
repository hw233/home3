package com.home.commonGame.tool.generate;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.activity.ActivityCompleteOnceRequest;
import com.home.commonGame.net.request.activity.ActivityResetRequest;
import com.home.commonGame.net.request.activity.ActivitySwitchRequest;
import com.home.commonGame.net.request.func.auction.FuncAuctionAddSaleItemRequest;
import com.home.commonGame.net.request.func.auction.FuncAuctionReQueryRequest;
import com.home.commonGame.net.request.func.auction.FuncAuctionRefreshSaleItemRequest;
import com.home.commonGame.net.request.func.auction.FuncAuctionRemoveSaleItemRequest;
import com.home.commonGame.net.request.func.auction.FuncReGetAuctionItemSuggestPriceRequest;
import com.home.commonGame.net.request.func.base.FuncCloseRequest;
import com.home.commonGame.net.request.func.base.FuncOpenRequest;
import com.home.commonGame.net.request.func.base.FuncPlayerRoleGroupSRequest;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.commonGame.net.request.func.item.FuncAddItemRequest;
import com.home.commonGame.net.request.func.item.FuncAddOneItemNumRequest;
import com.home.commonGame.net.request.func.item.FuncAddOneItemRequest;
import com.home.commonGame.net.request.func.item.FuncRefreshItemGridNumRequest;
import com.home.commonGame.net.request.func.item.FuncRemoveItemRequest;
import com.home.commonGame.net.request.func.item.FuncRemoveOneItemRequest;
import com.home.commonGame.net.request.func.item.FuncSendCleanUpItemRequest;
import com.home.commonGame.net.request.func.item.FuncSendMoveEquipRequest;
import com.home.commonGame.net.request.func.item.FuncSendMoveItemRequest;
import com.home.commonGame.net.request.func.item.FuncSendPutOffEquipRequest;
import com.home.commonGame.net.request.func.item.FuncSendPutOnEquipRequest;
import com.home.commonGame.net.request.func.item.FuncUseItemResultRequest;
import com.home.commonGame.net.request.func.match.FuncCancelMatchRequest;
import com.home.commonGame.net.request.func.match.FuncMatchOverRequest;
import com.home.commonGame.net.request.func.match.FuncMatchSuccessRequest;
import com.home.commonGame.net.request.func.match.FuncMatchTimeOutRequest;
import com.home.commonGame.net.request.func.match.FuncReAddMatchRequest;
import com.home.commonGame.net.request.func.match.FuncSendAcceptMatchRequest;
import com.home.commonGame.net.request.func.match.FuncStartMatchRequest;
import com.home.commonGame.net.request.func.rank.FuncReGetPageShowListRequest;
import com.home.commonGame.net.request.func.rank.FuncReGetPageShowRequest;
import com.home.commonGame.net.request.func.rank.FuncReGetSelfPageShowRequest;
import com.home.commonGame.net.request.func.rank.FuncRefreshRankRequest;
import com.home.commonGame.net.request.func.rank.FuncRefreshRoleGroupRankRequest;
import com.home.commonGame.net.request.func.rank.FuncResetRankRequest;
import com.home.commonGame.net.request.func.rank.FuncResetRoleGroupRankRequest;
import com.home.commonGame.net.request.func.rank.subsection.FuncReGetSubsectionPageShowListRequest;
import com.home.commonGame.net.request.func.rank.subsection.FuncRefreshSubsectionIndexRequest;
import com.home.commonGame.net.request.func.rank.subsection.FuncRefreshSubsectionRankRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncReGetRoleGroupDataRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncRefeshTitleRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendAddApplyRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendAddApplyRoleGroupSelfRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendChangeCanInviteInAbsRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendChangeLeaderRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendHandleApplyResultRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendHandleApplyResultToMemberRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendHandleInviteResultRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendInviteRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendPlayerJoinRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendPlayerLeaveRoleGroupRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendRoleGroupAddMemberRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendRoleGroupChangeRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendRoleGroupInfoLogRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendRoleGroupMemberChangeRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendRoleGroupMemberRoleShowChangeRequest;
import com.home.commonGame.net.request.func.roleGroup.FuncSendRoleGroupRemoveMemberRequest;
import com.home.commonGame.net.request.guide.RefreshMainGuideStepRequest;
import com.home.commonGame.net.request.item.AddRewardRequest;
import com.home.commonGame.net.request.login.ClientHotfixRequest;
import com.home.commonGame.net.request.login.CreatePlayerSuccessRequest;
import com.home.commonGame.net.request.login.DeletePlayerSuccessRequest;
import com.home.commonGame.net.request.login.InitClientRequest;
import com.home.commonGame.net.request.login.RePlayerListRequest;
import com.home.commonGame.net.request.login.SendBindPlatformRequest;
import com.home.commonGame.net.request.login.SwitchGameRequest;
import com.home.commonGame.net.request.login.SwitchSceneRequest;
import com.home.commonGame.net.request.mail.AddMailRequest;
import com.home.commonGame.net.request.mail.ReGetAllMailRequest;
import com.home.commonGame.net.request.mail.SendDeleteMailRequest;
import com.home.commonGame.net.request.mail.TakeMailSuccessRequest;
import com.home.commonGame.net.request.quest.RefreshTaskRequest;
import com.home.commonGame.net.request.quest.SendAcceptAchievementRequest;
import com.home.commonGame.net.request.quest.SendAcceptQuestRequest;
import com.home.commonGame.net.request.quest.SendAchievementCompleteRequest;
import com.home.commonGame.net.request.quest.SendClearAllQuestByGMRequest;
import com.home.commonGame.net.request.quest.SendCommitQuestRequest;
import com.home.commonGame.net.request.quest.SendGetAchievementRewardSuccessRequest;
import com.home.commonGame.net.request.quest.SendGiveUpQuestRequest;
import com.home.commonGame.net.request.quest.SendQuestFailedRequest;
import com.home.commonGame.net.request.quest.SendRemoveAcceptQuestRequest;
import com.home.commonGame.net.request.role.ChangeRoleNameRequest;
import com.home.commonGame.net.request.role.LevelUpRequest;
import com.home.commonGame.net.request.role.RefreshCurrencyRequest;
import com.home.commonGame.net.request.role.RefreshExpRequest;
import com.home.commonGame.net.request.role.RefreshFightForceRequest;
import com.home.commonGame.net.request.role.munit.MUnitAddBuffRequest;
import com.home.commonGame.net.request.role.munit.MUnitAddGroupTimeMaxPercentRequest;
import com.home.commonGame.net.request.role.munit.MUnitAddGroupTimeMaxValueRequest;
import com.home.commonGame.net.request.role.munit.MUnitAddGroupTimePassRequest;
import com.home.commonGame.net.request.role.munit.MUnitAddSkillRequest;
import com.home.commonGame.net.request.role.munit.MUnitRefreshAttributesRequest;
import com.home.commonGame.net.request.role.munit.MUnitRefreshAvatarPartRequest;
import com.home.commonGame.net.request.role.munit.MUnitRefreshAvatarRequest;
import com.home.commonGame.net.request.role.munit.MUnitRefreshBuffLastNumRequest;
import com.home.commonGame.net.request.role.munit.MUnitRefreshBuffRequest;
import com.home.commonGame.net.request.role.munit.MUnitRefreshStatusRequest;
import com.home.commonGame.net.request.role.munit.MUnitRemoveBuffRequest;
import com.home.commonGame.net.request.role.munit.MUnitRemoveGroupCDRequest;
import com.home.commonGame.net.request.role.munit.MUnitRemoveSkillRequest;
import com.home.commonGame.net.request.role.munit.MUnitSRequest;
import com.home.commonGame.net.request.role.munit.MUnitStartCDsRequest;
import com.home.commonGame.net.request.role.pet.AddPetRequest;
import com.home.commonGame.net.request.role.pet.RefreshPetIsWorkingRequest;
import com.home.commonGame.net.request.role.pet.RemovePetRequest;
import com.home.commonGame.net.request.scene.EnterNoneSceneRequest;
import com.home.commonGame.net.request.scene.EnterSceneFailedRequest;
import com.home.commonGame.net.request.scene.EnterSceneRequest;
import com.home.commonGame.net.request.scene.LeaveSceneRequest;
import com.home.commonGame.net.request.scene.PreEnterSceneNextRequest;
import com.home.commonGame.net.request.scene.PreEnterSceneRequest;
import com.home.commonGame.net.request.scene.RefreshCurrentLineRequest;
import com.home.commonGame.net.request.social.ReQueryPlayerRequest;
import com.home.commonGame.net.request.social.ReSearchPlayerRequest;
import com.home.commonGame.net.request.social.ReUpdateRoleSocialDataOneRequest;
import com.home.commonGame.net.request.social.ReUpdateRoleSocialDataRequest;
import com.home.commonGame.net.request.social.chat.SendPlayerChatRequest;
import com.home.commonGame.net.request.social.friend.SendAddFriendBlackListRequest;
import com.home.commonGame.net.request.social.friend.SendAddFriendRequest;
import com.home.commonGame.net.request.social.friend.SendApplyAddFriendRequest;
import com.home.commonGame.net.request.social.friend.SendRemoveFriendBlackListRequest;
import com.home.commonGame.net.request.social.friend.SendRemoveFriendRequest;
import com.home.commonGame.net.request.system.CenterTransGameToClientRequest;
import com.home.commonGame.net.request.system.ClientHotfixConfigRequest;
import com.home.commonGame.net.request.system.DailyRequest;
import com.home.commonGame.net.request.system.GameTransGameToClientRequest;
import com.home.commonGame.net.request.system.ReceiveClientOfflineWorkRequest;
import com.home.commonGame.net.request.system.RefreshServerTimeRequest;
import com.home.commonGame.net.request.system.SendGameReceiptToClientRequest;
import com.home.commonGame.net.request.system.SendInfoCodeRequest;
import com.home.commonGame.net.request.system.SendInfoCodeWithArgsRequest;
import com.home.commonGame.net.request.system.SendInfoLogRequest;
import com.home.commonGame.net.request.system.SendWarningLogRequest;
import com.home.shine.data.BaseData;
import com.home.shine.tool.CreateDataFunc;
import com.home.shine.tool.DataMaker;

/** (generated by shine) */
public class GameRequestMaker extends DataMaker
{
	public GameRequestMaker()
	{
		offSet=GameRequestType.off;
		list=new CreateDataFunc[GameRequestType.count-offSet];
		list[GameRequestType.ActivityCompleteOnce-offSet]=this::createActivityCompleteOnceRequest;
		list[GameRequestType.ActivityReset-offSet]=this::createActivityResetRequest;
		list[GameRequestType.ActivitySwitch-offSet]=this::createActivitySwitchRequest;
		list[GameRequestType.AddMail-offSet]=this::createAddMailRequest;
		list[GameRequestType.AddPet-offSet]=this::createAddPetRequest;
		list[GameRequestType.AddReward-offSet]=this::createAddRewardRequest;
		list[GameRequestType.CenterTransGameToClient-offSet]=this::createCenterTransGameToClientRequest;
		list[GameRequestType.ChangeRoleName-offSet]=this::createChangeRoleNameRequest;
		list[GameRequestType.ClientHotfixConfig-offSet]=this::createClientHotfixConfigRequest;
		list[GameRequestType.ClientHotfix-offSet]=this::createClientHotfixRequest;
		list[GameRequestType.CreatePlayerSuccess-offSet]=this::createCreatePlayerSuccessRequest;
		list[GameRequestType.Daily-offSet]=this::createDailyRequest;
		list[GameRequestType.DeletePlayerSuccess-offSet]=this::createDeletePlayerSuccessRequest;
		list[GameRequestType.EnterNoneScene-offSet]=this::createEnterNoneSceneRequest;
		list[GameRequestType.EnterSceneFailed-offSet]=this::createEnterSceneFailedRequest;
		list[GameRequestType.EnterScene-offSet]=this::createEnterSceneRequest;
		list[GameRequestType.FuncAddItem-offSet]=this::createFuncAddItemRequest;
		list[GameRequestType.FuncAddOneItem-offSet]=this::createFuncAddOneItemRequest;
		list[GameRequestType.FuncAddOneItemNum-offSet]=this::createFuncAddOneItemNumRequest;
		list[GameRequestType.FuncAuctionAddSaleItem-offSet]=this::createFuncAuctionAddSaleItemRequest;
		list[GameRequestType.FuncAuctionReQuery-offSet]=this::createFuncAuctionReQueryRequest;
		list[GameRequestType.FuncAuctionRefreshSaleItem-offSet]=this::createFuncAuctionRefreshSaleItemRequest;
		list[GameRequestType.FuncAuctionRemoveSaleItem-offSet]=this::createFuncAuctionRemoveSaleItemRequest;
		list[GameRequestType.FuncCancelMatch-offSet]=this::createFuncCancelMatchRequest;
		list[GameRequestType.FuncClose-offSet]=this::createFuncCloseRequest;
		list[GameRequestType.FuncMatchOver-offSet]=this::createFuncMatchOverRequest;
		list[GameRequestType.FuncMatchSuccess-offSet]=this::createFuncMatchSuccessRequest;
		list[GameRequestType.FuncMatchTimeOut-offSet]=this::createFuncMatchTimeOutRequest;
		list[GameRequestType.FuncOpen-offSet]=this::createFuncOpenRequest;
		list[GameRequestType.FuncPlayerRoleGroupS-offSet]=this::createFuncPlayerRoleGroupSRequest;
		list[GameRequestType.FuncReAddMatch-offSet]=this::createFuncReAddMatchRequest;
		list[GameRequestType.FuncReGetAuctionItemSuggestPrice-offSet]=this::createFuncReGetAuctionItemSuggestPriceRequest;
		list[GameRequestType.FuncReGetPageShowList-offSet]=this::createFuncReGetPageShowListRequest;
		list[GameRequestType.FuncReGetPageShow-offSet]=this::createFuncReGetPageShowRequest;
		list[GameRequestType.FuncReGetRoleGroupData-offSet]=this::createFuncReGetRoleGroupDataRequest;
		list[GameRequestType.FuncReGetSelfPageShow-offSet]=this::createFuncReGetSelfPageShowRequest;
		list[GameRequestType.FuncReGetSubsectionPageShowList-offSet]=this::createFuncReGetSubsectionPageShowListRequest;
		list[GameRequestType.FuncRefeshTitleRoleGroup-offSet]=this::createFuncRefeshTitleRoleGroupRequest;
		list[GameRequestType.FuncRefreshItemGridNum-offSet]=this::createFuncRefreshItemGridNumRequest;
		list[GameRequestType.FuncRefreshRank-offSet]=this::createFuncRefreshRankRequest;
		list[GameRequestType.FuncRefreshRoleGroupRank-offSet]=this::createFuncRefreshRoleGroupRankRequest;
		list[GameRequestType.FuncRefreshSubsectionRank-offSet]=this::createFuncRefreshSubsectionRankRequest;
		list[GameRequestType.FuncRemoveItem-offSet]=this::createFuncRemoveItemRequest;
		list[GameRequestType.FuncRemoveOneItem-offSet]=this::createFuncRemoveOneItemRequest;
		list[GameRequestType.FuncResetRank-offSet]=this::createFuncResetRankRequest;
		list[GameRequestType.FuncResetRoleGroupRank-offSet]=this::createFuncResetRoleGroupRankRequest;
		list[GameRequestType.FuncS-offSet]=this::createFuncSRequest;
		list[GameRequestType.FuncSendAcceptMatch-offSet]=this::createFuncSendAcceptMatchRequest;
		list[GameRequestType.FuncSendAddApplyRoleGroup-offSet]=this::createFuncSendAddApplyRoleGroupRequest;
		list[GameRequestType.FuncSendAddApplyRoleGroupSelf-offSet]=this::createFuncSendAddApplyRoleGroupSelfRequest;
		list[GameRequestType.FuncSendChangeCanInviteInAbsRoleGroup-offSet]=this::createFuncSendChangeCanInviteInAbsRoleGroupRequest;
		list[GameRequestType.FuncSendChangeLeaderRoleGroup-offSet]=this::createFuncSendChangeLeaderRoleGroupRequest;
		list[GameRequestType.FuncSendCleanUpItem-offSet]=this::createFuncSendCleanUpItemRequest;
		list[GameRequestType.FuncSendHandleApplyResultRoleGroup-offSet]=this::createFuncSendHandleApplyResultRoleGroupRequest;
		list[GameRequestType.FuncSendHandleApplyResultToMember-offSet]=this::createFuncSendHandleApplyResultToMemberRequest;
		list[GameRequestType.FuncSendHandleInviteResultRoleGroup-offSet]=this::createFuncSendHandleInviteResultRoleGroupRequest;
		list[GameRequestType.FuncSendInviteRoleGroup-offSet]=this::createFuncSendInviteRoleGroupRequest;
		list[GameRequestType.FuncSendMoveEquip-offSet]=this::createFuncSendMoveEquipRequest;
		list[GameRequestType.FuncSendMoveItem-offSet]=this::createFuncSendMoveItemRequest;
		list[GameRequestType.FuncSendPlayerJoinRoleGroup-offSet]=this::createFuncSendPlayerJoinRoleGroupRequest;
		list[GameRequestType.FuncSendPlayerLeaveRoleGroup-offSet]=this::createFuncSendPlayerLeaveRoleGroupRequest;
		list[GameRequestType.FuncSendPutOffEquip-offSet]=this::createFuncSendPutOffEquipRequest;
		list[GameRequestType.FuncSendPutOnEquip-offSet]=this::createFuncSendPutOnEquipRequest;
		list[GameRequestType.FuncSendRoleGroupAddMember-offSet]=this::createFuncSendRoleGroupAddMemberRequest;
		list[GameRequestType.FuncSendRoleGroupChange-offSet]=this::createFuncSendRoleGroupChangeRequest;
		list[GameRequestType.FuncSendRoleGroupInfoLog-offSet]=this::createFuncSendRoleGroupInfoLogRequest;
		list[GameRequestType.FuncSendRoleGroupMemberChange-offSet]=this::createFuncSendRoleGroupMemberChangeRequest;
		list[GameRequestType.FuncSendRoleGroupMemberRoleShowChange-offSet]=this::createFuncSendRoleGroupMemberRoleShowChangeRequest;
		list[GameRequestType.FuncSendRoleGroupRemoveMember-offSet]=this::createFuncSendRoleGroupRemoveMemberRequest;
		list[GameRequestType.FuncStartMatch-offSet]=this::createFuncStartMatchRequest;
		list[GameRequestType.FuncUseItemResult-offSet]=this::createFuncUseItemResultRequest;
		list[GameRequestType.GameTransGameToClient-offSet]=this::createGameTransGameToClientRequest;
		list[GameRequestType.InitClient-offSet]=this::createInitClientRequest;
		list[GameRequestType.LeaveScene-offSet]=this::createLeaveSceneRequest;
		list[GameRequestType.LevelUp-offSet]=this::createLevelUpRequest;
		list[GameRequestType.MUnitAddBuff-offSet]=this::createMUnitAddBuffRequest;
		list[GameRequestType.MUnitAddGroupTimeMaxPercent-offSet]=this::createMUnitAddGroupTimeMaxPercentRequest;
		list[GameRequestType.MUnitAddGroupTimeMaxValue-offSet]=this::createMUnitAddGroupTimeMaxValueRequest;
		list[GameRequestType.MUnitAddGroupTimePass-offSet]=this::createMUnitAddGroupTimePassRequest;
		list[GameRequestType.MUnitAddSkill-offSet]=this::createMUnitAddSkillRequest;
		list[GameRequestType.MUnitRefreshAttributes-offSet]=this::createMUnitRefreshAttributesRequest;
		list[GameRequestType.MUnitRefreshAvatar-offSet]=this::createMUnitRefreshAvatarRequest;
		list[GameRequestType.MUnitRefreshAvatarPart-offSet]=this::createMUnitRefreshAvatarPartRequest;
		list[GameRequestType.MUnitRefreshBuffLastNum-offSet]=this::createMUnitRefreshBuffLastNumRequest;
		list[GameRequestType.MUnitRefreshBuff-offSet]=this::createMUnitRefreshBuffRequest;
		list[GameRequestType.MUnitRefreshStatus-offSet]=this::createMUnitRefreshStatusRequest;
		list[GameRequestType.MUnitRemoveBuff-offSet]=this::createMUnitRemoveBuffRequest;
		list[GameRequestType.MUnitRemoveGroupCD-offSet]=this::createMUnitRemoveGroupCDRequest;
		list[GameRequestType.MUnitRemoveSkill-offSet]=this::createMUnitRemoveSkillRequest;
		list[GameRequestType.MUnitS-offSet]=this::createMUnitSRequest;
		list[GameRequestType.MUnitStartCDs-offSet]=this::createMUnitStartCDsRequest;
		list[GameRequestType.PreEnterScene-offSet]=this::createPreEnterSceneRequest;
		list[GameRequestType.PreEnterSceneNext-offSet]=this::createPreEnterSceneNextRequest;
		list[GameRequestType.ReGetAllMail-offSet]=this::createReGetAllMailRequest;
		list[GameRequestType.RePlayerList-offSet]=this::createRePlayerListRequest;
		list[GameRequestType.ReQueryPlayer-offSet]=this::createReQueryPlayerRequest;
		list[GameRequestType.ReSearchPlayer-offSet]=this::createReSearchPlayerRequest;
		list[GameRequestType.ReUpdateRoleSocialData-offSet]=this::createReUpdateRoleSocialDataRequest;
		list[GameRequestType.ReUpdateRoleSocialDataOne-offSet]=this::createReUpdateRoleSocialDataOneRequest;
		list[GameRequestType.ReceiveClientOfflineWork-offSet]=this::createReceiveClientOfflineWorkRequest;
		list[GameRequestType.RefreshCurrency-offSet]=this::createRefreshCurrencyRequest;
		list[GameRequestType.RefreshCurrentLine-offSet]=this::createRefreshCurrentLineRequest;
		list[GameRequestType.RefreshExp-offSet]=this::createRefreshExpRequest;
		list[GameRequestType.RefreshFightForce-offSet]=this::createRefreshFightForceRequest;
		list[GameRequestType.RefreshMainGuideStep-offSet]=this::createRefreshMainGuideStepRequest;
		list[GameRequestType.RefreshPetIsWorking-offSet]=this::createRefreshPetIsWorkingRequest;
		list[GameRequestType.RefreshServerTime-offSet]=this::createRefreshServerTimeRequest;
		list[GameRequestType.RefreshTask-offSet]=this::createRefreshTaskRequest;
		list[GameRequestType.RemovePet-offSet]=this::createRemovePetRequest;
		list[GameRequestType.SendAcceptAchievement-offSet]=this::createSendAcceptAchievementRequest;
		list[GameRequestType.SendAcceptQuest-offSet]=this::createSendAcceptQuestRequest;
		list[GameRequestType.SendAchievementComplete-offSet]=this::createSendAchievementCompleteRequest;
		list[GameRequestType.SendAddFriendBlackList-offSet]=this::createSendAddFriendBlackListRequest;
		list[GameRequestType.SendAddFriend-offSet]=this::createSendAddFriendRequest;
		list[GameRequestType.SendApplyAddFriend-offSet]=this::createSendApplyAddFriendRequest;
		list[GameRequestType.SendBindPlatform-offSet]=this::createSendBindPlatformRequest;
		list[GameRequestType.SendClearAllQuestByGM-offSet]=this::createSendClearAllQuestByGMRequest;
		list[GameRequestType.SendCommitQuest-offSet]=this::createSendCommitQuestRequest;
		list[GameRequestType.SendDeleteMail-offSet]=this::createSendDeleteMailRequest;
		list[GameRequestType.SendGameReceiptToClient-offSet]=this::createSendGameReceiptToClientRequest;
		list[GameRequestType.SendGetAchievementRewardSuccess-offSet]=this::createSendGetAchievementRewardSuccessRequest;
		list[GameRequestType.SendGiveUpQuest-offSet]=this::createSendGiveUpQuestRequest;
		list[GameRequestType.SendInfoCode-offSet]=this::createSendInfoCodeRequest;
		list[GameRequestType.SendInfoCodeWithArgs-offSet]=this::createSendInfoCodeWithArgsRequest;
		list[GameRequestType.SendInfoLog-offSet]=this::createSendInfoLogRequest;
		list[GameRequestType.SendPlayerChat-offSet]=this::createSendPlayerChatRequest;
		list[GameRequestType.SendQuestFailed-offSet]=this::createSendQuestFailedRequest;
		list[GameRequestType.SendRemoveAcceptQuest-offSet]=this::createSendRemoveAcceptQuestRequest;
		list[GameRequestType.SendRemoveFriendBlackList-offSet]=this::createSendRemoveFriendBlackListRequest;
		list[GameRequestType.SendRemoveFriend-offSet]=this::createSendRemoveFriendRequest;
		list[GameRequestType.SendWarningLog-offSet]=this::createSendWarningLogRequest;
		list[GameRequestType.SwitchGame-offSet]=this::createSwitchGameRequest;
		list[GameRequestType.SwitchScene-offSet]=this::createSwitchSceneRequest;
		list[GameRequestType.TakeMailSuccess-offSet]=this::createTakeMailSuccessRequest;
		list[GameRequestType.FuncRefreshSubsectionIndex-offSet]=this::createFuncRefreshSubsectionIndexRequest;
	}
	
	private BaseData createActivityCompleteOnceRequest()
	{
		return new ActivityCompleteOnceRequest();
	}
	
	private BaseData createActivityResetRequest()
	{
		return new ActivityResetRequest();
	}
	
	private BaseData createActivitySwitchRequest()
	{
		return new ActivitySwitchRequest();
	}
	
	private BaseData createAddMailRequest()
	{
		return new AddMailRequest();
	}
	
	private BaseData createAddRewardRequest()
	{
		return new AddRewardRequest();
	}
	
	private BaseData createCenterTransGameToClientRequest()
	{
		return new CenterTransGameToClientRequest();
	}
	
	private BaseData createChangeRoleNameRequest()
	{
		return new ChangeRoleNameRequest();
	}
	
	private BaseData createClientHotfixRequest()
	{
		return new ClientHotfixRequest();
	}
	
	private BaseData createCreatePlayerSuccessRequest()
	{
		return new CreatePlayerSuccessRequest();
	}
	
	private BaseData createDailyRequest()
	{
		return new DailyRequest();
	}
	
	private BaseData createDeletePlayerSuccessRequest()
	{
		return new DeletePlayerSuccessRequest();
	}
	
	private BaseData createEnterNoneSceneRequest()
	{
		return new EnterNoneSceneRequest();
	}
	
	private BaseData createEnterSceneFailedRequest()
	{
		return new EnterSceneFailedRequest();
	}
	
	private BaseData createEnterSceneRequest()
	{
		return new EnterSceneRequest();
	}
	
	private BaseData createFuncAuctionRefreshSaleItemRequest()
	{
		return new FuncAuctionRefreshSaleItemRequest();
	}
	
	private BaseData createFuncAddItemRequest()
	{
		return new FuncAddItemRequest();
	}
	
	private BaseData createFuncAddOneItemRequest()
	{
		return new FuncAddOneItemRequest();
	}
	
	private BaseData createFuncAddOneItemNumRequest()
	{
		return new FuncAddOneItemNumRequest();
	}
	
	private BaseData createFuncCancelMatchRequest()
	{
		return new FuncCancelMatchRequest();
	}
	
	private BaseData createFuncMatchOverRequest()
	{
		return new FuncMatchOverRequest();
	}
	
	private BaseData createFuncMatchSuccessRequest()
	{
		return new FuncMatchSuccessRequest();
	}
	
	private BaseData createFuncMatchTimeOutRequest()
	{
		return new FuncMatchTimeOutRequest();
	}
	
	private BaseData createFuncReAddMatchRequest()
	{
		return new FuncReAddMatchRequest();
	}
	
	private BaseData createFuncReGetPageShowRequest()
	{
		return new FuncReGetPageShowRequest();
	}
	
	private BaseData createFuncReGetSelfPageShowRequest()
	{
		return new FuncReGetSelfPageShowRequest();
	}
	
	private BaseData createFuncRefreshRankRequest()
	{
		return new FuncRefreshRankRequest();
	}
	
	private BaseData createFuncRemoveItemRequest()
	{
		return new FuncRemoveItemRequest();
	}
	
	private BaseData createFuncRemoveOneItemRequest()
	{
		return new FuncRemoveOneItemRequest();
	}
	
	private BaseData createFuncResetRankRequest()
	{
		return new FuncResetRankRequest();
	}
	
	private BaseData createFuncSRequest()
	{
		return new FuncSRequest();
	}
	
	private BaseData createFuncSendAcceptMatchRequest()
	{
		return new FuncSendAcceptMatchRequest();
	}
	
	private BaseData createFuncSendCleanUpItemRequest()
	{
		return new FuncSendCleanUpItemRequest();
	}
	
	private BaseData createFuncSendMoveEquipRequest()
	{
		return new FuncSendMoveEquipRequest();
	}
	
	private BaseData createFuncSendPutOffEquipRequest()
	{
		return new FuncSendPutOffEquipRequest();
	}
	
	private BaseData createFuncSendPutOnEquipRequest()
	{
		return new FuncSendPutOnEquipRequest();
	}
	
	private BaseData createFuncStartMatchRequest()
	{
		return new FuncStartMatchRequest();
	}
	
	private BaseData createFuncUseItemResultRequest()
	{
		return new FuncUseItemResultRequest();
	}
	
	private BaseData createInitClientRequest()
	{
		return new InitClientRequest();
	}
	
	private BaseData createLeaveSceneRequest()
	{
		return new LeaveSceneRequest();
	}
	
	private BaseData createLevelUpRequest()
	{
		return new LevelUpRequest();
	}
	
	private BaseData createMUnitAddBuffRequest()
	{
		return new MUnitAddBuffRequest();
	}
	
	private BaseData createMUnitAddGroupTimeMaxPercentRequest()
	{
		return new MUnitAddGroupTimeMaxPercentRequest();
	}
	
	private BaseData createMUnitAddGroupTimeMaxValueRequest()
	{
		return new MUnitAddGroupTimeMaxValueRequest();
	}
	
	private BaseData createMUnitAddGroupTimePassRequest()
	{
		return new MUnitAddGroupTimePassRequest();
	}
	
	private BaseData createMUnitAddSkillRequest()
	{
		return new MUnitAddSkillRequest();
	}
	
	private BaseData createMUnitRefreshAttributesRequest()
	{
		return new MUnitRefreshAttributesRequest();
	}
	
	private BaseData createMUnitRefreshAvatarRequest()
	{
		return new MUnitRefreshAvatarRequest();
	}
	
	private BaseData createMUnitRefreshAvatarPartRequest()
	{
		return new MUnitRefreshAvatarPartRequest();
	}
	
	private BaseData createMUnitRefreshBuffLastNumRequest()
	{
		return new MUnitRefreshBuffLastNumRequest();
	}
	
	private BaseData createMUnitRefreshBuffRequest()
	{
		return new MUnitRefreshBuffRequest();
	}
	
	private BaseData createMUnitRefreshStatusRequest()
	{
		return new MUnitRefreshStatusRequest();
	}
	
	private BaseData createMUnitRemoveBuffRequest()
	{
		return new MUnitRemoveBuffRequest();
	}
	
	private BaseData createMUnitRemoveGroupCDRequest()
	{
		return new MUnitRemoveGroupCDRequest();
	}
	
	private BaseData createMUnitRemoveSkillRequest()
	{
		return new MUnitRemoveSkillRequest();
	}
	
	private BaseData createMUnitStartCDsRequest()
	{
		return new MUnitStartCDsRequest();
	}
	
	private BaseData createPreEnterSceneRequest()
	{
		return new PreEnterSceneRequest();
	}
	
	private BaseData createPreEnterSceneNextRequest()
	{
		return new PreEnterSceneNextRequest();
	}
	
	private BaseData createReGetAllMailRequest()
	{
		return new ReGetAllMailRequest();
	}
	
	private BaseData createRePlayerListRequest()
	{
		return new RePlayerListRequest();
	}
	
	private BaseData createReQueryPlayerRequest()
	{
		return new ReQueryPlayerRequest();
	}
	
	private BaseData createReSearchPlayerRequest()
	{
		return new ReSearchPlayerRequest();
	}
	
	private BaseData createReUpdateRoleSocialDataRequest()
	{
		return new ReUpdateRoleSocialDataRequest();
	}
	
	private BaseData createReUpdateRoleSocialDataOneRequest()
	{
		return new ReUpdateRoleSocialDataOneRequest();
	}
	
	private BaseData createReceiveClientOfflineWorkRequest()
	{
		return new ReceiveClientOfflineWorkRequest();
	}
	
	private BaseData createRefreshCurrencyRequest()
	{
		return new RefreshCurrencyRequest();
	}
	
	private BaseData createRefreshCurrentLineRequest()
	{
		return new RefreshCurrentLineRequest();
	}
	
	private BaseData createRefreshExpRequest()
	{
		return new RefreshExpRequest();
	}
	
	private BaseData createRefreshFightForceRequest()
	{
		return new RefreshFightForceRequest();
	}
	
	private BaseData createRefreshMainGuideStepRequest()
	{
		return new RefreshMainGuideStepRequest();
	}
	
	private BaseData createRefreshServerTimeRequest()
	{
		return new RefreshServerTimeRequest();
	}
	
	private BaseData createRefreshTaskRequest()
	{
		return new RefreshTaskRequest();
	}
	
	private BaseData createSendAcceptAchievementRequest()
	{
		return new SendAcceptAchievementRequest();
	}
	
	private BaseData createSendAcceptQuestRequest()
	{
		return new SendAcceptQuestRequest();
	}
	
	private BaseData createSendAchievementCompleteRequest()
	{
		return new SendAchievementCompleteRequest();
	}
	
	private BaseData createSendAddFriendBlackListRequest()
	{
		return new SendAddFriendBlackListRequest();
	}
	
	private BaseData createSendAddFriendRequest()
	{
		return new SendAddFriendRequest();
	}
	
	private BaseData createSendApplyAddFriendRequest()
	{
		return new SendApplyAddFriendRequest();
	}
	
	private BaseData createSendBindPlatformRequest()
	{
		return new SendBindPlatformRequest();
	}
	
	private BaseData createSendClearAllQuestByGMRequest()
	{
		return new SendClearAllQuestByGMRequest();
	}
	
	private BaseData createSendCommitQuestRequest()
	{
		return new SendCommitQuestRequest();
	}
	
	private BaseData createSendDeleteMailRequest()
	{
		return new SendDeleteMailRequest();
	}
	
	private BaseData createSendGameReceiptToClientRequest()
	{
		return new SendGameReceiptToClientRequest();
	}
	
	private BaseData createSendGetAchievementRewardSuccessRequest()
	{
		return new SendGetAchievementRewardSuccessRequest();
	}
	
	private BaseData createSendGiveUpQuestRequest()
	{
		return new SendGiveUpQuestRequest();
	}
	
	private BaseData createSendInfoCodeRequest()
	{
		return new SendInfoCodeRequest();
	}
	
	private BaseData createSendInfoCodeWithArgsRequest()
	{
		return new SendInfoCodeWithArgsRequest();
	}
	
	private BaseData createSendQuestFailedRequest()
	{
		return new SendQuestFailedRequest();
	}
	
	private BaseData createSendRemoveAcceptQuestRequest()
	{
		return new SendRemoveAcceptQuestRequest();
	}
	
	private BaseData createSendRemoveFriendBlackListRequest()
	{
		return new SendRemoveFriendBlackListRequest();
	}
	
	private BaseData createSendRemoveFriendRequest()
	{
		return new SendRemoveFriendRequest();
	}
	
	private BaseData createSwitchGameRequest()
	{
		return new SwitchGameRequest();
	}
	
	private BaseData createTakeMailSuccessRequest()
	{
		return new TakeMailSuccessRequest();
	}
	
	private BaseData createFuncSendPlayerJoinRoleGroupRequest()
	{
		return new FuncSendPlayerJoinRoleGroupRequest();
	}
	
	private BaseData createFuncSendPlayerLeaveRoleGroupRequest()
	{
		return new FuncSendPlayerLeaveRoleGroupRequest();
	}
	
	private BaseData createFuncSendRoleGroupAddMemberRequest()
	{
		return new FuncSendRoleGroupAddMemberRequest();
	}
	
	private BaseData createFuncSendRoleGroupRemoveMemberRequest()
	{
		return new FuncSendRoleGroupRemoveMemberRequest();
	}
	
	private BaseData createFuncPlayerRoleGroupSRequest()
	{
		return new FuncPlayerRoleGroupSRequest();
	}
	
	private BaseData createFuncSendAddApplyRoleGroupRequest()
	{
		return new FuncSendAddApplyRoleGroupRequest();
	}
	
	private BaseData createFuncSendHandleApplyResultRoleGroupRequest()
	{
		return new FuncSendHandleApplyResultRoleGroupRequest();
	}
	
	private BaseData createFuncSendHandleInviteResultRoleGroupRequest()
	{
		return new FuncSendHandleInviteResultRoleGroupRequest();
	}
	
	private BaseData createFuncSendInviteRoleGroupRequest()
	{
		return new FuncSendInviteRoleGroupRequest();
	}
	
	private BaseData createFuncReGetPageShowListRequest()
	{
		return new FuncReGetPageShowListRequest();
	}
	
	private BaseData createFuncRefeshTitleRoleGroupRequest()
	{
		return new FuncRefeshTitleRoleGroupRequest();
	}
	
	private BaseData createFuncSendChangeLeaderRoleGroupRequest()
	{
		return new FuncSendChangeLeaderRoleGroupRequest();
	}
	
	private BaseData createFuncRefreshSubsectionRankRequest()
	{
		return new FuncRefreshSubsectionRankRequest();
	}
	
	private BaseData createGameTransGameToClientRequest()
	{
		return new GameTransGameToClientRequest();
	}
	
	private BaseData createFuncSendHandleApplyResultToMemberRequest()
	{
		return new FuncSendHandleApplyResultToMemberRequest();
	}
	
	private BaseData createFuncSendAddApplyRoleGroupSelfRequest()
	{
		return new FuncSendAddApplyRoleGroupSelfRequest();
	}
	
	private BaseData createFuncSendRoleGroupChangeRequest()
	{
		return new FuncSendRoleGroupChangeRequest();
	}
	
	private BaseData createSendInfoLogRequest()
	{
		return new SendInfoLogRequest();
	}
	
	private BaseData createFuncReGetSubsectionPageShowListRequest()
	{
		return new FuncReGetSubsectionPageShowListRequest();
	}
	
	private BaseData createFuncSendChangeCanInviteInAbsRoleGroupRequest()
	{
		return new FuncSendChangeCanInviteInAbsRoleGroupRequest();
	}
	
	private BaseData createClientHotfixConfigRequest()
	{
		return new ClientHotfixConfigRequest();
	}
	
	private BaseData createFuncSendRoleGroupInfoLogRequest()
	{
		return new FuncSendRoleGroupInfoLogRequest();
	}
	
	private BaseData createFuncSendRoleGroupMemberChangeRequest()
	{
		return new FuncSendRoleGroupMemberChangeRequest();
	}
	
	private BaseData createFuncReGetRoleGroupDataRequest()
	{
		return new FuncReGetRoleGroupDataRequest();
	}
	
	private BaseData createSendPlayerChatRequest()
	{
		return new SendPlayerChatRequest();
	}
	
	private BaseData createAddPetRequest()
	{
		return new AddPetRequest();
	}
	
	private BaseData createFuncSendRoleGroupMemberRoleShowChangeRequest()
	{
		return new FuncSendRoleGroupMemberRoleShowChangeRequest();
	}
	
	private BaseData createFuncSendMoveItemRequest()
	{
		return new FuncSendMoveItemRequest();
	}
	
	private BaseData createFuncRefreshItemGridNumRequest()
	{
		return new FuncRefreshItemGridNumRequest();
	}
	
	private BaseData createFuncRefreshRoleGroupRankRequest()
	{
		return new FuncRefreshRoleGroupRankRequest();
	}
	
	private BaseData createFuncResetRoleGroupRankRequest()
	{
		return new FuncResetRoleGroupRankRequest();
	}
	
	private BaseData createSendWarningLogRequest()
	{
		return new SendWarningLogRequest();
	}
	
	private BaseData createFuncCloseRequest()
	{
		return new FuncCloseRequest();
	}
	
	private BaseData createFuncOpenRequest()
	{
		return new FuncOpenRequest();
	}
	
	private BaseData createFuncAuctionAddSaleItemRequest()
	{
		return new FuncAuctionAddSaleItemRequest();
	}
	
	private BaseData createFuncAuctionReQueryRequest()
	{
		return new FuncAuctionReQueryRequest();
	}
	
	private BaseData createMUnitSRequest()
	{
		return new MUnitSRequest();
	}
	
	private BaseData createRefreshPetIsWorkingRequest()
	{
		return new RefreshPetIsWorkingRequest();
	}
	
	private BaseData createFuncReGetAuctionItemSuggestPriceRequest()
	{
		return new FuncReGetAuctionItemSuggestPriceRequest();
	}
	
	private BaseData createRemovePetRequest()
	{
		return new RemovePetRequest();
	}
	
	private BaseData createFuncAuctionRemoveSaleItemRequest()
	{
		return new FuncAuctionRemoveSaleItemRequest();
	}
	
	private BaseData createSwitchSceneRequest()
	{
		return new SwitchSceneRequest();
	}
	
	private BaseData createFuncRefreshSubsectionIndexRequest()
	{
		return new FuncRefreshSubsectionIndexRequest();
	}
	
}
