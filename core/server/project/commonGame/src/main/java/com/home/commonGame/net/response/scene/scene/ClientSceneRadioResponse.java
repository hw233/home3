package com.home.commonGame.net.response.scene.scene;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.request.scene.scene.SceneRadioRequest;
import com.home.commonGame.net.response.scene.base.SceneRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 客户端场景广播(generated by shine) */
public class ClientSceneRadioResponse extends SceneRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.ClientSceneRadio;
	
	/** 数据 */
	public BaseData data;
	
	public ClientSceneRadioResponse()
	{
		_dataID=GameResponseType.ClientSceneRadio;
	}
	
	/** 执行 */
	protected void execute()
	{
		//广播
		scene.aoi.radioMessage(me.scene.getUnit(),SceneRadioRequest.create(data),false);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ClientSceneRadioResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT instanceof BaseData)
			{
				this.data=(BaseData)dataT;
			}
			else
			{
				this.data=new BaseData();
				if(!(dataT.getClass().isAssignableFrom(BaseData.class)))
				{
					stream.throwTypeReadError(BaseData.class,dataT.getClass());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(BaseData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("BaseData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
}
