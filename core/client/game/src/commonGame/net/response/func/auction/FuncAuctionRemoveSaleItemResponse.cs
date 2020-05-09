using ShineEngine;

/// <summary>
/// 拍卖行移除自己的物品消息(generated by shine)
/// </summary>
public class FuncAuctionRemoveSaleItemResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncAuctionRemoveSaleItem;
	
	/// <summary>
	/// 原因
	/// </summary>
	public int code;
	
	/// <summary>
	/// 实例ID
	/// </summary>
	public long instanceID;
	
	public FuncAuctionRemoveSaleItemResponse()
	{
		_dataID=GameResponseType.FuncAuctionRemoveSaleItem;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncAuctionRemoveSaleItemResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readLong();
		
		this.code=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.instanceID=stream.readLong();
		
		this.code=stream.readInt();
		
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
		writer.sb.Append("code");
		writer.sb.Append(':');
		writer.sb.Append(this.code);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.instanceID=0L;
		this.code=0;
	}
	
}
