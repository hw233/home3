package com.home.commonClient.net.response.scene.unit;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.constlist.generate.MGameResponseType;
import com.home.commonClient.net.response.scene.base.SceneSResponse;
import com.home.commonClient.net.response.scene.base.UnitSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位刷新buff(generated by shine) */
public class UnitRefreshBuffResponse extends UnitSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.UnitRefreshBuff;
	
	/** buff实例ID */
	public int buffInstanceID;
	
	/** 剩余时间 */
	public int lastTime;
	
	/** 剩余次数 */
	public int lastNum;
	
	public UnitRefreshBuffResponse()
	{
		_dataID=GameResponseType.UnitRefreshBuff;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		scene.getFightUnitAbs(instanceID).fight.getBuffLogic().refreshBuffByServer(buffInstanceID,lastTime,lastNum);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitRefreshBuffResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.buffInstanceID=stream.readInt();
		
		this.lastTime=stream.readInt();
		
		this.lastNum=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.buffInstanceID=stream.readInt();
		
		this.lastTime=stream.readInt();
		
		this.lastNum=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("buffInstanceID");
		writer.sb.append(':');
		writer.sb.append(this.buffInstanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("lastTime");
		writer.sb.append(':');
		writer.sb.append(this.lastTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("lastNum");
		writer.sb.append(':');
		writer.sb.append(this.lastNum);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.buffInstanceID=0;
		this.lastTime=0;
		this.lastNum=0;
	}
	
}
