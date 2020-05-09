package com.home.commonGame.part.player.part;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.config.game.ChatChannelConfig;
import com.home.commonBase.constlist.generate.CallWayType;
import com.home.commonBase.constlist.generate.ChatChannelType;
import com.home.commonBase.constlist.generate.ChatType;
import com.home.commonBase.constlist.generate.InfoCodeType;
import com.home.commonBase.constlist.generate.RoleShowDataPartType;
import com.home.commonBase.data.login.PlayerLoginToEachGameData;
import com.home.commonBase.data.login.PlayerSwitchGameData;
import com.home.commonBase.data.login.RePlayerLoginFromEachGameData;
import com.home.commonBase.data.role.RoleShowChangeData;
import com.home.commonBase.data.social.QueryPlayerAWData;
import com.home.commonBase.data.social.ReGetRoleSocialDataWData;
import com.home.commonBase.data.social.ReQueryPlayerOWData;
import com.home.commonBase.data.social.RefreshPartRoleShowDataWData;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonBase.data.social.base.QueryPlayerResultData;
import com.home.commonBase.data.social.chat.ChatChannelData;
import com.home.commonBase.data.social.chat.ChatData;
import com.home.commonBase.data.social.chat.RoleChatData;
import com.home.commonBase.data.social.chat.SendPlayerChatOWData;
import com.home.commonBase.data.social.friend.ContactData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.global.CommonSetting;
import com.home.commonBase.part.player.clientData.SocialClientPartData;
import com.home.commonBase.part.player.data.SocialPartData;
import com.home.commonBase.scene.base.Unit;
import com.home.commonBase.utils.BaseGameUtils;
import com.home.commonGame.constlist.social.GetRoleSocialDataType;
import com.home.commonGame.control.LogicExecutor;
import com.home.commonGame.global.GameC;
import com.home.commonGame.logic.team.PlayerTeam;
import com.home.commonGame.logic.union.PlayerUnion;
import com.home.commonGame.net.request.social.ReQueryPlayerRequest;
import com.home.commonGame.net.request.social.ReSearchPlayerRequest;
import com.home.commonGame.net.request.social.ReUpdateRoleSocialDataOneRequest;
import com.home.commonGame.net.request.social.ReUpdateRoleSocialDataRequest;
import com.home.commonGame.net.request.social.chat.SendPlayerChatRequest;
import com.home.commonGame.net.serverRequest.center.func.social.FuncGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest;
import com.home.commonGame.net.serverRequest.center.social.CommitRoleSocialToCenterServerRequest;
import com.home.commonGame.net.serverRequest.center.social.RefreshRoleSocialToCenterServerRequest;
import com.home.commonGame.net.serverRequest.game.social.RadioPlayerChatToGameServerRequest;
import com.home.commonGame.net.serverRequest.game.social.RefreshRoleShowToSourceGameServerRequest;
import com.home.commonGame.part.player.Player;
import com.home.commonGame.part.player.base.PlayerBasePart;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.dataEx.VObj;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.LongIntMap;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.collection.LongSet;
import com.home.shine.support.collection.SList;
import com.home.shine.support.collection.SQueue;
import com.home.shine.support.func.ObjectCall;
import com.home.shine.support.func.ObjectCall2;
import com.home.shine.support.func.ObjectFunc2;
import com.home.shine.utils.TimeUtils;

/** 社交(generated by shine) */
public class SocialPart extends PlayerBasePart
{
	/** 数据 */
	private SocialPartData _d;
	
	/** 是否需要中心服社交数据(center传递用)(团体部分) */
	private boolean _needSocialForCenter;
	
	/** 角色社交数据(自己需要的所有角色社交数据)(不存库) */
	private LongObjectMap<RoleSocialData> _roleSocialDic=new LongObjectMap<>(RoleSocialData[]::new);
	
	/** 被联系人统计组 */
	private LongIntMap _beContactCountDic=new LongIntMap();
	
