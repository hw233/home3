package com.home.commonClient.net.request.scene.base;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 场景接收基类(generated by shine) */
public class SceneRRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.SceneR;
	
	public SceneRRequest()
	{
		_dataID=GameRequestType.SceneR;
		setNeedRelease();
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
		return "SceneRRequest";
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
	public static SceneRRequest create()
	{
		SceneRRequest re=(SceneRRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}
