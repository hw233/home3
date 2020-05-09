using ShineEngine;

/// <summary>
/// 收到客户端离线事务消息(generated by shine)
/// </summary>
public class ReceiveClientOfflineWorkResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.ReceiveClientOfflineWork;
	
	/// <summary>
	/// 收到的序号
	/// </summary>
	public int receiveIndex;
	
	/// <summary>
	/// 是否执行成功
	/// </summary>
	public bool success;
	
	public ReceiveClientOfflineWorkResponse()
	{
		_dataID=GameResponseType.ReceiveClientOfflineWork;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ReceiveClientOfflineWorkResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.receiveIndex=stream.readInt();
		
		this.success=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.receiveIndex=stream.readInt();
		
		this.success=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("receiveIndex");
		writer.sb.Append(':');
		writer.sb.Append(this.receiveIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("success");
		writer.sb.Append(':');
		writer.sb.Append(this.success);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		GameC.offline.onReceive(receiveIndex,success);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.receiveIndex=0;
		this.success=false;
	}
	
}
