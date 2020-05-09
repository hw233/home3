package com.home.commonGame.scene.unit;

import com.home.commonBase.control.AttributeControl;
import com.home.commonBase.dataEx.scene.SocketAOICountData;
import com.home.commonBase.scene.base.Unit;
import com.home.commonBase.scene.unit.UnitAOITowerLogic;
import com.home.commonBase.scene.unit.UnitFightLogic;
import com.home.commonGame.net.request.scene.scene.AddBindVisionUnitRequest;
import com.home.commonGame.net.request.scene.scene.AddUnitRequest;
import com.home.commonGame.net.request.scene.scene.RemoveBindVisionUnitRequest;
import com.home.commonGame.net.request.scene.scene.RemoveUnitRequest;
import com.home.commonGame.net.request.scene.unit.RefreshSimpleUnitAttributeRequest;
import com.home.commonGame.net.request.scene.unit.RefreshSimpleUnitPosRequest;
import com.home.commonGame.scene.scene.SceneAOITowerLogic;
import com.home.shine.net.socket.BaseSocket;
import com.home.shine.support.collection.IntIntMap;

/** 角色的灯塔AOI逻辑 */
public class GameUnitAOITowerLogic extends UnitAOITowerLogic
{
	@Override
	public SocketAOICountData getSelfAOICheck()
	{
		BaseSocket socket=_unit.getSocket();
		
		if(socket!=null)
			return ((SceneAOITowerLogic)_scene.aoi).getSocketAOICheck(_unit.identity.controlPlayerID);
		
		return null;
	}
	
	@Override
	protected void sendAddOne(Unit unit)
	{
		unit.beforeWrite();
		
		//是否可战斗
		if(unit.canFight())
		{
			UnitFightLogic fight=unit.fight;
			
			//是自己的
			if(unit.identity.getControlCharacterLogic()==_unit.identity)
			{
				fight.switchSendSelf();
				_unit.send(AddUnitRequest.create(unit.getUnitData()));
				fight.endSwitchSend();
			}
			else
			{
				fight.switchSendOther();
				_unit.send(AddUnitRequest.create(unit.getUnitData()));
				fight.endSwitchSend();
			}
		}
		else
		{
			_unit.send(AddUnitRequest.create(unit.getUnitData()));
		}
		
		recordAddUnit(unit.instanceID);
	}
	
	@Override
	protected void sendRemoveOne(Unit unit)
	{
		_unit.send(RemoveUnitRequest.create(unit.instanceID));
		
		recordRemoveUnit(unit.instanceID);
	}
	
	//@Override
	//public void addBindUnit(Unit unit)
	//{
	//	super.addBindUnit(unit);
	//
	//	_unit.send(AddBindVisionUnitRequest.create(unit.instanceID,isSee(unit) ? null : unit.createSimpleUnitData()));
	//}
	//
	//@Override
	//public void removeBindUnit(Unit unit)
	//{
	//	super.removeBindUnit(unit);
	//
	//	_unit.send(RemoveBindVisionUnitRequest.create(unit.instanceID));
	//}
	
	@Override
	protected void doSimplePosChanged()
	{
		super.doSimplePosChanged();
		
		//有绑定单位
		if(!_bindVisionUnits.isEmpty())
		{
			RefreshSimpleUnitPosRequest request=null;
			
			Unit[] values;
			Unit v;
			
			for(int i=(values=_bindVisionUnits.getValues()).length-1;i>=0;--i)
			{
				if((v=values[i])!=null)
				{
					//目标看不见我
					if(!v.aoiTower.isSee(_unit))
					{
						if(request==null)
						{
							request=RefreshSimpleUnitPosRequest.create(_unit.instanceID,_unit.pos.getPos(),_unit.pos.getDir());
							request.write();
						}
						
						v.send(request);
					}
				}
			}
		}
	}
	
	/** 属性变化 */
	public void doAttributeChanged(IntIntMap dic)
	{
		if(_bindVisionUnits.isEmpty())
			return;
		
		IntIntMap aDic=null;
		
		boolean[] simpleUnitSet=AttributeControl.attribute.simpleUnitSet;
		
		if(!dic.isEmpty())
		{
			int free=dic.getFreeValue();
			long[] tab=dic.getTable();
			long entry;
			int key;
			
			for(int i=(tab.length) - 1;i >= 0;--i)
			{
				if((key=((int)(entry=tab[i])))!=free)
				{
					if(simpleUnitSet[key])
					{
						if(aDic==null)
							aDic=new IntIntMap();
						
						aDic.put(key,(int)(entry >>> 32));
					}
				}
			}
		}
		
		if(aDic==null)
			return;
		
		RefreshSimpleUnitAttributeRequest request=null;
		
		Unit[] values;
		Unit v;
		
		for(int i=(values=_bindVisionUnits.getValues()).length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				//目标看不见我
				if(!v.aoiTower.isSee(_unit))
				{
					if(request==null)
					{
						request=RefreshSimpleUnitAttributeRequest.create(_unit.instanceID,aDic);
						request.write();
					}
					
					v.send(request);
				}
			}
		}
	}
}
