package com.home.commonCenter.net.serverResponse.game.func.match;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.net.serverResponse.game.base.PlayerToCenterServerResponse;
import com.home.commonCenter.net.serverResponse.game.func.base.FuncPlayerToCenterServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 接收匹配到中心服消息(generated by shine) */
public class FuncAcceptMatchToCenterServerResponse extends FuncPlayerToCenterServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncAcceptMatchToCenter;
	
	/** 序号 */
	public int index;
	
	public FuncAcceptMatchToCenterServerResponse()
	{
		_dataID=ServerMessageType.FuncAcceptMatchToCenter;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.index=stream.readInt();
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		//取消匹配
		CenterC.global.func.getMatchTool(funcID).acceptMatch(index,playerID);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncAcceptMatchToCenterServerResponse";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
	}
	
}
