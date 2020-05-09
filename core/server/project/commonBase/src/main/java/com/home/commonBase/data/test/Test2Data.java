package com.home.commonBase.data.test;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class Test2Data extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.Test2;
	
	public int a;
	
	public boolean b;
	
	public Test2Data()
	{
		_dataID=BaseDataType.Test2;
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.a=stream.readInt();
		
		this.b=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.a);
		
		stream.writeBoolean(this.b);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.a=stream.readInt();
		
		this.b=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.a);
		
		stream.writeBoolean(this.b);
		
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof Test2Data))
			return;
		
		Test2Data mData=(Test2Data)data;
		
		this.a=mData.a;
		
		this.b=mData.b;
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof Test2Data))
			return;
		
		Test2Data mData=(Test2Data)data;
		
		this.a=mData.a;
		this.b=mData.b;
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		Test2Data mData=(Test2Data)data;
		if(this.a!=mData.a)
			return false;
		
		if(this.b!=mData.b)
			return false;
		
		return true;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "Test2Data";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("a");
		writer.sb.append(':');
		writer.sb.append(this.a);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("b");
		writer.sb.append(':');
		writer.sb.append(this.b);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.a=0;
		this.b=false;
	}
	
}
