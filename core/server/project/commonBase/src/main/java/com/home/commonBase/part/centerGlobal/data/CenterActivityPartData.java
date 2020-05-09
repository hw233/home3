package com.home.commonBase.part.centerGlobal.data;
import com.home.commonBase.constlist.generate.CenterGlobalPartDataType;
import com.home.commonBase.data.activity.ActivityServerData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.pool.DataPool;

/** 活动数据(generated by shine) */
public class CenterActivityPartData extends BaseData
{
	/** 数据组 */
	public IntObjectMap<ActivityServerData> datas;
	
	/** 数据类型ID */
	public static final int dataID=CenterGlobalPartDataType.CenterActivity;
	
	public CenterActivityPartData()
	{
		_dataID=CenterGlobalPartDataType.CenterActivity;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterActivityPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int datasLen=stream.readLen();
		if(this.datas!=null)
		{
			this.datas.clear();
			this.datas.ensureCapacity(datasLen);
		}
		else
		{
			this.datas=new IntObjectMap<ActivityServerData>(ActivityServerData[]::new,datasLen);
		}
		
		IntObjectMap<ActivityServerData> datasT=this.datas;
		for(int datasI=datasLen-1;datasI>=0;--datasI)
		{
			ActivityServerData datasV;
			BaseData datasVT=stream.readDataFullNotNull();
			if(datasVT!=null)
			{
				if(datasVT instanceof ActivityServerData)
				{
					datasV=(ActivityServerData)datasVT;
				}
				else
				{
					datasV=new ActivityServerData();
					if(!(datasVT.getClass().isAssignableFrom(ActivityServerData.class)))
					{
						stream.throwTypeReadError(ActivityServerData.class,datasVT.getClass());
					}
					datasV.shadowCopy(datasVT);
				}
			}
			else
			{
				datasV=null;
			}
			
			datasT.put(datasV.id,datasV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.datas!=null)
		{
			stream.writeLen(this.datas.size());
			if(!this.datas.isEmpty())
			{
				Object[] datasVValues=this.datas.getValues();
				for(int datasVI=datasVValues.length-1;datasVI>=0;--datasVI)
				{
					if(datasVValues[datasVI]!=null)
					{
						ActivityServerData datasV=(ActivityServerData)datasVValues[datasVI];
						if(datasV!=null)
						{
							stream.writeDataFullNotNull(datasV);
						}
						else
						{
							nullObjError("datasV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("datas");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int datasLen=stream.readLen();
		if(this.datas!=null)
		{
			this.datas.clear();
			this.datas.ensureCapacity(datasLen);
		}
		else
		{
			this.datas=new IntObjectMap<ActivityServerData>(ActivityServerData[]::new,datasLen);
		}
		
		IntObjectMap<ActivityServerData> datasT=this.datas;
		for(int datasI=datasLen-1;datasI>=0;--datasI)
		{
			ActivityServerData datasV;
			datasV=(ActivityServerData)stream.readDataSimpleNotNull();
			
			datasT.put(datasV.id,datasV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.datas!=null)
		{
			stream.writeLen(this.datas.size());
			if(!this.datas.isEmpty())
			{
				Object[] datasVValues=this.datas.getValues();
				for(int datasVI=datasVValues.length-1;datasVI>=0;--datasVI)
				{
					if(datasVValues[datasVI]!=null)
					{
						ActivityServerData datasV=(ActivityServerData)datasVValues[datasVI];
						if(datasV!=null)
						{
							stream.writeDataSimpleNotNull(datasV);
						}
						else
						{
							nullObjError("datasV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("datas");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof CenterActivityPartData))
			return;
		
		CenterActivityPartData mData=(CenterActivityPartData)data;
		
		this.datas=mData.datas;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof CenterActivityPartData))
			return;
		
		CenterActivityPartData mData=(CenterActivityPartData)data;
		
		if(mData.datas!=null)
		{
			if(this.datas!=null)
			{
				this.datas.clear();
				this.datas.ensureCapacity(mData.datas.size());
			}
			else
			{
				this.datas=new IntObjectMap<ActivityServerData>(ActivityServerData[]::new,mData.datas.size());
			}
			
			IntObjectMap<ActivityServerData> datasT=this.datas;
			if(!mData.datas.isEmpty())
			{
				Object[] datasVValues=mData.datas.getValues();
				for(int datasVI=datasVValues.length-1;datasVI>=0;--datasVI)
				{
					if(datasVValues[datasVI]!=null)
					{
						ActivityServerData datasV=(ActivityServerData)datasVValues[datasVI];
						ActivityServerData datasU;
						if(datasV!=null)
						{
							datasU=(ActivityServerData)datasV.clone();
						}
						else
						{
							datasU=null;
							nullObjError("datasU");
						}
						
						datasT.put(datasU.id,datasU);
					}
				}
			}
		}
		else
		{
			this.datas=null;
			nullObjError("datas");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		CenterActivityPartData mData=(CenterActivityPartData)data;
		if(mData.datas!=null)
		{
			if(this.datas==null)
				return false;
			if(this.datas.size()!=mData.datas.size())
				return false;
			IntObjectMap<ActivityServerData> datasR=mData.datas;
			if(!this.datas.isEmpty())
			{
				int datasKFreeValue=this.datas.getFreeValue();
				int[] datasKKeys=this.datas.getKeys();
				Object[] datasVValues=this.datas.getValues();
				for(int datasKI=datasKKeys.length-1;datasKI>=0;--datasKI)
				{
					int datasK=datasKKeys[datasKI];
					if(datasK!=datasKFreeValue)
					{
						ActivityServerData datasV=(ActivityServerData)datasVValues[datasKI];
						ActivityServerData datasU=datasR.get(datasK);
						if(datasU!=null)
						{
							if(datasV==null)
								return false;
							if(!datasV.dataEquals(datasU))
								return false;
						}
						else
						{
							if(datasV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.datas!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("datas");
		writer.sb.append(':');
		writer.sb.append("Map<int,ActivityServerData>");
		if(this.datas!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.datas.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.datas.isEmpty())
			{
				int datasKFreeValue=this.datas.getFreeValue();
				int[] datasKKeys=this.datas.getKeys();
				Object[] datasVValues=this.datas.getValues();
				for(int datasKI=datasKKeys.length-1;datasKI>=0;--datasKI)
				{
					int datasK=datasKKeys[datasKI];
					if(datasK!=datasKFreeValue)
					{
						ActivityServerData datasV=(ActivityServerData)datasVValues[datasKI];
						writer.writeTabs();
						writer.sb.append(datasK);
						
						writer.sb.append(':');
						if(datasV!=null)
						{
							datasV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("ActivityServerData=null");
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
		this.datas=new IntObjectMap<ActivityServerData>(ActivityServerData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.datas=null;
	}
	
}
