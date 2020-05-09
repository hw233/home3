package com.home.commonGame.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.login.GameLoginToGameData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.game.base.GameToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.constlist.SocketType;
import com.home.shine.net.socket.SendSocket;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 回复成为game服消息(generated by shine) */
public class ReBeGameToGameServerResponse extends GameToGameServerResponse
{
	/** 数据 */
	public GameLoginToGameData data;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReBeGameToGame;
	
	public ReBeGameToGameServerResponse()
	{
		_dataID=ServerMessageType.ReBeGameToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReBeGameToGameServerResponse";
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.global.readGameLoginData(fromGameID,data);
		GameC.server.reBack(SocketType.Game,((SendSocket)socket).sendID);
		GameC.server.checkNext();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(GameLoginToGameData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("GameLoginToGameData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
}
