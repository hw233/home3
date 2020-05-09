package com.home.commonGame.net.serverRequest.game.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.base.GameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色预备退出消息(发到源服)(generated by shine) */
public class PlayerPreExitToGameServerRequest extends GameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerPreExitToGame;
	
	/** 角色ID */
	public long playerID;
	
	public PlayerPreExitToGameServerRequest()
	{
		_dataID=ServerMessageType.PlayerPreExitToGame;
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
		return "PlayerPreExitToGameServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
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
	public static PlayerPreExitToGameServerRequest create(long playerID)
	{
		PlayerPreExitToGameServerRequest re=(PlayerPreExitToGameServerRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		return re;
	}
	
}
