package com.home.commonGame.net.response.scene.base;
import com.home.commonBase.scene.base.Unit;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.SceneRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 控制单位操作消息(generated by shine) */
public class CUnitRResponse extends SceneRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CUnitR;
	
	/** 实例ID */
	public int instanceID;
	
	/** 单位 */
	public Unit unit;
	
	public CUnitRResponse()
	{
		_dataID=GameResponseType.CUnitR;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitRResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.instanceID=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
	}
	
	@Override
	protected void preExecute()
	{
		if(me==null)
			return;
		
		if((scene=me.scene.getScene())==null)
			return;
		
		if((unit=scene.getPlayerControlUnit(me,instanceID))==null)
			return;
		
		doExecute();
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
		
		this.instanceID=0;
	}
	
}
