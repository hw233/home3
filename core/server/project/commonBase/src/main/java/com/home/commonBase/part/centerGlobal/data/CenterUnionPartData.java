package com.home.commonBase.part.centerGlobal.data;
import com.home.commonBase.constlist.generate.CenterGlobalPartDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;

/** 中心服宗门数据(generated by shine) */
public class CenterUnionPartData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=CenterGlobalPartDataType.CenterUnion;
	
	public CenterUnionPartData()
	{
		_dataID=CenterGlobalPartDataType.CenterUnion;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterUnionPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
}
