using ShineEngine;

/// <summary>
/// 推送接受匹配(generated by shine)
/// </summary>
public class FuncSendAcceptMatchResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncSendAcceptMatch;
	
	/// <summary>
	/// 角色ID
	/// </summary>
	public long playerID;
	
	public FuncSendAcceptMatchResponse()
	{
		_dataID=GameResponseType.FuncSendAcceptMatch;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.dispatch(GameEventType.PlayerAcceptMatch,playerID);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncSendAcceptMatchResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
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
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.playerID=0L;
	}
	
}
