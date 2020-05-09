package com.home.commonGame.part.player.part;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.config.game.QuestConfig;
import com.home.commonBase.config.game.TaskConfig;
import com.home.commonBase.config.game.enumT.TaskTypeConfig;
import com.home.commonBase.constlist.generate.CallWayType;
import com.home.commonBase.constlist.generate.FunctionType;
import com.home.commonBase.constlist.generate.InfoCodeType;
import com.home.commonBase.constlist.generate.QuestCommitType;
import com.home.commonBase.constlist.generate.QuestExecuteType;
import com.home.commonBase.constlist.generate.QuestRepeatType;
import com.home.commonBase.constlist.generate.TaskType;
import com.home.commonBase.constlist.system.PartCallPhaseType;
import com.home.commonBase.data.quest.QuestCompleteData;
import com.home.commonBase.data.quest.QuestData;
import com.home.commonBase.data.quest.TaskData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.global.Global;
import com.home.commonBase.part.player.clientData.QuestClientPartData;
import com.home.commonBase.part.player.data.QuestPartData;
import com.home.commonBase.scene.base.Region;
import com.home.commonBase.scene.base.Unit;
import com.home.commonGame.control.LogicExecutor;
import com.home.commonGame.net.request.quest.RefreshTaskRequest;
import com.home.commonGame.net.request.quest.SendAcceptQuestRequest;
import com.home.commonGame.net.request.quest.SendClearAllQuestByGMRequest;
import com.home.commonGame.net.request.quest.SendCommitQuestRequest;
import com.home.commonGame.net.request.quest.SendGiveUpQuestRequest;
import com.home.commonGame.net.request.quest.SendQuestFailedRequest;
import com.home.commonGame.net.request.quest.SendRemoveAcceptQuestRequest;
import com.home.commonGame.part.player.base.PlayerBasePart;
import com.home.commonGame.scene.base.GameScene;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.data.DIntData;
import com.home.shine.global.ShineSetting;
import com.home.shine.support.collection.IntList;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.IntSet;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.collection.SList;
import com.home.shine.support.func.ObjectCall;
import com.home.shine.utils.MathUtils;
import com.home.shine.utils.ObjectUtils;

/** 任务(generated by shine) */
public class QuestPart extends PlayerBasePart
{
	/** 数据 */
	private QuestPartData _d;
	
	/** 执行目标类型组(单键) */
	protected IntObjectMap<IntObjectMap<TaskData>> _runningTaskTypeOneDic=new IntObjectMap<>(IntObjectMap[]::new);
	
	/** 执行目标类型组(双键) */
	protected LongObjectMap<IntObjectMap<TaskData>> _runningTaskTypeTwoDic=new LongObjectMap<>(IntObjectMap[]::new);
	
	/** 执行目标类型组2(双键) */
	protected LongObjectMap<IntObjectMap<TaskData>> _runningTaskTypeTwoDic2=new LongObjectMap<>(IntObjectMap[]::new);
	
	/** 回调组 */
	private IntObjectMap<ObjectCall<TaskData>> _taskCompleteFuncDic=new IntObjectMap<>();
	
	private int[] _tempArr=new int[1];
	
