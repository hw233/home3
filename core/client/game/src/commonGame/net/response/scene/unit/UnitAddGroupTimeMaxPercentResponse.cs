using ShineEngine;

/// <summary>
/// 单位添加组CD百分比(generated by shine)
/// </summary>
public class UnitAddGroupTimeMaxPercentResponse:UnitSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.UnitAddGroupTimeMaxPercent;
	
	/// <summary>
	/// 组ID
	/// </summary>
	public int groupID;
	
	/// <summary>
	/// 值
	/// </summary>
	public int value;
	
	public UnitAddGroupTimeMaxPercentResponse()
	{
		_dataID=GameResponseType.UnitAddGroupTimeMaxPercent;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		unit.fight.getCDDataLogic().addGroupTimeMaxPercent(groupID,value);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "UnitAddGroupTimeMaxPercentResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.groupID=stream.readInt();
		
		this.value=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.groupID=stream.readInt();
		
		this.value=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("groupID");
		writer.sb.Append(':');
		writer.sb.Append(this.groupID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("value");
		writer.sb.Append(':');
		writer.sb.Append(this.value);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.groupID=0;
		this.value=0;
	}
	
}
