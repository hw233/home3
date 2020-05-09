package com.home.commonClient.net.request.system;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.CenterRequest;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.ctrl.Ctrl;

/** 客户端到中心服转发到game消息(generated by shine) */
public class CenterTransClientToGameRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.CenterTransClientToGame;
	
	/** 绑定消息 */
	private CenterRequest _request;
	
	public CenterTransClientToGameRequest()
	{
		_dataID=GameRequestType.CenterTransClientToGame;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	@Override
	protected void doWriteBytesSimple(BytesWriteStream stream)
	{
		if(_request==null)
		{
			Ctrl.throwError("绑定消息为空");
			return;
		}
		
		_request.writeToStream(stream);
	}
	
	public void setData(CenterRequest request)
	{
		_request=request;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterTransClientToGameRequest";
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
	public static CenterTransClientToGameRequest create()
	{
		CenterTransClientToGameRequest re=(CenterTransClientToGameRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}
