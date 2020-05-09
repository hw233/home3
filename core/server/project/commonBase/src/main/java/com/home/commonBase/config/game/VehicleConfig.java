package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.commonBase.config.game.LanguageConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;

/** 载具表(generated by shine) */
public class VehicleConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<VehicleConfig> _dic;
	
	/** id */
	public int id;
	
	/** 战斗单位ID */
	public int fightUnitID;
	
	/** 名字 */
	public String name="";
	
	/** 驾驶条件 */
	public int[][] driveConditions;
	
	/** 驾驶后添加动作(下车移除)(走装备动作组) */
	public int[][] driveActions;
	
	/** 可驾驶人数 */
	public int driverNum;
	
	/** 可驾驶半径 */
	public float driveOnRadius;
	
	public float driveOnRadiusT;
	
	/** 名字原值 */
	private String _name;
	
	/** 获取 */
	public static VehicleConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<VehicleConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<VehicleConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.fightUnitID=stream.readInt();
		
		this.name=stream.readUTF();
		
		int driveConditionsLen=stream.readLen();
		if(this.driveConditions==null || this.driveConditions.length!=driveConditionsLen)
		{
			this.driveConditions=new int[driveConditionsLen][];
		}
		int[][] driveConditionsT=this.driveConditions;
		for(int driveConditionsI=0;driveConditionsI<driveConditionsLen;++driveConditionsI)
		{
			int[] driveConditionsV;
			int driveConditionsVLen=stream.readLen();
			driveConditionsV=new int[driveConditionsVLen];
			int[] driveConditionsVT=driveConditionsV;
			for(int driveConditionsVI=0;driveConditionsVI<driveConditionsVLen;++driveConditionsVI)
			{
				int driveConditionsVV;
				driveConditionsVV=stream.readInt();
				
				driveConditionsVT[driveConditionsVI]=driveConditionsVV;
			}
			
			driveConditionsT[driveConditionsI]=driveConditionsV;
		}
		
		int driveActionsLen=stream.readLen();
		if(this.driveActions==null || this.driveActions.length!=driveActionsLen)
		{
			this.driveActions=new int[driveActionsLen][];
		}
		int[][] driveActionsT=this.driveActions;
		for(int driveActionsI=0;driveActionsI<driveActionsLen;++driveActionsI)
		{
			int[] driveActionsV;
			int driveActionsVLen=stream.readLen();
			driveActionsV=new int[driveActionsVLen];
			int[] driveActionsVT=driveActionsV;
			for(int driveActionsVI=0;driveActionsVI<driveActionsVLen;++driveActionsVI)
			{
				int driveActionsVV;
				driveActionsVV=stream.readInt();
				
				driveActionsVT[driveActionsVI]=driveActionsVV;
			}
			
			driveActionsT[driveActionsI]=driveActionsV;
		}
		
		this.driveOnRadius=stream.readFloat();
		
		this.driverNum=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.fightUnitID);
		
		stream.writeUTF(this.name);
		
		if(this.driveConditions!=null)
		{
			int[][] driveConditionsT=this.driveConditions;
			stream.writeLen(driveConditionsT.length);
			for(int driveConditionsVI=0,driveConditionsVLen=driveConditionsT.length;driveConditionsVI<driveConditionsVLen;++driveConditionsVI)
			{
				int[] driveConditionsV=driveConditionsT[driveConditionsVI];
				if(driveConditionsV!=null)
				{
					int[] driveConditionsVT=driveConditionsV;
					stream.writeLen(driveConditionsVT.length);
					for(int driveConditionsVVI=0,driveConditionsVVLen=driveConditionsVT.length;driveConditionsVVI<driveConditionsVVLen;++driveConditionsVVI)
					{
						int driveConditionsVV=driveConditionsVT[driveConditionsVVI];
						stream.writeInt(driveConditionsVV);
						
					}
				}
				else
				{
					nullObjError("driveConditionsV");
				}
				
			}
		}
		else
		{
			nullObjError("driveConditions");
		}
		
		if(this.driveActions!=null)
		{
			int[][] driveActionsT=this.driveActions;
			stream.writeLen(driveActionsT.length);
			for(int driveActionsVI=0,driveActionsVLen=driveActionsT.length;driveActionsVI<driveActionsVLen;++driveActionsVI)
			{
				int[] driveActionsV=driveActionsT[driveActionsVI];
				if(driveActionsV!=null)
				{
					int[] driveActionsVT=driveActionsV;
					stream.writeLen(driveActionsVT.length);
					for(int driveActionsVVI=0,driveActionsVVLen=driveActionsVT.length;driveActionsVVI<driveActionsVVLen;++driveActionsVVI)
					{
						int driveActionsVV=driveActionsVT[driveActionsVVI];
						stream.writeInt(driveActionsVV);
						
					}
				}
				else
				{
					nullObjError("driveActionsV");
				}
				
			}
		}
		else
		{
			nullObjError("driveActions");
		}
		
		stream.writeFloat(this.driveOnRadius);
		
		stream.writeInt(this.driverNum);
		
	}
	
	/** 生成刷新配置 */
	@Override
	protected void generateRefresh()
	{
		if(_name==null)
			_name=name;
		name=LanguageConfig.getText(_name);
		
	}
	
	@Override
	protected void afterReadConfig()
	{
		super.afterReadConfig();
		
		driveOnRadiusT=driveOnRadius*driveOnRadius;
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
}
