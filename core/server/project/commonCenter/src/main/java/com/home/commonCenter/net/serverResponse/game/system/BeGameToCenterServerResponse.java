package com.home.commonCenter.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.net.serverRequest.game.system.ReBeGameToCenterServerRequest;
import com.home.commonCenter.net.serverResponse.game.base.GameToCenterServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.constlist.SocketType;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class BeGameToCenterServerResponse extends GameToCenterServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.BeGameToCenter;
	
	/** 是否第一次连接 */
	public boolean isFirst;
	
	public int id;
	
	public BeGameToCenterServerResponse()
	{
		_dataID=ServerMessageType.BeGameToCenter;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.isFirst=stream.readBoolean();
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		CenterC.server.getSocketInfo(SocketType.Game).registerSocket(id,socket);
		
		socket.send(ReBeGameToCenterServerRequest.create(CenterC.main.makeGameLoginData(id)));
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "BeGameToCenterServerResponse";
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.isFirst=false;
	}
	
}
