package com.home.commonBase.data.scene.unit;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.scene.base.BuffData;
import com.home.commonBase.data.scene.base.CDData;
import com.home.commonBase.data.scene.base.SkillData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntBooleanMap;
import com.home.shine.support.collection.IntIntMap;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.pool.DataPool;

/** 战斗基础数据(4元素+cd)(generated by shine) */
public class UnitFightData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.UnitFight;
	
	/** 状态组 */
	public IntBooleanMap status;
	
	/** 属性组 */
	public IntIntMap attributes;
	
	/** 技能组 */
	public IntObjectMap<SkillData> skills;
	
	/** buff组 */
	public IntObjectMap<BuffData> buffs;
	
	/** CD组 */
	public IntObjectMap<CDData> cds;
	
	public UnitFightData()
	{
		_dataID=BaseDataType.UnitFight;
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int statusLen=stream.readLen();
		if(this.status!=null)
		{
			this.status.clear();
			this.status.ensureCapacity(statusLen);
		}
		else
		{
			this.status=new IntBooleanMap(statusLen);
		}
		
		IntBooleanMap statusT=this.status;
		for(int statusI=statusLen-1;statusI>=0;--statusI)
		{
			int statusK;
			boolean statusV;
			statusK=stream.readInt();
			
			statusV=stream.readBoolean();
			
			statusT.put(statusK,statusV);
		}
		
		int attributesLen=stream.readLen();
		if(this.attributes!=null)
		{
			this.attributes.clear();
			this.attributes.ensureCapacity(attributesLen);
		}
		else
		{
			this.attributes=new IntIntMap(attributesLen);
		}
		
		IntIntMap attributesT=this.attributes;
		for(int attributesI=attributesLen-1;attributesI>=0;--attributesI)
		{
			int attributesK;
			int attributesV;
			attributesK=stream.readInt();
			
			attributesV=stream.readInt();
			
			attributesT.put(attributesK,attributesV);
		}
		
		int skillsLen=stream.readLen();
		if(this.skills!=null)
		{
			this.skills.clear();
			this.skills.ensureCapacity(skillsLen);
		}
		else
		{
			this.skills=new IntObjectMap<SkillData>(SkillData[]::new,skillsLen);
		}
		
		IntObjectMap<SkillData> skillsT=this.skills;
		for(int skillsI=skillsLen-1;skillsI>=0;--skillsI)
		{
			SkillData skillsV;
			BaseData skillsVT=stream.readDataFullNotNull();
			if(skillsVT!=null)
			{
				if(skillsVT instanceof SkillData)
				{
					skillsV=(SkillData)skillsVT;
				}
				else
				{
					skillsV=new SkillData();
					if(!(skillsVT.getClass().isAssignableFrom(SkillData.class)))
					{
						stream.throwTypeReadError(SkillData.class,skillsVT.getClass());
					}
					skillsV.shadowCopy(skillsVT);
				}
			}
			else
			{
				skillsV=null;
			}
			
			skillsT.put(skillsV.id,skillsV);
		}
		
		int buffsLen=stream.readLen();
		if(this.buffs!=null)
		{
			this.buffs.clear();
			this.buffs.ensureCapacity(buffsLen);
		}
		else
		{
			this.buffs=new IntObjectMap<BuffData>(BuffData[]::new,buffsLen);
		}
		
		IntObjectMap<BuffData> buffsT=this.buffs;
		for(int buffsI=buffsLen-1;buffsI>=0;--buffsI)
		{
			BuffData buffsV;
			BaseData buffsVT=stream.readDataFullNotNull();
			if(buffsVT!=null)
			{
				if(buffsVT instanceof BuffData)
				{
					buffsV=(BuffData)buffsVT;
				}
				else
				{
					buffsV=new BuffData();
					if(!(buffsVT.getClass().isAssignableFrom(BuffData.class)))
					{
						stream.throwTypeReadError(BuffData.class,buffsVT.getClass());
					}
					buffsV.shadowCopy(buffsVT);
				}
			}
			else
			{
				buffsV=null;
			}
			
			buffsT.put(buffsV.instanceID,buffsV);
		}
		
		int cdsLen=stream.readLen();
		if(this.cds!=null)
		{
			this.cds.clear();
			this.cds.ensureCapacity(cdsLen);
		}
		else
		{
			this.cds=new IntObjectMap<CDData>(CDData[]::new,cdsLen);
		}
		
		IntObjectMap<CDData> cdsT=this.cds;
		for(int cdsI=cdsLen-1;cdsI>=0;--cdsI)
		{
			CDData cdsV;
			cdsV=new CDData();
			cdsV.readBytesFull(stream);
			
			cdsT.put(cdsV.id,cdsV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.status!=null)
		{
			stream.writeLen(this.status.size());
			if(!this.status.isEmpty())
			{
				int statusKFreeValue=this.status.getFreeValue();
				int[] statusKKeys=this.status.getKeys();
				boolean[] statusVValues=this.status.getValues();
				for(int statusKI=statusKKeys.length-1;statusKI>=0;--statusKI)
				{
					int statusK=statusKKeys[statusKI];
					if(statusK!=statusKFreeValue)
					{
						boolean statusV=statusVValues[statusKI];
						stream.writeInt(statusK);
						
						stream.writeBoolean(statusV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("status");
		}
		
		if(this.attributes!=null)
		{
			stream.writeLen(this.attributes.size());
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				long[] attributesKTable=this.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						stream.writeInt(attributesK);
						
						stream.writeInt(attributesV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("attributes");
		}
		
		if(this.skills!=null)
		{
			stream.writeLen(this.skills.size());
			if(!this.skills.isEmpty())
			{
				Object[] skillsVValues=this.skills.getValues();
				for(int skillsVI=skillsVValues.length-1;skillsVI>=0;--skillsVI)
				{
					if(skillsVValues[skillsVI]!=null)
					{
						SkillData skillsV=(SkillData)skillsVValues[skillsVI];
						if(skillsV!=null)
						{
							stream.writeDataFullNotNull(skillsV);
						}
						else
						{
							nullObjError("skillsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("skills");
		}
		
		if(this.buffs!=null)
		{
			stream.writeLen(this.buffs.size());
			if(!this.buffs.isEmpty())
			{
				Object[] buffsVValues=this.buffs.getValues();
				for(int buffsVI=buffsVValues.length-1;buffsVI>=0;--buffsVI)
				{
					if(buffsVValues[buffsVI]!=null)
					{
						BuffData buffsV=(BuffData)buffsVValues[buffsVI];
						if(buffsV!=null)
						{
							stream.writeDataFullNotNull(buffsV);
						}
						else
						{
							nullObjError("buffsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("buffs");
		}
		
		if(this.cds!=null)
		{
			stream.writeLen(this.cds.size());
			if(!this.cds.isEmpty())
			{
				Object[] cdsVValues=this.cds.getValues();
				for(int cdsVI=cdsVValues.length-1;cdsVI>=0;--cdsVI)
				{
					if(cdsVValues[cdsVI]!=null)
					{
						CDData cdsV=(CDData)cdsVValues[cdsVI];
						if(cdsV!=null)
						{
							cdsV.writeBytesFull(stream);
						}
						else
						{
							nullObjError("cdsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("cds");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int statusLen=stream.readLen();
		if(this.status!=null)
		{
			this.status.clear();
			this.status.ensureCapacity(statusLen);
		}
		else
		{
			this.status=new IntBooleanMap(statusLen);
		}
		
		IntBooleanMap statusT=this.status;
		for(int statusI=statusLen-1;statusI>=0;--statusI)
		{
			int statusK;
			boolean statusV;
			statusK=stream.readInt();
			
			statusV=stream.readBoolean();
			
			statusT.put(statusK,statusV);
		}
		
		int attributesLen=stream.readLen();
		if(this.attributes!=null)
		{
			this.attributes.clear();
			this.attributes.ensureCapacity(attributesLen);
		}
		else
		{
			this.attributes=new IntIntMap(attributesLen);
		}
		
		IntIntMap attributesT=this.attributes;
		for(int attributesI=attributesLen-1;attributesI>=0;--attributesI)
		{
			int attributesK;
			int attributesV;
			attributesK=stream.readInt();
			
			attributesV=stream.readInt();
			
			attributesT.put(attributesK,attributesV);
		}
		
		int skillsLen=stream.readLen();
		if(this.skills!=null)
		{
			this.skills.clear();
			this.skills.ensureCapacity(skillsLen);
		}
		else
		{
			this.skills=new IntObjectMap<SkillData>(SkillData[]::new,skillsLen);
		}
		
		IntObjectMap<SkillData> skillsT=this.skills;
		for(int skillsI=skillsLen-1;skillsI>=0;--skillsI)
		{
			SkillData skillsV;
			skillsV=(SkillData)stream.readDataSimpleNotNull();
			
			skillsT.put(skillsV.id,skillsV);
		}
		
		int buffsLen=stream.readLen();
		if(this.buffs!=null)
		{
			this.buffs.clear();
			this.buffs.ensureCapacity(buffsLen);
		}
		else
		{
			this.buffs=new IntObjectMap<BuffData>(BuffData[]::new,buffsLen);
		}
		
		IntObjectMap<BuffData> buffsT=this.buffs;
		for(int buffsI=buffsLen-1;buffsI>=0;--buffsI)
		{
			BuffData buffsV;
			buffsV=(BuffData)stream.readDataSimpleNotNull();
			
			buffsT.put(buffsV.instanceID,buffsV);
		}
		
		int cdsLen=stream.readLen();
		if(this.cds!=null)
		{
			this.cds.clear();
			this.cds.ensureCapacity(cdsLen);
		}
		else
		{
			this.cds=new IntObjectMap<CDData>(CDData[]::new,cdsLen);
		}
		
		IntObjectMap<CDData> cdsT=this.cds;
		for(int cdsI=cdsLen-1;cdsI>=0;--cdsI)
		{
			CDData cdsV;
			cdsV=new CDData();
			cdsV.readBytesSimple(stream);
			
			cdsT.put(cdsV.id,cdsV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.status!=null)
		{
			stream.writeLen(this.status.size());
			if(!this.status.isEmpty())
			{
				int statusKFreeValue=this.status.getFreeValue();
				int[] statusKKeys=this.status.getKeys();
				boolean[] statusVValues=this.status.getValues();
				for(int statusKI=statusKKeys.length-1;statusKI>=0;--statusKI)
				{
					int statusK=statusKKeys[statusKI];
					if(statusK!=statusKFreeValue)
					{
						boolean statusV=statusVValues[statusKI];
						stream.writeInt(statusK);
						
						stream.writeBoolean(statusV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("status");
		}
		
		if(this.attributes!=null)
		{
			stream.writeLen(this.attributes.size());
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				long[] attributesKTable=this.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						stream.writeInt(attributesK);
						
						stream.writeInt(attributesV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("attributes");
		}
		
		if(this.skills!=null)
		{
			stream.writeLen(this.skills.size());
			if(!this.skills.isEmpty())
			{
				Object[] skillsVValues=this.skills.getValues();
				for(int skillsVI=skillsVValues.length-1;skillsVI>=0;--skillsVI)
				{
					if(skillsVValues[skillsVI]!=null)
					{
						SkillData skillsV=(SkillData)skillsVValues[skillsVI];
						if(skillsV!=null)
						{
							stream.writeDataSimpleNotNull(skillsV);
						}
						else
						{
							nullObjError("skillsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("skills");
		}
		
		if(this.buffs!=null)
		{
			stream.writeLen(this.buffs.size());
			if(!this.buffs.isEmpty())
			{
				Object[] buffsVValues=this.buffs.getValues();
				for(int buffsVI=buffsVValues.length-1;buffsVI>=0;--buffsVI)
				{
					if(buffsVValues[buffsVI]!=null)
					{
						BuffData buffsV=(BuffData)buffsVValues[buffsVI];
						if(buffsV!=null)
						{
							stream.writeDataSimpleNotNull(buffsV);
						}
						else
						{
							nullObjError("buffsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("buffs");
		}
		
		if(this.cds!=null)
		{
			stream.writeLen(this.cds.size());
			if(!this.cds.isEmpty())
			{
				Object[] cdsVValues=this.cds.getValues();
				for(int cdsVI=cdsVValues.length-1;cdsVI>=0;--cdsVI)
				{
					if(cdsVValues[cdsVI]!=null)
					{
						CDData cdsV=(CDData)cdsVValues[cdsVI];
						if(cdsV!=null)
						{
							cdsV.writeBytesSimple(stream);
						}
						else
						{
							nullObjError("cdsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("cds");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof UnitFightData))
			return;
		
		UnitFightData mData=(UnitFightData)data;
		
		this.status=mData.status;
		this.attributes=mData.attributes;
		this.skills=mData.skills;
		this.buffs=mData.buffs;
		this.cds=mData.cds;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof UnitFightData))
			return;
		
		UnitFightData mData=(UnitFightData)data;
		
		if(mData.status!=null)
		{
			if(this.status!=null)
			{
				this.status.clear();
				this.status.ensureCapacity(mData.status.size());
			}
			else
			{
				this.status=new IntBooleanMap(mData.status.size());
			}
			
			IntBooleanMap statusT=this.status;
			if(!mData.status.isEmpty())
			{
				int statusKFreeValue=mData.status.getFreeValue();
				int[] statusKKeys=mData.status.getKeys();
				boolean[] statusVValues=mData.status.getValues();
				for(int statusKI=statusKKeys.length-1;statusKI>=0;--statusKI)
				{
					int statusK=statusKKeys[statusKI];
					if(statusK!=statusKFreeValue)
					{
						boolean statusV=statusVValues[statusKI];
						int statusW;
						boolean statusU;
						statusW=statusK;
						
						statusU=statusV;
						
						statusT.put(statusW,statusU);
					}
				}
			}
		}
		else
		{
			this.status=null;
			nullObjError("status");
		}
		
		if(mData.attributes!=null)
		{
			if(this.attributes!=null)
			{
				this.attributes.clear();
				this.attributes.ensureCapacity(mData.attributes.size());
			}
			else
			{
				this.attributes=new IntIntMap(mData.attributes.size());
			}
			
			IntIntMap attributesT=this.attributes;
			if(!mData.attributes.isEmpty())
			{
				int attributesKFreeValue=mData.attributes.getFreeValue();
				long[] attributesKTable=mData.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						int attributesW;
						int attributesU;
						attributesW=attributesK;
						
						attributesU=attributesV;
						
						attributesT.put(attributesW,attributesU);
					}
				}
			}
		}
		else
		{
			this.attributes=null;
			nullObjError("attributes");
		}
		
		if(mData.skills!=null)
		{
			if(this.skills!=null)
			{
				this.skills.clear();
				this.skills.ensureCapacity(mData.skills.size());
			}
			else
			{
				this.skills=new IntObjectMap<SkillData>(SkillData[]::new,mData.skills.size());
			}
			
			IntObjectMap<SkillData> skillsT=this.skills;
			if(!mData.skills.isEmpty())
			{
				Object[] skillsVValues=mData.skills.getValues();
				for(int skillsVI=skillsVValues.length-1;skillsVI>=0;--skillsVI)
				{
					if(skillsVValues[skillsVI]!=null)
					{
						SkillData skillsV=(SkillData)skillsVValues[skillsVI];
						SkillData skillsU;
						if(skillsV!=null)
						{
							skillsU=(SkillData)skillsV.clone();
						}
						else
						{
							skillsU=null;
							nullObjError("skillsU");
						}
						
						skillsT.put(skillsU.id,skillsU);
					}
				}
			}
		}
		else
		{
			this.skills=null;
			nullObjError("skills");
		}
		
		if(mData.buffs!=null)
		{
			if(this.buffs!=null)
			{
				this.buffs.clear();
				this.buffs.ensureCapacity(mData.buffs.size());
			}
			else
			{
				this.buffs=new IntObjectMap<BuffData>(BuffData[]::new,mData.buffs.size());
			}
			
			IntObjectMap<BuffData> buffsT=this.buffs;
			if(!mData.buffs.isEmpty())
			{
				Object[] buffsVValues=mData.buffs.getValues();
				for(int buffsVI=buffsVValues.length-1;buffsVI>=0;--buffsVI)
				{
					if(buffsVValues[buffsVI]!=null)
					{
						BuffData buffsV=(BuffData)buffsVValues[buffsVI];
						BuffData buffsU;
						if(buffsV!=null)
						{
							buffsU=(BuffData)buffsV.clone();
						}
						else
						{
							buffsU=null;
							nullObjError("buffsU");
						}
						
						buffsT.put(buffsU.instanceID,buffsU);
					}
				}
			}
		}
		else
		{
			this.buffs=null;
			nullObjError("buffs");
		}
		
		if(mData.cds!=null)
		{
			if(this.cds!=null)
			{
				this.cds.clear();
				this.cds.ensureCapacity(mData.cds.size());
			}
			else
			{
				this.cds=new IntObjectMap<CDData>(CDData[]::new,mData.cds.size());
			}
			
			IntObjectMap<CDData> cdsT=this.cds;
			if(!mData.cds.isEmpty())
			{
				Object[] cdsVValues=mData.cds.getValues();
				for(int cdsVI=cdsVValues.length-1;cdsVI>=0;--cdsVI)
				{
					if(cdsVValues[cdsVI]!=null)
					{
						CDData cdsV=(CDData)cdsVValues[cdsVI];
						CDData cdsU;
						if(cdsV!=null)
						{
							cdsU=new CDData();
							cdsU.copy(cdsV);
						}
						else
						{
							cdsU=null;
							nullObjError("cdsU");
						}
						
						cdsT.put(cdsU.id,cdsU);
					}
				}
			}
		}
		else
		{
			this.cds=null;
			nullObjError("cds");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		UnitFightData mData=(UnitFightData)data;
		if(mData.status!=null)
		{
			if(this.status==null)
				return false;
			if(this.status.size()!=mData.status.size())
				return false;
			IntBooleanMap statusR=mData.status;
			if(!this.status.isEmpty())
			{
				int statusKFreeValue=this.status.getFreeValue();
				int[] statusKKeys=this.status.getKeys();
				boolean[] statusVValues=this.status.getValues();
				for(int statusKI=statusKKeys.length-1;statusKI>=0;--statusKI)
				{
					int statusK=statusKKeys[statusKI];
					if(statusK!=statusKFreeValue)
					{
						boolean statusV=statusVValues[statusKI];
						boolean statusU=statusR.get(statusK);
						if(statusV!=statusU)
							return false;
						
					}
				}
			}
		}
		else
		{
			if(this.status!=null)
				return false;
		}
		
		if(mData.attributes!=null)
		{
			if(this.attributes==null)
				return false;
			if(this.attributes.size()!=mData.attributes.size())
				return false;
			IntIntMap attributesR=mData.attributes;
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				long[] attributesKTable=this.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						int attributesU=attributesR.get(attributesK);
						if(attributesV!=attributesU)
							return false;
						
					}
				}
			}
		}
		else
		{
			if(this.attributes!=null)
				return false;
		}
		
		if(mData.skills!=null)
		{
			if(this.skills==null)
				return false;
			if(this.skills.size()!=mData.skills.size())
				return false;
			IntObjectMap<SkillData> skillsR=mData.skills;
			if(!this.skills.isEmpty())
			{
				int skillsKFreeValue=this.skills.getFreeValue();
				int[] skillsKKeys=this.skills.getKeys();
				Object[] skillsVValues=this.skills.getValues();
				for(int skillsKI=skillsKKeys.length-1;skillsKI>=0;--skillsKI)
				{
					int skillsK=skillsKKeys[skillsKI];
					if(skillsK!=skillsKFreeValue)
					{
						SkillData skillsV=(SkillData)skillsVValues[skillsKI];
						SkillData skillsU=skillsR.get(skillsK);
						if(skillsU!=null)
						{
							if(skillsV==null)
								return false;
							if(!skillsV.dataEquals(skillsU))
								return false;
						}
						else
						{
							if(skillsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.skills!=null)
				return false;
		}
		
		if(mData.buffs!=null)
		{
			if(this.buffs==null)
				return false;
			if(this.buffs.size()!=mData.buffs.size())
				return false;
			IntObjectMap<BuffData> buffsR=mData.buffs;
			if(!this.buffs.isEmpty())
			{
				int buffsKFreeValue=this.buffs.getFreeValue();
				int[] buffsKKeys=this.buffs.getKeys();
				Object[] buffsVValues=this.buffs.getValues();
				for(int buffsKI=buffsKKeys.length-1;buffsKI>=0;--buffsKI)
				{
					int buffsK=buffsKKeys[buffsKI];
					if(buffsK!=buffsKFreeValue)
					{
						BuffData buffsV=(BuffData)buffsVValues[buffsKI];
						BuffData buffsU=buffsR.get(buffsK);
						if(buffsU!=null)
						{
							if(buffsV==null)
								return false;
							if(!buffsV.dataEquals(buffsU))
								return false;
						}
						else
						{
							if(buffsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.buffs!=null)
				return false;
		}
		
		if(mData.cds!=null)
		{
			if(this.cds==null)
				return false;
			if(this.cds.size()!=mData.cds.size())
				return false;
			IntObjectMap<CDData> cdsR=mData.cds;
			if(!this.cds.isEmpty())
			{
				int cdsKFreeValue=this.cds.getFreeValue();
				int[] cdsKKeys=this.cds.getKeys();
				Object[] cdsVValues=this.cds.getValues();
				for(int cdsKI=cdsKKeys.length-1;cdsKI>=0;--cdsKI)
				{
					int cdsK=cdsKKeys[cdsKI];
					if(cdsK!=cdsKFreeValue)
					{
						CDData cdsV=(CDData)cdsVValues[cdsKI];
						CDData cdsU=cdsR.get(cdsK);
						if(cdsU!=null)
						{
							if(cdsV==null)
								return false;
							if(!cdsV.dataEquals(cdsU))
								return false;
						}
						else
						{
							if(cdsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.cds!=null)
				return false;
		}
		
		return true;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitFightData";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("status");
		writer.sb.append(':');
		writer.sb.append("Map<int,boolean>");
		if(this.status!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.status.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.status.isEmpty())
			{
				int statusKFreeValue=this.status.getFreeValue();
				int[] statusKKeys=this.status.getKeys();
				boolean[] statusVValues=this.status.getValues();
				for(int statusKI=statusKKeys.length-1;statusKI>=0;--statusKI)
				{
					int statusK=statusKKeys[statusKI];
					if(statusK!=statusKFreeValue)
					{
						boolean statusV=statusVValues[statusKI];
						writer.writeTabs();
						writer.sb.append(statusK);
						
						writer.sb.append(':');
						writer.sb.append(statusV);
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("attributes");
		writer.sb.append(':');
		writer.sb.append("Map<int,int>");
		if(this.attributes!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.attributes.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				long[] attributesKTable=this.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						writer.writeTabs();
						writer.sb.append(attributesK);
						
						writer.sb.append(':');
						writer.sb.append(attributesV);
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("skills");
		writer.sb.append(':');
		writer.sb.append("Map<int,SkillData>");
		if(this.skills!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.skills.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.skills.isEmpty())
			{
				int skillsKFreeValue=this.skills.getFreeValue();
				int[] skillsKKeys=this.skills.getKeys();
				Object[] skillsVValues=this.skills.getValues();
				for(int skillsKI=skillsKKeys.length-1;skillsKI>=0;--skillsKI)
				{
					int skillsK=skillsKKeys[skillsKI];
					if(skillsK!=skillsKFreeValue)
					{
						SkillData skillsV=(SkillData)skillsVValues[skillsKI];
						writer.writeTabs();
						writer.sb.append(skillsK);
						
						writer.sb.append(':');
						if(skillsV!=null)
						{
							skillsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("SkillData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("buffs");
		writer.sb.append(':');
		writer.sb.append("Map<int,BuffData>");
		if(this.buffs!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.buffs.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.buffs.isEmpty())
			{
				int buffsKFreeValue=this.buffs.getFreeValue();
				int[] buffsKKeys=this.buffs.getKeys();
				Object[] buffsVValues=this.buffs.getValues();
				for(int buffsKI=buffsKKeys.length-1;buffsKI>=0;--buffsKI)
				{
					int buffsK=buffsKKeys[buffsKI];
					if(buffsK!=buffsKFreeValue)
					{
						BuffData buffsV=(BuffData)buffsVValues[buffsKI];
						writer.writeTabs();
						writer.sb.append(buffsK);
						
						writer.sb.append(':');
						if(buffsV!=null)
						{
							buffsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("BuffData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("cds");
		writer.sb.append(':');
		writer.sb.append("Map<int,CDData>");
		if(this.cds!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.cds.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.cds.isEmpty())
			{
				int cdsKFreeValue=this.cds.getFreeValue();
				int[] cdsKKeys=this.cds.getKeys();
				Object[] cdsVValues=this.cds.getValues();
				for(int cdsKI=cdsKKeys.length-1;cdsKI>=0;--cdsKI)
				{
					int cdsK=cdsKKeys[cdsKI];
					if(cdsK!=cdsKFreeValue)
					{
						CDData cdsV=(CDData)cdsVValues[cdsKI];
						writer.writeTabs();
						writer.sb.append(cdsK);
						
						writer.sb.append(':');
						if(cdsV!=null)
						{
							cdsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("CDData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.status=new IntBooleanMap();
		this.attributes=new IntIntMap();
		this.skills=new IntObjectMap<SkillData>(SkillData[]::new);
		this.buffs=new IntObjectMap<BuffData>(BuffData[]::new);
		this.cds=new IntObjectMap<CDData>(CDData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.status=null;
		this.attributes=null;
		this.skills=null;
		this.buffs=null;
		this.cds=null;
	}
	
}
