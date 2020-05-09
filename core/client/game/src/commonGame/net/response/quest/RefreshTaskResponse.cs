using ShineEngine;

/// <summary>
/// 刷新目标数目消息(generated by shine)
/// </summary>
public class RefreshTaskResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.RefreshTask;
	
	/// <summary>
	/// 实例ID
	/// </summary>
	public int instanceID;
	
	/// <summary>
	/// 数目
	/// </summary>
	public int num;
	
	public RefreshTaskResponse()
	{
		_dataID=GameResponseType.RefreshTask;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.quest.onRefreshTask(instanceID,num);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RefreshTaskResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		this.num=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.instanceID=stream.readInt();
		
		this.num=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("instanceID");
		writer.sb.Append(':');
		writer.sb.Append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("num");
		writer.sb.Append(':');
		writer.sb.Append(this.num);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.instanceID=0;
		this.num=0;
	}
	
}
