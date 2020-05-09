package com.home.commonGame.net.serverRequest.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.func.base.FuncRoleGroupToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 离开玩家群到逻辑服(generated by shine) */
public class FuncLeaveRoleGroupToGameServerRequest extends FuncRoleGroupToGameServerRequest
{
	public long playerID;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncLeaveRoleGroupToGame;
	
	public FuncLeaveRoleGroupToGameServerRequest()
	{
		_dataID=ServerMessageType.FuncLeaveRoleGroupToGame;
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
		return "FuncLeaveRoleGroupToGameServerRequest";
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
	public static FuncLeaveRoleGroupToGameServerRequest create(int funcID,long groupID,long playerID)
	{
		FuncLeaveRoleGroupToGameServerRequest re=(FuncLeaveRoleGroupToGameServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.playerID=playerID;
		return re;
	}
	
}
