package com.home.commonClient.net.response.role;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新货币消息(generated by shine) */
public class RefreshCurrencyResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.RefreshCurrency;
	
	/** 类型 */
	public int type;
	
	/** 值 */
	public long value;
	
	public RefreshCurrencyResponse()
	{
		_dataID=GameResponseType.RefreshCurrency;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.role.onRefreshCurrency(type,value);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RefreshCurrencyResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.type=stream.readInt();
		
		this.value=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.type=stream.readInt();
		
		this.value=stream.readLong();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("type");
		writer.sb.append(':');
		writer.sb.append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("value");
		writer.sb.append(':');
		writer.sb.append(this.value);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.type=0;
		this.value=0L;
	}
	
}
