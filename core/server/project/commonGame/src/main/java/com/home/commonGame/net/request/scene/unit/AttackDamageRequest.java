package com.home.commonGame.net.request.scene.unit;
import com.home.commonBase.data.scene.fight.DamageOneData;
import com.home.commonBase.data.scene.fight.SkillTargetData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.scene.base.SceneSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 攻击伤害数据(generated by shine) */
public class AttackDamageRequest extends SceneSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.AttackDamage;
	
	/** 来源单位 */
	public int fromInstanceID;
	
	/** 目标数据 */
	public SkillTargetData target;
	
	/** 攻击ID */
	public int id;
	
	/** 攻击等级 */
	public int level;
	
	/** 伤害数据组 */
	public SList<DamageOneData> damageDatas;
	
	public AttackDamageRequest()
	{
		_dataID=GameRequestType.AttackDamage;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SkillTargetData targetTemp=target;
		if(targetTemp!=null)
		{
			this.target=(SkillTargetData)targetTemp.clone();
		}
		else
		{
			this.target=null;
			nullObjError("target");
		}
		
		SList<DamageOneData> damageDatasTemp=damageDatas;
		if(damageDatasTemp!=null)
		{
			this.damageDatas=new SList<DamageOneData>(DamageOneData[]::new,damageDatasTemp.size());
			SList<DamageOneData> damageDatasT=this.damageDatas;
			if(!damageDatasTemp.isEmpty())
			{
				Object[] damageDatasVValues=damageDatasTemp.getValues();
				for(int damageDatasVI=0,damageDatasVLen=damageDatasTemp.length();damageDatasVI<damageDatasVLen;++damageDatasVI)
				{
					DamageOneData damageDatasV=(DamageOneData)damageDatasVValues[damageDatasVI];
					DamageOneData damageDatasU;
					if(damageDatasV!=null)
					{
						damageDatasU=(DamageOneData)damageDatasV.clone();
					}
					else
					{
						damageDatasU=null;
					}
					
					damageDatasT.add(damageDatasU);
				}
			}
		}
		else
		{
			this.damageDatas=null;
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "AttackDamageRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("fromInstanceID");
		writer.sb.append(':');
		writer.sb.append(this.fromInstanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("target");
		writer.sb.append(':');
		if(this.target!=null)
		{
			this.target.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SkillTargetData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("level");
		writer.sb.append(':');
		writer.sb.append(this.level);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("damageDatas");
		writer.sb.append(':');
		writer.sb.append("List<DamageOneData>");
		if(this.damageDatas!=null)
		{
			SList<DamageOneData> damageDatasT=this.damageDatas;
			int damageDatasLen=damageDatasT.size();
			writer.sb.append('(');
			writer.sb.append(damageDatasLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int damageDatasI=0;damageDatasI<damageDatasLen;++damageDatasI)
			{
				DamageOneData damageDatasV=damageDatasT.get(damageDatasI);
				writer.writeTabs();
				writer.sb.append(damageDatasI);
				writer.sb.append(':');
				if(damageDatasV!=null)
				{
					damageDatasV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("DamageOneData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.fromInstanceID);
		
		if(this.target!=null)
		{
			stream.writeDataFullNotNull(this.target);
		}
		else
		{
			nullObjError("target");
		}
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.level);
		
		if(this.damageDatas!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.damageDatas.size());
			if(!this.damageDatas.isEmpty())
			{
				Object[] damageDatasVValues=this.damageDatas.getValues();
				for(int damageDatasVI=0,damageDatasVLen=this.damageDatas.length();damageDatasVI<damageDatasVLen;++damageDatasVI)
				{
					DamageOneData damageDatasV=(DamageOneData)damageDatasVValues[damageDatasVI];
					if(damageDatasV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataFullNotNull(damageDatasV);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.fromInstanceID);
		
		if(this.target!=null)
		{
			stream.writeDataSimpleNotNull(this.target);
		}
		else
		{
			nullObjError("target");
		}
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.level);
		
		if(this.damageDatas!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.damageDatas.size());
			if(!this.damageDatas.isEmpty())
			{
				Object[] damageDatasVValues=this.damageDatas.getValues();
				for(int damageDatasVI=0,damageDatasVLen=this.damageDatas.length();damageDatasVI<damageDatasVLen;++damageDatasVI)
				{
					DamageOneData damageDatasV=(DamageOneData)damageDatasVValues[damageDatasVI];
					if(damageDatasV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataSimpleNotNull(damageDatasV);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.fromInstanceID=0;
		this.target=null;
		this.id=0;
		this.level=0;
		this.damageDatas=null;
	}
	
	/** 创建实例 */
	public static AttackDamageRequest create(int fromInstanceID,SkillTargetData target,int id,int level,SList<DamageOneData> damageDatas)
	{
		AttackDamageRequest re=(AttackDamageRequest)BytesControl.createRequest(dataID);
		re.fromInstanceID=fromInstanceID;
		re.target=target;
		re.id=id;
		re.level=level;
		re.damageDatas=damageDatas;
		return re;
	}
	
}
