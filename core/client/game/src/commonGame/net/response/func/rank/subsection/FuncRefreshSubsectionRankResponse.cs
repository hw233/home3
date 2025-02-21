using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class FuncRefreshSubsectionRankResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncRefreshSubsectionRank;
	
	/// <summary>
	/// 排行(-1为移除排行)
	/// </summary>
	public int rank;
	
	/// <summary>
	/// 排行值
	/// </summary>
	public long value;
	
	public FuncRefreshSubsectionRankResponse()
	{
		_dataID=GameResponseType.FuncRefreshSubsectionRank;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncRefreshSubsectionRankResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.rank=stream.readInt();
		
		this.value=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.rank=stream.readInt();
		
		this.value=stream.readLong();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("rank");
		writer.sb.Append(':');
		writer.sb.Append(this.rank);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("value");
		writer.sb.Append(':');
		writer.sb.Append(this.value);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.func.getSubsectionRankTool(funcID).onRefreshRank(rank,value);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.rank=0;
		this.value=0L;
	}
	
}
