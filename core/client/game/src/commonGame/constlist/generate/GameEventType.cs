using ShineEngine;

/// <summary>
/// 客户端游戏类型(generated by shine)
/// </summary>
public class GameEventType
{
	/// <summary>
	/// 前后台切换事件
	/// </summary>
	public const int ApplicationPause=2;
	
	/// <summary>
	/// 刷新服务器时间
	/// </summary>
	public const int RefreshServerOffTime=5;
	
	/// <summary>
	/// 配置热更
	/// </summary>
	public const int ReloadConfig=6;
	
	/// <summary>
	/// 刷新货币(data:type)
	/// </summary>
	public const int RefreshCurrency=7;
	
	/// <summary>
	/// 刷新角色经验
	/// </summary>
	public const int RefreshExp=8;
	
	/// <summary>
	/// 角色升级(data:oldLevel)
	/// </summary>
	public const int RoleLevelUp=9;
	
	/// <summary>
	/// 角色改名
	/// </summary>
	public const int RoleChangeName=10;
	
	/// <summary>
	/// 红点更新(data:type)
	/// </summary>
	public const int RefreshRedPoint=11;
	
	/// <summary>
	/// 绑定平台成功
	/// </summary>
	public const int BindPlatformSuccess=12;
	
	/// <summary>
	/// 初始化全部客户端数据(离线游戏用)
	/// </summary>
	public const int InitClient=13;
	
	/// <summary>
	/// 刷新角色战斗力
	/// </summary>
	public const int RefreshFightForce=14;
	
	/// <summary>
	/// 信息日志更新(data:InfoLogData)
	/// </summary>
	public const int RefreshInfoLog=15;
	
	/// <summary>
	/// 进入场景消息(data:sceneID)
	/// </summary>
	public const int EnterScene=19;
	
	/// <summary>
	/// 退出当前场景(data:sceneID)
	/// </summary>
	public const int LeaveScene=20;
	
	/// <summary>
	/// 退出最后场景结束
	/// </summary>
	public const int LeaveLastSceneOver=21;
	
	/// <summary>
	/// 主角单位状态变化(arg0:index,arg1:changeSet)
	/// </summary>
	public const int MUnitStatusChange=22;
	
	/// <summary>
	/// 主角单位属性变化(arg0:index,arg1:changeSet)
	/// </summary>
	public const int MUnitAttributeChange=23;
	
	/// <summary>
	/// 主角单位CD(arg0:index)
	/// </summary>
	public const int MUnitCDChange=24;
	
	/// <summary>
	/// 主角单位buff组更新(add/remove/refresh)
	/// </summary>
	public const int MUnitBuffChange=25;
	
	/// <summary>
	/// 主角造型模型变化
	/// </summary>
	public const int MUnitAvatarModelChange=26;
	
	/// <summary>
	/// 主角造型部件变化
	/// </summary>
	public const int MUnitAvatarPartChange=27;
	
	/// <summary>
	/// 主角单位技能组更新(add/remove/refresh)
	/// </summary>
	public const int MUnitSkillChange=28;
	
	/// <summary>
	/// 主角色属性变化(arg1:changeSet)
	/// </summary>
	public const int MRoleAttributeChange=29;
	
	/// <summary>
	/// 单位驾驶状态改变
	/// </summary>
	public const int OnUnitDriveChange=30;
	
	/// <summary>
	/// 载具驾驶状态改变
	/// </summary>
	public const int OnVehicleDriveChange=31;
	
	/// <summary>
	/// 功能开启(data:functionID)
	/// </summary>
	public const int FunctionOpen=35;
	
	/// <summary>
	/// 功能关闭(data:functionID)
	/// </summary>
	public const int FunctionClose=36;
	
	/// <summary>
	/// 活动开启(data:activityID)
	/// </summary>
	public const int ActivityOpen=37;
	
	/// <summary>
	/// 活动关闭(data:activityID)
	/// </summary>
	public const int ActivityClose=38;
	
	/// <summary>
	/// 活动重置(data:activityID)
	/// </summary>
	public const int ActivityReset=39;
	
	/// <summary>
	/// 活动可见(data:activityID)
	/// </summary>
	public const int ActivitySee=40;
	
	/// <summary>
	/// 活动不可见(data:activityID)
	/// </summary>
	public const int ActivityCantSee=41;
	
	/// <summary>
	/// 活动完成一次(data:activityID)
	/// </summary>
	public const int ActivityCompleteOnce=42;
	
	/// <summary>
	/// 副本状态更新
	/// </summary>
	public const int BattleStateChange=45;
	
	/// <summary>
	/// 开始匹配消息
	/// </summary>
	public const int StartMatch=48;
	
