using ShineEngine;

/// <summary>
/// 邀请玩家群接收数据(generated by shine)
/// </summary>
public class InviteRoleGroupReceiveData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.InviteRoleGroupReceive;
	
	/// <summary>
	/// 邀请者
	/// </summary>
	public RoleShowData inviter;
	
	/// <summary>
	/// 玩家群简版数据
	/// </summary>
	public RoleGroupSimpleData simpleData;
	
	/// <summary>
	/// 邀请时间
	/// </summary>
	public long time;
	
	public InviteRoleGroupReceiveData()
	{
		_dataID=BaseDataType.InviteRoleGroupReceive;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "InviteRoleGroupReceiveData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData inviterT=stream.readDataFullNotNull();
		if(inviterT!=null)
		{
			if(inviterT is RoleShowData)
			{
				this.inviter=(RoleShowData)inviterT;
			}
			else
			{
				this.inviter=new RoleShowData();
				if(!(inviterT.GetType().IsAssignableFrom(typeof(RoleShowData))))
				{
					stream.throwTypeReadError(typeof(RoleShowData),inviterT.GetType());
				}
				this.inviter.shadowCopy(inviterT);
			}
		}
		else
		{
			this.inviter=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData simpleDataT=stream.readDataFullNotNull();
			if(simpleDataT!=null)
			{
				if(simpleDataT is RoleGroupSimpleData)
				{
					this.simpleData=(RoleGroupSimpleData)simpleDataT;
				}
				else
				{
					this.simpleData=new RoleGroupSimpleData();
					if(!(simpleDataT.GetType().IsAssignableFrom(typeof(RoleGroupSimpleData))))
					{
						stream.throwTypeReadError(typeof(RoleGroupSimpleData),simpleDataT.GetType());
					}
					this.simpleData.shadowCopy(simpleDataT);
				}
			}
			else
			{
				this.simpleData=null;
			}
		}
		else
		{
			this.simpleData=null;
		}
		
		this.time=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.inviter!=null)
		{
			stream.writeDataFullNotNull(this.inviter);
		}
		else
		{
			nullObjError("inviter");
		}
		
		if(this.simpleData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.simpleData);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeLong(this.time);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.inviter=(RoleShowData)stream.readDataSimpleNotNull();
		
		if(stream.readBoolean())
		{
			this.simpleData=(RoleGroupSimpleData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.simpleData=null;
		}
		
		this.time=stream.readLong();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.inviter!=null)
		{
			stream.writeDataSimpleNotNull(this.inviter);
		}
		else
		{
			nullObjError("inviter");
		}
		
		if(this.simpleData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.simpleData);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeLong(this.time);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is InviteRoleGroupReceiveData))
			return;
		
		InviteRoleGroupReceiveData mData=(InviteRoleGroupReceiveData)data;
		
		this.inviter=mData.inviter;
		this.simpleData=mData.simpleData;
		this.time=mData.time;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is InviteRoleGroupReceiveData))
			return;
		
		InviteRoleGroupReceiveData mData=(InviteRoleGroupReceiveData)data;
		
		if(mData.inviter!=null)
		{
			this.inviter=(RoleShowData)mData.inviter.clone();
		}
		else
		{
			this.inviter=null;
			nullObjError("inviter");
		}
		
		if(mData.simpleData!=null)
		{
			this.simpleData=(RoleGroupSimpleData)mData.simpleData.clone();
		}
		else
		{
			this.simpleData=null;
		}
		
		this.time=mData.time;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		InviteRoleGroupReceiveData mData=(InviteRoleGroupReceiveData)data;
		if(mData.inviter!=null)
		{
			if(this.inviter==null)
				return false;
			if(!this.inviter.dataEquals(mData.inviter))
				return false;
		}
		else
		{
			if(this.inviter!=null)
				return false;
		}
		
		if(mData.simpleData!=null)
		{
			if(this.simpleData==null)
				return false;
			if(!this.simpleData.dataEquals(mData.simpleData))
				return false;
		}
		else
		{
			if(this.simpleData!=null)
				return false;
		}
		
		if(this.time!=mData.time)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("inviter");
		writer.sb.Append(':');
		if(this.inviter!=null)
		{
			this.inviter.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("RoleShowData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("simpleData");
		writer.sb.Append(':');
		if(this.simpleData!=null)
		{
			this.simpleData.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("RoleGroupSimpleData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("time");
		writer.sb.Append(':');
		writer.sb.Append(this.time);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.inviter=new RoleShowData();
		this.inviter.initDefault();
	}
	
	public long getRoleGroupID()
	{
		return simpleData!=null ? simpleData.groupID : -1L;
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.inviter=null;
		this.simpleData=null;
		this.time=0L;
	}
	
}
