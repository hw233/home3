using ShineEngine;

/// <summary>
/// 帧同步数据(generated by shine)
/// </summary>
public class FrameSyncData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.FrameSync;
	
	/// <summary>
	/// 帧序号
	/// </summary>
	public int index;
	
	/// <summary>
	/// 指令组
	/// </summary>
	public SList<FrameSyncCommandData> commands;
	
	public FrameSyncData()
	{
		_dataID=BaseDataType.FrameSync;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FrameSyncData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.index=stream.readInt();
		
		if(stream.readBoolean())
		{
			int commandsLen=stream.readLen();
			if(this.commands!=null)
			{
				this.commands.clear();
				this.commands.ensureCapacity(commandsLen);
			}
			else
			{
				this.commands=new SList<FrameSyncCommandData>();
			}
			
			SList<FrameSyncCommandData> commandsT=this.commands;
			for(int commandsI=commandsLen-1;commandsI>=0;--commandsI)
			{
				FrameSyncCommandData commandsV;
				if(stream.readBoolean())
				{
					commandsV=(FrameSyncCommandData)stream.readDataSimpleNotNull();
				}
				else
				{
					commandsV=null;
				}
				
				commandsT.add(commandsV);
			}
		}
		else
		{
			this.commands=null;
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.index);
		
		if(this.commands!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.commands.size());
			if(!this.commands.isEmpty())
			{
				FrameSyncCommandData[] commandsVValues=this.commands.getValues();
				for(int commandsVI=0,commandsVLen=this.commands.length();commandsVI<commandsVLen;++commandsVI)
				{
					FrameSyncCommandData commandsV=commandsVValues[commandsVI];
					if(commandsV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataSimpleNotNull(commandsV);
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
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is FrameSyncData))
			return;
		
		FrameSyncData mData=(FrameSyncData)data;
		
		this.index=mData.index;
		this.commands=mData.commands;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is FrameSyncData))
			return;
		
		FrameSyncData mData=(FrameSyncData)data;
		
		this.index=mData.index;
		
		if(mData.commands!=null)
		{
			if(this.commands!=null)
			{
				this.commands.clear();
				this.commands.ensureCapacity(mData.commands.size());
			}
			else
			{
				this.commands=new SList<FrameSyncCommandData>();
			}
			
			SList<FrameSyncCommandData> commandsT=this.commands;
			if(!mData.commands.isEmpty())
			{
				FrameSyncCommandData[] commandsVValues=mData.commands.getValues();
				for(int commandsVI=0,commandsVLen=mData.commands.length();commandsVI<commandsVLen;++commandsVI)
				{
					FrameSyncCommandData commandsV=commandsVValues[commandsVI];
					FrameSyncCommandData commandsU;
					if(commandsV!=null)
					{
						commandsU=(FrameSyncCommandData)commandsV.clone();
					}
					else
					{
						commandsU=null;
					}
					
					commandsT.add(commandsU);
				}
			}
		}
		else
		{
			this.commands=null;
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		FrameSyncData mData=(FrameSyncData)data;
		if(this.index!=mData.index)
			return false;
		
		if(mData.commands!=null)
		{
			if(this.commands==null)
				return false;
			if(this.commands.size()!=mData.commands.size())
				return false;
			SList<FrameSyncCommandData> commandsT=this.commands;
			SList<FrameSyncCommandData> commandsR=mData.commands;
			int commandsLen=commandsT.size();
			for(int commandsI=0;commandsI<commandsLen;++commandsI)
			{
				FrameSyncCommandData commandsU=commandsT.get(commandsI);
				FrameSyncCommandData commandsV=commandsR.get(commandsI);
				if(commandsV!=null)
				{
					if(commandsU==null)
						return false;
					if(!commandsU.dataEquals(commandsV))
						return false;
				}
				else
				{
					if(commandsU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.commands!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("index");
		writer.sb.Append(':');
		writer.sb.Append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("commands");
		writer.sb.Append(':');
		writer.sb.Append("List<FrameSyncCommandData>");
		if(this.commands!=null)
		{
			SList<FrameSyncCommandData> commandsT=this.commands;
			int commandsLen=commandsT.size();
			writer.sb.Append('(');
			writer.sb.Append(commandsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int commandsI=0;commandsI<commandsLen;++commandsI)
			{
				FrameSyncCommandData commandsV=commandsT.get(commandsI);
				writer.writeTabs();
				writer.sb.Append(commandsI);
				writer.sb.Append(':');
				if(commandsV!=null)
				{
					commandsV.writeDataString(writer);
				}
				else
				{
					writer.sb.Append("FrameSyncCommandData=null");
				}
				
				writer.writeEnter();
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
		
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.index=stream.readInt();
		
		if(stream.readBoolean())
		{
			int commandsLen=stream.readLen();
			if(this.commands!=null)
			{
				this.commands.clear();
				this.commands.ensureCapacity(commandsLen);
			}
			else
			{
				this.commands=new SList<FrameSyncCommandData>();
			}
			
			SList<FrameSyncCommandData> commandsT=this.commands;
			for(int commandsI=commandsLen-1;commandsI>=0;--commandsI)
			{
				FrameSyncCommandData commandsV;
				if(stream.readBoolean())
				{
					BaseData commandsVT=stream.readDataFullNotNull();
					if(commandsVT!=null)
					{
						if(commandsVT is FrameSyncCommandData)
						{
							commandsV=(FrameSyncCommandData)commandsVT;
						}
						else
						{
							commandsV=new FrameSyncCommandData();
							if(!(commandsVT.GetType().IsAssignableFrom(typeof(FrameSyncCommandData))))
							{
								stream.throwTypeReadError(typeof(FrameSyncCommandData),commandsVT.GetType());
							}
							commandsV.shadowCopy(commandsVT);
						}
					}
					else
					{
						commandsV=null;
					}
				}
				else
				{
					commandsV=null;
				}
				
				commandsT.add(commandsV);
			}
		}
		else
		{
			this.commands=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.index);
		
		if(this.commands!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.commands.size());
			if(!this.commands.isEmpty())
			{
				FrameSyncCommandData[] commandsVValues=this.commands.getValues();
				for(int commandsVI=0,commandsVLen=this.commands.length();commandsVI<commandsVLen;++commandsVI)
				{
					FrameSyncCommandData commandsV=commandsVValues[commandsVI];
					if(commandsV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataFullNotNull(commandsV);
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
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.index=0;
		this.commands=null;
	}
	
}