	/** 执行任务时间标记 */
	private boolean _doingTaskEvent=false;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(QuestPartData)data;
	}
	
	/** 获取数据 */
	public QuestPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new QuestPartData();
	}
	
	@Override
	protected BaseClientPartData createClientData()
	{
		return new QuestClientPartData();
	}
	
	/** 写客户端数据(copyServer过后的) */
	@Override
	protected void writeClientData(BaseClientPartData data)
	{
		toWriteClientData((QuestClientPartData)data);
	}
	
	/** 写客户端数据具体执行(已执行过copyServer了,就是说CPO中与SPO同名同类型的属性无需再赋值) */
	private void toWriteClientData(QuestClientPartData data)
	{
		
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		registTaskCompleteFunc(FunctionType.Quest,this::taskCompleteForQuest);
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
		_runningTaskTypeOneDic.forEachValue(v->
		{
			v.forEachValueAndClear(v2->
			{
				releaseTask(v2);
			});
		});
		
		_runningTaskTypeTwoDic.forEachValue(v->
		{
			v.forEachValueAndClear(v2->
			{
				releaseTask(v2);
			});
		});
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		//版本号不一致
		if(_d.questConfigChangeVersion!=Global.questConfigChangeVersion)
		{
			_d.questConfigChangeVersion=Global.questConfigChangeVersion;
			checkQuestDeprecated();
		}
		
		_d.accepts.forEachValue(data->
		{
			data.makeConfig();
			
			for(TaskData v : data.tasks)
			{
				reMakeTask(v,FunctionType.Quest,data.id);
			}
			
			addRunningQuest(data);
		});
	}
	
	@Override
	public void afterReadDataSecond()
	{
		
		
		_d.accepts.forEachValueS(v->
		{
			if(v.isComplete())
			{
				preQuestComplete(v);
			}
		});
		
		_runningTaskTypeOneDic.forEachValue(v->
		{
			checkTaskDic(v);
		});
		
		_runningTaskTypeTwoDic.forEachValue(v->
		{
			checkTaskDic(v);
		});
	}
	
	/** 每秒调用 */
	@Override
	public void onSecond(int delay)
	{
		long now=me.getTimeMillis();
		
		_d.accepts.forEachValue(v->
		{
			//有有效时间
			if(!v.isFailed && !v.config.failTimeT.isEmpty() && now >= v.enableTime)
			{
				preQuestFailed(v);
			}
		});
		
		_d.completeQuestsDic.forEachValueS(v->
		{
			//超时
			if(now >= v.reTime)
			{
				//移除
				_d.completeQuestsDic.remove(v.id);
			}
		});
	}
	
	/** 配置表更新后(配置替换) */
	@Override
	public void onReloadConfig()
	{
		_d.accepts.forEachValue(v->
		{
			for(TaskData tData : v.tasks)
			{
				tData.reloadConfig();
			}
		});
		
		_runningTaskTypeOneDic.forEachValue(v1->
		{
			v1.forEachValue(TaskData::reloadConfig);
		});
		
		_runningTaskTypeTwoDic.forEachValue(v1->
		{
			v1.forEachValue(TaskData::reloadConfig);
		});
	}
	
	/** 新创建时(该主对象在服务器上第一次被创建时的动作(一生只一次),(只对数据赋值就好,自定义数据构造的部分写到afterReadData里,因为这个完事儿就会回调到)) */
	@Override
	public void onNewCreate()
	{
		_d.taskInstanceIDIndex=0;
		_d.clientTaskInstanceIDIndex=ShineSetting.indexMaxHalf;
		
		//接取首次任务
		IntList list=QuestConfig.initQuests;
		
		if(!list.isEmpty())
		{
			int[] values=list.getValues();
			QuestConfig config;
			
			for(int i=0,len=list.size();i<len;++i)
			{
				config=QuestConfig.get(values[i]);
				
				if(me.role.checkRoleConditions(config.acceptConditions,false))
				{
					doAcceptQuest(config);
				}
			}
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
	
	private void checkTaskDic(IntObjectMap<TaskData> dic)
	{
		dic.forEachValueS(v->
		{
			if(v.isComplete())
			{
				taskComplete(v);
			}
		});
	}
	
	public void registTaskCompleteFunc(int funcID,ObjectCall<TaskData> func)
	{
		if(me.getPhase()!=PartCallPhaseType.Construct)
		{
			Ctrl.throwError("注册目标完成回调时,必须在construct阶段");
			return;
		}
		
		if(ShineSetting.openCheck)
		{
			if(_taskCompleteFuncDic.contains(funcID))
			{
				Ctrl.throwError("registTaskCompleteFunc时,重复的功能ID",funcID);
			}
		}
		
		_taskCompleteFuncDic.put(funcID,func);
	}
	
	/** 注册目标完成回调(construct阶段用) */
	protected TaskData toCreateTaskData(int type)
	{
		LogicExecutor executor;
		
		if((executor=me.getExecutor())!=null)
		{
			return executor.createTaskData(type);
		}
		
		return BaseC.logic.createTaskData(type);
	}
	
	/** 回收任务目标 */
	public void releaseTask(TaskData data)
	{
		int type=data.config.type;
		
		LogicExecutor executor;
		
		if((executor=me.getExecutor())!=null)
		{
			executor.releaseTaskData(type,data);
		}
	}
	
	/** 回收任务数据 */
	private void releaseQuest(QuestData data)
	{
		for(TaskData v : data.tasks)
		{
			releaseTask(v);
		}
		
		data.clear();
		
		//TODO:QuestData回收
	}
	
	/** 获取某任务是否完成 */
	public boolean isQuestComplete(int id)
	{
		return isQuestComplete(QuestConfig.get(id));
	}
	
	/** 获取某任务是否完成 */
	private boolean isQuestComplete(QuestConfig config)
	{
		if(_d.completeIDs.contains(config.id))
			return true;
		
		DIntData line;
		//有值
		if(!(line=config.questLine).isEmpty())
		{
			int lineQuestID=_d.completeLines.getOrDefault(line.key,-1);
			
			if(lineQuestID>0)
			{
				return config.questLineIndex<=QuestConfig.get(lineQuestID).questLineIndex;
			}
			else
			{
				return false;
			}
		}
		
		QuestCompleteData cData;
		
		if((cData=_d.completeQuestsDic.get(config.id))!=null)
		{
			return cData.isSuccess;
		}
		
		return false;
	}
	
	/** 获取某任务是否失败 */
	public boolean isQuestFailed(int id)
	{
		QuestData data;
		if((data=_d.accepts.get(id))!=null)
		{
			return data.isFailed;
		}
		
		QuestCompleteData cData;
		if((cData=_d.completeQuestsDic.get(id))!=null)
		{
			return !cData.isSuccess;
		}
		
		return false;
	}
	
	/** 通过id创建任务目标 */
	public TaskData createTaskByID(int id,int funcID,int mainID)
	{
		return createTaskByID(id,funcID,mainID,0);
	}
	
	/** 通过id创建任务目标 */
	public TaskData createTaskByID(int id,int funcID,int mainID,int num)
	{
		TaskConfig config=TaskConfig.get(id);
		
		TaskData taskData=toCreateTaskData(config.type);
		taskData.id=config.id;
		taskData.config=config;
		taskData.funcID=funcID;
		taskData.mainID=mainID;
		taskData.num=num;
		
		//初始化给值
		if(num==0 && config.initNum>0)
		{
			taskData.num=config.initNum;
		}
		
		//创建
		taskData.instanceID=me.system.isClientOfflining() ? ++_d.clientTaskInstanceIDIndex : ++_d.taskInstanceIDIndex;
	
		refreshTaskData(taskData);
		
		return taskData;
	}
	
	/** 重建任务目标数据(afterRead阶段) */
	public void reMakeTask(TaskData data,int funcID,int mainID)
	{
		data.reloadConfig();
		//data.instanceID=++_taskInstanceIDMaker;
		data.funcID=funcID;
		data.mainID=mainID;
		
		refreshTaskData(data);
	}
	
	/** 直接接取任务 */
	private void doAcceptQuest(QuestConfig config)
	{
		QuestData qData=BaseC.factory.createQuestData();
		qData.id=config.id;
		qData.makeConfig();
		
		makeTaskDataArr(qData);
		
		if(!config.failTimeT.isEmpty())
		{
			qData.enableTime=config.failTimeT.getNextTime(me);
		}
		else
		{
			qData.enableTime=0L;
		}
		
		doAcceptQuest(qData);
	}
	
	/** 构造任务目标数据 */
	protected void makeTaskDataArr(QuestData qData)
	{
		int[] list=qData.config.tasks;
		
		TaskData[] tasks=qData.tasks=new TaskData[list.length];
		
		for(int i=0;i<list.length;i++)
		{
			tasks[i]=createTaskByID(list[i],FunctionType.Quest,qData.config.id);
		}
	}
	
	/** 执行接取任务 */
	protected void doAcceptQuest(QuestData data)
	{
		data.makeConfig();
		
		_d.accepts.put(data.id,data);
		
		//成功接取任务后 把任务道具给玩家
		DIntData[] questItem=data.config.questItem;
		if(questItem.length>0)
		{
			me.bag.addItems(questItem,1,CallWayType.AcceptQuest);
		}
		
		boolean isComplete=data.isComplete();
		
		if(!isComplete)
		{
			addRunningQuest(data);
		}
		
		//推送
		me.send(SendAcceptQuestRequest.create(data));
		
		if(isComplete)
		{
			preQuestComplete(data);
		}
	}
	
	private void addRunningQuest(QuestData data)
	{
		TaskData[] tasks=data.tasks;
		TaskData tData;
		
		//串行
		if(data.config.executeType==QuestExecuteType.Serial)
		{
			for(int i=0;i<tasks.length;i++)
			{
				//未完成,或刷新式的
				if(!(tData=tasks[i]).isComplete())
				{
					//只加一次
					doAddRunningTask(tData);
					break;
				}
			}
		}
		//并行或任意
		else
		{
			for(int i=0;i<tasks.length;i++)
			{
				//未完成,或刷新式的
				if(!(tData=tasks[i]).isComplete() || TaskTypeConfig.get(tData.config.type).needUpdate)
				{
					doAddRunningTask(tData);
				}
			}
		}
	}
	
	/** 添加执行目标 */
	public void addRunningTask(TaskData data)
	{
		refreshTaskData(data);
		
		doAddRunningTask(data);
		
		//直接完成
		if(data.isComplete())
		{
			taskComplete(data);
		}
	}
	
	/** 执行添加任务目标 */
	private void doAddRunningTask(TaskData data)
	{
		TaskTypeConfig tConfig;
		//双键
		if((tConfig=TaskTypeConfig.get(data.config.type)).needSecondKey)
		{
			_runningTaskTypeTwoDic.computeIfAbsent((long)data.config.type << 32 | data.config.args[1],k->new IntObjectMap<>(TaskData[]::new)).put(data.instanceID,data);
			
			if(tConfig.needSecondKey2)
			{
				_runningTaskTypeTwoDic2.computeIfAbsent((long)data.config.type << 32 | data.config.args[2],k->new IntObjectMap<>(TaskData[]::new)).put(data.instanceID,data);
			}
		}
		//单键
		else
		{
			_runningTaskTypeOneDic.computeIfAbsent(data.config.type,k->new IntObjectMap<>(TaskData[]::new)).put(data.instanceID,data);
		}
	}
	
	/** 移除执行目标 */
	public void removeRunningTask(TaskData data)
	{
		TaskTypeConfig tConfig;
		
		IntObjectMap<TaskData> dic;
		//双键
		if((tConfig=TaskTypeConfig.get(data.config.type)).needSecondKey)
		{
			if((dic=_runningTaskTypeTwoDic.get((long)data.config.type << 32 | data.config.args[1]))!=null)
				dic.remove(data.instanceID);
			
			if(tConfig.needSecondKey2)
			{
				if((dic=_runningTaskTypeTwoDic2.get((long)data.config.type << 32 | data.config.args[2]))!=null)
					dic.remove(data.instanceID);
			}
		}
		//单键
		else
		{
			if((dic=_runningTaskTypeOneDic.get(data.config.type))!=null)
				dic.remove(data.instanceID);
		}
	}
	
	/** 目标完成 */
	private void taskComplete(TaskData data)
	{
		int funcID=data.funcID;
		
		//先移除
		if(!TaskTypeConfig.get(data.config.type).needUpdate)
		{
			removeRunningTask(data);
		}
		
		ObjectCall<TaskData> func;
		
		if((func=_taskCompleteFuncDic.get(funcID))==null)
		{
			Ctrl.throwError("找不到注册的task回调");
			return;
		}
		
		func.apply(data);
	}
	
	private void taskCompleteForQuest(TaskData data)
	{
		QuestData qData=_d.accepts.get(data.mainID);
		
		if(qData==null)
		{
			Ctrl.throwError("不该找不到任务");
			return;
		}
		
		//完成
		if(qData.isComplete())
		{
			preQuestComplete(qData);
		}
		else
		{
			//串行
			if(qData.config.executeType==QuestExecuteType.Serial)
			{
				removeRunningTask(data);
				
				int index=ObjectUtils.arrayIndexOf(qData.tasks,data);
				
				if(index==-1)
				{
					Ctrl.throwError("不该找不到任务目标索引");
				}
				
				//添加下一个
				addRunningTask(qData.tasks[index + 1]);
			}
		}
	}
	
	/** 任务失败 */
	private void preQuestFailed(QuestData data)
	{
		data.isFailed=true;
		
		addCompleteRecord(data.config,false);
		
		me.send(SendQuestFailedRequest.create(data.id));
		
		//TODO:服务器任务失败后续流程
	}
	
	/** 任务预备完成 */
	private void preQuestComplete(QuestData data)
	{
		//服务器自动提交
		if(data.config.commitType==QuestCommitType.ServerAuto)
		{
			toCommitQuest(data,true);
		}
	}
	
	/** 添加完成记录 */
	protected void addCompleteRecord(QuestConfig config,boolean isSuccess)
	{
		switch(config.repeatType)
		{
			case QuestRepeatType.Once:
			{
				//胜利记录
				if(isSuccess)
				{
					DIntData questLine;
					if(!(questLine=config.questLine).isEmpty())
					{
						int lineQuestID=_d.completeLines.getOrDefault(questLine.key,-1);
						
						//没有，或更高
						if(lineQuestID<=0 || config.questLineIndex>QuestConfig.get(lineQuestID).questLineIndex)
						{
							_d.completeLines.put(questLine.key,config.id);
						}
						
						//关键任务
						if(config.isKeyQuest)
						{
							_d.completeIDs.add(config.id);
						}
					}
					else
					{
						_d.completeIDs.add(config.id);
					}
				}
			}
				break;
			case QuestRepeatType.Cycle:
			{
				QuestCompleteData cData=_d.completeQuestsDic.get(config.id);
				
				if(cData==null)
				{
					cData=new QuestCompleteData();
					cData.id=config.id;
					_d.completeQuestsDic.put(config.id,cData);
				}
				
				//下个时间
				cData.reTime=config.cycleTimeT.getNextTime(me);
				cData.isSuccess=isSuccess;
			}
			break;
		}
	}
	
	/** 移除配置记录 */
	public void removeCompleteRecord(QuestConfig config)
	{
		switch(config.repeatType)
		{
			case QuestRepeatType.Once:
			{
				if(!config.questLine.isEmpty())
				{
					Ctrl.throwError("不可删除链式任务结构数据");
				}
				else
				{
					_d.completeIDs.remove(config.id);
				}
			}
				break;
			case QuestRepeatType.Cycle:
			{
				_d.completeQuestsDic.remove(config.id);
			}
				break;
		}
	}
	
	/** 移除已接任务 */
	private void removeAcceptQuest(QuestData data)
	{
		_d.accepts.remove(data.id);
		
		boolean isComplete=data.isComplete();
		
		//全部移除
		for(TaskData v : data.tasks)
		{
			removeRunningTask(v);
			
			if(isComplete)
			{
				//TODO:目前只支持固定任务的移除部分
				
				taskCompleteRemove(v);
			}
		}
	}
	
	/** 删除已接任务(服务器用) */
	public void removeAcceptQuestAbs(int id)
	{
		QuestData data=_d.accepts.get(id);
		
		if(data==null)
			return;
		
		removeAcceptQuest(data);
		
		me.send(SendRemoveAcceptQuestRequest.create(id));
	}
	
	/** 执行完成任务 */
	protected void toCommitQuest(QuestData data,boolean isAbs)
	{
		removeAcceptQuest(data);
		
		QuestConfig config=data.config;
		
		addCompleteRecord(config,true);
		
		//删除任务道具
		DIntData[] questItemArr=config.questItem;
		if(questItemArr.length>0)
		{
			//如果需要删除任务道具
			me.bag.removeItems(questItemArr,1,CallWayType.CommitQuest);
		}
		
		//执行任务完成动作组
		me.role.doRoleActions(config.completeActions,1,CallWayType.CommitQuest);
		
		//有奖励
		if(data.config.rewardID>0)
		{
			//奖励
			if(isAbs)
			{
				me.bag.addRewardAbs(data.config.rewardID,CallWayType.CommitQuest);
			}
			else
			{
				me.bag.addReward(data.config.rewardID,CallWayType.CommitQuest);
			}
		}
		
		me.send(SendCommitQuestRequest.create(data.id));
		
		onQuestComplete(data);
		
		//回收
		releaseQuest(data);
	}
	
	/** 任务目标事件 */
	public void taskEvent(int type)
	{
		taskEvent(type,null);
	}
	
	/** 任务目标事件 */
	public void taskEvent(int type,int...args)
	{
		TaskTypeConfig config=TaskTypeConfig.get(type);
		
		doTaskEvent(config,args,false,false);
	}
	
	/** 任务更新 */
	public void taskRefresh(int type)
	{
		taskRefresh(type,0,false);
	}
	
	/** 任务更新 */
	public void taskRefresh(int type,int secondKey)
	{
		taskRefresh(type,secondKey,false);
	}
	
	/** 任务更新 */
	public void taskRefresh(int type,int secondKey,boolean useSecond2)
	{
		TaskTypeConfig config=TaskTypeConfig.get(type);
		
		_tempArr[0]=secondKey;
		doTaskEvent(config,_tempArr,true,useSecond2);
	}
	
	/** 执行taskEvent */
	protected void doTaskEvent(TaskTypeConfig typeConfig,int[] args,boolean onlyRefresh,boolean useSecond2)
	{
		IntObjectMap<TaskData> dic;
		
		if(typeConfig.needSecondKey)
		{
			if(useSecond2)
			{
				if((dic=_runningTaskTypeTwoDic2.get((long)typeConfig.id << 32 | args[0]))==null || dic.isEmpty())
					return;
			}
			else
			{
				if((dic=_runningTaskTypeTwoDic.get((long)typeConfig.id << 32 | args[0]))==null || dic.isEmpty())
					return;
			}
		}
		else
		{
			if((dic=_runningTaskTypeOneDic.get(typeConfig.id))==null || dic.isEmpty())
				return;
		}
		
		_doingTaskEvent=true;
		
		dic.forEachValueS(v->
		{
			try
			{
				boolean lastIsComplete;
				int lastNum;
				
				//未完成
				if(!(lastIsComplete=v.isComplete()) || typeConfig.needUpdate)
				{
					lastNum=v.num;
					
					if(onlyRefresh)
					{
						refreshTaskData(v);
					}
					else
					{
						toTaskEvent(v,args);
					}
					
					//有变化
					if(lastNum!=v.num)
					{
						me.send(RefreshTaskRequest.create(v.instanceID,v.num));
					}
					
					//新的完成
					if(v.isComplete() && !lastIsComplete)
					{
						taskComplete(v);
					}
				}
			}
			catch(Exception e)
			{
				me.errorLog(e);
			}
		});
		
		_doingTaskEvent=false;
	}
	
	/** 接取任务 */
	public void acceptQuest(int id)
	{
		if(_d.accepts.contains(id))
		{
			me.warningInfoCode(InfoCodeType.Quest_accept_accepted,id);
			return;
		}
		
		if(isQuestComplete(id))
		{
			me.warningInfoCode(InfoCodeType.Quest_accept_completed,id);
			return;
		}
		
		QuestConfig config=QuestConfig.get(id);
		
		//任务失败了
		QuestCompleteData cData;
		if((cData=_d.completeQuestsDic.get(id))!=null && !cData.isSuccess)
		{
			//不可接取失败
			if(!config.cantAcceptFailed)
			{
				me.warningInfoCode(InfoCodeType.Quest_accept_failed,id);
				return;
			}
		}
		
		for(int v : config.preQuests)
		{
			if(!isQuestComplete(v))
			{
				me.warningInfoCode(InfoCodeType.Quest_accept_preQuestNotFinish,id,v);
				return;
			}
		}
		
		if(!me.role.checkRoleConditions(config.acceptConditions,true))
		{
			me.warningInfoCode(InfoCodeType.Quest_accept_conditionNotMet,id);
			return;
		}
		
		//接任务给任务道具
		DIntData[] questItem=config.questItem;
		if(questItem.length>0)
		{
			//检测是否有足够的格子放置任务道具
			if(!me.bag.hasItemPlace(questItem))
			{
				me.warningInfoCode(InfoCodeType.Quest_accept_bagNotEnough,id);
				return;
			}
		}
		
		doAcceptQuest(config);
	}
	
	/** 放弃任务 */
	public void giveUpQuest(int id)
	{
		QuestData data=_d.accepts.get(id);
		
		if(data==null)
		{
			me.warningInfoCode(InfoCodeType.Quest_giveUp_questNotExist);
			return;
		}
		
		//未失败的不可放弃任务
		if(!data.isFailed && !data.config.canGiveUp)
		{
			me.warningInfoCode(InfoCodeType.Quest_giveUp_questCanNotGiveUp);
			return;
		}
		
		//没失败
		if(!data.isFailed)
		{
			data.isFailed=true;
			addCompleteRecord(data.config,false);
		}
		
		removeAcceptQuest(data);
		releaseQuest(data);
		
		me.send(SendGiveUpQuestRequest.create(id));
	}
	
	/** 提交任务 */
	public void commitQuest(int id)
	{
		QuestData data=_d.accepts.get(id);
		
		if(data==null)
		{
			me.warningInfoCode(InfoCodeType.Quest_commit_questNotExist);
			return;
		}
		
		if(data.isFailed)
		{
			me.warningInfoCode(InfoCodeType.Quest_commit_failed);
			return;
		}
		
		if(!data.isComplete())
		{
			me.warningInfoCode(InfoCodeType.Quest_commit_questNotComplete);
			return;
		}
		
		if(data.config.rewardID>0)
		{
			if(!me.bag.hasRewardPlace(data.config.rewardID))
			{
				me.warnLog("提交任务时,背包空间不足");
				me.sendInfoCode(InfoCodeType.BagNotEnough);
				return;
			}
		}
		
		toCommitQuest(data,false);
	}
	
	/** 客户端任务目标事件 */
	public void clientTaskEvent(int type,int[] args)
	{
		TaskTypeConfig typeConfig=TaskTypeConfig.get(type);
		
		if(typeConfig==null)
		{
			me.warningInfoCode(InfoCodeType.Quest_clientTaskEvent_canNotFindConfig,type);
			return;
		}
		
		if(!typeConfig.isClientDrive)
		{
			me.warningInfoCode(InfoCodeType.Quest_clientTaskEvent_clientNotAllowed,type);
			return;
		}
		
		taskEvent(type,args);
	}
	
	/** 接任务(gm指令)(并完成所有前置) */
	public void acceptQuestByGM(int id,boolean needPre)
	{
		if(_d.accepts.contains(id))
		{
			me.warnLog("gm接任务时,任务已接",id);
			return;
		}
		
		if(isQuestComplete(id))
		{
			me.warnLog("gm接任务时,任务已完成",id);
			return;
		}
		
		if(needPre)
		{
			toCompleteQuestByGm(id);
		}
		
		doAcceptQuest(QuestConfig.get(id));
	}
	
	/** 完成任务(gm指令)(并完成所有前置) */
	public void commitQuestByGM(int id)
	{
		toCompleteQuestByGm(id);
	}
	
	/** 清空所有任务 */
	public void clearAllQuestByGM()
	{
		_d.accepts.forEachValueS(data->
		{
			removeAcceptQuest(data);
		});
		
		_d.completeIDs.clear();
		_d.completeLines.clear();
		_d.completeQuestsDic.clear();
		
		me.send(SendClearAllQuestByGMRequest.create());
	}
	
	/** 任务完成接口 */
	protected void onQuestComplete(QuestData data)
	{
	
	}
	
	/** 完成任务以及前置(gm) */
	private void toCompleteQuestByGm(int id)
	{
		if(isQuestComplete(id))
			return;
		
		QuestConfig config=QuestConfig.get(id);
		
		//前置任务
		for(int v:config.preQuests)
		{
			toCompleteQuestByGm(v);
		}
		
		//完成当前
		QuestData qData=_d.accepts.get(id);
		
		if(qData==null)
		{
			doAcceptQuest(config);
			
			qData=_d.accepts.get(id);
			
			//已自动完成
			if(qData==null)
				return;
		}
		
		toCommitQuest(qData,true);
	}
	
	/** 任务事件击杀怪物 */
	public void taskEventForKillMonster(Unit unit)
	{
		int monsterID=unit.getMonsterIdentityLogic().getMonsterConfig().id;
		
		taskEvent(TaskType.KillMonster,monsterID);
		taskEvent(TaskType.KillMonsterGetNum,monsterID);
		taskEvent(TaskType.KillMonsterGetItem,monsterID);
	}
	
	/** 刷新任务 由于 物品数目变化 */
	public void refreshTaskForItemNumChanged(int id)
	{
		//执行中
		if(_doingTaskEvent)
			return;
		
		taskRefresh(TaskType.HasItem,id);
		taskRefresh(TaskType.KillMonsterGetItem,id,true);
	}
	
	/** 更新目标数据 */
	protected void refreshTaskData(TaskData data)
	{
		int[] args;
		
		switch((args=data.config.args)[0])
		{
			case TaskType.HasItem:
			{
				data.num=me.bag.getItemNum(args[1]);
			}
				break;
			case TaskType.Level:
			{
				if(me.role.getLevel()>=args[1])
					data.num=1;
			}
				break;
			case TaskType.KillMonsterGetItem:
			{
				data.num=me.bag.getItemNum(args[2]);
			}
				break;
			case TaskType.EnterRegion:
			{
				GameScene scene=me.scene.getScene();
				
				Unit unit=me.scene.getUnit();
				
				//在对应场景
				if(scene!=null && unit!=null && scene.getConfig().id==args[1])
				{
					Region region=scene.getRegion(args[2]);
					//在region里
					if(region!=null && region.isInRegion(unit))
					{
						data.num=1;
					}
				}
			}
				break;
		}
	}
	
	/** 执行目标事件 */
	protected void toTaskEvent(TaskData data,int[] vars)
	{
		int[] args=data.config.args;
		
		switch(data.config.type)
		{
			case TaskType.WinBattle:
			case TaskType.KillMonster:
			{
				data.num++;
			}
				break;
			case TaskType.Level:
			{
				if(me.role.getLevel()>=args[1])
					data.num=1;
			}
			break;
			case TaskType.FriendNum:
			{
				int num=vars[0];
				
				if(num>data.num)
				{
					data.num=num;
				}
			}
			break;
			case TaskType.TotalAddCurrency:
			case TaskType.TotalCostCurrency:
			{
				//类型相同
				if(args[1]==vars[0])
				{
					data.num=vars[1];
				}
			}
			break;
			case TaskType.KillMonsterGetNum:
			{
				if(MathUtils.randomProb(args[2]))
				{
					data.num++;
				}
			}
				break;
			case TaskType.KillMonsterGetItem:
			{
				if(MathUtils.randomProb(args[3]))
				{
					//有位置
					if(me.bag.hasItemPlace(args[2],1))
					{
						data.num++;
						me.bag.addItem(args[2],1,CallWayType.TaskStep);
					}
				}
			}
				break;
			case TaskType.EnterRegion:
			{
				//sceneID 与 regionInstanceID都相等
				if(vars[0]==args[1] && vars[1]==args[2])
				{
					data.num=1;
				}
			}
				break;
			default:
			{
				refreshTaskData(data);
			}
				break;
		}
	}
	
	/** 任务目标完成移除 */
	protected void taskCompleteRemove(TaskData data)
	{
		int[] args=data.config.args;
		
		switch(data.config.type)
		{
			case TaskType.KillMonsterGetItem:
			{
				//移除的
				if(args[4]==1)
				{
					me.bag.removeItem(args[2],data.num,CallWayType.TaskRemove);
				}
			}
				break;
		}
	}
	
	/** 检查任务废弃 */
	private void checkQuestDeprecated()
	{
		IntSet completeDic=new IntSet();
		
		_d.completeIDs.forEachS(v->
		{
			QuestConfig config=QuestConfig.get(v);
			
			//数据已删除
			if(config==null || config.isDeprecated)
			{
				_d.completeIDs.remove(v);
			}
			else
			{
				markComplete(completeDic,v);
			}
		});
		
		_d.completeQuestsDic.forEachValueS(v->
		{
			QuestConfig config=QuestConfig.get(v.id);

			//数据已删除
			if(config==null || config.isDeprecated)
			{
				_d.completeQuestsDic.remove(v.id);
			}
			else
			{
				markComplete(completeDic,v.id);
			}
		});
		
		_d.completeLines.forEachS((k,v)->
		{
			QuestConfig config=QuestConfig.get(v);
			
			//数据已删除
			if(config==null)
			{
				me.errorLog("不能出现删除questLine任务配置的情况",v);
				_d.completeLines.remove(k);
			}
			else if(config.isDeprecated)
			{
				SList<QuestConfig> list=QuestConfig.questLineDic.get(k);
				
				for(int i=config.questLineIndex-1;i>=0;i--)
				{
					QuestConfig qConfig=list.get(i);
					
					//未废弃
					if(!qConfig.isDeprecated)
					{
						_d.completeLines.put(k,qConfig.id);
					}
				}
			}
			else
			{
				markComplete(completeDic,v);
			}
		});
		
		_d.accepts.forEachValueS(v->
		{
			QuestConfig config=QuestConfig.get(v.id);
			
			//数据已删除
			if(config==null || config.isDeprecated)
			{
				_d.accepts.remove(v.id);
			}
			else
			{
				markComplete(completeDic,v.id);
			}
		});
		
		//应该完成组
		completeDic.forEach(v->
		{
			QuestConfig config=QuestConfig.get(v);
			
			//关键人物，并且不在完成组
			if(config.isKeyQuest && !_d.completeIDs.contains(v))
			{
				_d.completeIDs.add(v);
				doKeyQuestComplete(config);
			}
		});
	}
	
	/** 执行关键任务后补奖励 */
	protected void doKeyQuestComplete(QuestConfig config)
	{
		//有奖励
		if(config.rewardID>0)
		{
			me.bag.addRewardAbs(config.rewardID,CallWayType.CommitQuest);
		}
	}
	
	private void markComplete(IntSet dic,int id)
	{
		if(dic.contains(id))
			return;
		
		dic.add(id);
		
		QuestConfig config=QuestConfig.get(id);
		
		for(int v:config.preQuests)
		{
			markComplete(dic,v);
		}
	}
	
}
