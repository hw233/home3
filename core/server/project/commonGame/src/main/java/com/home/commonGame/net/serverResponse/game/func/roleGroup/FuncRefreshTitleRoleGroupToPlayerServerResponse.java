package com.home.commonGame.net.serverResponse.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverResponse.game.func.base.FuncPlayerRoleGroupGameToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更新职位到角色(generated by shine) */
public class FuncRefreshTitleRoleGroupToPlayerServerResponse extends FuncPlayerRoleGroupGameToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRefreshTitleRoleGroupToPlayer;
	
	/** 成员id */
	public long memberID;
	
	/** 职位 */
	public int title;
	
	public FuncRefreshTitleRoleGroupToPlayerServerResponse()
	{
		_dataID=ServerMessageType.FuncRefreshTitleRoleGroupToPlayer;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRefreshTitleRoleGroupToPlayerServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.memberID=stream.readLong();
		
		this.title=stream.readInt();
		
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
		writer.sb.append("title");
		writer.sb.append(':');
		writer.sb.append(this.title);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		roleGroup.onSetTitle(memberID,title);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.memberID=0L;
		this.title=0;
	}
	
}
