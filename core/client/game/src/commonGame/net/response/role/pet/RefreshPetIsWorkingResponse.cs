using ShineEngine;

/// <summary>
/// 更新宠物是否出战消息(generated by shine)
/// </summary>
public class RefreshPetIsWorkingResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.RefreshPetIsWorking;
	
	public int index;
	
	public bool isWorking;
	
	public RefreshPetIsWorkingResponse()
	{
		_dataID=GameResponseType.RefreshPetIsWorking;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RefreshPetIsWorkingResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.index=stream.readInt();
		
		this.isWorking=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.index=stream.readInt();
		
		this.isWorking=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("index");
		writer.sb.Append(':');
		writer.sb.Append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("isWorking");
		writer.sb.Append(':');
		writer.sb.Append(this.isWorking);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.pet.onPetWorkingChange(index,isWorking);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.index=0;
		this.isWorking=false;
	}
	
}
