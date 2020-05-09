package com.home.commonClient.net.request.scene.syncScene;
import com.home.commonBase.data.scene.fight.FrameSyncCommandData;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.scene.base.SceneRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 帧同步单个玩家消息(generated by shine) */
public class FrameSyncOneRequest extends SceneRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FrameSyncOne;
	
	/** 指令 */
	public FrameSyncCommandData command;
	
	public FrameSyncOneRequest()
	{
		_dataID=GameRequestType.FrameSyncOne;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		FrameSyncCommandData commandTemp=command;
		if(commandTemp!=null)
		{
			this.command=(FrameSyncCommandData)commandTemp.clone();
		}
		else
		{
			this.command=null;
			nullObjError("command");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FrameSyncOneRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("command");
		writer.sb.append(':');
		if(this.command!=null)
		{
			this.command.writeDataString(writer);
		}
		else
		{
			writer.sb.append("FrameSyncCommandData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.command!=null)
		{
			stream.writeDataFullNotNull(this.command);
		}
		else
		{
			nullObjError("command");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.command!=null)
		{
			stream.writeDataSimpleNotNull(this.command);
		}
		else
		{
			nullObjError("command");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.command.release(pool);
		this.command=null;
	}
	
	/** 创建实例 */
	public static FrameSyncOneRequest create(FrameSyncCommandData command)
	{
		FrameSyncOneRequest re=(FrameSyncOneRequest)BytesControl.createRequest(dataID);
		re.command=command;
		return re;
	}
	
}
