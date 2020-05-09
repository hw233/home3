package com.home.commonGame.net.response.func.roleGroup;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.func.base.FuncRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更改被邀请时是否可直接入群(generated by shine) */
public class FuncChangeRoleGroupCanInviteInAbsResponse extends FuncRResponse
{
	/** 被邀请时是否可直接入群(无需同意) */
	public boolean canInviteInAbs;
	
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncChangeRoleGroupCanInviteInAbs;
	
	public FuncChangeRoleGroupCanInviteInAbsResponse()
	{
		_dataID=GameResponseType.FuncChangeRoleGroupCanInviteInAbs;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncChangeRoleGroupCanInviteInAbsResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.canInviteInAbs=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getRoleGroupTool(funcID).changeCanInviteInAbs(canInviteInAbs);
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.canInviteInAbs=stream.readBoolean();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("canInviteInAbs");
		writer.sb.append(':');
		writer.sb.append(this.canInviteInAbs);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.canInviteInAbs=false;
	}
	
}
