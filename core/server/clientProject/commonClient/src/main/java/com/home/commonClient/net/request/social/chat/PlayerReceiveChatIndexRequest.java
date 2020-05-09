package com.home.commonClient.net.request.social.chat;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色接收聊天序号(generated by shine) */
public class PlayerReceiveChatIndexRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.PlayerReceiveChatIndex;
	
	public int index;
	
	public PlayerReceiveChatIndexRequest()
	{
		_dataID=GameRequestType.PlayerReceiveChatIndex;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerReceiveChatIndexRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.index);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.index);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
	}
	
	/** 创建实例 */
	public static PlayerReceiveChatIndexRequest create(int index)
	{
		PlayerReceiveChatIndexRequest re=(PlayerReceiveChatIndexRequest)BytesControl.createRequest(dataID);
		re.index=index;
		return re;
	}
	
}
