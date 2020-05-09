package com.home.commonGame.part.player.part;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.config.game.CurrencyConfig;
import com.home.commonBase.config.game.FunctionConfig;
import com.home.commonBase.config.game.InitCreateConfig;
import com.home.commonBase.config.game.QuestConfig;
import com.home.commonBase.config.game.RewardConfig;
import com.home.commonBase.config.game.RoleLevelConfig;
import com.home.commonBase.config.game.enumT.RoleShowDataPartTypeConfig;
import com.home.commonBase.constlist.generate.CallWayType;
import com.home.commonBase.constlist.generate.CurrencyType;
import com.home.commonBase.constlist.generate.InfoCodeType;
import com.home.commonBase.constlist.generate.PlatformType;
import com.home.commonBase.constlist.generate.RoleActionType;
import com.home.commonBase.constlist.generate.RoleConditionType;
import com.home.commonBase.constlist.generate.RoleShowDataPartType;
import com.home.commonBase.constlist.generate.TaskType;
import com.home.commonBase.data.login.CreatePlayerData;
import com.home.commonBase.data.login.PlayerLoginData;
import com.home.commonBase.data.role.RoleShowChangeData;
import com.home.commonBase.data.role.RoleShowData;
import com.home.commonBase.data.role.RoleSimpleShowData;
import com.home.commonBase.data.scene.match.PlayerMatchData;
import com.home.commonBase.data.system.PlayerPrimaryKeyData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.global.CommonSetting;
import com.home.commonBase.global.Global;
import com.home.commonBase.part.player.clientData.RoleClientPartData;
import com.home.commonBase.part.player.data.RolePartData;
import com.home.commonBase.scene.base.Unit;
import com.home.commonBase.table.table.PlayerTable;
import com.home.commonGame.global.GameC;
import com.home.commonGame.logic.unit.CharacterUseLogic;
import com.home.commonGame.net.request.login.SendBindPlatformRequest;
import com.home.commonGame.net.request.role.ChangeRoleNameRequest;
import com.home.commonGame.net.request.role.LevelUpRequest;
import com.home.commonGame.net.request.role.RefreshCurrencyRequest;
import com.home.commonGame.net.request.role.RefreshExpRequest;
import com.home.commonGame.net.request.role.RefreshFightForceRequest;
import com.home.commonGame.net.request.scene.unit.CharacterRefreshPartRoleShowDataRequest;
import com.home.commonGame.net.serverRequest.login.login.ClientApplyBindPlatformToLoginServerRequest;
import com.home.commonGame.part.player.base.PlayerBasePart;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.data.DIntData;
import com.home.shine.utils.ObjectUtils;

/** 玩家(generated by shine) */
public class RolePart extends PlayerBasePart
{
	/** 数据 */
	private RolePartData _d;
	
	/** 角色ID */
	public long playerID;
	
	/** 名字 */
	public String name;
	
	/** 用户ID */
	public long userID;
	
	/** 用户uid */
	public String uid;
	
	/** 平台 */
	public String platform;
	
	/** 客户端设备平台类型 */
	public int clientPlatformType;
	
	/** 创建区ID */
	public int createAreaID;
	
	/** 来源gameID */
	public int sourceGameID=-1;
	
	/** 缓存角色显示数据 */
	private RoleShowData _selfRoleShowData;
	
	/** 货币上限组 */
	private long[] _currenciesMax=new long[CurrencyType.size];
	
	/** 当前战斗力 */
	private long _fightForce;
	
