package com.home.commonSceneBase.net.sceneBaseRequest.unit;
import com.home.commonSceneBase.constlist.generate.SceneBaseRequestType;
import com.home.commonSceneBase.net.sceneBaseRequest.base.UnitSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 移除子弹(generated by shine) */
public class RemoveBulletRequest extends UnitSRequest
{
	/** 数据类型ID */
	public static final int dataID=SceneBaseRequestType.RemoveBullet;
	
	/** 子弹实例ID */
	public int bulletInstanceID;
	
	public RemoveBulletRequest()
	{
		_dataID=SceneBaseRequestType.RemoveBullet;
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
		return "RemoveBulletRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("bulletInstanceID");
		writer.sb.append(':');
		writer.sb.append(this.bulletInstanceID);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.bulletInstanceID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.bulletInstanceID);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.bulletInstanceID=0;
	}
	
	/** 创建实例 */
	public static RemoveBulletRequest create(int instanceID,int bulletInstanceID)
	{
		RemoveBulletRequest re=(RemoveBulletRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.bulletInstanceID=bulletInstanceID;
		return re;
	}
	
}
