package com.home.commonGame.part.player.part;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.config.game.BuffConfig;
import com.home.commonBase.config.game.enumT.EquipSlotTypeConfig;
import com.home.commonBase.constlist.generate.BuffKeepType;
import com.home.commonBase.constlist.generate.FunctionType;
import com.home.commonBase.constlist.generate.ItemEquipActionType;
import com.home.commonBase.data.item.ItemData;
import com.home.commonBase.data.role.CharacterSaveData;
import com.home.commonBase.data.role.CharacterUseData;
import com.home.commonBase.data.role.MUnitSaveData;
import com.home.commonBase.data.role.MUnitUseData;
import com.home.commonBase.data.scene.base.BuffData;
import com.home.commonBase.data.system.KeyData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.global.CommonSetting;
import com.home.commonBase.logic.unit.AttributeDataLogic;
import com.home.commonBase.logic.unit.BuffDataLogic;
import com.home.commonBase.part.player.clientData.CharacterClientPartData;
import com.home.commonBase.part.player.data.CharacterPartData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.logic.unit.CharacterUseLogic;
import com.home.commonGame.logic.unit.MUnitFightDataLogic;
import com.home.commonGame.logic.unit.MUnitUseLogic;
import com.home.commonGame.part.player.base.PlayerBasePart;
import com.home.commonGame.tool.func.PlayerEquipContainerTool;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.global.ShineSetting;
import com.home.shine.support.collection.IntObjectMap;

/** 角色(generated by shine) */
public class CharacterPart extends PlayerBasePart
{
	/** 数据 */
	private CharacterPartData _d;
	
	/** 主角战斗数据逻辑组(全部) */
	private IntObjectMap<MUnitUseLogic> _mUnitUseLogics=new IntObjectMap<>(MUnitUseLogic[]::new);
	
