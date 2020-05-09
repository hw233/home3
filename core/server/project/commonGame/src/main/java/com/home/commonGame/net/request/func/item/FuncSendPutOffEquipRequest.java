package com.home.commonGame.net.request.func.item;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 脱装备(generated by shine) */
public class FuncSendPutOffEquipRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncSendPutOffEquip;
	
	/** 槽位 */
	public int slot;
	
	public FuncSendPutOffEquipRequest()
	{
		_dataID=GameRequestType.FuncSendPutOffEquip;
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
		return "FuncSendPutOffEquipRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.slot);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.slot);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("slot");
		writer.sb.append(':');
		writer.sb.append(this.slot);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.slot=0;
	}
	
	/** 创建实例 */
	public static FuncSendPutOffEquipRequest create(int funcID,int slot)
	{
		FuncSendPutOffEquipRequest re=(FuncSendPutOffEquipRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.slot=slot;
		return re;
	}
	
}