	/** 注册的获取角色社交数据回调字典 */
	private IntObjectMap<ObjectCall<ReGetRoleSocialDataWData>> _reGetRoleSocialFuncDic=new IntObjectMap<>();
	
	/** 注册的被查询角色数据回调字典(构造数据返回) */
	private IntObjectMap<ObjectFunc2<QueryPlayerResultData,QueryPlayerAWData>> _queryPlayerFuncDic=new IntObjectMap<>();
	
	/** 注册的查询角色数据回调字典(接收返回数据) */
	private IntObjectMap<ObjectCall<QueryPlayerResultData>> _reQueryPlayerFuncDic=new IntObjectMap<>();
	
	/** 多频道组 */
	private IntObjectMap<LongObjectMap<ChatChannelData>> _multiChannels;
	
	/** 单一频道组 */
	private IntObjectMap<ChatChannelData> _singleChannels;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(SocialPartData)data;
	}
	
	/** 获取数据 */
	public SocialPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new SocialPartData();
	}
	
	@Override
	protected BaseClientPartData createClientData()
	{
		return new SocialClientPartData();
	}
	
	/** 写客户端数据(copyServer过后的) */
	@Override
	protected void writeClientData(BaseClientPartData data)
	{
		toWriteClientData((SocialClientPartData)data);
	}
	
	/** 写客户端数据具体执行(已执行过copyServer了,就是说CPO中与SPO同名同类型的属性无需再赋值) */
	private void toWriteClientData(SocialClientPartData data)
	{
		
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		me.social.registReGetRoleSocialDataFunc(GetRoleSocialDataType.SearchPlayer,this::onReGetRoleSocialDataForAddSearchPlayer);
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
		_roleSocialDic.clear();
		_beContactCountDic.clear();
		_needSocialForCenter=false;
		
		_multiChannels=null;
		_singleChannels=null;
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		_multiChannels=_d.multiChannels;
		_singleChannels=_d.singleChannels;
	}
	
	/** 新创建时(该主对象在服务器上第一次被创建时的动作(一生只一次),(只对数据赋值就好,自定义数据构造的部分写到afterReadData里,因为这个完事儿就会回调到)) */
	@Override
	public void onNewCreate()
	{
		
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
	
	@Override
	public void beforeLoginForEachGame(RePlayerLoginFromEachGameData data)
	{
		//更新社交数据
		data.roleSocialDatas.forEach((k,v)->
		{
			addPlayerRoleSocial(k,v);
		});
	}
	
	@Override
	public void beforeLoginOnMain()
	{
	
	}
	
	@Override
	public void onLogoutOnMain()
	{
	
	}
	
	@Override
	public void onLogin()
	{
		//目前登录的时候也发一次,center的依旧暂时不推送
		RoleShowChangeData cData=new RoleShowChangeData();
		cData.type=RoleShowDataPartType.IsOnline;
		cData.arg0=1;
		cData.arg2=-1;
		refreshRoleSocialData(cData);
	}
	
	@Override
	public void onLogout()
	{
		RoleShowChangeData cData=new RoleShowChangeData();
		cData.type=RoleShowDataPartType.IsOnline;
		cData.arg0=0;
		cData.arg2=me.system.getLastOnlineTime();
		refreshRoleSocialData(cData);
	}
	
	@Override
	public void writeSwitchData(PlayerSwitchGameData data)
	{
		data.needPlayerRoleShowForCenter=_needSocialForCenter;
		data.roleSocialDatas=_roleSocialDic;
	}
	
	@Override
	public void readSwitchData(PlayerSwitchGameData data)
	{
		_needSocialForCenter=data.needPlayerRoleShowForCenter;
		
		RoleSocialData[] values;
		RoleSocialData v;
		
		for(int i=(values=data.roleSocialDatas.getValues()).length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				addPlayerRoleSocial(v.showData.playerID,v);
			}
		}
	}
	
	@Override
	public void makeLoginEachGameData(PlayerLoginToEachGameData data)
	{
		data.selfData=createRoleSocialData();
	}
	
	@Override
	public void onDaily()
	{
		doChatCheck(this::checkChatTimeOutOne);
	}
	
	/** 创建角色社交数据(主线程/池线程) */
	public RoleSocialData createRoleSocialData()
	{
		RoleSocialData re=BaseC.factory.createRoleSocialData();
		makeRoleSocialData(re);
		return re;
	}
	
	/** 创建联系人数据 */
	public ContactData createContactData()
	{
		ContactData re=BaseC.factory.createContactData();
		re.playerID=me.role.playerID;
		re.data=createRoleSocialData();
		return re;
	}
	
	/** 构造角色社交数据 */
	public void makeRoleSocialData(RoleSocialData data)
	{
		if(data.showData!=null)
		{
			me.role.makeRoleShowData(data.showData);
		}
		else
		{
			data.showData=me.role.createRoleShowData();
		}
		
		data.isOnline=me.system.isStateOnlineOrLogining();
		data.lastOnlineTime=me.system.getLastOnlineTime();
		
		if(CommonSetting.needSyncRoleSocialSceneLocation)
		{
			data.location=me.scene.createCurrentLocationData();
		}
	}
	
	/** 添加角色社交数据 */
	public RoleSocialData addPlayerRoleSocial(long playerID,RoleSocialData data)
	{
		RoleSocialData oldData;
		
		if((oldData=_roleSocialDic.get(playerID))!=null)
		{
			oldData.copy(data);
			return oldData;
		}
		else
		{
			_roleSocialDic.put(playerID,data);
			return data;
		}
	}
	
	/** 移除角色社交数据 */
	public void removePlayerRoleSocial(long playerID)
	{
		_roleSocialDic.remove(playerID);
	}
	
	/** 添加被联系引用计数 */
	public void addBeContactCount(long playerID)
	{
		_beContactCountDic.addValue(playerID,1);
	}
	
	/** 添加被联系引用计数组 */
	public void addBeContactCountList(LongSet dic)
	{
		dic.forEachA(k->
		{
			addBeContactCount(k);
		});
	}
	
	/** 减少被联系引用计数 */
	public void minusBeContactCount(long playerID)
	{
		_beContactCountDic.addValue(playerID,-1);
	}
	
	/** 更新社交部分角色显示数据(自身) */
	public void refreshRoleSocialData(RoleShowChangeData data)
	{
		long playerID=me.role.playerID;
		
		//先处理玩家对玩家
		if(!_beContactCountDic.isEmpty())
		{
			LongSet sendDic=_beContactCountDic.getKeySet();
			
			//在线事务
			RefreshPartRoleShowDataWData wData=new RefreshPartRoleShowDataWData();
			wData.playerID=playerID;
			wData.data=data;
			
			me.addPlayerListOnlineWork(sendDic,wData);
		}
		
		//角色主线程(只在线有效)
		me.addMainFunc(()->
		{
			GameC.global.social.refreshRoleSocialDataOnline(playerID,data);
		});
		
		//本服
		if(!me.isCurrentGame())
		{
			////发回源服
			RefreshRoleShowToSourceGameServerRequest.create(playerID,data).send(me.role.sourceGameID);
		}
		
		if(_needSocialForCenter)
		{
			RefreshRoleSocialToCenterServerRequest.create(playerID,data).send();
		}
		
		me.func.refreshRoleSocialData(data);
	}
	
	/** 提交角色社交数据到中心服(每个可能新增center社交数据的,都需要调用) */
	public void commitRoleSocialForCenter()
	{
		if(_needSocialForCenter)
			return;
		
		_needSocialForCenter=true;
		
		CommitRoleSocialToCenterServerRequest.create(me.role.playerID,createRoleSocialData()).send();
	}
	
	/** 提交角色社交数据到中心服(每个可能新增center社交数据的,都需要调用) */
	public void commitRoleSocialForCenter(RoleSocialData data)
	{
		if(_needSocialForCenter)
			return;
		
		_needSocialForCenter=true;
		
		CommitRoleSocialToCenterServerRequest.create(me.role.playerID,data).send();
	}
	
	/** 中心服移除了社交数据 */
	public void onCenterRemoveSocial()
	{
		_needSocialForCenter=false;
	}
	
	/** 更新角色显示数据 */
	public void onRefreshPartRoleSocial(long playerID,RoleShowChangeData data)
	{
		RoleSocialData sData=_roleSocialDic.get(playerID);
		
		if(sData==null)
		{
			me.warnLog("更新角色显示数据时,找不到角色",playerID);
			return;
		}
		
		sData.onChange(data);
		
		//无需推送,等待客户端获取
		if(CommonSetting.needUpdateSocialDataImmediately)
		{
			me.send(ReUpdateRoleSocialDataOneRequest.create(sData));
		}
		else
		{
			//标记脏
			sData.dirty=true;
		}
	}
	
	/** 注册某类型的角色社交数据回调(construct阶段用) */
	public void registReGetRoleSocialDataFunc(int type,ObjectCall<ReGetRoleSocialDataWData> func)
	{
		_reGetRoleSocialFuncDic.put(type,func);
	}
	
	/** 注册某类型的查询角色回调(构造数据返回)(construct阶段用) */
	public void registQueryPlayerFunc(int type,ObjectFunc2<QueryPlayerResultData,QueryPlayerAWData> func)
	{
		_queryPlayerFuncDic.put(type,func);
	}
	
	/** 注册某类型的查询角色接收回调(接收返回数据)(construct阶段用) */
	public void registReQueryPlayerFunc(int type,ObjectCall<QueryPlayerResultData> func)
	{
		_reQueryPlayerFuncDic.put(type,func);
	}
	
	/** 获取其他角色的社交数据(返回时，源角色使用在线事务)(返回的社交数据为新实例) */
	public void getAbsPlayerRoleSocialData(long playerID,int type)
	{
		LogicExecutor executor=me.getExecutor();
		
		//先看当前线程
		if(executor!=null)
		{
			Player player=executor.getPlayer(playerID);
			
			if(player!=null)
			{
				ReGetRoleSocialDataWData rData=new ReGetRoleSocialDataWData();
				rData.playerID=playerID;
				rData.type=type;
				rData.data=player.social.createRoleSocialData();
				
				me.system.executeWork(rData);
				return;
			}
		}
		
		long fromPlayerID=me.role.playerID;
		
		me.addMainFunc(()->
		{
			GameC.global.social.doGetAbsPlayerRoleSocialDataFromPlayer(fromPlayerID,playerID,type);
		});
	}
	
	/** 收到获取角色社交数据返回 */
	public void onReGetRoleSocialData(ReGetRoleSocialDataWData wData)
	{
		ObjectCall<ReGetRoleSocialDataWData> func=_reGetRoleSocialFuncDic.get(wData.type);
		
		if(func==null)
		{
			Ctrl.throwError("未找到收到获取角色社交数据返回回调",wData.type);
			return;
		}
		
		func.apply(wData);
	}
	
	/** 是否是客户端查询角色类型(需复写补充类型) */
	public boolean isClientQueryPlayer(int type)
	{
		return false;
	}
	
	/** 执行查询角色 */
	private void doQueryPlayer(long playerID,int type,int[] args)
	{
		QueryPlayerAWData data=new QueryPlayerAWData();
		data.sendPlayerID=me.role.playerID;
		data.type=type;
		data.args=args;
		
		me.addPlayerAbsWork(playerID,data);
	}
	
	/** 查询角色数据(服务器用)(返回时，源角色使用在线事务) */
	public void queryPlayer(long playerID,int type)
	{
		queryPlayer(playerID,type,null);
	}
	
	/** 查询角色数据(服务器用)(返回时，源角色使用在线事务) */
	public void queryPlayer(long playerID,int type,int[] args)
	{
		if(isClientQueryPlayer(type))
		{
			me.errorLog("queryPlayer时,不是服务器查询类型:"+type);
			return;
		}
		
		doQueryPlayer(playerID,type,args);
	}
	
	/** 客户端查询角色 */
	public void clientQueryPlayer(long playerID,int type,int[] args)
	{
		if(!isClientQueryPlayer(type))
		{
			me.errorLog("queryPlayer时,不是客户端查询类型:"+type);
			return;
		}
		
		doQueryPlayer(playerID,type,args);
	}
	
	/** 接收到查询角色事务 */
	public void onQueryPlayer(QueryPlayerAWData data)
	{
		ObjectFunc2<QueryPlayerResultData,QueryPlayerAWData> func=_queryPlayerFuncDic.get(data.type);
		
		if(func==null)
		{
			me.errorLog("接收到查询角色事务时,未注册事务类型:"+data.type);
			return;
		}
		
		QueryPlayerResultData reData=func.apply(data);
		reData.queryPlayerID=me.role.playerID;
		reData.queryType=data.type;
		reData.queryArgs=data.args;
		reData.isSuccess=true;
		
		ReQueryPlayerOWData wData=new ReQueryPlayerOWData();
		wData.result=reData;
		
		me.addPlayerOnlineWork(data.sendPlayerID,wData);
	}
	
	/** 接收到查询角色事务结果 */
	public void onQueryPlayerResult(QueryPlayerResultData result)
	{
		//客户端查询类型
		if(isClientQueryPlayer(result.queryType))
		{
			me.send(ReQueryPlayerRequest.create(result));
		}
		else
		{
			ObjectCall<QueryPlayerResultData> func=_reQueryPlayerFuncDic.get(result.queryType);
			
			if(func==null)
			{
				me.errorLog("接收到查询角色事务结果时,未注册事务类型:"+result.queryType);
				return;
			}
			
			func.apply(result);
		}
	}
	
	/** 更新角色社交数据列表 */
	public void onUpdateRoleSocialDataList()
	{
		VObj<LongObjectMap<RoleSocialData>> reDic=new VObj<>();
		
		_roleSocialDic.forEach((k,v)->
		{
			if(v.dirty)
			{
				v.dirty=false;
				
				if(reDic.value==null)
				{
					reDic.value=new LongObjectMap<>(RoleSocialData[]::new);
				}
				
				reDic.value.put(k,v);
			}
		});
		
		if(reDic.value!=null)
		{
			me.send(ReUpdateRoleSocialDataRequest.create(reDic.value));
		}
	}
	
	/** 搜索玩家 */
	public void searchPlayer(long playerID)
	{
		if(playerID==me.role.playerID)
		{
			return;
		}
		
		//各种验证
		me.social.getAbsPlayerRoleSocialData(playerID,GetRoleSocialDataType.SearchPlayer);
	}
	
	/** 搜索玩家结果(需要被复写) */
	protected void onReGetRoleSocialDataForAddSearchPlayer(ReGetRoleSocialDataWData wData)
	{
		//没有找到
		if(wData.data==null)
		{
			return;
		}
		
		ContactData cData=BaseC.factory.createContactData();
		
		cData.playerID=wData.playerID;
		cData.data=wData.data;
		
		me.send(ReSearchPlayerRequest.create(cData));
	}
	
	/** 获取一组随机角色列表从中心服角色缓存池 */
	public void getRandomPlayerListFromRoleSocialPoolToCenter(int funcID,int len,int arg)
	{
		FuncGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest.create(me.role.playerID,funcID,len,arg).send();
	}
	
	/** 收到获取角色列表从中心服的回复(池线程) */
	public void onReGetRandomPlayerListFromRoleSocialPoolFromCenter(int funcID,SList<RoleSocialData> list,int arg)
	{
		//TODO:g层派生书写逻辑
	}
	
	/** 获取聊天频道数据 */
	protected ChatChannelData getChatChannelData(int channel,long key)
	{
		ChatChannelConfig config=ChatChannelConfig.get(channel);
		
		ChatChannelData re;
		
		if(config.isMulti)
		{
			LongObjectMap<ChatChannelData> dic=_multiChannels.get(channel);
			
			if(dic==null)
			{
				_multiChannels.put(channel,dic=new LongObjectMap<>());
			}
			
			if((re=dic.get(key))==null)
			{
				dic.put(key,re=new ChatChannelData());
				re.initDefault();
			}
		}
		else
		{
			if((re=_singleChannels.get(channel))==null)
			{
				_singleChannels.put(channel,re=new ChatChannelData());
				re.initDefault();
			}
		}
		
		return re;
	}
	
	/** 聊天 */
	public void chat(ChatData data,int channel,long key)
	{
		ChatChannelConfig config=ChatChannelConfig.get(channel);
		
		//条件不满足
		if(!me.role.checkRoleConditions(config.useConditions,true))
		{
			me.warningInfoCode(InfoCodeType.Chat_conditionNotMet,channel);
			return;
		}
		
		ChatChannelData cData=getChatChannelData(channel,key);
		
		long now=me.getTimeMillis();
		
		if(config.cd>0 && (cData.lastChatTime+config.cd>now))
		{
			me.warningInfoCode(InfoCodeType.Chat_inCD,channel);
			return;
		}
		
		if(config.costID>0 && !me.bag.hasCost(config.costID))
		{
			me.warningInfoCode(InfoCodeType.Chat_costNotEnough,channel);
			return;
		}
		
		//文字
		if(data.type==ChatType.Text && BaseGameUtils.hasSensitiveWord(data.text))
		{
			me.warningInfoCode(InfoCodeType.Chat_sensitive,data.text);
			return;
		}
		
		if(config.cd>0)
			cData.lastChatTime=now;
		
		if(config.costID>0)
			me.bag.doCost(config.costID,CallWayType.Chat);
		
		//处理
		
		RoleChatData rData=new RoleChatData();
		rData.chatData=data;
		rData.showData=me.role.createRoleSimpleShowData();
		rData.time=now;
		
		doSendChat(rData,config,key);
	}
	
	protected void doSendChat(RoleChatData rData,ChatChannelConfig config,long key)
	{
		int channel=config.id;
		
		switch(channel)
		{
			case ChatChannelType.Near:
			{
				Unit unit=me.scene.getUnit();
				
				if(unit==null)
				{
					me.warningInfoCode(InfoCodeType.NearChat_canNotFindUnit);
					return;
				}
				
				//广播消息
				unit.radioMessage(SendPlayerChatRequest.create(rData,channel,key),true);
			}
			break;
			case ChatChannelType.Whisper:
			{
				SendPlayerChatOWData wData=new SendPlayerChatOWData();
				wData.chatData=rData;
				wData.channel=channel;
				wData.key=me.role.playerID;
				
				//直接离线事务
				me.addPlayerOfflineWork(key,wData);
			}
			break;
			case ChatChannelType.World:
			{
				me.addMainFunc(()->
				{
					//本服
					GameC.logic.sendChatToAllPlayer(rData,channel);
					//其他服
					GameC.server.radioGames(RadioPlayerChatToGameServerRequest.create(rData,channel));
				});
			}
			break;
			case ChatChannelType.Area:
			{
				me.addMainFunc(()->
				{
					GameC.logic.sendChatToAllPlayer(rData,channel);
				});
			}
			break;
			case ChatChannelType.Team:
			{
				PlayerTeam team=me.team.getTeam();
				
				if(team==null)
				{
					me.warningInfoCode(InfoCodeType.TeamChat_noTeam);
					return;
				}
				
				team.playerChat(rData,channel,config.offlineReceive);
			}
			break;
			case ChatChannelType.Union:
			{
				PlayerUnion union=me.union.getUnion();
				
				if(union==null)
				{
					me.warningInfoCode(InfoCodeType.UnionChat_noUnion);
					return;
				}
				
				union.playerChat(rData,channel,config.offlineReceive);
			}
			break;
		}
	}
	
	/** 检查是否可接受 */
	protected boolean checkNeedReceive(RoleChatData chatData,int channel,long key)
	{
		switch(channel)
		{
			case ChatChannelType.Team:
			{
				//队伍已不存在
				if(!me.team.hasTeam())
					return false;
			}
				break;
			case ChatChannelType.Union:
			{
				//工会已不存在
				if(!me.union.hasUnion())
					return false;
			}
				break;
		}
		
		return true;
	}
	
	/** 收到聊天内容 */
	public void onReceiveChat(RoleChatData chatData,int channel,long key)
	{
		//不需要接收的
		if(!checkNeedReceive(chatData,channel,key))
			return;
		
		ChatChannelConfig config=ChatChannelConfig.get(channel);
		
		//离线接收
		if(config.offlineReceive)
		{
			chatData.sendIndex=++_d.chatSendIndex;
			
			ChatChannelData cData=getChatChannelData(channel,key);
			
			cData.queue.offer(chatData);
			
			if(config.keepNum>0 && cData.queue.size()>config.keepNum)
			{
				cData.queue.poll();
			}
		}
		
		//如在线
		if(me.system.isStateOnline())
		{
			me.send(SendPlayerChatRequest.create(chatData,channel,key));
		}
	}
	
	private void doChatCheck(ObjectCall2<ChatChannelData,ChatChannelConfig> func)
	{
		if(!_multiChannels.isEmpty())
		{
			_multiChannels.forEach((k,v)->
			{
				if(v!=null)
				{
					ChatChannelConfig config=ChatChannelConfig.get(k);
					
					if(config.offlineReceive)
					{
						v.forEachValue(v2->
						{
							func.apply(v2,config);
						});
					}
				}
			});
		}
		
		if(!_singleChannels.isEmpty())
		{
			_singleChannels.forEach((k,v)->
			{
				if(v!=null)
				{
					ChatChannelConfig config=ChatChannelConfig.get(k);
					
					if(config.offlineReceive)
					{
						func.apply(v,config);
					}
				}
			});
		}
	}
	
	/** 检查聊天超时 */
	private void checkChatTimeOutOne(ChatChannelData cData,ChatChannelConfig config)
	{
		SQueue<RoleChatData> queue=cData.queue;
		
		if(!queue.isEmpty())
		{
			long removeTime=me.getTimeMillis()-(config.keepHour*TimeUtils.hourTime);
			
			while(true)
			{
				RoleChatData head=queue.peek();
				
				if(head==null)
					break;
				
				if(head.time>removeTime)
					break;
				
				queue.poll();
			}
		}
	}
	
	/** 接收聊天序号 */
	public void onChatReceiveIndex(int receiveIndex)
	{
		doChatCheck((cData,config)->
		{
			SQueue<RoleChatData> queue=cData.queue;
			
			if(!queue.isEmpty())
			{
				while(true)
				{
					RoleChatData head=queue.peek();
					
					if(head==null)
						break;
					
					if(head.sendIndex>receiveIndex)
						break;
					
					queue.poll();
				}
			}
		});
	}
	
	/** 清空聊天频道 */
	public void clearChatChannel(int channel)
	{
		ChatChannelConfig config=ChatChannelConfig.get(channel);
		
		if(config.isMulti)
		{
			_multiChannels.remove(channel);
		}
		else
		{
			_singleChannels.remove(channel);
		}
	}
	
}
