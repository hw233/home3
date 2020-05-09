using ShineEngine;

/// <summary>
/// 获取每页数据(主线程)(generated by shine)
/// </summary>
public class FuncGetSubsectionPageShowRequest:FuncRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.FuncGetSubsectionPageShow;
	
	/// <summary>
	/// 大组index
	/// </summary>
	public int subsectionIndex;
	
	/// <summary>
	/// 小组index
	/// </summary>
	public int subsectionSubIndex;
	
	/// <summary>
	/// 页码
	/// </summary>
	public int page;
	
	/// <summary>
	/// 参数(默认0)
	/// </summary>
	public int arg;
	
	public FuncGetSubsectionPageShowRequest()
	{
		_dataID=GameRequestType.FuncGetSubsectionPageShow;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncGetSubsectionPageShowRequest";
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.subsectionIndex);
		
		stream.writeInt(this.subsectionSubIndex);
		
		stream.writeInt(this.page);
		
		stream.writeInt(this.arg);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.subsectionIndex);
		
		stream.writeInt(this.subsectionSubIndex);
		
		stream.writeInt(this.page);
		
		stream.writeInt(this.arg);
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("subsectionIndex");
		writer.sb.Append(':');
		writer.sb.Append(this.subsectionIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("subsectionSubIndex");
		writer.sb.Append(':');
		writer.sb.Append(this.subsectionSubIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("page");
		writer.sb.Append(':');
		writer.sb.Append(this.page);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("arg");
		writer.sb.Append(':');
		writer.sb.Append(this.arg);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.subsectionIndex=0;
		this.subsectionSubIndex=0;
		this.page=0;
		this.arg=0;
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static FuncGetSubsectionPageShowRequest create(int funcID,int subsectionIndex,int subsectionSubIndex,int page,int arg)
	{
		FuncGetSubsectionPageShowRequest re=(FuncGetSubsectionPageShowRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.subsectionIndex=subsectionIndex;
		re.subsectionSubIndex=subsectionSubIndex;
		re.page=page;
		re.arg=arg;
		return re;
	}
	
}
