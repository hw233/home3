using ShineEngine;

/// <summary>
/// 客户端发送邮件消息(generated by shine)
/// </summary>
public class ClientSendMailRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.ClientSendMail;
	
	/// <summary>
	/// 目标玩家ID
	/// </summary>
	public long playerID;
	
	/// <summary>
	/// 邮件数据
	/// </summary>
	public MailData mail;
	
	public ClientSendMailRequest()
	{
		_dataID=GameRequestType.ClientSendMail;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ClientSendMailRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("playerID");
		writer.sb.Append(':');
		writer.sb.Append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("mail");
		writer.sb.Append(':');
		if(this.mail!=null)
		{
			this.mail.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("MailData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		if(this.mail!=null)
		{
			stream.writeDataFullNotNull(this.mail);
		}
		else
		{
			nullObjError("mail");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
		if(this.mail!=null)
		{
			stream.writeDataSimpleNotNull(this.mail);
		}
		else
		{
			nullObjError("mail");
		}
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.playerID=0L;
		this.mail.release(pool);
		this.mail=null;
	}
	
	protected override void copyData()
	{
		base.copyData();
		MailData mailTemp=mail;
		if(mailTemp!=null)
		{
			this.mail=(MailData)mailTemp.clone();
		}
		else
		{
			this.mail=null;
			nullObjError("mail");
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static ClientSendMailRequest create(long playerID,MailData mail)
	{
		ClientSendMailRequest re=(ClientSendMailRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		re.mail=mail;
		return re;
	}
	
}
