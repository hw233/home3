package com.home.commonManager.net.httpResponse.role;
import com.home.commonBase.data.system.PlayerPrimaryKeyData;
import com.home.commonBase.data.system.PlayerWorkListData;
import com.home.commonManager.constlist.generate.ManagerHttpResponseType;
import com.home.commonManager.global.ManagerC;
import com.home.commonManager.net.httpResponse.base.ManagerRHttpResponse;
import com.home.commonManager.net.httpResponseResult.role.MQueryPlayerResult;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;

/** 查询角色消息(generated by shine) */
public class MQueryPlayerHttpResponse extends ManagerRHttpResponse
{
	/** 数据类型ID */
	public static final int dataID=ManagerHttpResponseType.MQueryPlayer;
	
	/** 返回值 */
	protected MQueryPlayerResult _re=new MQueryPlayerResult();
	
	/** gameID */
	public int gameID;
	
	/** 角色ID */
	public long playerID;
	
	public MQueryPlayerHttpResponse()
	{
		_dataID=ManagerHttpResponseType.MQueryPlayer;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		ManagerC.db.selectPlayer(gameID,playerID,(a,b,c)->
		{
			reBack(a.createPrimaryKeyData(),b,c);
		});
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.gameID=stream.readInt();
		
		this.playerID=stream.readLong();
		
	}
	
	/** 收到返回方法 */
	public void reBack(PlayerPrimaryKeyData key,BaseData data,PlayerWorkListData workList)
	{
		_re.key=key;
		_re.data=data;
		_re.workList=workList;
		resultData(_re);
	}
	
}
