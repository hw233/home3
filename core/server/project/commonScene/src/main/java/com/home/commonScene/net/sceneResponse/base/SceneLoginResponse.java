package com.home.commonScene.net.sceneResponse.base;
import com.home.commonScene.constlist.generate.SceneResponseType;
import com.home.commonScene.net.base.SceneResponse;
import com.home.commonScene.part.ScenePlayer;
import com.home.commonScene.server.SceneReceiveSocket;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.control.ThreadControl;

/** 场景服登录消息(generated by shine) */
public class SceneLoginResponse extends SceneResponse
{
	/** 数据类型ID */
	public static final int dataID=SceneResponseType.SceneLogin;
	
	/** 玩家socket */
	protected SceneReceiveSocket sceneSocket;
	
	public SceneLoginResponse()
	{
		_dataID=SceneResponseType.SceneLogin;
		setUseMainThread();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SceneLoginResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	@Override
	public void dispatch()
	{
		sceneSocket=(SceneReceiveSocket)socket;
		
		ScenePlayer player;
		
		if((player=sceneSocket.player)!=null)
		{
			setPlayer(player);
		}
		
		//丢主线程执行
		ThreadControl.addMainFunc(this);
	}
	
}
