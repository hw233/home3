package com.home.commonGame.net.request.func.roleGroup;
import com.home.commonBase.data.social.roleGroup.PlayerRoleGroupData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送添加玩家群消息(generated by shine) */
public class FuncSendPlayerJoinRoleGroupRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncSendPlayerJoinRoleGroup;
	
	/** 方式 */
	public int type;
	
	/** 玩家群数据 */
	public PlayerRoleGroupData data;
	
	public FuncSendPlayerJoinRoleGroupRequest()
	{
		_dataID=GameRequestType.FuncSendPlayerJoinRoleGroup;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		PlayerRoleGroupData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(PlayerRoleGroupData)dataTemp.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendPlayerJoinRoleGroupRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeInt(this.type);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeInt(this.type);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PlayerRoleGroupData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("type");
		writer.sb.append(':');
		writer.sb.append(this.type);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data.release(pool);
		this.data=null;
		this.type=0;
	}
	
	/** 创建实例 */
	public static FuncSendPlayerJoinRoleGroupRequest create(int funcID,PlayerRoleGroupData data,int type)
	{
		FuncSendPlayerJoinRoleGroupRequest re=(FuncSendPlayerJoinRoleGroupRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.data=data;
		re.type=type;
		return re;
	}
	
}
