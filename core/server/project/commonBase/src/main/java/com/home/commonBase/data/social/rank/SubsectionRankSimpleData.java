package com.home.commonBase.data.social.rank;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.func.FuncToolData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 简单排名数据(generated by shine) */
public class SubsectionRankSimpleData extends FuncToolData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.SubsectionRankSimple;
	
	/** 大组index */
	public int subsectionIndex;
	
	/** 小组index */
	public int subsectionSubIndex;
	
	/** 排名(从1开始) */
	public int rank;
	
	/** 排行值(如以后一个值不够用,再补,理论上应该是够的) */
	public long value;
	
	public SubsectionRankSimpleData()
	{
		_dataID=BaseDataType.SubsectionRankSimple;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SubsectionRankSimpleData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.subsectionIndex=stream.readInt();
		
		this.subsectionSubIndex=stream.readInt();
		
		this.rank=stream.readInt();
		
		this.value=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.subsectionIndex);
		
		stream.writeInt(this.subsectionSubIndex);
		
		stream.writeInt(this.rank);
		
		stream.writeLong(this.value);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.subsectionIndex=stream.readInt();
		
		this.subsectionSubIndex=stream.readInt();
		
		this.rank=stream.readInt();
		
		this.value=stream.readLong();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.subsectionIndex);
		
		stream.writeInt(this.subsectionSubIndex);
		
		stream.writeInt(this.rank);
		
		stream.writeLong(this.value);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof SubsectionRankSimpleData))
			return;
		
		SubsectionRankSimpleData mData=(SubsectionRankSimpleData)data;
		
		this.subsectionIndex=mData.subsectionIndex;
		this.subsectionSubIndex=mData.subsectionSubIndex;
		this.rank=mData.rank;
		this.value=mData.value;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof SubsectionRankSimpleData))
			return;
		
		SubsectionRankSimpleData mData=(SubsectionRankSimpleData)data;
		
		this.subsectionIndex=mData.subsectionIndex;
		
		this.subsectionSubIndex=mData.subsectionSubIndex;
		
		this.rank=mData.rank;
		
		this.value=mData.value;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		SubsectionRankSimpleData mData=(SubsectionRankSimpleData)data;
		if(this.subsectionIndex!=mData.subsectionIndex)
			return false;
		
		if(this.subsectionSubIndex!=mData.subsectionSubIndex)
			return false;
		
		if(this.rank!=mData.rank)
			return false;
		
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
		writer.sb.append("subsectionIndex");
		writer.sb.append(':');
		writer.sb.append(this.subsectionIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("subsectionSubIndex");
		writer.sb.append(':');
		writer.sb.append(this.subsectionSubIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("rank");
		writer.sb.append(':');
		writer.sb.append(this.rank);
		
		writer.writeEnter();
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
		
		this.subsectionIndex=0;
		this.subsectionSubIndex=0;
		this.rank=0;
		this.value=0L;
	}
	
}
