package com.home.commonGame.net.response.func.item;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.func.base.FuncRResponse;
import com.home.shine.bytes.BytesReadStream;

/** 整理物品容器消息(generated by shine) */
public class FuncCleanUpItemResponse extends FuncRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncCleanUpItem;
	
	public FuncCleanUpItemResponse()
	{
		_dataID=GameResponseType.FuncCleanUpItem;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getItemContainerTool(funcID).cleanUp();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncCleanUpItemResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
}
