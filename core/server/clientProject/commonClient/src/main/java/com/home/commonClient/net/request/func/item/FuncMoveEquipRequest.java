package com.home.commonClient.net.request.func.item;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.func.base.FuncRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 移动装备消息(generated by shine) */
public class FuncMoveEquipRequest extends FuncRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncMoveEquip;
	
	public int fromSlot;
	
	public int toSlot;
	
	public FuncMoveEquipRequest()
	{
		_dataID=GameRequestType.FuncMoveEquip;
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
		return "FuncMoveEquipRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.fromSlot);
		
		stream.writeInt(this.toSlot);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.fromSlot);
		
		stream.writeInt(this.toSlot);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("fromSlot");
		writer.sb.append(':');
		writer.sb.append(this.fromSlot);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("toSlot");
		writer.sb.append(':');
		writer.sb.append(this.toSlot);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.fromSlot=0;
		this.toSlot=0;
	}
	
	/** 创建实例 */
	public static FuncMoveEquipRequest create(int funcID,int fromSlot,int toSlot)
	{
		FuncMoveEquipRequest re=(FuncMoveEquipRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.fromSlot=fromSlot;
		re.toSlot=toSlot;
		return re;
	}
	
}
