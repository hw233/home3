using ShineEngine;

/// <summary>
/// 保存bool(generated by shine)
/// </summary>
public class SaveBooleanRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.SaveBoolean;
	
	/// <summary>
	/// key
	/// </summary>
	public int key;
	
	/// <summary>
	/// 值
	/// </summary>
	public bool value;
	
	public SaveBooleanRequest()
	{
		_dataID=GameRequestType.SaveBoolean;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "SaveBooleanRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("key");
		writer.sb.Append(':');
		writer.sb.Append(this.key);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("value");
		writer.sb.Append(':');
		writer.sb.Append(this.value);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.key);
		
		stream.writeBoolean(this.value);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.key);
		
		stream.writeBoolean(this.value);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.key=0;
		this.value=false;
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static SaveBooleanRequest create(int key,bool value)
	{
		SaveBooleanRequest re=(SaveBooleanRequest)BytesControl.createRequest(dataID);
		re.key=key;
		re.value=value;
		return re;
	}
	
}
