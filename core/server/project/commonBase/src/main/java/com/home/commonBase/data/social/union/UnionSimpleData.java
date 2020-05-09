package com.home.commonBase.data.social.union;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.roleGroup.RoleGroupSimpleData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;

/** 工会简版数据(generated by shine) */
public class UnionSimpleData extends RoleGroupSimpleData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.UnionSimple;
	
	public UnionSimpleData()
	{
		_dataID=BaseDataType.UnionSimple;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnionSimpleData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
}