	/** 出战中所有主单位 */
	private IntObjectMap<MUnitUseLogic> _mUnitUseLogicOnWorking=new IntObjectMap<>(MUnitUseLogic[]::new);
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(CharacterPartData)data;
	}
	
	/** 获取数据 */
	public CharacterPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new CharacterPartData();
	}
	
	@Override
	protected BaseClientPartData createClientData()
	{
		return new CharacterClientPartData();
	}
	
	/** 写客户端数据(copyServer过后的) */
	@Override
	protected void writeClientData(BaseClientPartData data)
	{
		toWriteClientData((CharacterClientPartData)data);
	}
	
	/** 写客户端数据具体执行(已执行过copyServer了,就是说CPO中与SPO同名同类型的属性无需再赋值) */
	private void toWriteClientData(CharacterClientPartData data)
	{
		
	}
	
	/** 推送完客户端数据后 */
	public void afterSendClientListData()
	{
	
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
	
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		
	}
	
	/** 配置表更新后(配置替换) */
	@Override
	public void onReloadConfig()
	{
		_mUnitUseLogics.forEachValue(v->
		{
			v.getFightLogic().reloadConfig();
		});
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
	
	public void onPiece(int delay)
	{
		//间隔拉长
		if(!_mUnitUseLogics.isEmpty())
		{
			MUnitUseLogic[] values;
			MUnitUseLogic v;
			
			for(int i=(values=_mUnitUseLogics.getValues()).length-1;i>=0;--i)
			{
				if((v=values[i])!=null)
				{
					v.onPiece(delay);
				}
			}
		}
	}
	
	public void onSecondEx(int delay)
	{
		//间隔拉长
		if(me.scene.isNoneScene() && !_mUnitUseLogics.isEmpty())
		{
			MUnitUseLogic[] values;
			MUnitUseLogic v;
			
			for(int i=(values=_mUnitUseLogics.getValues()).length-1;i>=0;--i)
			{
				if((v=values[i])!=null)
				{
					v.onPieceEx(delay);
				}
			}
		}
	}
	
	/** 获取一个可用的主单位序号 */
	public int getOneMUnitIndex()
	{
		return ++_d.mUnitIndex;
	}
	
	/** 添加角色战斗数据逻辑 */
	public void addMUnitUseLogic(MUnitUseLogic logic)
	{
		if(logic.index==-1)
		{
			me.throwError("未就绪的MUnitUseLogic");
		}
		
		if(_mUnitUseLogics.contains(logic.index))
		{
			me.throwError("重复的MUnitUseLogic"+logic.index);
		}
		
		_mUnitUseLogics.put(logic.index,logic);
		
		if(logic.isWorking())
		{
			_mUnitUseLogicOnWorking.put(logic.index,logic);
		}
	}
	
	/** 移除角色战斗数据逻辑 */
	public void removeMUnitUseLogic(MUnitUseLogic logic)
	{
		if(logic.index==-1)
		{
			Ctrl.throwError("未就绪的MUnitUseLogic");
		}
		
		_mUnitUseLogics.remove(logic.index);
		
		if(logic.isWorking())
		{
			_mUnitUseLogicOnWorking.remove(logic.index);
		}
	}
	
	/** 获取当前主单位使用逻辑(可能为空) */
	public MUnitUseLogic getMUnitUseLogic(int index)
	{
		return _mUnitUseLogics.get(index);
	}
	
	/** 获取所有出战单位 */
	public IntObjectMap<MUnitUseLogic> getMUnitUseLogicOnWorking()
	{
		return _mUnitUseLogicOnWorking;
	}
	
	/** 获取当前角色使用逻辑(可能为空) */
	public CharacterUseLogic getCurrentCharacterUseLogic()
	{
		return null;
	}
	
	/** 获取当前角色的战斗数据逻辑 */
	public MUnitFightDataLogic getCurrentFightDataLogic()
	{
		return getCurrentCharacterUseLogic().getFightLogic();
	}
	
	/** 获取当前角色的属性逻辑 */
	public AttributeDataLogic getCurrentAttributeDataLogic()
	{
		return getCurrentCharacterUseLogic().getAttributeLogic();
	}
	
	/** 获取当前角色的属性逻辑 */
	public BuffDataLogic getCurrentBuffDataLogic()
	{
		return getCurrentCharacterUseLogic().getBuffLogic();
	}
	
	/** 获取主角单位数据逻辑 */
	public MUnitFightDataLogic getMUnitFightDataLogic(int index)
	{
		return getMUnitUseLogic(index).getFightLogic();
	}
	
	/** 新创建的保存数据 */
	protected void newCreateSaveData(MUnitSaveData saveData)
	{
		saveData.mIndex=getOneMUnitIndex();
		saveData.equips=BaseC.factory.createEquipContainerData();
		saveData.equips.initDefault();
		
		int unitType=saveData.getUnitType();
		
		for(EquipSlotTypeConfig v : EquipSlotTypeConfig.getDic())
		{
			if(v!=null && v.unitType==unitType)
			{
				if(v.isOpen)
				{
					//直接打开
					saveData.equips.openSlots.add(v.id);
				}
			}
		}
	}
	
	/** 通过saveData初始化useData */
	public void initMUnitUseBySave(MUnitUseData uData,MUnitSaveData sData)
	{
		uData.mIndex=sData.mIndex;
		uData.id=sData.id;
		uData.equips=sData.equips;//引用传递
	}
	
	/** 构造character部分 */
	protected void initCharacterUseBySave(CharacterUseData uData,CharacterSaveData sData)
	{
	
	}
	
	/** 通过保存数据，创建使用数据 */
	public CharacterUseData createCharacterUseDataBySaveData(CharacterSaveData saveData)
	{
		CharacterUseData data=BaseC.factory.createCharacterUseData();
		data.initDefault();
		
		//1级
		data.level=me.role.getLevel();
		initMUnitUseBySave(data,saveData);
		initCharacterUseBySave(data,saveData);
		
		return data;
	}
	
	/** 通过保存数据初始化 */
	public void initCharacterUseLogicBySaveData(CharacterUseLogic logic,CharacterSaveData saveData,boolean needFuncTool,boolean needBindPlayer)
	{
		initUseLogicByUseData(logic,createCharacterUseDataBySaveData(saveData),saveData,needFuncTool,needBindPlayer);
	}
	
	/** 通过保存数据初始化 */
	public void initUseLogicByUseData(MUnitUseLogic logic,MUnitUseData useData,MUnitSaveData saveData,boolean needFuncTool,boolean needBindPlayer)
	{
		//基础部分
		logic.init(useData,saveData);
		
		//补满血蓝
		logic.getAttributeLogic().fillHpMp();
		//刷属性
		logic.getAttributeLogic().refreshAttributes();
		
		if(needBindPlayer)
		{
			logic.setPlayer(me);
		}
		
		if(needFuncTool)
		{
			int funcID=logic.getMUnitFuncID(FunctionType.Equip);
			PlayerEquipContainerTool funcTool=GameC.factory.createPlayerEquipContainerTool(funcID);
			//互相绑定
			funcTool.setMUnitLogic(logic);
			logic.setEquipTool(funcTool);
			
			me.func.addFuncTool(funcTool,useData.equips);
		}
		
		if(saveData.cache!=null)
		{
			logic.getFightLogic().loadCache(saveData.cache);
		}
	}
	
	private void doEquipActions(MUnitUseLogic logic,PlayerEquipContainerTool tool,int slot,int[][] actions,boolean isOn)
	{
		for(int i=0;i<actions.length;++i)
		{
			doOneEquipAction(logic,tool,slot,i,actions[i],isOn);
		}
	}
	
	/** 执行单个装备方法 */
	protected void doOneEquipAction(MUnitUseLogic logic,PlayerEquipContainerTool tool,int slot,int index,int[] args,boolean isOn)
	{
		switch(args[0])
		{
			case ItemEquipActionType.AddBuff:
			{
				if(isOn)
				{
					if(ShineSetting.openCheck)
					{
						BuffConfig buffConfig=BuffConfig.get(args[1]);
						
						if(buffConfig.keepType!=BuffKeepType.Online)
						{
							Ctrl.throwError("装备用buff的保存类型必须为Online");
						}
					}
					
					BuffData buffData=logic.getBuffLogic().addBuff(args[1],args[2]);
					//记录buffID
					tool.getBuffInstanceIDDic().put(slot << CommonSetting.buffActionIndexOff | index,buffData.instanceID);
				}
				else
				{
					int instanceID=tool.getBuffInstanceIDDic().remove(slot << CommonSetting.buffActionIndexOff | index);
					
					if(instanceID<=0)
					{
						Ctrl.errorLog("不该找不到buff instanceID");
					}
					else
					{
						logic.getBuffLogic().removeBuffByInstanceID(instanceID);
					}
				}
			}
				break;
			case ItemEquipActionType.AddSkill:
			{
				if(isOn)
				{
					logic.getFightLogic().addSkill(args[1],args[2]);
				}
				else
				{
					logic.getFightLogic().removeSkill(args[1]);
				}
			}
				break;
			case ItemEquipActionType.AddAvatarPart:
			{
				if(isOn)
				{
					logic.getFightLogic().avatar.addPart(args[1],args[2]);
				}
				else
				{
					logic.getFightLogic().avatar.removePart(args[1],args[2]);
				}
			}
				break;
		}
	}
	
	/** 添加装备影响(单个装备) */
	public void addEquipInfluence(MUnitUseLogic logic,PlayerEquipContainerTool tool,int slot,ItemData data)
	{
		logic.getAttributeLogic().addAttributes(data.config.baseAttributes);
		doEquipActions(logic,tool,slot,data.config.equipActions,true);
	}
	
	/** 移除装备影响(单个装备) */
	public void removeEquipInfluence(MUnitUseLogic logic,PlayerEquipContainerTool tool,int slot,ItemData data)
	{
		logic.getAttributeLogic().subAttributes(data.config.baseAttributes);
		doEquipActions(logic,tool,slot,data.config.equipActions,false);
	}
	
	/** 保存缓存数据 */
	public void saveCache(int type)
	{
		if(!_mUnitUseLogics.isEmpty())
		{
			MUnitUseLogic[] values;
			MUnitUseLogic v;
			
			for(int i=(values=_mUnitUseLogics.getValues()).length-1;i>=0;--i)
			{
				if((v=values[i])!=null)
				{
					if(v.isWorking())
					{
						v.saveCache(type);
					}
				}
			}
		}
	}
	
	public void clearCache()
	{
		if(!_mUnitUseLogics.isEmpty())
		{
			MUnitUseLogic[] values;
			MUnitUseLogic v;

			for(int i=(values=_mUnitUseLogics.getValues()).length-1;i>=0;--i)
			{
				if((v=values[i])!=null)
				{
					if(v.isWorking())
					{
						v.clearCache();
					}
				}
			}
		}
	}
	
}
