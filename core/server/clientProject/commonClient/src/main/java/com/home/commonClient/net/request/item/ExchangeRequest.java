package com.home.commonClient.net.request.item;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 兑换消息(generated by shine) */
public class ExchangeRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.Exchange;
	
	/** 兑换次数 */
	public int num;
	
	/** 兑换ID */
	public int id;
	
	public ExchangeRequest()
	{
		_dataID=GameRequestType.Exchange;
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
		return "ExchangeRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.num);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.num);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("num");
		writer.sb.append(':');
		writer.sb.append(this.num);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.num=0;
	}
	
	/** 创建实例 */
	public static ExchangeRequest create(int id,int num)
	{
		ExchangeRequest re=(ExchangeRequest)BytesControl.createRequest(dataID);
		re.id=id;
		re.num=num;
		return re;
	}
	
}
