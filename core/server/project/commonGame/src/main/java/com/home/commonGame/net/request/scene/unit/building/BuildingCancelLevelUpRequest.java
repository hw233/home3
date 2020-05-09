package com.home.commonGame.net.request.scene.unit.building;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.scene.base.UnitSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 建筑取消升级(generated by shine) */
public class BuildingCancelLevelUpRequest extends UnitSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.BuildingCancelLevelUp;
	
	public BuildingCancelLevelUpRequest()
	{
		_dataID=GameRequestType.BuildingCancelLevelUp;
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
		return "BuildingCancelLevelUpRequest";
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
	public static BuildingCancelLevelUpRequest create(int instanceID)
	{
		BuildingCancelLevelUpRequest re=(BuildingCancelLevelUpRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		return re;
	}
	
}
