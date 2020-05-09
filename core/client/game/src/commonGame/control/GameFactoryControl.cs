﻿using System;
using ShineEngine;

/// <summary>
/// 游戏工程工厂(generated by shine client)
/// </summary>
[Hotfix]
public class GameFactoryControl
{
	public virtual GameDataRegister createDataRegister()
	{
		return new GameDataRegister();
	}

	public virtual ConfigControl createConfigControl()
	{
		return new ConfigControl();
	}

	public virtual GameMainControl createGameMainControl()
	{
		return new GameMainControl();
	}

	public virtual GameServer createGameServer()
	{
		return new GameServer();
	}

	public virtual Player createPlayer()
	{
		return new Player();
	}

	public virtual GameUIControl createGameUIControl()
	{
		return new GameUIControl();
	}

	public virtual InfoControl createInfoControl()
	{
		return new InfoControl();
	}

	public virtual KeyboardControl createKeyboardControl()
	{
		return new KeyboardControl();
	}

	public virtual TouchControl createTouchControl()
	{
		return new TouchControl();
	}

	public virtual RedPointControl createRedPointControl()
	{
		return new RedPointControl();
	}

	public virtual BaseLogicControl createBaseLogicControl()
	{
		return new BaseLogicControl();
	}

	public virtual BaseConstControl createBaseConstControl()
	{
		return new BaseConstControl();
	}

	public virtual SceneControl createSceneControl()
	{
		return new SceneControl();
	}

	public virtual GameOfflineControl createGameOfflineControl()
	{
		return new GameOfflineControl();
	}

	public virtual PlayerSaveControl createPlayerSaveControl()
	{
		return new PlayerSaveControl();
	}

	public virtual GameLogControl createGameLogControl()
	{
		return new GameLogControl();
	}

	public virtual GamePoolControl createGamePoolControl()
	{
		return new GamePoolControl();
	}

	public virtual ClientGMControl createClientGMControl()
	{
		return new ClientGMControl();
	}

	public virtual TriggerControl createTriggerControl()
	{
		return new TriggerControl();
	}

	public virtual GuideControl createGuideControl()
	{
		return new GuideControl();
	}

	public virtual GuideTriggerExecutor createGuideTriggerExecutor()
	{
		return new GuideTriggerExecutor();
	}

	public virtual ConfigReadData createConfigReadData()
	{
		return new ConfigReadData();
	}

	public virtual GlobalReadData createGlobalReadData()
	{
		return new GlobalReadData();
	}

	public virtual RoleShowData createRoleShowData()
	{
		return new RoleShowData();
	}

	public virtual RoleSimpleShowData createRoleSimpleShowData()
	{
		return new RoleSimpleShowData();
	}

	public virtual UnitData createUnitData()
	{
		return new UnitData();
	}

	public virtual UnitSimpleData createUnitSimpleData()
	{
		return new UnitSimpleData();
	}

	public virtual CharacterIdentityData createCharacterIdentityData()
	{
		return new CharacterIdentityData();
	}

	public virtual ItemData createItemData()
	{
		return new ItemData();
	}

	public virtual ItemIdentityData createItemIdentityData()
	{
		return new ItemIdentityData();
	}

	public virtual CharacterUseData createCharacterUseData()
	{
		return new CharacterUseData();
	}

	public virtual ClientLoginData createClientLoginData()
	{
		return new ClientLoginData();
	}

	public virtual RoleSocialData createRoleSocialData()
	{
		return new RoleSocialData();
	}

	public virtual PlayerRankData createPlayerRankData()
	{
		return new PlayerRankData();
	}

	public virtual PlayerMatchData createPlayerMatchData()
	{
		return new PlayerMatchData();
	}

	public virtual ItemEquipData createItemEquipData()
	{
		return new ItemEquipData();
	}

	public virtual MailData createMailData()
	{
		return new MailData();
	}

	public virtual FriendData createFriendData()
	{
		return new FriendData();
	}

