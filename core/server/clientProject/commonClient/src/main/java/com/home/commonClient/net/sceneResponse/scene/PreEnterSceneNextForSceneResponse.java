package com.home.commonClient.net.sceneResponse.scene;
import com.home.commonBase.data.scene.scene.ScenePreInfoData;
import com.home.commonClient.constlist.generate.SceneResponseType;
import com.home.commonClient.net.base.SceneResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 预进入场景服务器就绪(场景服)(generated by shine) */
public class PreEnterSceneNextForSceneResponse extends SceneResponse
{
	/** 数据类型ID */
	public static final int dataID=SceneResponseType.PreEnterSceneNextForScene;
	
	/** 预备信息 */
	public ScenePreInfoData preInfo;
	
	public PreEnterSceneNextForSceneResponse()
	{
		_dataID=SceneResponseType.PreEnterSceneNextForScene;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PreEnterSceneNextForSceneResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData preInfoT=stream.readDataFullNotNull();
		if(preInfoT!=null)
		{
			if(preInfoT instanceof ScenePreInfoData)
			{
				this.preInfo=(ScenePreInfoData)preInfoT;
			}
			else
			{
				this.preInfo=new ScenePreInfoData();
				if(!(preInfoT.getClass().isAssignableFrom(ScenePreInfoData.class)))
				{
					stream.throwTypeReadError(ScenePreInfoData.class,preInfoT.getClass());
				}
				this.preInfo.shadowCopy(preInfoT);
			}
		}
		else
		{
			this.preInfo=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.preInfo=(ScenePreInfoData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("preInfo");
		writer.sb.append(':');
		if(this.preInfo!=null)
		{
			this.preInfo.writeDataString(writer);
		}
		else
		{
			writer.sb.append("ScenePreInfoData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.preInfo=null;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
}
