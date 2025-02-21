using ShineEngine;

/// <summary>
/// 场景接收基类(generated by shine)
/// </summary>
public class SceneRRequest:SceneBaseRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=SceneBaseRequestType.SceneR;
	
	public SceneRRequest()
	{
		_dataID=SceneBaseRequestType.SceneR;
		setNeedRelease();
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "SceneRRequest";
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static SceneRRequest create()
	{
		SceneRRequest re=(SceneRRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}
