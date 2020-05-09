package com.home.commonGame.net.response.login;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.response.base.LoginResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色切换game服消息(generated by shine) */
public class PlayerSwitchGameResponse extends LoginResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.PlayerSwitchGame;
	
	/** 令牌 */
	public int token;
	
	public PlayerSwitchGameResponse()
	{
		_dataID=GameResponseType.PlayerSwitchGame;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.gameSwitch.playerSwitchGameReceive(gameSocket,token);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerSwitchGameResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.token=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.token=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("token");
		writer.sb.append(':');
		writer.sb.append(this.token);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.token=0;
	}
	
}