	public virtual UnitFightDataLogic createUnitFightDataLogic()
	{
		return new UnitFightDataLogic();
	}

	public virtual BuffDataLogic createBuffDataLogic()
	{
		return new BuffDataLogic();
	}

	public virtual Scene createScene()
	{
		return new Scene();
	}

	public virtual Unit createUnit()
	{
		return new Unit();
	}

	public virtual Bullet createBullet()
	{
		return new Bullet();
	}

	public virtual UnitEffect createUnitEffect()
	{
		return new UnitEffect();
	}

	public virtual CharacterUseLogic createCharacterUseLogic()
	{
		return new CharacterUseLogic();
	}

	public virtual ItemTipsReplaceTextTool createItemTipsReplaceTextTool()
	{
		return new ItemTipsReplaceTextTool();
	}

	public virtual TaskDescribeReplaceTextTool createTaskDescribeReplaceTextTool()
	{
		return new TaskDescribeReplaceTextTool();
	}

	public virtual AchievementCompleteData createAchievementCompleteData()
	{
		return new AchievementCompleteData();
	}

	public virtual AchievementData createAchievementData()
	{
		return new AchievementData();
	}

	public virtual AchievementPart createAchievementPart()
	{
		return new AchievementPart();
	}

	public virtual AchievementSaveData createAchievementSaveData()
	{
		return new AchievementSaveData();
	}

	public virtual ActivityData createActivityData()
	{
		return new ActivityData();
	}

	public virtual ActivityPart createActivityPart()
	{
		return new ActivityPart();
	}

	public virtual ApplyAddFriendData createApplyAddFriendData()
	{
		return new ApplyAddFriendData();
	}

	public virtual AreaClientData createAreaClientData()
	{
		return new AreaClientData();
	}

	public virtual AttackData createAttackData()
	{
		return new AttackData();
	}

	public virtual BagPart createBagPart()
	{
		return new BagPart();
	}


	public virtual BaseServer createBaseServer()
	{
		return new BaseServer();
	}

	public virtual BattleSceneEnterData createBattleSceneEnterData()
	{
		return new BattleSceneEnterData();
	}

	public virtual BattleScenePlayLogic createBattleScenePlayLogic()
	{
		return new BattleScenePlayLogic();
	}

	public virtual BattleSceneSyncPlayLogic createBattleSceneSyncPlayLogic()
	{
		return new BattleSceneSyncPlayLogic();
	}

	public virtual BuffData createBuffData()
	{
		return new BuffData();
	}

	public virtual BuffIntervalActionData createBuffIntervalActionData()
	{
		return new BuffIntervalActionData();
	}

	public virtual BulletData createBulletData()
	{
		return new BulletData();
	}

	public virtual BulletLogicBase createBulletLogicBase()
	{
		return new BulletLogicBase();
	}

	public virtual BulletPosLogic createBulletPosLogic()
	{
		return new BulletPosLogic();
	}

	public virtual BulletShowLogic createBulletShowLogic()
	{
		return new BulletShowLogic();
	}

	public virtual CDData createCDData()
	{
		return new CDData();
	}

	public virtual CharacterIdentityLogic createCharacterIdentityLogic()
	{
		return new CharacterIdentityLogic();
	}

	public virtual CharacterPart createCharacterPart()
	{
		return new CharacterPart();
	}

	public virtual CharacterSaveData createCharacterSaveData()
	{
		return new CharacterSaveData();
	}

	public virtual ChatData createChatData()
	{
		return new ChatData();
	}

	public virtual ChatElementData createChatElementData()
	{
		return new ChatElementData();
	}

	public virtual ClientLoginExData createClientLoginExData()
	{
		return new ClientLoginExData();
	}

	public virtual ClientSimpleScene createClientSimpleScene()
	{
		return new ClientSimpleScene();
	}

	public virtual ContactData createContactData()
	{
		return new ContactData();
	}

	public virtual CreatePlayerData createCreatePlayerData()
	{
		return new CreatePlayerData();
	}

