using ShineEngine;

/// <summary>
/// 推送任务失败消息(generated by shine)
/// </summary>
public class SendQuestFailedResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.SendQuestFailed;
	
	/// <summary>
	/// 任务id
	/// </summary>
	public int id;
	
	public SendQuestFailedResponse()
	{
		_dataID=GameResponseType.SendQuestFailed;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.quest.onQuestFailed(id);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "SendQuestFailedResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("id");
		writer.sb.Append(':');
		writer.sb.Append(this.id);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.id=0;
	}
	
}
