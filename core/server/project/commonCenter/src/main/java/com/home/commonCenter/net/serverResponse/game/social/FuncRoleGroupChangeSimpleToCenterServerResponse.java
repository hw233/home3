package com.home.commonCenter.net.serverResponse.game.social;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.social.roleGroup.RoleGroupChangeData;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.net.serverResponse.game.base.FuncToCenterServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncRoleGroupChangeSimpleToCenterServerResponse extends FuncToCenterServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRoleGroupChangeSimpleToCenter;
	
	public long groupID;
	
	/** 改变数据 */
	public RoleGroupChangeData changeData;
	
	public FuncRoleGroupChangeSimpleToCenterServerResponse()
	{
		_dataID=ServerMessageType.FuncRoleGroupChangeSimpleToCenter;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRoleGroupChangeSimpleToCenterServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.groupID=stream.readLong();
		
		this.changeData=(RoleGroupChangeData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("groupID");
		writer.sb.append(':');
		writer.sb.append(this.groupID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("changeData");
		writer.sb.append(':');
		if(this.changeData!=null)
		{
			this.changeData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleGroupChangeData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		CenterC.global.func.getRoleGroupTool(funcID).doRoleGroupSimpleChange(groupID,changeData);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groupID=0L;
		this.changeData=null;
	}
	
}
