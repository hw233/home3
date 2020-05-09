package com.home.commonGame.net.serverRequest.center.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.system.CenterGlobalWorkData;
import com.home.commonBase.data.system.WorkData;
import com.home.commonGame.net.serverRequest.center.base.GameToCenterServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送中心服事务到中心服(generated by shine) */
public class SendCenterWorkToCenterServerRequest extends GameToCenterServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendCenterWorkToCenter;
	
	/** 事务 */
	public CenterGlobalWorkData data;
	
	public SendCenterWorkToCenterServerRequest()
	{
		_dataID=ServerMessageType.SendCenterWorkToCenter;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		CenterGlobalWorkData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(CenterGlobalWorkData)dataTemp.clone();
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
		return "SendCenterWorkToCenterServerRequest";
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
			writer.sb.append("CenterGlobalWorkData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
	/** 创建实例 */
	public static SendCenterWorkToCenterServerRequest create(CenterGlobalWorkData data)
	{
		SendCenterWorkToCenterServerRequest re=(SendCenterWorkToCenterServerRequest)BytesControl.createRequest(dataID);
		re.data=data;
		return re;
	}
	
}
