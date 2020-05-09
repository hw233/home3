package com.home.commonGame.net.serverResponse.login.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.login.base.LoginToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 发送信息码来自登录服(generated by shine) */
public class SendInfoCodeFromLoginServerResponse extends LoginToGameServerResponse
{
	public int code;
	
	public long playerID;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendInfoCodeFromLogin;
	
	public SendInfoCodeFromLoginServerResponse()
	{
		_dataID=ServerMessageType.SendInfoCodeFromLogin;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendInfoCodeFromLoginServerResponse";
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.main.sendInfoCodeToPlayer(playerID,code);
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
		this.code=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("code");
		writer.sb.append(':');
		writer.sb.append(this.code);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
		this.code=0;
	}
	
}
