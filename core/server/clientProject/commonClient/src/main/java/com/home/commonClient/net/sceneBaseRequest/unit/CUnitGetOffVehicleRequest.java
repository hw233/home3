package com.home.commonClient.net.sceneBaseRequest.unit;
import com.home.commonBase.data.scene.base.PosData;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.constlist.generate.SceneBaseRequestType;
import com.home.commonClient.net.sceneBaseRequest.base.CUnitRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位下载具(generated by shine) */
public class CUnitGetOffVehicleRequest extends CUnitRRequest
{
	/** 数据类型ID */
	public static final int dataID=SceneBaseRequestType.CUnitGetOffVehicle;
	
	/** 下落位置 */
	public PosData pos;
	
	public CUnitGetOffVehicleRequest()
	{
		_dataID=SceneBaseRequestType.CUnitGetOffVehicle;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		PosData posTemp=pos;
		if(posTemp!=null)
		{
			this.pos=new PosData();
			this.pos.copy(posTemp);
		}
		else
		{
			this.pos=null;
			nullObjError("pos");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitGetOffVehicleRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.pos!=null)
		{
			this.pos.writeBytesFull(stream);
		}
		else
		{
			nullObjError("pos");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.pos!=null)
		{
			this.pos.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("pos");
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
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
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.pos.release(pool);
		this.pos=null;
	}
	
	/** 创建实例 */
	public static CUnitGetOffVehicleRequest create(int instanceID,PosData pos)
	{
		CUnitGetOffVehicleRequest re=(CUnitGetOffVehicleRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.pos=pos;
		return re;
	}
	
}
