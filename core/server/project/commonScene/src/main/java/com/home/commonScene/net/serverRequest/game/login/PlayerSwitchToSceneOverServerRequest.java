package com.home.commonScene.net.serverRequest.game.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.scene.scene.SceneEnterArgData;
import com.home.commonBase.data.scene.scene.SceneLocationData;
import com.home.commonScene.net.serverRequest.game.base.PlayerSceneToGameServerRequest;
import com.home.commonScene.net.serverRequest.game.base.SceneToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 场景切换到场景服结束(generated by shine) */
public class PlayerSwitchToSceneOverServerRequest extends PlayerSceneToGameServerRequest
{
	/** 位置数据 */
	public SceneLocationData location;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerSwitchToSceneOver;
	
	public PlayerSwitchToSceneOverServerRequest()
	{
		_dataID=ServerMessageType.PlayerSwitchToSceneOver;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SceneLocationData locationTemp=location;
		if(locationTemp!=null)
		{
			this.location=(SceneLocationData)locationTemp.clone();
		}
		else
		{
			this.location=null;
			nullObjError("location");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerSwitchToSceneOverServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.location!=null)
		{
			stream.writeDataSimpleNotNull(this.location);
		}
		else
		{
			nullObjError("location");
		}
		
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
		
		this.location.release(pool);
		this.location=null;
	}
	
	/** 创建实例 */
	public static PlayerSwitchToSceneOverServerRequest create(long playerID,SceneLocationData location)
	{
		PlayerSwitchToSceneOverServerRequest re=(PlayerSwitchToSceneOverServerRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		re.location=location;
		return re;
	}
	
}