	public virtual DamageOneData createDamageOneData()
	{
		return new DamageOneData();
	}

	public virtual DirData createDirData()
	{
		return new DirData();
	}

	public virtual EquipPart createEquipPart()
	{
		return new EquipPart();
	}

	public virtual FrameSyncCommandData createFrameSyncCommandData()
	{
		return new FrameSyncCommandData();
	}

	public virtual FrameSyncData createFrameSyncData()
	{
		return new FrameSyncData();
	}

	public virtual FriendPart createFriendPart()
	{
		return new FriendPart();
	}

	public virtual FuncPart createFuncPart()
	{
		return new FuncPart();
	}

	public virtual FuncToolData createFuncToolData()
	{
		return new FuncToolData();
	}

	public virtual GameApp createGameApp()
	{
		return new GameApp();
	}

	public virtual GameDataRegister createGameDataRegister()
	{
		return new GameDataRegister();
	}

	public virtual GameFactoryControl createGameFactoryControl()
	{
		return new GameFactoryControl();
	}

	public virtual GameServerClientSimpleData createGameServerClientSimpleData()
	{
		return new GameServerClientSimpleData();
	}

	public virtual GameServerRunData createGameServerRunData()
	{
		return new GameServerRunData();
	}

	public virtual GameServerSimpleInfoData createGameServerSimpleInfoData()
	{
		return new GameServerSimpleInfoData();
	}

	public virtual GameUIBase createGameUIBase()
	{
		return new GameUIBase();
	}

	public virtual GameUILogicBase createGameUILogicBase()
	{
		return new GameUILogicBase();
	}

	public virtual UnionPart createUnionPart()
	{
		return new UnionPart();
	}

	public virtual ItemContainerData createItemContainerData()
	{
		return new ItemContainerData();
	}

	public virtual ItemRecordData createItemRecordData()
	{
		return new ItemRecordData();
	}

	public virtual KeepSaveData createKeepSaveData()
	{
		return new KeepSaveData();
	}

	public virtual KeyData createKeyData()
	{
		return new KeyData();
	}

	public virtual MailPart createMailPart()
	{
		return new MailPart();
	}

	public virtual MonsterIdentityData createMonsterIdentityData()
	{
		return new MonsterIdentityData();
	}

	public virtual MonsterIdentityLogic createMonsterIdentityLogic()
	{
		return new MonsterIdentityLogic();
	}

	public virtual MUnitCacheData createMUnitCacheData()
	{
		return new MUnitCacheData();
	}

	public virtual MUnitFightDataLogic createMUnitFightDataLogic()
	{
		return new MUnitFightDataLogic();
	}

	public virtual MUnitUseData createMUnitUseData()
	{
		return new MUnitUseData();
	}

	public virtual MUnitUseLogic createMUnitUseLogic()
	{
		return new MUnitUseLogic();
	}

	public virtual NPCIdentityData createNPCIdentityData()
	{
		return new NPCIdentityData();
	}

	public virtual PetIdentityData createPetIdentityData()
	{
		return new PetIdentityData();
	}

	public virtual PetUseData createPetUseData()
	{
		return new PetUseData();
	}

	public virtual PlayerLoginData createPlayerLoginData()
	{
		return new PlayerLoginData();
	}

	public virtual PlayerMailData createPlayerMailData()
	{
		return new PlayerMailData();
	}

	public virtual PlayerPrimaryKeyData createPlayerPrimaryKeyData()
	{
		return new PlayerPrimaryKeyData();
	}

	public virtual PlayerRankToolData createPlayerRankToolData()
	{
		return new PlayerRankToolData();
	}

	public virtual PosData createPosData()
	{
		return new PosData();
	}

	public virtual PosDirData createPosDirData()
	{
		return new PosDirData();
	}

	public virtual PreBattleScenePlayLogic createPreBattleScenePlayLogic()
	{
		return new PreBattleScenePlayLogic();
	}

