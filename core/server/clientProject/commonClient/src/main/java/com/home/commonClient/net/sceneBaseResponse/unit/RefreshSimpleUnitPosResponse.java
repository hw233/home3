package com.home.commonClient.net.sceneBaseResponse.unit;
import com.home.commonBase.data.scene.base.DirData;
import com.home.commonBase.data.scene.base.PosData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.constlist.generate.SceneBaseResponseType;
import com.home.commonClient.net.sceneBaseResponse.base.SceneSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新简版单位位置消息(generated by shine) */
public class RefreshSimpleUnitPosResponse extends SceneSResponse
{
	/** 数据类型ID */
	public static final int dataID=SceneBaseResponseType.RefreshSimpleUnitPos;
	
	public int instanceID;
	
	public PosData pos;
	
	public DirData dir;
	
	public RefreshSimpleUnitPosResponse()
	{
		_dataID=SceneBaseResponseType.RefreshSimpleUnitPos;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RefreshSimpleUnitPosResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		this.pos=new PosData();
		this.pos.readBytesFull(stream);
		
		this.dir=new DirData();
		this.dir.readBytesFull(stream);
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.instanceID=stream.readInt();
		
		this.pos=new PosData();
		this.pos.readBytesSimple(stream);
		
		this.dir=new DirData();
		this.dir.readBytesSimple(stream);
		
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
		writer.writeTabs();
		writer.sb.append("pos");
		writer.sb.append(':');
		if(this.pos!=null)
		{
			this.pos.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("dir");
		writer.sb.append(':');
		if(this.dir!=null)
		{
			this.dir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("DirData=null");
		}
		
		writer.writeEnter();
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
		this.pos=null;
		this.dir=null;
	}
	
}
