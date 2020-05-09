package com.home.commonCenter.net.serverRequest.game.func.rank;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.serverRequest.game.base.CenterToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送移除排行榜数据消息(generated by shine) */
public class FuncRemoveRankToGameServerRequest extends CenterToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRemoveRankToGame;
	
	/** 功能ID */
	public int funcID;
	
	/** 主键 */
	public long key;
	
	public FuncRemoveRankToGameServerRequest()
	{
		_dataID=ServerMessageType.FuncRemoveRankToGame;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.funcID);
		
		stream.writeLong(this.key);
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRemoveRankToGameServerRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("funcID");
		writer.sb.append(':');
		writer.sb.append(this.funcID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("key");
		writer.sb.append(':');
		writer.sb.append(this.key);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcID=0;
		this.key=0L;
	}
	
	/** 创建实例 */
	public static FuncRemoveRankToGameServerRequest create(int funcID,long key)
	{
		FuncRemoveRankToGameServerRequest re=(FuncRemoveRankToGameServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.key=key;
		return re;
	}
	
}