	public virtual PuppetIdentityData createPuppetIdentityData()
	{
		return new PuppetIdentityData();
	}

	public virtual PuppetIdentityLogic createPuppetIdentityLogic()
	{
		return new PuppetIdentityLogic();
	}

	public virtual QuestCompleteData createQuestCompleteData()
	{
		return new QuestCompleteData();
	}

	public virtual QuestData createQuestData()
	{
		return new QuestData();
	}

	public virtual QuestPart createQuestPart()
	{
		return new QuestPart();
	}

	public virtual RankData createRankData()
	{
		return new RankData();
	}

	public virtual RankSimpleData createRankSimpleData()
	{
		return new RankSimpleData();
	}

	public virtual RankToolData createRankToolData()
	{
		return new RankToolData();
	}

	public virtual ReplaceTextTool createReplaceTextTool()
	{
		return new ReplaceTextTool();
	}

	public virtual RewardShowData createRewardShowData()
	{
		return new RewardShowData();
	}

	public virtual RolePart createRolePart()
	{
		return new RolePart();
	}

	public virtual RoleShowChangeData createRoleShowChangeData()
	{
		return new RoleShowChangeData();
	}

	public virtual SaveVersionData createSaveVersionData()
	{
		return new SaveVersionData();
	}

	public virtual SceneCameraLogic createSceneCameraLogic()
	{
		return new SceneCameraLogic();
	}

	public virtual SceneCameraLogic3DOne createSceneCameraLogic3D()
	{
		return new SceneCameraLogic3DOne();
	}

	public virtual SceneEffectIdentityData createSceneEffectIdentityData()
	{
		return new SceneEffectIdentityData();
	}

	public virtual SceneEnterArgData createSceneEnterArgData()
	{
		return new SceneEnterArgData();
	}

	public virtual SceneEnterData createSceneEnterData()
	{
		return new SceneEnterData();
	}

	public virtual SceneFightLogic createSceneFightLogic()
	{
		return new SceneFightLogic();
	}

	public virtual SceneInOutLogic createSceneInOutLogic()
	{
		return new SceneInOutLogic();
	}

	public virtual SceneLoadLogic createSceneLoadLogic()
	{
		return new SceneLoadLogic();
	}

	public virtual SceneObject createSceneObject()
	{
		return new SceneObject();
	}

	public virtual SceneObjectLogicBase createSceneObjectLogicBase()
	{
		return new SceneObjectLogicBase();
	}

	public virtual ScenePart createScenePart()
	{
		return new ScenePart();
	}

	public virtual ScenePlaceConfig createScenePlaceConfig()
	{
		return new ScenePlaceConfig();
	}

	public virtual ScenePlayLogic createScenePlayLogic()
	{
		return new ScenePlayLogic();
	}

	public virtual ScenePosLogic createScenePosLogic()
	{
		return new ScenePosLogic();
	}

	public virtual ScenePosLogic3DOne createScenePosLogic3D()
	{
		return new ScenePosLogic3DOne();
	}

	public virtual ScenePreInfoData createScenePreInfoData()
	{
		return new ScenePreInfoData();
	}

	public virtual SceneShowLogic createSceneShowLogic()
	{
		return new SceneShowLogic();
	}

	public virtual SceneShowLogic3DOne createSceneShowLogic3D()
	{
		return new SceneShowLogic3DOne();
	}

	public virtual ServerSimpleInfoData createServerSimpleInfoData()
	{
		return new ServerSimpleInfoData();
	}

	public virtual SingleBagPart createSingleBagPart()
	{
		return new SingleBagPart();
	}

	public virtual SingleCharacterPart createSingleCharacterPart()
	{
		return new SingleCharacterPart();
	}

	public virtual SkillData createSkillData()
	{
		return new SkillData();
	}

	public virtual SkillTargetData createSkillTargetData()
	{
		return new SkillTargetData();
	}

	public virtual SocialPart createSocialPart()
	{
		return new SocialPart();
	}

