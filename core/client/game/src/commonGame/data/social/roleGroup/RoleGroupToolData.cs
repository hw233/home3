using ShineEngine;

/// <summary>
/// 玩家群数据(generated by shine)
/// </summary>
public class RoleGroupToolData:FuncToolData
{
	/// <summary>
	/// 简版信息组
	/// </summary>
	public LongObjectMap<RoleGroupSimpleData> simpleDatas;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.RoleGroupTool;
	
	public RoleGroupToolData()
	{
		_dataID=BaseDataType.RoleGroupTool;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RoleGroupToolData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int simpleDatasLen=stream.readLen();
		if(this.simpleDatas!=null)
		{
			this.simpleDatas.clear();
			this.simpleDatas.ensureCapacity(simpleDatasLen);
		}
		else
		{
			this.simpleDatas=new LongObjectMap<RoleGroupSimpleData>(simpleDatasLen);
		}
		
		LongObjectMap<RoleGroupSimpleData> simpleDatasT=this.simpleDatas;
		for(int simpleDatasI=simpleDatasLen-1;simpleDatasI>=0;--simpleDatasI)
		{
			long simpleDatasK;
			RoleGroupSimpleData simpleDatasV;
			simpleDatasK=stream.readLong();
			
			BaseData simpleDatasVT=stream.readDataFullNotNull();
			if(simpleDatasVT!=null)
			{
				if(simpleDatasVT is RoleGroupSimpleData)
				{
					simpleDatasV=(RoleGroupSimpleData)simpleDatasVT;
				}
				else
				{
					simpleDatasV=new RoleGroupSimpleData();
					if(!(simpleDatasVT.GetType().IsAssignableFrom(typeof(RoleGroupSimpleData))))
					{
						stream.throwTypeReadError(typeof(RoleGroupSimpleData),simpleDatasVT.GetType());
					}
					simpleDatasV.shadowCopy(simpleDatasVT);
				}
			}
			else
			{
				simpleDatasV=null;
			}
			
			simpleDatasT.put(simpleDatasK,simpleDatasV);
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.simpleDatas!=null)
		{
			stream.writeLen(this.simpleDatas.size());
			if(!this.simpleDatas.isEmpty())
			{
				long simpleDatasKFreeValue=this.simpleDatas.getFreeValue();
				long[] simpleDatasKKeys=this.simpleDatas.getKeys();
				RoleGroupSimpleData[] simpleDatasVValues=this.simpleDatas.getValues();
				for(int simpleDatasKI=simpleDatasKKeys.Length-1;simpleDatasKI>=0;--simpleDatasKI)
				{
					long simpleDatasK=simpleDatasKKeys[simpleDatasKI];
					if(simpleDatasK!=simpleDatasKFreeValue)
					{
						RoleGroupSimpleData simpleDatasV=simpleDatasVValues[simpleDatasKI];
						stream.writeLong(simpleDatasK);
						
						if(simpleDatasV!=null)
						{
							stream.writeDataFullNotNull(simpleDatasV);
						}
						else
						{
							nullObjError("simpleDatasV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("simpleDatas");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		int simpleDatasLen=stream.readLen();
		if(this.simpleDatas!=null)
		{
			this.simpleDatas.clear();
			this.simpleDatas.ensureCapacity(simpleDatasLen);
		}
		else
		{
			this.simpleDatas=new LongObjectMap<RoleGroupSimpleData>(simpleDatasLen);
		}
		
		LongObjectMap<RoleGroupSimpleData> simpleDatasT=this.simpleDatas;
		for(int simpleDatasI=simpleDatasLen-1;simpleDatasI>=0;--simpleDatasI)
		{
			long simpleDatasK;
			RoleGroupSimpleData simpleDatasV;
			simpleDatasK=stream.readLong();
			
			simpleDatasV=(RoleGroupSimpleData)stream.readDataSimpleNotNull();
			
			simpleDatasT.put(simpleDatasK,simpleDatasV);
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.simpleDatas!=null)
		{
			stream.writeLen(this.simpleDatas.size());
			if(!this.simpleDatas.isEmpty())
			{
				long simpleDatasKFreeValue=this.simpleDatas.getFreeValue();
				long[] simpleDatasKKeys=this.simpleDatas.getKeys();
				RoleGroupSimpleData[] simpleDatasVValues=this.simpleDatas.getValues();
				for(int simpleDatasKI=simpleDatasKKeys.Length-1;simpleDatasKI>=0;--simpleDatasKI)
				{
					long simpleDatasK=simpleDatasKKeys[simpleDatasKI];
					if(simpleDatasK!=simpleDatasKFreeValue)
					{
						RoleGroupSimpleData simpleDatasV=simpleDatasVValues[simpleDatasKI];
						stream.writeLong(simpleDatasK);
						
						if(simpleDatasV!=null)
						{
							stream.writeDataSimpleNotNull(simpleDatasV);
						}
						else
						{
							nullObjError("simpleDatasV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("simpleDatas");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is RoleGroupToolData))
			return;
		
		RoleGroupToolData mData=(RoleGroupToolData)data;
		
		this.simpleDatas=mData.simpleDatas;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is RoleGroupToolData))
			return;
		
		RoleGroupToolData mData=(RoleGroupToolData)data;
		
		if(mData.simpleDatas!=null)
		{
			if(this.simpleDatas!=null)
			{
				this.simpleDatas.clear();
				this.simpleDatas.ensureCapacity(mData.simpleDatas.size());
			}
			else
			{
				this.simpleDatas=new LongObjectMap<RoleGroupSimpleData>(mData.simpleDatas.size());
			}
			
			LongObjectMap<RoleGroupSimpleData> simpleDatasT=this.simpleDatas;
			if(!mData.simpleDatas.isEmpty())
			{
				long simpleDatasKFreeValue=mData.simpleDatas.getFreeValue();
				long[] simpleDatasKKeys=mData.simpleDatas.getKeys();
				RoleGroupSimpleData[] simpleDatasVValues=mData.simpleDatas.getValues();
				for(int simpleDatasKI=simpleDatasKKeys.Length-1;simpleDatasKI>=0;--simpleDatasKI)
				{
					long simpleDatasK=simpleDatasKKeys[simpleDatasKI];
					if(simpleDatasK!=simpleDatasKFreeValue)
					{
						RoleGroupSimpleData simpleDatasV=simpleDatasVValues[simpleDatasKI];
						long simpleDatasW;
						RoleGroupSimpleData simpleDatasU;
						simpleDatasW=simpleDatasK;
						
						if(simpleDatasV!=null)
						{
							simpleDatasU=(RoleGroupSimpleData)simpleDatasV.clone();
						}
						else
						{
							simpleDatasU=null;
							nullObjError("simpleDatasU");
						}
						
						simpleDatasT.put(simpleDatasW,simpleDatasU);
					}
				}
			}
		}
		else
		{
			this.simpleDatas=null;
			nullObjError("simpleDatas");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		RoleGroupToolData mData=(RoleGroupToolData)data;
		if(mData.simpleDatas!=null)
		{
			if(this.simpleDatas==null)
				return false;
			if(this.simpleDatas.size()!=mData.simpleDatas.size())
				return false;
			LongObjectMap<RoleGroupSimpleData> simpleDatasR=mData.simpleDatas;
			if(!this.simpleDatas.isEmpty())
			{
				long simpleDatasKFreeValue=this.simpleDatas.getFreeValue();
				long[] simpleDatasKKeys=this.simpleDatas.getKeys();
				RoleGroupSimpleData[] simpleDatasVValues=this.simpleDatas.getValues();
				for(int simpleDatasKI=simpleDatasKKeys.Length-1;simpleDatasKI>=0;--simpleDatasKI)
				{
					long simpleDatasK=simpleDatasKKeys[simpleDatasKI];
					if(simpleDatasK!=simpleDatasKFreeValue)
					{
						RoleGroupSimpleData simpleDatasV=simpleDatasVValues[simpleDatasKI];
						RoleGroupSimpleData simpleDatasU=simpleDatasR.get(simpleDatasK);
						if(simpleDatasU!=null)
						{
							if(simpleDatasV==null)
								return false;
							if(!simpleDatasV.dataEquals(simpleDatasU))
								return false;
						}
						else
						{
							if(simpleDatasV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.simpleDatas!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("simpleDatas");
		writer.sb.Append(':');
		writer.sb.Append("Map<long,RoleGroupSimpleData>");
		if(this.simpleDatas!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.simpleDatas.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.simpleDatas.isEmpty())
			{
				long simpleDatasKFreeValue=this.simpleDatas.getFreeValue();
				long[] simpleDatasKKeys=this.simpleDatas.getKeys();
				RoleGroupSimpleData[] simpleDatasVValues=this.simpleDatas.getValues();
				for(int simpleDatasKI=simpleDatasKKeys.Length-1;simpleDatasKI>=0;--simpleDatasKI)
				{
					long simpleDatasK=simpleDatasKKeys[simpleDatasKI];
					if(simpleDatasK!=simpleDatasKFreeValue)
					{
						RoleGroupSimpleData simpleDatasV=simpleDatasVValues[simpleDatasKI];
						writer.writeTabs();
						writer.sb.Append(simpleDatasK);
						
						writer.sb.Append(':');
						if(simpleDatasV!=null)
						{
							simpleDatasV.writeDataString(writer);
						}
						else
						{
							writer.sb.Append("RoleGroupSimpleData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
		this.simpleDatas=new LongObjectMap<RoleGroupSimpleData>();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.simpleDatas=null;
	}
	
}
