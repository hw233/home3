package com.home.commonGame.net.serverResponse.center.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.shine.ShineSetup;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.control.ThreadControl;
import com.home.shine.ctrl.Ctrl;

/** 关闭game服消息(generated by shine) */
public class GameExitServerResponse extends CenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.GameExit;
	
	public GameExitServerResponse()
	{
		_dataID=ServerMessageType.GameExit;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		Ctrl.log("收到游戏服关闭消息(来自中心服)");
		
		ThreadControl.getMainTimeDriver().callLater(ShineSetup::exit);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "GameExitServerResponse";
	}
	
}
