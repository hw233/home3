package com.home.commonGame.net.request.social;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新单个社交数据(实时刷新用)(generated by shine) */
public class ReUpdateRoleSocialDataOneRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.ReUpdateRoleSocialDataOne;
	
	/** 数据 */
	public RoleSocialData data;
	
	public ReUpdateRoleSocialDataOneRequest()
	{
		_dataID=GameRequestType.ReUpdateRoleSocialDataOne;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		RoleSocialData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(RoleSocialData)dataTemp.clone();
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
		return "ReUpdateRoleSocialDataOneRequest";
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
			writer.sb.append("RoleSocialData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data.release(pool);
		this.data=null;
	}
	
	/** 创建实例 */
	public static ReUpdateRoleSocialDataOneRequest create(RoleSocialData data)
	{
		ReUpdateRoleSocialDataOneRequest re=(ReUpdateRoleSocialDataOneRequest)BytesControl.createRequest(dataID);
		re.data=data;
		return re;
	}
	
}
