package com.home.commonGMClient.net.httpResponseResult.system;
import com.home.commonGMClient.constlist.generate.ManagerHttpResponseResultType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;

/** (generated by shine) */
public class GMClientLoginResult extends BaseData
{
	/** 令牌 */
	public int token;
	
	/** 数据类型ID */
	public static final int dataID=ManagerHttpResponseResultType.GMClientLogin;
	
	public GMClientLoginResult()
	{
		_dataID=ManagerHttpResponseResultType.GMClientLogin;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.token=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.token);
		
	}
	
}
