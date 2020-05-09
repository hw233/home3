package com.home.commonClient.net.response.social;
import com.home.commonBase.data.social.base.QueryPlayerResultData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 回复查询角色消息(generated by shine) */
public class ReQueryPlayerResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.ReQueryPlayer;
	
	/** 回复角色数据 */
	public QueryPlayerResultData result;
	
	public ReQueryPlayerResponse()
	{
		_dataID=GameResponseType.ReQueryPlayer;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReQueryPlayerResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData resultT=stream.readDataFullNotNull();
		if(resultT!=null)
		{
			if(resultT instanceof QueryPlayerResultData)
			{
				this.result=(QueryPlayerResultData)resultT;
			}
			else
			{
				this.result=new QueryPlayerResultData();
				if(!(resultT.getClass().isAssignableFrom(QueryPlayerResultData.class)))
				{
					stream.throwTypeReadError(QueryPlayerResultData.class,resultT.getClass());
				}
				this.result.shadowCopy(resultT);
			}
		}
		else
		{
			this.result=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.result=(QueryPlayerResultData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("result");
		writer.sb.append(':');
		if(this.result!=null)
		{
			this.result.writeDataString(writer);
		}
		else
		{
			writer.sb.append("QueryPlayerResultData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.result=null;
	}
	
}
