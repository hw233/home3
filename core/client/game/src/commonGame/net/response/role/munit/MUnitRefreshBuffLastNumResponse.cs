using ShineEngine;

/// <summary>
/// 主角刷buff剩余次数(generated by shine)
/// </summary>
public class MUnitRefreshBuffLastNumResponse:MUnitSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.MUnitRefreshBuffLastNum;
	
	/// <summary>
	/// buff流水ID
	/// </summary>
	public int instanceID;
	
	/// <summary>
	/// 剩余次数
	/// </summary>
	public int lastNum;
	
	public MUnitRefreshBuffLastNumResponse()
	{
		_dataID=GameResponseType.MUnitRefreshBuffLastNum;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		mLogic.getFightLogic().buff.refreshBuffLastNumByServer(instanceID,lastNum);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "MUnitRefreshBuffLastNumResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		this.lastNum=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.instanceID=stream.readInt();
		
		this.lastNum=stream.readInt();
		
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
		writer.sb.Append("lastNum");
		writer.sb.Append(':');
		writer.sb.Append(this.lastNum);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.instanceID=0;
		this.lastNum=0;
	}
	
}