	public virtual SystemPart createSystemPart()
	{
		return new SystemPart();
	}

	public virtual TaskData createTaskData()
	{
		return new TaskData();
	}

	public virtual TeamPart createTeamPart()
	{
		return new TeamPart();
	}

	public virtual Test2Data createTest2Data()
	{
		return new Test2Data();
	}

	public virtual TestData createTestData()
	{
		return new TestData();
	}

	public virtual UIBase createUIBase()
	{
		return new UIBase();
	}

	public virtual UILogicBase createUILogicBase()
	{
		return new UILogicBase();
	}

	public virtual UnitAIData createUnitAIData()
	{
		return new UnitAIData();
	}

	public virtual UnitAILogic createUnitAILogic()
	{
		return new UnitAILogic();
	}

	public virtual UnitAvatarData createUnitAvatarData()
	{
		return new UnitAvatarData();
	}

	public virtual UnitAvatarLogic createUnitAvatarLogic()
	{
		return new UnitAvatarLogic();
	}

	public virtual UnitFightData createUnitFightData()
	{
		return new UnitFightData();
	}

	public virtual UnitFightExData createUnitFightExData()
	{
		return new UnitFightExData();
	}

	public virtual UnitFightLogic createUnitFightLogic()
	{
		return new UnitFightLogic();
	}

	public virtual UnitHeadLogic createUnitHeadLogic()
	{
		return new UnitHeadLogic();
	}

	public virtual UnitIdentityData createUnitIdentityData()
	{
		return new UnitIdentityData();
	}

	public virtual UnitIdentityLogic createUnitIdentityLogic()
	{
		return new UnitIdentityLogic();
	}

	public virtual UnitInfoData createUnitInfoData()
	{
		return new UnitInfoData();
	}

	public virtual UnitLogicBase createUnitLogicBase()
	{
		return new UnitLogicBase();
	}

	public virtual UnitPosData createUnitPosData()
	{
		return new UnitPosData();
	}

	public virtual UnitPosLogic createUnitPosLogic()
	{
		return new UnitPosLogic();
	}

	public virtual UnitShowLogic3DOne createUnitShowLogic3DBase()
	{
		return new UnitShowLogic3DOne();
	}

	public virtual UseItemArgData createUseItemArgData()
	{
		return new UseItemArgData();
	}

	public virtual VehicleIdentityData createVehicleIdentityData()
	{
		return new VehicleIdentityData();
	}

	public virtual UnitShowLogic createUnitShowLogic()
	{
		return new UnitShowLogic();
	}

	public virtual SEventRegister createSEventRegister()
	{
		return new SEventRegister();
	}

	public virtual ViewControl createViewControl()
	{
		return new ViewControl();
	}

	public virtual ClientVersionData createClientVersionData()
	{
		return new ClientVersionData();
	}

	public virtual ClientLoginCacheData createClientLoginCacheData()
	{
		return new ClientLoginCacheData();
	}

	public virtual ClientOfflineWorkData createClientOfflineWorkData()
	{
		return new ClientOfflineWorkData();
	}

	public virtual ClientOfflineWorkListData createClientOfflineWorkListData()
	{
		return new ClientOfflineWorkListData();
	}

	public virtual PlayerOfflineCacheExData createPlayerOfflineCacheExData()
	{
		return new PlayerOfflineCacheExData();
	}

	public virtual PlayerVersionControl createPlayerVersionControl()
	{
		return new PlayerVersionControl();
	}

	public virtual ClientPlayerLocalCacheData createClientPlayerLocalCacheData()
	{
		return new ClientPlayerLocalCacheData();
	}

	public virtual PlayerUnionTool createPlayerUnionTool()
	{
		return new PlayerUnionTool();
	}

	public virtual PlayerTeamTool createPlayerTeamTool()
	{
		return new PlayerTeamTool();
	}

	public virtual Role createRole()
	{
		return new Role();
	}

	public virtual EquipContainerData createEquipContainerData()
	{
		return new EquipContainerData();
	}
}
