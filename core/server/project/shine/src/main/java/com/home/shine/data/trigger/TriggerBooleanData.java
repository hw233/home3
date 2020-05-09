package com.home.shine.data.trigger;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.constlist.generate.ShineDataType;
import com.home.shine.data.BaseData;
import com.home.shine.data.trigger.TriggerObjData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class TriggerBooleanData extends TriggerObjData
{
	/** 数据类型ID */
	public static final int dataID=ShineDataType.TriggerBoolean;
	
	public boolean value;
	
	public TriggerBooleanData()
	{
		_dataID=ShineDataType.TriggerBoolean;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "TriggerBooleanData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.value=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeBoolean(this.value);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.value=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeBoolean(this.value);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof TriggerBooleanData))
			return;
		
		TriggerBooleanData mData=(TriggerBooleanData)data;
		
		this.value=mData.value;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof TriggerBooleanData))
			return;
		
		TriggerBooleanData mData=(TriggerBooleanData)data;
		
		this.value=mData.value;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		TriggerBooleanData mData=(TriggerBooleanData)data;
		if(this.value!=mData.value)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("value");
		writer.sb.append(':');
		writer.sb.append(this.value);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.value=false;
	}
	
}
