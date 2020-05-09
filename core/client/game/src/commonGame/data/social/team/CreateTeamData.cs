using ShineEngine;

/// <summary>
/// 创建队伍参数(generated by shine)
/// </summary>
public class CreateTeamData:CreateRoleGroupData
{
	/// <summary>
	/// 目标id
	/// </summary>
	public int targetID;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.CreateTeam;
	
	public CreateTeamData()
	{
		_dataID=BaseDataType.CreateTeam;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CreateTeamData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.targetID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.targetID);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.targetID=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.targetID);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is CreateTeamData))
			return;
		
		CreateTeamData mData=(CreateTeamData)data;
		
		this.targetID=mData.targetID;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is CreateTeamData))
			return;
		
		CreateTeamData mData=(CreateTeamData)data;
		
		this.targetID=mData.targetID;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		CreateTeamData mData=(CreateTeamData)data;
		if(this.targetID!=mData.targetID)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("targetID");
		writer.sb.Append(':');
		writer.sb.Append(this.targetID);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.targetID=0;
	}
	
}
