using ShineEngine;

/// <summary>
/// 主单位切换属性开关(generated by shine)
/// </summary>
public class MUnitAttributeSwitchNormalSendRequest:MUnitRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.MUnitAttributeSwitchNormalSend;
	
	/// <summary>
	/// 是否开启
	/// </summary>
	public bool isOpen;
	
	public MUnitAttributeSwitchNormalSendRequest()
	{
		_dataID=GameRequestType.MUnitAttributeSwitchNormalSend;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "MUnitAttributeSwitchNormalSendRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("isOpen");
		writer.sb.Append(':');
		writer.sb.Append(this.isOpen);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeBoolean(this.isOpen);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeBoolean(this.isOpen);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.isOpen=false;
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static MUnitAttributeSwitchNormalSendRequest create(int mIndex,bool isOpen)
	{
		MUnitAttributeSwitchNormalSendRequest re=(MUnitAttributeSwitchNormalSendRequest)BytesControl.createRequest(dataID);
		re.mIndex=mIndex;
		re.isOpen=isOpen;
		return re;
	}
	
}