	/// <summary>
	/// 其他人同意匹配消息(playerID)
	/// </summary>
	public const int PlayerAcceptMatch=49;
	
	/// <summary>
	/// 取消匹配消息
	/// </summary>
	public const int CancelMatch=50;
	
	/// <summary>
	/// 结束匹配消息
	/// </summary>
	public const int MatchOver=51;
	
	/// <summary>
	/// 翻页插件数据更新(data:[funcID,page])
	/// </summary>
	public const int FuncRefreshPageShow=54;
	
	/// <summary>
	/// 排行插件数据更新(data:funcID)
	/// </summary>
	public const int FuncRefreshRank=55;
	
	/// <summary>
	/// 排行插件数据重置(data:funcID)
	/// </summary>
	public const int FuncResetRank=56;
	
	/// <summary>
	/// 分段翻页插件数据更新(data:[subsectionIndex,subsectionSubIndex,funcID,page])
	/// </summary>
	public const int FuncRefreshSubsectionPageShow=57;
	
	/// <summary>
	/// 背包容器更新单格(data:[funcID,index])
	/// </summary>
	public const int FuncItemContainerRefreshGrid=61;
	
	/// <summary>
	/// 背包容器全刷(整理)(data:funcID)
	/// </summary>
	public const int FuncItemContainerRefreshAll=62;
	
	/// <summary>
	/// 背包容器变化(data:funcID)
	/// </summary>
	public const int FuncItemContainerChange=63;
	
	/// <summary>
	/// 主背包容器更新单格(data:index)
	/// </summary>
	public const int MainBagRefreshGrid=64;
	
	/// <summary>
	/// 主背包容器全更新(整理)
	/// </summary>
	public const int MainBagRefreshAll=65;
	
	/// <summary>
	/// 主背包容器变化
	/// </summary>
	public const int MainBagChange=66;
	
	/// <summary>
	/// 主背包某物品Id变化(data:itemID)
	/// </summary>
	public const int MainBagItemChange=67;
	
	/// <summary>
	/// 获得道具提示(data:List<ItemData>)
	/// </summary>
	public const int AddItemNotice=68;
	
	/// <summary>
	/// 获得奖励(data:RewardShowData)
	/// </summary>
	public const int AddReward=69;
	
	/// <summary>
	/// 装备容器更新(data:[funcID,slot])
	/// </summary>
	public const int FuncEquipContainerRefreshGrid=72;
	
	/// <summary>
	/// 更新语言(国际化)
	/// </summary>
	public const int RefreshLanguage=75;
	
	/// <summary>
	/// 刷新全部邮件内容
	/// </summary>
	public const int RefreshAllMails=78;
	
	/// <summary>
	/// 添加新邮件(data:index)
	/// </summary>
	public const int AddNewMail=79;
	
	/// <summary>
	/// 刷新新邮件数目
	/// </summary>
	public const int RefreshNewMailNum=80;
	
	/// <summary>
	/// 更新一封邮件(data:index)
	/// </summary>
	public const int RefreshOneMail=81;
	
	/// <summary>
	/// 删除一封邮件(data:index)
	/// </summary>
	public const int DeleteOneMail=82;
	
	/// <summary>
	/// 领取一封邮件(data:index)
	/// </summary>
	public const int RewardOneMail=83;
	
	/// <summary>
	/// 刷新全部任务
	/// </summary>
	public const int RefreshAllQuest=86;
	
	/// <summary>
	/// 刷新单个任务显示
	/// </summary>
	public const int RefreshOneQuest=87;
	
	/// <summary>
	/// 刷新可接任务列表
	/// </summary>
	public const int RefreshCanAcceptQuests=88;
	
	/// <summary>
	/// 刷新可视任务列表
	/// </summary>
	public const int RefreshCanSeeQuests=89;
	
	/// <summary>
	/// 接收任务(data:id)
	/// </summary>
	public const int AcceptQuest=90;
	
	/// <summary>
	/// 提交任务(任务完成)(data:id)
	/// </summary>
	public const int CommitQuest=91;
	
	/// <summary>
	/// 任务失败(data:id)
	/// </summary>
	public const int QuestFaied=92;
	
	/// <summary>
	/// 放弃任务(data:id)
	/// </summary>
	public const int GiveUpQuest=93;
	
	/// <summary>
	/// 移除已接任务(data:id)
	/// </summary>
	public const int RemoveAcceptQuest=94;
	
	/// <summary>
	/// 刷新成就显示(data:id)
	/// </summary>
	public const int RefreshAchievement=97;
	
	/// <summary>
	/// 完成成就(data:id)
	/// </summary>
	public const int CompleteAchievement=98;
	
	/// <summary>
	/// 领取成就奖励成功(data:id)
	/// </summary>
	public const int GetAchievementReward=99;
	
