package com.home.commonClient.net.httpRequest;
import com.home.commonBase.constlist.generate.RobotFlowStepType;
import com.home.commonClient.constlist.generate.LoginHttpRequestType;
import com.home.commonClient.net.base.LoginHttpRequest;
import com.home.commonClient.net.httpResponseResult.ClientLoginSelectResult;
import com.home.commonClient.part.player.Player;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 登录选择消息(generated by shine) */
public class ClientLoginSelectHttpRequest extends LoginHttpRequest
{
	/** 数据类型ID */
	public static final int dataID=LoginHttpRequestType.ClientLoginSelect;
	
	/** 登录令牌 */
	public int loginToken;
	
	/** 选择区服ID */
	public int areaID=-1;
	
	/** 返回值 */
	protected ClientLoginSelectResult _re;
	
	public Player me;
	
	public ClientLoginSelectHttpRequest()
	{
		_dataID=LoginHttpRequestType.ClientLoginSelect;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.loginToken);
		
		stream.writeInt(this.areaID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.loginToken);
		
		stream.writeInt(this.areaID);
		
	}
	
	/** 执行 */
	@Override
	protected void toRead()
	{
		_re=new ClientLoginSelectResult();
		readResult(_re,_resultStream);
	}
	
	/** 获取结果 */
	public ClientLoginSelectResult getResult()
	{
		return _re;
	}
	
	/** 执行 */
	@Override
	protected void onComplete()
	{
		me.recordStep(RobotFlowStepType.ReClientLogin);
		
		if(_result==-1 || _re==null)
		{
			me.system.onLoginHttpFailed();
			
			return;
		}
		
		me.system.loginGame(_re.info);
	}
	
	/** 同步执行 */
	public ClientLoginSelectResult sendMSync()
	{
		doSendSync();
		return _re;
	}
	
	/** 创建实例 */
	public static ClientLoginSelectHttpRequest create(int loginToken,int areaID)
	{
		ClientLoginSelectHttpRequest re=new ClientLoginSelectHttpRequest();
		re.loginToken=loginToken;
		re.areaID=areaID;
		return re;
	}
	
}
