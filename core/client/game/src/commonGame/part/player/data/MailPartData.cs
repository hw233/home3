using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class MailPartData:BaseData
{
	/// <summary>
	/// 新邮件数(未读数)
	/// </summary>
	public int newNum;
	
	/// <summary>
	/// 邮件数
	/// </summary>
	public int mailNum;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=PlayerPartDataType.Mail;
	
	public MailPartData()
	{
		_dataID=PlayerPartDataType.Mail;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.mailNum=stream.readInt();
		
		this.newNum=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.mailNum);
		
		stream.writeInt(this.newNum);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is MailPartData))
			return;
		
		MailPartData mData=(MailPartData)data;
		
		this.mailNum=mData.mailNum;
		this.newNum=mData.newNum;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is MailPartData))
			return;
		
		MailPartData mData=(MailPartData)data;
		
		this.mailNum=mData.mailNum;
		
		this.newNum=mData.newNum;
		
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "MailPartData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.mailNum=stream.readInt();
		
		this.newNum=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.mailNum);
		
		stream.writeInt(this.newNum);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		MailPartData mData=(MailPartData)data;
		if(this.mailNum!=mData.mailNum)
			return false;
		
		if(this.newNum!=mData.newNum)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("mailNum");
		writer.sb.Append(':');
		writer.sb.Append(this.mailNum);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("newNum");
		writer.sb.Append(':');
		writer.sb.Append(this.newNum);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.mailNum=0;
		this.newNum=0;
	}
	
}
