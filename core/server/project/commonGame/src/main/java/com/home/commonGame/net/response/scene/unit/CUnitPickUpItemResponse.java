package com.home.commonGame.net.response.scene.unit;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.CUnitRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 拾取物品消息(generated by shine) */
public class CUnitPickUpItemResponse extends CUnitRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CUnitPickUpItem;
	
	/** 目标物品实例ID */
	public int targetInstanceID;
	
	public CUnitPickUpItemResponse()
	{
		_dataID=GameResponseType.CUnitPickUpItem;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitPickUpItemResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.targetInstanceID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.targetInstanceID=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("targetInstanceID");
		writer.sb.append(':');
		writer.sb.append(this.targetInstanceID);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		scene.role.pickUpItem(unit,targetInstanceID);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.targetInstanceID=0;
	}
	
}
