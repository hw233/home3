package com.home.commonGame.net.request.social.friend;
import com.home.commonBase.data.social.friend.ApplyAddFriendData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送申请添加好友消息(generated by shine) */
public class SendApplyAddFriendRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.SendApplyAddFriend;
	
	/** 申请数据 */
	public ApplyAddFriendData applyData;
	
	public SendApplyAddFriendRequest()
	{
		_dataID=GameRequestType.SendApplyAddFriend;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		ApplyAddFriendData applyDataTemp=applyData;
		if(applyDataTemp!=null)
		{
			this.applyData=(ApplyAddFriendData)applyDataTemp.clone();
		}
		else
		{
			this.applyData=null;
			nullObjError("applyData");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendApplyAddFriendRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("applyData");
		writer.sb.append(':');
		if(this.applyData!=null)
		{
			this.applyData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("ApplyAddFriendData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.applyData!=null)
		{
			stream.writeDataFullNotNull(this.applyData);
		}
		else
		{
			nullObjError("applyData");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.applyData!=null)
		{
			stream.writeDataSimpleNotNull(this.applyData);
		}
		else
		{
			nullObjError("applyData");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.applyData.release(pool);
		this.applyData=null;
	}
	
	/** 创建实例 */
	public static SendApplyAddFriendRequest create(ApplyAddFriendData applyData)
	{
		SendApplyAddFriendRequest re=(SendApplyAddFriendRequest)BytesControl.createRequest(dataID);
		re.applyData=applyData;
		return re;
	}
	
}
