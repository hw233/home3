package com.home.commonGame.net.serverRequest.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.system.AreaGlobalWorkData;
import com.home.commonGame.net.serverRequest.game.base.GameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class SendAreaWorkToGameServerRequest extends GameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendAreaWorkToGame;
	
	/** 逻辑服事务 */
	public AreaGlobalWorkData data;
	
	public SendAreaWorkToGameServerRequest()
	{
		_dataID=ServerMessageType.SendAreaWorkToGame;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		AreaGlobalWorkData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(AreaGlobalWorkData)dataTemp.clone();
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
		return "SendAreaWorkToGameServerRequest";
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
			writer.sb.append("AreaGlobalWorkData=null");
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
	public static SendAreaWorkToGameServerRequest create(AreaGlobalWorkData data)
	{
		SendAreaWorkToGameServerRequest re=(SendAreaWorkToGameServerRequest)BytesControl.createRequest(dataID);
		re.data=data;
		return re;
	}
	
}
