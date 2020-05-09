package com.home.commonClient.net.response.login;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送绑定平台消息(generated by shine) */
public class SendBindPlatformResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.SendBindPlatform;
	
	/** uid */
	public String uid="";
	
	/** 平台 */
	public String platform="";
	
	public SendBindPlatformResponse()
	{
		_dataID=GameResponseType.SendBindPlatform;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.role.onBindPlatform(uid,platform);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendBindPlatformResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.uid=stream.readUTF();
		
		this.platform=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.uid=stream.readUTF();
		
		this.platform=stream.readUTF();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("uid");
		writer.sb.append(':');
		writer.sb.append(this.uid);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("platform");
		writer.sb.append(':');
		writer.sb.append(this.platform);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.uid="";
		this.platform="";
	}
	
}
