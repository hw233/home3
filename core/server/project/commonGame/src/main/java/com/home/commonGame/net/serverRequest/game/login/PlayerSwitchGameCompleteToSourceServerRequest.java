package com.home.commonGame.net.serverRequest.game.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.base.GameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色切换游戏服完毕推到源服消息(切换完毕)(generated by shine) */
public class PlayerSwitchGameCompleteToSourceServerRequest extends GameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerSwitchGameCompleteToSource;
	
	/** 角色ID */
	public long playerID;
	
	public PlayerSwitchGameCompleteToSourceServerRequest()
	{
		_dataID=ServerMessageType.PlayerSwitchGameCompleteToSource;
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
		return "PlayerSwitchGameCompleteToSourceServerRequest";
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
	public static PlayerSwitchGameCompleteToSourceServerRequest create(long playerID)
	{
		PlayerSwitchGameCompleteToSourceServerRequest re=(PlayerSwitchGameCompleteToSourceServerRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		return re;
	}
	
}
