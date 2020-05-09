package com.home.commonClient.net.response.func.roleGroup;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 发送被邀请时是否可直接入群的变化(generated by shine) */
public class FuncSendChangeCanInviteInAbsRoleGroupResponse extends FuncSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncSendChangeCanInviteInAbsRoleGroup;
	
	/** 被邀请时是否可直接入群(无需同意) */
	public boolean canInviteInAbs;
	
	public FuncSendChangeCanInviteInAbsRoleGroupResponse()
	{
		_dataID=GameResponseType.FuncSendChangeCanInviteInAbsRoleGroup;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendChangeCanInviteInAbsRoleGroupResponse";
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
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.canInviteInAbs=false;
	}
	
}
