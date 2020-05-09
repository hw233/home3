using ShineEngine;

/// <summary>
/// 申请添加好友数据(generated by shine)
/// </summary>
public class ApplyAddFriendData:BaseData
{
	/// <summary>
	/// 角色ID
	/// </summary>
	public long playerID;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.ApplyAddFriend;
	
	/// <summary>
	/// 社交数据
	/// </summary>
	public RoleSocialData data;
	
	/// <summary>
	/// 添加类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 申请时间
	/// </summary>
	public long applyTime;
	
	public ApplyAddFriendData()
	{
		_dataID=BaseDataType.ApplyAddFriend;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ApplyAddFriendData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.playerID=stream.readLong();
		
		this.data=(RoleSocialData)stream.readDataSimpleNotNull();
		
		this.applyTime=stream.readLong();
		
		this.type=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.playerID);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeLong(this.applyTime);
		
		stream.writeInt(this.type);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is ApplyAddFriendData))
			return;
		
		ApplyAddFriendData mData=(ApplyAddFriendData)data;
		
		this.playerID=mData.playerID;
		this.data=mData.data;
		this.applyTime=mData.applyTime;
		this.type=mData.type;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is ApplyAddFriendData))
			return;
		
		ApplyAddFriendData mData=(ApplyAddFriendData)data;
		
		this.playerID=mData.playerID;
		
		if(mData.data!=null)
		{
			this.data=(RoleSocialData)mData.data.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
		this.applyTime=mData.applyTime;
		
		this.type=mData.type;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		ApplyAddFriendData mData=(ApplyAddFriendData)data;
		if(this.playerID!=mData.playerID)
			return false;
		
		if(mData.data!=null)
		{
			if(this.data==null)
				return false;
			if(!this.data.dataEquals(mData.data))
				return false;
		}
		else
		{
			if(this.data!=null)
				return false;
		}
		
		if(this.applyTime!=mData.applyTime)
			return false;
		
		if(this.type!=mData.type)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("playerID");
		writer.sb.Append(':');
		writer.sb.Append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("data");
		writer.sb.Append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("RoleSocialData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("applyTime");
		writer.sb.Append(':');
		writer.sb.Append(this.applyTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("type");
		writer.sb.Append(':');
		writer.sb.Append(this.type);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.data=new RoleSocialData();
		this.data.initDefault();
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT is RoleSocialData)
			{
				this.data=(RoleSocialData)dataT;
			}
			else
			{
				this.data=new RoleSocialData();
				if(!(dataT.GetType().IsAssignableFrom(typeof(RoleSocialData))))
				{
					stream.throwTypeReadError(typeof(RoleSocialData),dataT.GetType());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		this.applyTime=stream.readLong();
		
		this.type=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeLong(this.applyTime);
		
		stream.writeInt(this.type);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.playerID=0L;
		this.data=null;
		this.applyTime=0L;
		this.type=0;
	}
	
}
