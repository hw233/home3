package com.home.commonBase.part.centerGlobal.data;
import com.home.commonBase.constlist.generate.CenterGlobalPartDataType;
import com.home.commonBase.data.system.SaveVersionData;
import com.home.commonBase.data.system.WorkReceiverData;
import com.home.commonBase.data.system.WorkSenderData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 中心服系统数据(generated by shine) */
public class CenterSystemPartData extends BaseData
{
	/** 版本数据 */
	public SaveVersionData version;
	
	/** 数据类型ID */
	public static final int dataID=CenterGlobalPartDataType.CenterSystem;
	
	/** 服务器时间偏移 */
	public long serverOffTime;
	
	/** 下一个0点时刻 */
	public long nextDailyTime;
	
	/** 开服时间 */
	public long serverStartTime;
	
	/** 事务发起者数据 */
	public WorkSenderData workSenderData;
	
	/** 服务器出生码(每个新服生成一次) */
	public int serverBornCode;
	
	/** 事务接收数据 */
	public WorkReceiverData workReceiverData;
	
	/** 服务器运行序号(每次起服+1) */
	public int serverRunIndex;
	
	public CenterSystemPartData()
	{
		_dataID=CenterGlobalPartDataType.CenterSystem;
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData versionT=stream.readDataFullNotNull();
		if(versionT!=null)
		{
			if(versionT instanceof SaveVersionData)
			{
				this.version=(SaveVersionData)versionT;
			}
			else
			{
				this.version=new SaveVersionData();
				if(!(versionT.getClass().isAssignableFrom(SaveVersionData.class)))
				{
					stream.throwTypeReadError(SaveVersionData.class,versionT.getClass());
				}
				this.version.shadowCopy(versionT);
			}
		}
		else
		{
			this.version=null;
		}
		
		this.serverStartTime=stream.readLong();
		
		this.serverOffTime=stream.readLong();
		
		this.nextDailyTime=stream.readLong();
		
		this.serverRunIndex=stream.readInt();
		
		this.workSenderData=new WorkSenderData();
		this.workSenderData.readBytesFull(stream);
		
		this.serverBornCode=stream.readInt();
		
		this.workReceiverData=new WorkReceiverData();
		this.workReceiverData.readBytesFull(stream);
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.version!=null)
		{
			stream.writeDataFullNotNull(this.version);
		}
		else
		{
			nullObjError("version");
		}
		
		stream.writeLong(this.serverStartTime);
		
		stream.writeLong(this.serverOffTime);
		
		stream.writeLong(this.nextDailyTime);
		
		stream.writeInt(this.serverRunIndex);
		
		if(this.workSenderData!=null)
		{
			this.workSenderData.writeBytesFull(stream);
		}
		else
		{
			nullObjError("workSenderData");
		}
		
		stream.writeInt(this.serverBornCode);
		
		if(this.workReceiverData!=null)
		{
			this.workReceiverData.writeBytesFull(stream);
		}
		else
		{
			nullObjError("workReceiverData");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.version=(SaveVersionData)stream.readDataSimpleNotNull();
		
		this.serverStartTime=stream.readLong();
		
		this.serverOffTime=stream.readLong();
		
		this.nextDailyTime=stream.readLong();
		
		this.serverRunIndex=stream.readInt();
		
		this.workSenderData=new WorkSenderData();
		this.workSenderData.readBytesSimple(stream);
		
		this.serverBornCode=stream.readInt();
		
		this.workReceiverData=new WorkReceiverData();
		this.workReceiverData.readBytesSimple(stream);
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.version!=null)
		{
			stream.writeDataSimpleNotNull(this.version);
		}
		else
		{
			nullObjError("version");
		}
		
		stream.writeLong(this.serverStartTime);
		
		stream.writeLong(this.serverOffTime);
		
		stream.writeLong(this.nextDailyTime);
		
		stream.writeInt(this.serverRunIndex);
		
		if(this.workSenderData!=null)
		{
			this.workSenderData.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("workSenderData");
		}
		
		stream.writeInt(this.serverBornCode);
		
