using ShineEngine;

/// <summary>
/// 单位确认选择(generated by shine)
/// </summary>
public class CUnitPreBattleSureRequest:SceneRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.CUnitPreBattleSure;
	
	/// <summary>
	/// 实例ID
	/// </summary>
	public int instanceID;
	
	public CUnitPreBattleSureRequest()
	{
		_dataID=GameRequestType.CUnitPreBattleSure;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CUnitPreBattleSureRequest";
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
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.instanceID);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.instanceID);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.instanceID=0;
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static CUnitPreBattleSureRequest create(int instanceID)
	{
		CUnitPreBattleSureRequest re=(CUnitPreBattleSureRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		return re;
	}
	
}
