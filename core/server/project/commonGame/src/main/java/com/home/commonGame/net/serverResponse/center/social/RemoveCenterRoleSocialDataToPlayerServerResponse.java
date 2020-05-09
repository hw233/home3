package com.home.commonGame.net.serverResponse.center.social;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverResponse.center.base.PlayerToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;

/** 中心服移除角色社交数据到角色(generated by shine) */
public class RemoveCenterRoleSocialDataToPlayerServerResponse extends PlayerToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.RemoveCenterRoleSocialDataToPlayer;
	
	public RemoveCenterRoleSocialDataToPlayerServerResponse()
	{
		_dataID=ServerMessageType.RemoveCenterRoleSocialDataToPlayer;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RemoveCenterRoleSocialDataToPlayerServerResponse";
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.social.onCenterRemoveSocial();
	}
	
}
