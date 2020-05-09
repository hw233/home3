package com.home.commonGame.net.serverRequest.center.base;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.center.base.GameToCenterServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncToCenterServerRequest extends GameToCenterServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncToCenter;
	
	public int funcID;
	
	public FuncToCenterServerRequest()
	{
		_dataID=ServerMessageType.FuncToCenter;
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
		return "FuncToCenterServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.funcID);
		
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
	
	/** 创建实例 */
	public static FuncToCenterServerRequest create(int funcID)
	{
		FuncToCenterServerRequest re=(FuncToCenterServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		return re;
	}
	
}