	/** 战斗力是否修改了 */
	private boolean _fightForceModified;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(RolePartData)data;
	}
	
	/** 获取数据 */
	public RolePartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new RolePartData();
	}
	
	@Override
	protected BaseClientPartData createClientData()
	{
		return new RoleClientPartData();
	}
	
	/** 写客户端数据(copyServer过后的) */
	@Override
	protected void writeClientData(BaseClientPartData data)
	{
		toWriteClientData((RoleClientPartData)data);
	}
	
	/** 写客户端数据具体执行(已执行过copyServer了,就是说CPO中与SPO同名同类型的属性无需再赋值) */
	private void toWriteClientData(RoleClientPartData data)
	{
		data.playerID=playerID;
		data.name=name;
		data.uid=uid;
		data.userID=userID;
		data.platform=platform;
		data.createAreaID=createAreaID;
		data.currenciesMax=_currenciesMax;
		data.fightForce=_fightForce;
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		
	}
	
	/** 初始化(创建后刚调用,与dispose成对) */
	@Override
	public void init()
	{
	
	}
	
	/** 析构(回池前调用,与init成对) */
	@Override
	public void dispose()
	{
		sourceGameID=-1;
		_selfRoleShowData=null;
		
		for(int i=0;i<_currenciesMax.length;++i)
		{
			_currenciesMax[i]=0;
		}
		
		_fightForce=0L;
		_fightForceModified=false;
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		//长度梗概
		_d.currencies=ObjectUtils.ensureArrayLength(_d.currencies,CurrencyType.size);
		_d.totalAddCurrencies=ObjectUtils.ensureArrayLength(_d.totalAddCurrencies,CurrencyType.size);
		_selfRoleShowData=BaseC.factory.createRoleShowData();
		
		_fightForceModified=true;
	}
	
	@Override
	public void afterReadDataSecond()
	{
		makeRoleShowData(_selfRoleShowData);
	}
	
	/** 新创建时(该主对象在服务器上第一次被创建时的动作(一生只一次),(只对数据赋值就好,自定义数据构造的部分写到afterReadData里,因为这个完事儿就会回调到)) */
	@Override
	public void onNewCreate()
	{
		_d.level=1;
		_d.exp=0L;
		
		_d.currencies=new long[CurrencyType.size];
		_d.totalAddCurrencies=new long[CurrencyType.size];
		
		InitCreateConfig config=InitCreateConfig.get(_d.vocation);
		
		if(config!=null)
		{
			for(DIntData v : config.currency)
			{
				addCurrency(v.key,v.value,CallWayType.InitCreate);
			}
		}
		else
		{
			Ctrl.warnLog("未找到角色初始化配置,vocation:",_d.vocation);
		}
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		
	}
	
	/** 功能开启(id:功能ID) */
	@Override
	public void onFunctionOpen(int id)
	{
		
	}
	
	/** 功能关闭(id:功能ID) */
	@Override
	public void onFunctionClose(int id)
	{
		
	}
	
	public void onPiece(int delay)
	{
		if(_fightForceModified)
		{
			_fightForceModified=false;
			
			long vv=0;
			
			PlayerBasePart[] partList=me.getPartList();
			
			for(int i=0;i<partList.length;i++)
			{
				vv+=partList[i].countFightForce();
			}
			
			if(vv!=_fightForce)
			{
				_fightForce=vv;
				//推送
				me.send(RefreshFightForceRequest.create(_fightForce));
				//刷新外显数据
				refreshPartRoleShowDataForLong(RoleShowDataPartType.FightForce,vv);
				
				onFightForceChange(_fightForce);
			}
		}
	}
	
	public void afterSendClientListData()
	{
		//标记关闭
		_fightForceModified=false;
	}
	
	/** 读主键数据 */
	public void readPrimaryKeyData(PlayerPrimaryKeyData data)
	{
		playerID=data.playerID;
		name=data.name;
		uid=data.uid;
		userID=data.userID;
		platform=data.platform;
		createAreaID=data.createAreaID;
		sourceGameID=data.sourceGameID;
	}
	
	/** 创建主键数据 */
	public PlayerPrimaryKeyData createPrimaryKeyData()
	{
		PlayerPrimaryKeyData data=new PlayerPrimaryKeyData();
		data.playerID=playerID;
		data.name=name;
		data.uid=uid;
		data.userID=userID;
		data.platform=platform;
		data.createAreaID=createAreaID;
		data.sourceGameID=sourceGameID;
		
		return data;
	}
	
	/** 读取player表的其他部分 */
	public void readPlayerTableKey(PlayerTable table)
	{
		playerID=table.playerID;
		name=table.name;
		userID=table.userID;
		uid=table.uid;
		createAreaID=table.createAreaID;
		platform=table.platform;
	}
	
	/** 写playerTable主键 */
	public void writePlayerTableKey(PlayerTable table)
	{
		table.playerID=playerID;
		table.name=name;
		table.userID=userID;
		table.uid=uid;
		table.createAreaID=createAreaID;
		table.platform=platform;
	}
	
	/** 是否是当前游戏服 */
	public boolean isCurrentGame()
	{
		return sourceGameID==GameC.app.id;
	}
	
	/** 性别 */
	public int getSex()
	{
		return _d.sex;
	}
	
	/** 玩家职业 */
	public int getVocation()
	{
		return _d.vocation;
	}
	
	/** 获取等级 */
	public int getLevel()
	{
		return _d.level;
	}
	
	/** 战斗力 */
	public long getFightForce()
	{
		return _fightForce;
	}
	
	/** 创建登录角色数据(会多线程调用!) */
	public PlayerLoginData createLoginData()
	{
		PlayerLoginData data=BaseC.factory.createPlayerLoginData();
		writeLoginData(data);
		return data;
	}
	
	/** 写登录数据(不区分深浅,因为东西少) */
	public void writeLoginData(PlayerLoginData loginData)
	{
		loginData.playerID=playerID;
		loginData.name=name;
		loginData.sex=_d.sex;
		loginData.vocation=_d.vocation;
		loginData.isOnline=false;//都按离线算
	}
	
	/** 执行创建角色(逻辑相关) */
	public void doCreatePlayer(CreatePlayerData data)
	{
		_d.sex=data.sex;
		_d.vocation=data.vocation;
	}
	
	/** 构造角色展示数据 */
	public void makeRoleShowData(RoleShowData data)
	{
		data.playerID=playerID;
		data.createAreaID=createAreaID;
		data.name=name;
		
		data.sex=_d.sex;
		data.level=_d.level;
		data.vocation=_d.vocation;
	}
	
	/** 构造角色简版展示数据 */
	public void makeRoleSimpleShowData(RoleSimpleShowData data)
	{
		data.playerID=playerID;
		data.createAreaID=createAreaID;
		data.name=name;
		
		data.sex=_d.sex;
		data.vocation=_d.vocation;
	}
	
	/** 创建角色展示数据(主线程/池线程) */
	public RoleShowData createRoleShowData()
	{
		RoleShowData data=BaseC.factory.createRoleShowData();
		makeRoleShowData(data);
		return data;
	}
	
	/** 获取缓存角色展示数据(当前线程用) */
	public RoleShowData getSelfRoleShowData()
	{
		return _selfRoleShowData;
	}
	
	/** 创建角色简版显示数据(主线程/池线程) */
	public RoleSimpleShowData createRoleSimpleShowData()
	{
		RoleSimpleShowData data=BaseC.factory.createRoleSimpleShowData();
		makeRoleSimpleShowData(data);
		return data;
	}
	
	/** 构造匹配数据基础部分 */
	public void makeMatchData(PlayerMatchData data)
	{
		data.showData=createRoleShowData();
	}
	
	/** 添加经验 */
	public void addExp(long value,int way)
	{
		if(value<=0)
			return;
		
		int level;
		//已达最大等级
		if((level=_d.level) >= Global.levelMax)
		{
			return;
		}
		
		long v=(_d.exp+=value);
		
		long expMax;
		
		if(v >= (expMax=RoleLevelConfig.get(level).expMax))
		{
			int oldLevel=level;
			
			while(true)
			{
				v-=expMax;
				
				if(++level == Global.levelMax)
				{
					v=0;
					
					break;
				}
				
				expMax=RoleLevelConfig.get(level).expMax;
				
				if(v<expMax)
					break;
			}
			
			_d.exp=v;
			
			me.send(RefreshExpRequest.create(v));
			
			_d.level=level;
			
			me.send(LevelUpRequest.create(level));
			
			me.onLevelUp(oldLevel);
		}
		else
		{
			me.send(RefreshExpRequest.create(v));
		}
	}
	
	@Override
	public void onLevelUp(int oldLevel)
	{
		refreshPartRoleShowData(RoleShowDataPartType.Level,_d.level);
		
		me.quest.taskEvent(TaskType.Level);
	}
	
	/** 升到多少级 */
	public void levelUpByGM(int level)
	{
		int oldLevel;
		
		//已达最大等级
		if((oldLevel=_d.level) >= Global.levelMax)
		{
			return;
		}
		
		if(level<=oldLevel)
		{
			return;
		}
		
		if(level>Global.levelMax)
		{
			level=Global.levelMax;
		}
		
		//TODO:gm way
		
		_d.exp=0;
		
		me.send(RefreshExpRequest.create(0));
		
		_d.level=level;
		
		me.send(LevelUpRequest.create(level));
		
		me.onLevelUp(oldLevel);
	}
	
	/** 改名 */
	public void changeName(String name)
	{
		if(!me.isCurrentGame())
		{
			me.warningInfoCode(InfoCodeType.Role_changeName_notSource);
			return;
		}
		
		if(!checkAndCostChangeName())
			return;
		
		//TODO:屏蔽字
		
		long playerID=me.role.playerID;
		
		me.addMainFunc(()->
		{
			GameC.main.changePlayerName(playerID,name);
		});
	}
	
	/** 改名后 */
	public void onChangeName(String name)
	{
		this.name=name;
		
		me.send(ChangeRoleNameRequest.create(name));
		
		refreshPartRoleShowData(RoleShowDataPartType.Name,name);
	}
	
	/** 检查并消耗改名 */
	protected boolean checkAndCostChangeName()
	{
		return true;
	}
	
	/** 添加货币上限值 */
	public void addCurrencyMax(int type,long value)
	{
		_currenciesMax[type]+=value;
	}
	
	/** 减少货币上限值 */
	public void subCurrencyMax(int type,long value)
	{
		_currenciesMax[type]-=value;
	}
	
	/** 货币是否到达上限 */
	public boolean isCurrencyMax(int type)
	{
		long max;
		return (max=_currenciesMax[type])>0 && _d.currencies[type]>=max;
	}
	
	/** 添加货币(只能加不能减) */
	public void addCurrency(int type,long value,int way)
	{
		addCurrency(type,value,way,false);
	}
	
	/** 添加货币(只能加不能减) */
	public void addCurrencyAbs(int type,long value,int way)
	{
		addCurrency(type,value,way,true);
	}
	
	/** 添加货币(只能加不能减) */
	public void addCurrency(int type,long value,int way,boolean isAbs)
	{
		if(value<=0)
			return;

		long now=_d.currencies[type];
		
		if(!isAbs || !CurrencyConfig.get(type).canOverMaxByAbs)
		{
			long max;
			if((max=_currenciesMax[type])>0)
			{
				//达到上限
				if(now>=max)
				{
					return;
				}
				
				//本次可加值
				if(now+value>=max)
				{
					value=max-now;
				}
			}
		}

		now=(_d.currencies[type]+=value);
		
		me.send(RefreshCurrencyRequest.create(type,now));
		
		toLogAddCurrency(type,value,way);
		
		//需要增加记录
		if(CurrencyConfig.get(type).needAddRecord)
		{
			int v2=(int)(_d.totalAddCurrencies[type]+=value);
			
			me.quest.taskEvent(TaskType.TotalAddCurrency,type,v2);
		}
		
		onAddCurrency(type,value);
	}
	
	/** 是否拥有货币组 */
	public boolean hasCurrencies(DIntData[] list)
	{
		return hasCurrencies(list,1);
	}
	
	/** 是否拥有货币组,num次 */
	public boolean hasCurrencies(DIntData[] list,int num)
	{
		for(DIntData v:list)
		{
			if(!hasCurrency(v.key,v.value*num))
				return false;
		}
		
		return true;
	}
	
	/** 添加货币组 */
	public void addCurrencies(DIntData[] list,int way)
	{
		for(DIntData v:list)
		{
			addCurrency(v.key,v.value,way);
		}
	}
	
	/** 添加货币组(突破上限) */
	public void addCurrenciesAbs(DIntData[] list,int num,int way)
	{
		for(DIntData v:list)
		{
			addCurrency(v.key,v.value*num,way,true);
		}
	}
	
	/** 是否有足够货币 */
	public boolean hasCurrency(int type,long value)
	{
		if(value<0)
			return false;
		
		return _d.currencies[type] >= value;
	}
	
	/** 获取货币 */
	public long getCurrency(int type)
	{
		return _d.currencies[type];
	}
	
	/** 消耗货币 */
	public void costCurrency(int type,long value,int way)
	{
		if(value<=0)
			return;
		
		long[] currencies;
		
		long v=(currencies=_d.currencies)[type];
		
		if((v-=value)<0)
		{
			value=v;
			v=0;
		}
		
		currencies[type]=v;
		
		me.send(RefreshCurrencyRequest.create(type,v));
		
		toLogCostCurrency(type,value,way);
		
		if(CurrencyConfig.get(type).needAddRecord)
		{
			me.quest.taskEvent(TaskType.TotalCostCurrency,type,(int)(_d.totalAddCurrencies[type]-_d.currencies[type]));
		}
		
		onCostCurrency(type,value);
	}
	
	/** 消耗货币组 */
	public boolean costCurrencies(DIntData[] list,int way)
	{
		if(!hasCurrencies(list))
			return false;
		
		for(DIntData v:list)
		{
			costCurrency(v.key,v.value,way);
		}
		
		return true;
	}
	
	/** 添加货币日志(可复写做过滤) */
	protected void toLogAddCurrency(int type,long value,int way)
	{
		GameC.log.playerAddCurrency(me,type,value,way);
	}
	
	/** 消耗货币记录(可复写做过滤) */
	protected void toLogCostCurrency(int type,long value,int way)
	{
		GameC.log.playerCostCurrency(me,type,value,way);
	}
	
	/** 添加货币接口 */
	protected void onAddCurrency(int type,long value)
	{
	
	}
	
	/** 添加货币接口 */
	protected void onCostCurrency(int type,long value)
	{
	
	}
	
	/** 充值 */
	public void chargeCash(int value,int way)
	{
		addCurrency(CurrencyType.Cash,value,way);
	}
	
	/** 刷新部分外显数据(int) */
	public void refreshPartRoleShowData(int type,int value)
	{
		RoleShowChangeData data=new RoleShowChangeData();
		data.type=type;
		data.arg0=value;
		
		refreshPartRoleShowData(data);
	}
	
	/** 刷新部分外显数据(String) */
	public void refreshPartRoleShowData(int type,String value)
	{
		RoleShowChangeData data=new RoleShowChangeData();
		data.type=type;
		data.arg1=value;
		
		refreshPartRoleShowData(data);
	}
	
	/** 刷新部分外显数据(long) */
	public void refreshPartRoleShowDataForLong(int type,long value)
	{
		RoleShowChangeData data=new RoleShowChangeData();
		data.type=type;
		data.arg2=value;
		
		refreshPartRoleShowData(data);
	}
	
	/** 刷新部分外显数据(long+string) */
	public void refreshPartRoleShowData(int type,long v1,String v2)
	{
		RoleShowChangeData data=new RoleShowChangeData();
		data.type=type;
		data.arg2=v1;
		data.arg1=v2;
		
		refreshPartRoleShowData(data);
	}
	
	/** 刷新部分外显数据 */
	public void refreshPartRoleShowData(RoleShowChangeData data)
	{
		//不在线
		if(!me.system.isStateOnline())
			return;
		
		//先改自己的
		_selfRoleShowData.onChange(data);
		
		//场景部分
		Unit unit;
		
		if((unit=me.scene.getUnit())!=null)
		{
			//非社交部分
			if(!RoleShowDataPartTypeConfig.get(data.type).isSocialPart)
			{
				RoleShowData roleShowData=unit.getUnitData().getCharacterIdentity().roleShowData;
				
				roleShowData.onChange(data);
				
				CharacterRefreshPartRoleShowDataRequest request=CharacterRefreshPartRoleShowDataRequest.create(unit.instanceID,data);
				//包括推送自己
				unit.radioMessage(request,true);
			}
		}
		
		//社交部分
		me.social.refreshRoleSocialData(data);
	}
	
	/** 申请绑定平台 */
	public void applyBindPlatform(String uid,String platform)
	{
		//不是游客
		if(!CommonSetting.UserNeedMultiPlatformBind && !this.platform.equals(PlatformType.Visitor))
		{
			me.warningInfoCode(InfoCodeType.Role_bindPlatform_notTourist);
			return;
		}
		
		ClientApplyBindPlatformToLoginServerRequest.create(this.playerID,this.userID,uid,platform).sendByUID(uid);
	}
	
	/** 绑定平台 */
	public void onBindPlatform(String uid,String platform)
	{
		//单一绑定
		if(!CommonSetting.UserNeedMultiPlatformBind)
		{
			this.platform=platform;
			this.uid=uid;
		}
		
		//通知客户端
		me.send(SendBindPlatformRequest.create(uid,platform));
	}
	
	/** 战斗力变化 */
	public void fightForceModified()
	{
		_fightForceModified=true;
	}
	
	/** 战斗力变化后 */
	public void onFightForceChange(long oldValue)
	{
	
	}
	
	/** 检查角色条件一组 */
	public boolean checkRoleConditions(int[][] args,boolean needNotice)
	{
		for(int[] v : args)
		{
			if(!checkOneRoleCondition(v,needNotice))
			{
				return false;
			}
		}
		
		return true;
	}
	
	/** 检查单个角色条件 */
	public boolean checkOneRoleCondition(int[] args,boolean needNotice)
	{
		switch(args[0])
		{
			case RoleConditionType.Level:
			{
				if(me.role.getLevel()<args[1])
				{
					if(needNotice)
						me.sendInfoCode(InfoCodeType.Condition_needLevel);
					
					return false;
				}
			}
				break;
			case RoleConditionType.FunctionOpen:
			{
				if(!me.func.isFunctionOpen(args[1]))
				{
					if(needNotice)
						me.sendInfoCode(InfoCodeType.Condition_functionNotOpen,FunctionConfig.get(args[1]).showName);
					
					return false;
				}
			}
				break;
			case RoleConditionType.NeedUnion:
			{
				if(!me.union.hasUnion())
				{
					if(needNotice)
						me.sendInfoCode(InfoCodeType.Condition_needUnion);
					
					return false;
				}
			}
				break;
			case RoleConditionType.QuestComplete:
			{
				if(!me.quest.isQuestComplete(args[1]))
				{
					if(needNotice)
						me.sendInfoCode(InfoCodeType.Condition_needCompleteQuest,QuestConfig.get(args[1]).name);
					
					return false;
				}
			}
				break;
			case RoleConditionType.OnStatus:
			{
				if(!me.character.getCurrentCharacterUseLogic().getFightLogic().status.getStatus(args[1]))
				{
					
					return false;
				}
			}
				break;
			case RoleConditionType.OffStatus:
			{
				if(me.character.getCurrentCharacterUseLogic().getFightLogic().status.getStatus(args[1]))
				{
					
					return false;
				}
			}
				break;
		}
		
		return true;
	}
	
	public void doRoleActions(int[][] actions,int num,int way)
	{
		for(int[] arg:actions)
		{
			doOneRoleAction(arg,num,way);
		}
	}
	
	/** 执行单个动作 */
	public void doOneRoleAction(int[] args,int num,int way)
	{
		switch(args[0])
		{
			case RoleActionType.HeroAddAttribute:
			{
				CharacterUseLogic logic;
				
				if((logic=me.character.getCurrentCharacterUseLogic())!=null)
				{
					logic.getAttributeLogic().addOneAttribute(args[1],args[2]*num);
				}
			}
				break;
			case RoleActionType.HeroAddAttributeVar:
			{
				CharacterUseLogic logic;
				
				if((logic=me.character.getCurrentCharacterUseLogic())!=null)
				{
					logic.getAttributeLogic().addOneAttribute(args[1],logic.getFightLogic().getSkillVarValue(args[2])*num);
				}
			}
				break;
			case RoleActionType.HeroAddBuff:
			{
				CharacterUseLogic logic;
				
				if((logic=me.character.getCurrentCharacterUseLogic())!=null)
				{
					logic.getBuffLogic().addBuff(args[1],args[2]);//buff只加一次
				}
			}
				break;
			case RoleActionType.AddCurrency:
			{
				me.role.addCurrency(args[1],args[2]*num,way);
			}
				break;
			case RoleActionType.AddReward:
			{
				for(int i=0;i<num;++i)
				{
					me.bag.addReward(args[1],way);
				}
			}
				break;
			case RoleActionType.RemoveItem:
			{
				//通过物品id和数量移除道具
				me.bag.removeItem(args[1],args[2]*num,way);
			}
				break;
		}
	}
	
	/** 执行单个道具物品动作 */
	public boolean checkOneRoleConditionForAction(int[] args,int num)
	{
		switch(args[0])
		{
			case RoleActionType.AddReward:
			{
				RewardConfig rewardConfig=RewardConfig.get(args[1]);
				//只看空余格子
				return me.bag.hasFreeGrid(rewardConfig.needGrid*num);
			}
		}
		
		return true;
	}
	
}