		if(this.workReceiverData!=null)
		{
			this.workReceiverData.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("workReceiverData");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof CenterSystemPartData))
			return;
		
		CenterSystemPartData mData=(CenterSystemPartData)data;
		
		this.version=mData.version;
		this.serverStartTime=mData.serverStartTime;
		this.serverOffTime=mData.serverOffTime;
		this.nextDailyTime=mData.nextDailyTime;
		this.serverRunIndex=mData.serverRunIndex;
		this.workSenderData=mData.workSenderData;
		this.serverBornCode=mData.serverBornCode;
		this.workReceiverData=mData.workReceiverData;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof CenterSystemPartData))
			return;
		
		CenterSystemPartData mData=(CenterSystemPartData)data;
		
		if(mData.version!=null)
		{
			this.version=(SaveVersionData)mData.version.clone();
		}
		else
		{
			this.version=null;
			nullObjError("version");
		}
		
		this.serverStartTime=mData.serverStartTime;
		
		this.serverOffTime=mData.serverOffTime;
		
		this.nextDailyTime=mData.nextDailyTime;
		
		this.serverRunIndex=mData.serverRunIndex;
		
		if(mData.workSenderData!=null)
		{
			this.workSenderData=new WorkSenderData();
			this.workSenderData.copy(mData.workSenderData);
		}
		else
		{
			this.workSenderData=null;
			nullObjError("workSenderData");
		}
		
		this.serverBornCode=mData.serverBornCode;
		
		if(mData.workReceiverData!=null)
		{
			this.workReceiverData=new WorkReceiverData();
			this.workReceiverData.copy(mData.workReceiverData);
		}
		else
		{
			this.workReceiverData=null;
			nullObjError("workReceiverData");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		CenterSystemPartData mData=(CenterSystemPartData)data;
		if(mData.version!=null)
		{
			if(this.version==null)
				return false;
			if(!this.version.dataEquals(mData.version))
				return false;
		}
		else
		{
			if(this.version!=null)
				return false;
		}
		
		if(this.serverStartTime!=mData.serverStartTime)
			return false;
		
		if(this.serverOffTime!=mData.serverOffTime)
			return false;
		
		if(this.nextDailyTime!=mData.nextDailyTime)
			return false;
		
		if(this.serverRunIndex!=mData.serverRunIndex)
			return false;
		
		if(mData.workSenderData!=null)
		{
			if(this.workSenderData==null)
				return false;
			if(!this.workSenderData.dataEquals(mData.workSenderData))
				return false;
		}
		else
		{
			if(this.workSenderData!=null)
				return false;
		}
		
		if(this.serverBornCode!=mData.serverBornCode)
			return false;
		
		if(mData.workReceiverData!=null)
		{
			if(this.workReceiverData==null)
				return false;
			if(!this.workReceiverData.dataEquals(mData.workReceiverData))
				return false;
		}
		else
		{
			if(this.workReceiverData!=null)
				return false;
		}
		
		return true;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterSystemPartData";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("version");
		writer.sb.append(':');
		if(this.version!=null)
		{
			this.version.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SaveVersionData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverStartTime");
		writer.sb.append(':');
		writer.sb.append(this.serverStartTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverOffTime");
		writer.sb.append(':');
		writer.sb.append(this.serverOffTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("nextDailyTime");
		writer.sb.append(':');
		writer.sb.append(this.nextDailyTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverRunIndex");
		writer.sb.append(':');
		writer.sb.append(this.serverRunIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("workSenderData");
		writer.sb.append(':');
		if(this.workSenderData!=null)
		{
			this.workSenderData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("WorkSenderData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverBornCode");
		writer.sb.append(':');
		writer.sb.append(this.serverBornCode);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("workReceiverData");
		writer.sb.append(':');
		if(this.workReceiverData!=null)
		{
			this.workReceiverData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("WorkReceiverData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.version=new SaveVersionData();
		this.version.initDefault();
		this.workSenderData=new WorkSenderData();
		this.workSenderData.initDefault();
		this.workReceiverData=new WorkReceiverData();
		this.workReceiverData.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.version=null;
		this.serverStartTime=0L;
		this.serverOffTime=0L;
		this.nextDailyTime=0L;
		this.serverRunIndex=0;
		this.workSenderData=null;
		this.serverBornCode=0;
		this.workReceiverData=null;
	}
	
}
