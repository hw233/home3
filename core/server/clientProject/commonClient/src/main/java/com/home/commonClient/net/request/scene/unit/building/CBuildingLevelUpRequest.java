package com.home.commonClient.net.request.scene.unit.building;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.scene.base.CUnitRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 客户端请求建筑升级 注意:包含父类参数 instanceID(generated by shine) */
public class CBuildingLevelUpRequest extends CUnitRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.CBuildingLevelUp;
	
	public CBuildingLevelUpRequest()
	{
		_dataID=GameRequestType.CBuildingLevelUp;
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
		return "CBuildingLevelUpRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
	/** 创建实例 */
	public static CBuildingLevelUpRequest create(int instanceID)
	{
		CBuildingLevelUpRequest re=(CBuildingLevelUpRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		return re;
	}
	
}
