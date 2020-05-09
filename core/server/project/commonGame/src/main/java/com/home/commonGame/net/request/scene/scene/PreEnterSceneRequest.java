package com.home.commonGame.net.request.scene.scene;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 预备进入场景消息(generated by shine) */
public class PreEnterSceneRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.PreEnterScene;
	
	/** 场景ID */
	public int id;
	
	/** 线ID */
	public int lineID=-1;
	
	public PreEnterSceneRequest()
	{
		_dataID=GameRequestType.PreEnterScene;
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
		return "PreEnterSceneRequest";
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
		writer.sb.append("lineID");
		writer.sb.append(':');
		writer.sb.append(this.lineID);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.lineID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.lineID);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.lineID=0;
	}
	
	/** 创建实例 */
	public static PreEnterSceneRequest create(int id,int lineID)
	{
		PreEnterSceneRequest re=(PreEnterSceneRequest)BytesControl.createRequest(dataID);
		re.id=id;
		re.lineID=lineID;
		return re;
	}
	
}
