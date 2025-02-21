package com.home.commonClient.net.sceneBaseRequest.unit;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.constlist.generate.SceneBaseRequestType;
import com.home.commonClient.net.sceneBaseRequest.base.CUnitRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 控制单位使用Attack(客户端驱动attack时用)(generated by shine) */
public class CUnitSkillOverRequest extends CUnitRRequest
{
	/** 数据类型ID */
	public static final int dataID=SceneBaseRequestType.CUnitSkillOver;
	
	public CUnitSkillOverRequest()
	{
		_dataID=SceneBaseRequestType.CUnitSkillOver;
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
		return "CUnitSkillOverRequest";
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
	public static CUnitSkillOverRequest create(int instanceID)
	{
		CUnitSkillOverRequest re=(CUnitSkillOverRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		return re;
	}
	
}
