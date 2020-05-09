package com.home.commonGame.net.serverResponse.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.social.roleGroup.RoleGroupMemberChangeData;
import com.home.commonGame.net.serverResponse.game.func.base.FuncPlayerRoleGroupGameToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncRoleGroupMemberChangeToPlayerServerResponse extends FuncPlayerRoleGroupGameToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRoleGroupMemberChangeToPlayer;
	
	public long memberID;
	
	public RoleGroupMemberChangeData data;
	
	public FuncRoleGroupMemberChangeToPlayerServerResponse()
	{
		_dataID=ServerMessageType.FuncRoleGroupMemberChangeToPlayer;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRoleGroupMemberChangeToPlayerServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.memberID=stream.readLong();
		
		this.data=(RoleGroupMemberChangeData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("memberID");
		writer.sb.append(':');
		writer.sb.append(this.memberID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleGroupMemberChangeData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		roleGroup.onRoleGroupMemberChange(memberID,data);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.memberID=0L;
		this.data=null;
	}
	
}
