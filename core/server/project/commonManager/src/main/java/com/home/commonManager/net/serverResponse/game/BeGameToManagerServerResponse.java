package com.home.commonManager.net.serverResponse.game;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.login.GameInitServerData;
import com.home.commonBase.data.system.GameServerInfoData;
import com.home.commonBase.global.BaseC;
import com.home.commonManager.global.ManagerC;
import com.home.commonManager.net.serverRequest.game.ReBeGameToManagerServerRequest;
import com.home.commonManager.net.serverResponse.game.base.GameToManagerServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.constlist.SocketType;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class BeGameToManagerServerResponse extends GameToManagerServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.BeGameToManager;
	
	public int id;
	
	/** 是否第一次连接 */
	public boolean isFirst;
	
	public BeGameToManagerServerResponse()
	{
		_dataID=ServerMessageType.BeGameToManager;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "BeGameToManagerServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.isFirst=stream.readBoolean();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isFirst");
		writer.sb.append(':');
		writer.sb.append(this.isFirst);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		if(!ManagerC.main.hasGameServer(id))
		{
			Ctrl.throwError("找不到游戏服配置",id);
			return;
		}
		
		ManagerC.server.getSocketInfo(SocketType.Game).registerSocket(id,socket);
		
		GameInitServerData initData=isFirst ? ManagerC.main.createGameInitData(id) : null;
		
		socket.send(ReBeGameToManagerServerRequest.create(initData));
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.isFirst=false;
	}
	
}
