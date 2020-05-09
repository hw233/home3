package com.home.commonGame.net.serverResponse.center.base;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.commonGame.part.player.Player;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.constlist.ThreadType;

/** 角色到逻辑服消息(只有在线角色响应)(switching时,消息阻塞)(generated by shine) */
public class PlayerToGameServerResponse extends CenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerToGame;
	
	/** 角色 */
	public Player me;
	
	public PlayerToGameServerResponse()
	{
		_dataID=ServerMessageType.PlayerToGame;
	}
	
	@Override
	public void dispatch()
	{
		if(me!=null)
		{
			me.addFunc(this);
		}
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerToGameServerResponse";
	}
	
}
