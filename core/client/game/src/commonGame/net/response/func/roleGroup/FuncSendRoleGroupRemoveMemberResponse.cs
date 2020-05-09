using ShineEngine;

/// <summary>
/// 推送玩家群移除成员(generated by shine)
/// </summary>
public class FuncSendRoleGroupRemoveMemberResponse:FuncPlayerRoleGroupSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncSendRoleGroupRemoveMember;
	
	/// <summary>
	/// 方式
	/// </summary>
	public int type;
	
	public long playerID;
	
	public FuncSendRoleGroupRemoveMemberResponse()
	{
		_dataID=GameResponseType.FuncSendRoleGroupRemoveMember;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncSendRoleGroupRemoveMemberResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		this.type=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
		this.type=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("playerID");
		writer.sb.Append(':');
		writer.sb.Append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("type");
		writer.sb.Append(':');
		writer.sb.Append(this.type);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		roleGroup.onRemoveMember(playerID,type);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.playerID=0L;
		this.type=0;
	}
	
}