	/// <summary>
	/// 社交数据更新
	/// </summary>
	public const int UpdateSocialData=103;
	
	/// <summary>
	/// 收到聊天消息(data:NormalEvt,int0=channel,long0=key)
	/// </summary>
	public const int ReceiveChat=104;
	
	/// <summary>
	/// 添加好友(data:playerID)
	/// </summary>
	public const int AddFriend=107;
	
	/// <summary>
	/// 移除好友(data:playerID)
	/// </summary>
	public const int RemoveFriend=108;
	
	/// <summary>
	/// 收到好友申请(data:playerID)
	/// </summary>
	public const int ReceiveApplyFriend=109;
	
	/// <summary>
	/// 好友申请列表更新
	/// </summary>
	public const int RefreshApplyFriendList=110;
	
	/// <summary>
	/// 添加好友黑名单(data:playerID)
	/// </summary>
	public const int AddFriendBlackList=111;
	
	/// <summary>
	/// 移除好友黑名单(data:playerID)
	/// </summary>
	public const int RemoveFriendBlackList=112;
	
	/// <summary>
	/// 加入玩家群(data:RoleGroupEvt->groupID,type)
	/// </summary>
	public const int JoinRoleGroup=115;
	
	/// <summary>
	/// 离开玩家群(data:RoleGroupEvt->groupID,type)
	/// </summary>
	public const int LeaveRoleGroup=116;
	
	/// <summary>
	/// 添加玩家群成员(data:RoleGroupEvt->groupID,targetID,type)
	/// </summary>
	public const int AddRoleGroupMember=117;
	
	/// <summary>
	/// 移除玩家群成员(data:RoleGroupEvt->groupID,targetID,type)
	/// </summary>
	public const int RemoveRoleGroupMember=118;
	
	/// <summary>
	/// 更新玩家群职位(data:RoleGroupEvt->groupID,targetID,oldTitle,newTitle)
	/// </summary>
	public const int RefreshRoleGroupTitle=119;
	
	/// <summary>
	/// 改变玩家群群主(data:RoleGroupEvt->groupID,targetID)
	/// </summary>
	public const int ChangeRoleGroupLeader=120;
	
	/// <summary>
	/// 改变玩家群数据(data:RoleGroupEvt->groupID,changeData)
	/// </summary>
	public const int ChangeRoleGroupData=121;
	
	/// <summary>
	/// 改变玩家群成员数据(data:RoleGroupEvt->groupID,targetID,changeData)
	/// </summary>
	public const int ChangeRoleGroupMemberData=122;
	
	/// <summary>
	/// 收到邀请进入玩家群(data:InviteRoleGroupTempData)
	/// </summary>
	public const int ReceiveInviteRoleGroup=123;
	
	/// <summary>
	/// 玩家群收到新的申请(data:RoleGroupEvt->groupID,applyData)
	/// </summary>
	public const int RoleGroupReceiveApply=124;
	
	/// <summary>
	/// 玩家群申请信息变化(data:RoleGroupEvt->groupID,applyData)
	/// </summary>
	public const int RoleGroupApplyChange=125;
	
	/// <summary>
	/// 玩家群自身申请信息变化(data:RoleGroupEvt->groupID)
	/// </summary>
	public const int RoleGroupSelfApplyChange=126;
	
	/// <summary>
	/// 玩家群自身申请信息结果(data:RoleGroupEvt->groupID)
	/// </summary>
	public const int RoleGroupSelfApplyResult=127;
	
	/// <summary>
	/// 玩家群邀请结果(data:RoleGroupEvt->groupID,roleShowData,result)
	/// </summary>
	public const int RoleGroupInviteResult=128;
	
	/// <summary>
	/// 玩家群更新信息日志(data:RoleGroupEvt->groupID)
	/// </summary>
	public const int RoleGroupRefreshInfoLog=129;
	
	/// <summary>
	/// 更新玩家群附加数据(data:RoleGroupEvt->groupID)
	/// </summary>
	public const int RefreshRoleGroupEx=130;
	
	/// <summary>
	/// 改变玩家群成员角色显示数据(data:RoleGroupEvt->groupID,targetID,type)
	/// </summary>
	public const int ChangeRoleGroupMemberRoleShowData=131;
	
	/// <summary>
	/// 添加宠物(data:mIndex)
	/// </summary>
	public const int AddPet=135;
	
	/// <summary>
	/// 删除宠物(data:mIndex)
	/// </summary>
	public const int RemovePet=136;
	
	/// <summary>
	/// 宠物出战状态变化(data:mIndex)
	/// </summary>
	public const int PetIsWorkingChange=137;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=0;
	
}
