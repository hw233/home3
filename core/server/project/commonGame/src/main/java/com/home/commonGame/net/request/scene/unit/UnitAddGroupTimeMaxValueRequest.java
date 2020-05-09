package com.home.commonGame.net.request.scene.unit;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.scene.base.SceneSRequest;
import com.home.commonGame.net.request.scene.base.UnitSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位添加组CD固定值(generated by shine) */
public class UnitAddGroupTimeMaxValueRequest extends UnitSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.UnitAddGroupTimeMaxValue;
	
	/** 组ID */
	public int groupID;
	
	/** 值 */
	public int value;
	
	public UnitAddGroupTimeMaxValueRequest()
	{
		_dataID=GameRequestType.UnitAddGroupTimeMaxValue;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitAddGroupTimeMaxValueRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("groupID");
		writer.sb.append(':');
		writer.sb.append(this.groupID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("value");
		writer.sb.append(':');
		writer.sb.append(this.value);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.groupID);
		
		stream.writeInt(this.value);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.groupID);
		
		stream.writeInt(this.value);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groupID=0;
		this.value=0;
	}
	
	/** 创建实例 */
	public static UnitAddGroupTimeMaxValueRequest create(int instanceID,int groupID,int value)
	{
		UnitAddGroupTimeMaxValueRequest re=(UnitAddGroupTimeMaxValueRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.groupID=groupID;
		re.value=value;
		return re;
	}
	
}
