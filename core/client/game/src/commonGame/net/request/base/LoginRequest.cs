using ShineEngine;

/// <summary>
/// 登陆部分协议基类(generated by shine)
/// </summary>
public class LoginRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.Login;
	
	public LoginRequest()
	{
		_dataID=GameRequestType.Login;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "LoginRequest";
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
	public static LoginRequest create()
	{
		LoginRequest re=(LoginRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}
