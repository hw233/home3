package com.home.commonGame.net.serverRequest.game.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.base.GameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 回复游戏服角色切换回失败消息(服务器即将关闭)(generated by shine) */
public class RePreSwitchGameFailedServerRequest extends GameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.RePreSwitchGameFailed;
	
	/** 角色ID */
	public long playerID;
	
	public RePreSwitchGameFailedServerRequest()
	{
		_dataID=ServerMessageType.RePreSwitchGameFailed;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RePreSwitchGameFailedServerRequest";
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
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
	}
	
	/** 创建实例 */
	public static RePreSwitchGameFailedServerRequest create(long playerID)
	{
		RePreSwitchGameFailedServerRequest re=(RePreSwitchGameFailedServerRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		return re;
	}
	
}
