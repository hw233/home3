package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.system.WorkData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 区服全局数据(generated by shine) */
public class AreaGlobalWorkData extends WorkData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.AreaGlobalWork;
	
	public int receiveAreaID;
	
	public AreaGlobalWorkData()
	{
		_dataID=BaseDataType.AreaGlobalWork;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "AreaGlobalWorkData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.receiveAreaID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.receiveAreaID);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.receiveAreaID=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.receiveAreaID);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof AreaGlobalWorkData))
			return;
		
		AreaGlobalWorkData mData=(AreaGlobalWorkData)data;
		
		this.receiveAreaID=mData.receiveAreaID;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof AreaGlobalWorkData))
			return;
		
		AreaGlobalWorkData mData=(AreaGlobalWorkData)data;
		
		this.receiveAreaID=mData.receiveAreaID;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		AreaGlobalWorkData mData=(AreaGlobalWorkData)data;
		if(this.receiveAreaID!=mData.receiveAreaID)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("receiveAreaID");
		writer.sb.append(':');
		writer.sb.append(this.receiveAreaID);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	@Override
	public AreaGlobalWorkCompleteData createCompleteData()
	{
		AreaGlobalWorkCompleteData re=new AreaGlobalWorkCompleteData();
		re.workInstanceID=this.workInstanceID;
		re.senderIndex=this.senderIndex;
		re.receiveAreaID=this.receiveAreaID;
		return re;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.receiveAreaID=0;
	}
	
}
