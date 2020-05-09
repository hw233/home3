package com.home.commonBase.part.player.data;
import com.home.commonBase.constlist.generate.PlayerPartDataType;
import com.home.commonBase.data.role.PetSaveData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.pool.DataPool;

/** 宠物(generated by shine) */
public class PetPartData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=PlayerPartDataType.Pet;
	
	/** 宠物字典 */
	public IntObjectMap<PetSaveData> petDic;
	
	public PetPartData()
	{
		_dataID=PlayerPartDataType.Pet;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PetPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int petDicLen=stream.readLen();
		if(this.petDic!=null)
		{
			this.petDic.clear();
			this.petDic.ensureCapacity(petDicLen);
		}
		else
		{
			this.petDic=new IntObjectMap<PetSaveData>(PetSaveData[]::new,petDicLen);
		}
		
		IntObjectMap<PetSaveData> petDicT=this.petDic;
		for(int petDicI=petDicLen-1;petDicI>=0;--petDicI)
		{
			PetSaveData petDicV;
			BaseData petDicVT=stream.readDataFullNotNull();
			if(petDicVT!=null)
			{
				if(petDicVT instanceof PetSaveData)
				{
					petDicV=(PetSaveData)petDicVT;
				}
				else
				{
					petDicV=new PetSaveData();
					if(!(petDicVT.getClass().isAssignableFrom(PetSaveData.class)))
					{
						stream.throwTypeReadError(PetSaveData.class,petDicVT.getClass());
					}
					petDicV.shadowCopy(petDicVT);
				}
			}
			else
			{
				petDicV=null;
			}
			
			petDicT.put(petDicV.mIndex,petDicV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.petDic!=null)
		{
			stream.writeLen(this.petDic.size());
			if(!this.petDic.isEmpty())
			{
				Object[] petDicVValues=this.petDic.getValues();
				for(int petDicVI=petDicVValues.length-1;petDicVI>=0;--petDicVI)
				{
					if(petDicVValues[petDicVI]!=null)
					{
						PetSaveData petDicV=(PetSaveData)petDicVValues[petDicVI];
						if(petDicV!=null)
						{
							stream.writeDataFullNotNull(petDicV);
						}
						else
						{
							nullObjError("petDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("petDic");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int petDicLen=stream.readLen();
		if(this.petDic!=null)
		{
			this.petDic.clear();
			this.petDic.ensureCapacity(petDicLen);
		}
		else
		{
			this.petDic=new IntObjectMap<PetSaveData>(PetSaveData[]::new,petDicLen);
		}
		
		IntObjectMap<PetSaveData> petDicT=this.petDic;
		for(int petDicI=petDicLen-1;petDicI>=0;--petDicI)
		{
			PetSaveData petDicV;
			petDicV=(PetSaveData)stream.readDataSimpleNotNull();
			
			petDicT.put(petDicV.mIndex,petDicV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.petDic!=null)
		{
			stream.writeLen(this.petDic.size());
			if(!this.petDic.isEmpty())
			{
				Object[] petDicVValues=this.petDic.getValues();
				for(int petDicVI=petDicVValues.length-1;petDicVI>=0;--petDicVI)
				{
					if(petDicVValues[petDicVI]!=null)
					{
						PetSaveData petDicV=(PetSaveData)petDicVValues[petDicVI];
						if(petDicV!=null)
						{
							stream.writeDataSimpleNotNull(petDicV);
						}
						else
						{
							nullObjError("petDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("petDic");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof PetPartData))
			return;
		
		PetPartData mData=(PetPartData)data;
		
		this.petDic=mData.petDic;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof PetPartData))
			return;
		
		PetPartData mData=(PetPartData)data;
		
		if(mData.petDic!=null)
		{
			if(this.petDic!=null)
			{
				this.petDic.clear();
				this.petDic.ensureCapacity(mData.petDic.size());
			}
			else
			{
				this.petDic=new IntObjectMap<PetSaveData>(PetSaveData[]::new,mData.petDic.size());
			}
			
			IntObjectMap<PetSaveData> petDicT=this.petDic;
			if(!mData.petDic.isEmpty())
			{
				Object[] petDicVValues=mData.petDic.getValues();
				for(int petDicVI=petDicVValues.length-1;petDicVI>=0;--petDicVI)
				{
					if(petDicVValues[petDicVI]!=null)
					{
						PetSaveData petDicV=(PetSaveData)petDicVValues[petDicVI];
						PetSaveData petDicU;
						if(petDicV!=null)
						{
							petDicU=(PetSaveData)petDicV.clone();
						}
						else
						{
							petDicU=null;
							nullObjError("petDicU");
						}
						
						petDicT.put(petDicU.mIndex,petDicU);
					}
				}
			}
		}
		else
		{
			this.petDic=null;
			nullObjError("petDic");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		PetPartData mData=(PetPartData)data;
		if(mData.petDic!=null)
		{
			if(this.petDic==null)
				return false;
			if(this.petDic.size()!=mData.petDic.size())
				return false;
			IntObjectMap<PetSaveData> petDicR=mData.petDic;
			if(!this.petDic.isEmpty())
			{
				int petDicKFreeValue=this.petDic.getFreeValue();
				int[] petDicKKeys=this.petDic.getKeys();
				Object[] petDicVValues=this.petDic.getValues();
				for(int petDicKI=petDicKKeys.length-1;petDicKI>=0;--petDicKI)
				{
					int petDicK=petDicKKeys[petDicKI];
					if(petDicK!=petDicKFreeValue)
					{
						PetSaveData petDicV=(PetSaveData)petDicVValues[petDicKI];
						PetSaveData petDicU=petDicR.get(petDicK);
						if(petDicU!=null)
						{
							if(petDicV==null)
								return false;
							if(!petDicV.dataEquals(petDicU))
								return false;
						}
						else
						{
							if(petDicV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.petDic!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("petDic");
		writer.sb.append(':');
		writer.sb.append("Map<int,PetSaveData>");
		if(this.petDic!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.petDic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.petDic.isEmpty())
			{
				int petDicKFreeValue=this.petDic.getFreeValue();
				int[] petDicKKeys=this.petDic.getKeys();
				Object[] petDicVValues=this.petDic.getValues();
				for(int petDicKI=petDicKKeys.length-1;petDicKI>=0;--petDicKI)
				{
					int petDicK=petDicKKeys[petDicKI];
					if(petDicK!=petDicKFreeValue)
					{
						PetSaveData petDicV=(PetSaveData)petDicVValues[petDicKI];
						writer.writeTabs();
						writer.sb.append(petDicK);
						
						writer.sb.append(':');
						if(petDicV!=null)
						{
							petDicV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("PetSaveData=null");
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
		this.petDic=new IntObjectMap<PetSaveData>(PetSaveData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.petDic=null;
	}
	
}
