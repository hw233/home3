package com.home.commonGame.net.serverResponse.scene.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.scene.scene.SceneLocationData;
import com.home.commonGame.net.serverResponse.scene.base.PlayerSceneToGameServerResponse;
import com.home.commonGame.net.serverResponse.scene.base.SceneToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 场景切换到场景服结束(generated by shine) */
public class PlayerSwitchToSceneOverServerResponse extends PlayerSceneToGameServerResponse
{
	/** 位置数据 */
	public SceneLocationData location;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerSwitchToSceneOver;
	
	public PlayerSwitchToSceneOverServerResponse()
	{
		_dataID=ServerMessageType.PlayerSwitchToSceneOver;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerSwitchToSceneOverServerResponse";
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.addFunc(()->
		{
			me.getExecutor().playerSwitchToSceneThird(me,location);
		});
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.location=(SceneLocationData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("location");
		writer.sb.append(':');
		if(this.location!=null)
		{
			this.location.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SceneLocationData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.location=null;
	}
	
}
