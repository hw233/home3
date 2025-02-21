package com.home.commonClient.net.request.scene;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 请求进入场景消息(generated by shine) */
public class ApplyEnterSceneRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.ApplyEnterScene;
	
	/** 场景ID */
	public int id;
	
	/** 线ID */
	public int line=-1;
	
	/** 位置ID */
	public int posID=-1;
	
	public ApplyEnterSceneRequest()
	{
		_dataID=GameRequestType.ApplyEnterScene;
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
		return "ApplyEnterSceneRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("line");
		writer.sb.append(':');
		writer.sb.append(this.line);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("posID");
		writer.sb.append(':');
		writer.sb.append(this.posID);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.line);
		
		stream.writeInt(this.posID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.line);
		
		stream.writeInt(this.posID);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.line=0;
		this.posID=0;
	}
	
	/** 创建实例 */
	public static ApplyEnterSceneRequest create(int id,int line,int posID)
	{
		ApplyEnterSceneRequest re=(ApplyEnterSceneRequest)BytesControl.createRequest(dataID);
		re.id=id;
		re.line=line;
		re.posID=posID;
		return re;
	}
	
}
