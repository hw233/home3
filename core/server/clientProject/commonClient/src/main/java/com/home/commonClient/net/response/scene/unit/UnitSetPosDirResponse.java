package com.home.commonClient.net.response.scene.unit;
import com.home.commonBase.data.scene.base.PosDirData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.scene.base.UnitSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位直接更改位置朝向消息(generated by shine) */
public class UnitSetPosDirResponse extends UnitSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.UnitSetPosDir;
	
	/** 位置朝向 */
	public PosDirData posDir;
	
	public UnitSetPosDirResponse()
	{
		_dataID=GameResponseType.UnitSetPosDir;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitSetPosDirResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.posDir=new PosDirData();
		this.posDir.readBytesFull(stream);
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.posDir=new PosDirData();
		this.posDir.readBytesSimple(stream);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("posDir");
		writer.sb.append(':');
		if(this.posDir!=null)
		{
			this.posDir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosDirData=null");
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
		
		this.posDir=null;
	}
	
}
