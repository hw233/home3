package com.home.commonGame.net.request.func.roleGroup;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 发送被邀请时是否可直接入群的变化(generated by shine) */
public class FuncSendChangeCanInviteInAbsRoleGroupRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncSendChangeCanInviteInAbsRoleGroup;
	
	/** 被邀请时是否可直接入群(无需同意) */
	public boolean canInviteInAbs;
	
	public FuncSendChangeCanInviteInAbsRoleGroupRequest()
	{
		_dataID=GameRequestType.FuncSendChangeCanInviteInAbsRoleGroup;
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
		return "FuncSendChangeCanInviteInAbsRoleGroupRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeBoolean(this.canInviteInAbs);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeBoolean(this.canInviteInAbs);
		
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
	
	/** 创建实例 */
	public static FuncSendChangeCanInviteInAbsRoleGroupRequest create(int funcID,boolean canInviteInAbs)
	{
		FuncSendChangeCanInviteInAbsRoleGroupRequest re=(FuncSendChangeCanInviteInAbsRoleGroupRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.canInviteInAbs=canInviteInAbs;
		return re;
	}
	
}
