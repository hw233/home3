using ShineEngine;

/// <summary>
/// 玩家展示数据(generated by shine)
/// </summary>
public class RoleShowData:BaseData
{
	/// <summary>
	/// 角色ID
	/// </summary>
	public long playerID;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.RoleShow;
	
	/// <summary>
	/// 创建区服
	/// </summary>
	public int createAreaID;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 性别
	/// </summary>
	public int sex;
	
	/// <summary>
	/// 职业
	/// </summary>
	public int vocation;
	
	/// <summary>
	/// 战斗力
	/// </summary>
	public long fightForce;
	
	/// <summary>
	/// 工会名
	/// </summary>
	public string unionName;
	
	/// <summary>
	/// 工会id
	/// </summary>
	public long unionID;
	
	/// <summary>
	/// 玩家等级(不是角色等级)
	/// </summary>
	public int level;
	
	public RoleShowData()
	{
		_dataID=BaseDataType.RoleShow;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.playerID=stream.readLong();
		
		this.createAreaID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.sex=stream.readInt();
		
		this.vocation=stream.readInt();
		
		this.level=stream.readInt();
		
		this.fightForce=stream.readLong();
		
		this.unionID=stream.readLong();
		
		this.unionName=stream.readUTF();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.sex);
		
		stream.writeInt(this.vocation);
		
		stream.writeInt(this.level);
		
		stream.writeLong(this.fightForce);
		
		stream.writeLong(this.unionID);
		
		stream.writeUTF(this.unionName);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is RoleShowData))
			return;
		
		RoleShowData mData=(RoleShowData)data;
		
		this.playerID=mData.playerID;
		this.createAreaID=mData.createAreaID;
		this.name=mData.name;
		this.sex=mData.sex;
		this.vocation=mData.vocation;
		this.level=mData.level;
		this.fightForce=mData.fightForce;
		this.unionID=mData.unionID;
		this.unionName=mData.unionName;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is RoleShowData))
			return;
		
		RoleShowData mData=(RoleShowData)data;
		
		this.playerID=mData.playerID;
		
		this.createAreaID=mData.createAreaID;
		
		this.name=mData.name;
		
		this.sex=mData.sex;
		
		this.vocation=mData.vocation;
		
		this.level=mData.level;
		
		this.fightForce=mData.fightForce;
		
		this.unionID=mData.unionID;
		
		this.unionName=mData.unionName;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		RoleShowData mData=(RoleShowData)data;
		if(this.playerID!=mData.playerID)
			return false;
		
		if(this.createAreaID!=mData.createAreaID)
			return false;
		
		if(this.name!=mData.name)
			return false;
		
		if(this.sex!=mData.sex)
			return false;
		
		if(this.vocation!=mData.vocation)
			return false;
		
		if(this.level!=mData.level)
			return false;
		
		if(this.fightForce!=mData.fightForce)
			return false;
		
		if(this.unionID!=mData.unionID)
			return false;
		
		if(this.unionName!=mData.unionName)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RoleShowData";
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
		writer.sb.Append("createAreaID");
		writer.sb.Append(':');
		writer.sb.Append(this.createAreaID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("name");
		writer.sb.Append(':');
		writer.sb.Append(this.name);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("sex");
		writer.sb.Append(':');
		writer.sb.Append(this.sex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("vocation");
		writer.sb.Append(':');
		writer.sb.Append(this.vocation);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("level");
		writer.sb.Append(':');
		writer.sb.Append(this.level);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("fightForce");
		writer.sb.Append(':');
		writer.sb.Append(this.fightForce);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("unionID");
		writer.sb.Append(':');
		writer.sb.Append(this.unionID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("unionName");
		writer.sb.Append(':');
		writer.sb.Append(this.unionName);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 改变
	/// </summary>
	public virtual void onChange(RoleShowChangeData data)
	{
		switch(data.type)
		{
			case RoleShowDataPartType.Name:
			{
				this.name=data.arg1;
				return;
			}
			case RoleShowDataPartType.Sex:
			{
				this.sex=data.arg0;
				return;
			}
			case RoleShowDataPartType.Vocation:
			{
				this.vocation=data.arg0;
				return;
			}
			case RoleShowDataPartType.Level:
			{
				this.level=data.arg0;
				return;
			}
			case RoleShowDataPartType.FightForce:
			{
				this.fightForce=data.arg2;
				return;
			}
			case RoleShowDataPartType.IsOnline:
			case RoleShowDataPartType.LastOnlineTime:
			{
				return;
			}
			case RoleShowDataPartType.Union:
			{
				this.unionID=data.arg2;
				this.unionName=data.arg1;
				return;
			}
			default:
			{
				Ctrl.throwError("未处理的ShowDataPartType类型:"+data.type);
			}
				break;
		}
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		this.createAreaID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.sex=stream.readInt();
		
		this.vocation=stream.readInt();
		
		this.level=stream.readInt();
		
		this.fightForce=stream.readLong();
		
		this.unionID=stream.readLong();
		
		this.unionName=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.sex);
		
		stream.writeInt(this.vocation);
		
		stream.writeInt(this.level);
		
		stream.writeLong(this.fightForce);
		
		stream.writeLong(this.unionID);
		
		stream.writeUTF(this.unionName);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.playerID=0L;
		this.createAreaID=0;
		this.name="";
		this.sex=0;
		this.vocation=0;
		this.level=0;
		this.fightForce=0L;
		this.unionID=0L;
		this.unionName="";
	}
	
}
