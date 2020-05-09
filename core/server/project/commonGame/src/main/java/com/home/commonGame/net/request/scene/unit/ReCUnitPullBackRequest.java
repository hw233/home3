package com.home.commonGame.net.request.scene.unit;
import com.home.commonBase.data.scene.base.PosDirData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.scene.base.SceneSRequest;
import com.home.commonGame.net.request.scene.base.UnitSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位拉回消息(generated by shine) */
public class ReCUnitPullBackRequest extends UnitSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.ReCUnitPullBack;
	
	/** 位置 */
	public PosDirData posDir;
	
	public ReCUnitPullBackRequest()
	{
		_dataID=GameRequestType.ReCUnitPullBack;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		PosDirData posDirTemp=posDir;
		if(posDirTemp!=null)
		{
			this.posDir=new PosDirData();
			this.posDir.copy(posDirTemp);
		}
		else
		{
			this.posDir=null;
			nullObjError("posDir");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReCUnitPullBackRequest";
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.posDir!=null)
		{
			this.posDir.writeBytesFull(stream);
		}
		else
		{
			nullObjError("posDir");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.posDir!=null)
		{
			this.posDir.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("posDir");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.posDir.release(pool);
		this.posDir=null;
	}
	
	/** 创建实例 */
	public static ReCUnitPullBackRequest create(int instanceID,PosDirData posDir)
	{
		ReCUnitPullBackRequest re=(ReCUnitPullBackRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.posDir=posDir;
		return re;
	}
	
}
