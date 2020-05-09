package com.home.commonGame.net.serverResponse.center.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.system.PlayerWorkCompleteData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 发送角色事务完成消息(generated by shine) */
public class SendPlayerWorkCompleteServerResponse extends CenterToGameServerResponse
{
	/** 事务完成数据 */
	public PlayerWorkCompleteData data;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendPlayerWorkComplete;
	
	public SendPlayerWorkCompleteServerResponse()
	{
		_dataID=ServerMessageType.SendPlayerWorkComplete;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendPlayerWorkCompleteServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(PlayerWorkCompleteData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PlayerWorkCompleteData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.main.onPlayerWorkComplete(data);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
}
