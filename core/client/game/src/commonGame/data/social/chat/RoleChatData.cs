using ShineEngine;

/// <summary>
/// 角色聊天数据(generated by shine)
/// </summary>
public class RoleChatData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.RoleChat;
	
	/// <summary>
	/// 显示数据
	/// </summary>
	public RoleSimpleShowData showData;
	
	/// <summary>
	/// 聊天数据
	/// </summary>
	public ChatData chatData;
	
	/// <summary>
	/// 发送序号
	/// </summary>
	public int sendIndex;
	
	/// <summary>
	/// 时间
	/// </summary>
	public long time;
	
	public RoleChatData()
	{
		_dataID=BaseDataType.RoleChat;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RoleChatData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData showDataT=stream.readDataFullNotNull();
		if(showDataT!=null)
		{
			if(showDataT is RoleSimpleShowData)
			{
				this.showData=(RoleSimpleShowData)showDataT;
			}
			else
			{
				this.showData=new RoleSimpleShowData();
				if(!(showDataT.GetType().IsAssignableFrom(typeof(RoleSimpleShowData))))
				{
					stream.throwTypeReadError(typeof(RoleSimpleShowData),showDataT.GetType());
				}
				this.showData.shadowCopy(showDataT);
			}
		}
		else
		{
			this.showData=null;
		}
		
		BaseData chatDataT=stream.readDataFullNotNull();
		if(chatDataT!=null)
		{
			if(chatDataT is ChatData)
			{
				this.chatData=(ChatData)chatDataT;
			}
			else
			{
				this.chatData=new ChatData();
				if(!(chatDataT.GetType().IsAssignableFrom(typeof(ChatData))))
				{
					stream.throwTypeReadError(typeof(ChatData),chatDataT.GetType());
				}
				this.chatData.shadowCopy(chatDataT);
			}
		}
		else
		{
			this.chatData=null;
		}
		
		this.time=stream.readLong();
		
		this.sendIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.showData!=null)
		{
			stream.writeDataFullNotNull(this.showData);
		}
		else
		{
			nullObjError("showData");
		}
		
		if(this.chatData!=null)
		{
			stream.writeDataFullNotNull(this.chatData);
		}
		else
		{
			nullObjError("chatData");
		}
		
		stream.writeLong(this.time);
		
		stream.writeInt(this.sendIndex);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.showData=(RoleSimpleShowData)stream.readDataSimpleNotNull();
		
		this.chatData=(ChatData)stream.readDataSimpleNotNull();
		
		this.time=stream.readLong();
		
		this.sendIndex=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.showData!=null)
		{
			stream.writeDataSimpleNotNull(this.showData);
		}
		else
		{
			nullObjError("showData");
		}
		
		if(this.chatData!=null)
		{
			stream.writeDataSimpleNotNull(this.chatData);
		}
		else
		{
			nullObjError("chatData");
		}
		
		stream.writeLong(this.time);
		
		stream.writeInt(this.sendIndex);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is RoleChatData))
			return;
		
		RoleChatData mData=(RoleChatData)data;
		
		this.showData=mData.showData;
		this.chatData=mData.chatData;
		this.time=mData.time;
		this.sendIndex=mData.sendIndex;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is RoleChatData))
			return;
		
		RoleChatData mData=(RoleChatData)data;
		
		if(mData.showData!=null)
		{
			this.showData=(RoleSimpleShowData)mData.showData.clone();
		}
		else
		{
			this.showData=null;
			nullObjError("showData");
		}
		
		if(mData.chatData!=null)
		{
			this.chatData=(ChatData)mData.chatData.clone();
		}
		else
		{
			this.chatData=null;
			nullObjError("chatData");
		}
		
		this.time=mData.time;
		
		this.sendIndex=mData.sendIndex;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		RoleChatData mData=(RoleChatData)data;
		if(mData.showData!=null)
		{
			if(this.showData==null)
				return false;
			if(!this.showData.dataEquals(mData.showData))
				return false;
		}
		else
		{
			if(this.showData!=null)
				return false;
		}
		
		if(mData.chatData!=null)
		{
			if(this.chatData==null)
				return false;
			if(!this.chatData.dataEquals(mData.chatData))
				return false;
		}
		else
		{
			if(this.chatData!=null)
				return false;
		}
		
		if(this.time!=mData.time)
			return false;
		
		if(this.sendIndex!=mData.sendIndex)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("showData");
		writer.sb.Append(':');
		if(this.showData!=null)
		{
			this.showData.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("RoleSimpleShowData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("chatData");
		writer.sb.Append(':');
		if(this.chatData!=null)
		{
			this.chatData.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("ChatData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("time");
		writer.sb.Append(':');
		writer.sb.Append(this.time);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("sendIndex");
		writer.sb.Append(':');
		writer.sb.Append(this.sendIndex);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.showData=new RoleSimpleShowData();
		this.showData.initDefault();
		this.chatData=new ChatData();
		this.chatData.initDefault();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.showData=null;
		this.chatData=null;
		this.time=0L;
		this.sendIndex=0;
	}
	
}
