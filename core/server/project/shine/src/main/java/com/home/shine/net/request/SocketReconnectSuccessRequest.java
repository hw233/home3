package com.home.shine.net.request;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.constlist.generate.ShineRequestType;
import com.home.shine.control.BytesControl;
import com.home.shine.net.base.ShineRequest;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 重连成功(generated by shine) */
public class SocketReconnectSuccessRequest extends ShineRequest
{
	/** 数据类型ID */
	public static final int dataID=ShineRequestType.SocketReconnectSuccess;
	
	/** 最后收包索引 */
	public int lastReceiveIndex;
	
	public SocketReconnectSuccessRequest()
	{
		_dataID=ShineRequestType.SocketReconnectSuccess;
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
		return "SocketReconnectSuccessRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.lastReceiveIndex);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.lastReceiveIndex);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("lastReceiveIndex");
		writer.sb.append(':');
		writer.sb.append(this.lastReceiveIndex);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.lastReceiveIndex=0;
	}
	
	/** 创建实例 */
	public static SocketReconnectSuccessRequest create(int lastReceiveIndex)
	{
		SocketReconnectSuccessRequest re=(SocketReconnectSuccessRequest)BytesControl.createRequest(dataID);
		re.lastReceiveIndex=lastReceiveIndex;
		return re;
	}
	
}
