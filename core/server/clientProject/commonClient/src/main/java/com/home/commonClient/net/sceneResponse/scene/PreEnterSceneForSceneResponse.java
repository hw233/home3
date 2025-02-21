package com.home.commonClient.net.sceneResponse.scene;
import com.home.commonClient.constlist.generate.SceneResponseType;
import com.home.commonClient.net.base.SceneResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 预备进入场景消息(场景服)(generated by shine) */
public class PreEnterSceneForSceneResponse extends SceneResponse
{
	/** 数据类型ID */
	public static final int dataID=SceneResponseType.PreEnterSceneForScene;
	
	/** 场景ID */
	public int id;
	
	/** 线ID */
	public int lineID=-1;
	
	public PreEnterSceneForSceneResponse()
	{
		_dataID=SceneResponseType.PreEnterSceneForScene;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PreEnterSceneForSceneResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.lineID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.lineID=stream.readInt();
		
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.lineID=0;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.scene.onPreEnterScene(id,lineID);
	}
	
}
