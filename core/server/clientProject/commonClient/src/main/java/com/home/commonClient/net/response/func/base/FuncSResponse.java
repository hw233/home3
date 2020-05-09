package com.home.commonClient.net.response.func.base;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 功能发送消息(generated by shine) */
public class FuncSResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncS;
	
	public int funcID;
	
	public FuncSResponse()
	{
		_dataID=GameResponseType.FuncS;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.funcID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.funcID=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("funcID");
		writer.sb.append(':');
		writer.sb.append(this.funcID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcID=0;
	}
	
}
