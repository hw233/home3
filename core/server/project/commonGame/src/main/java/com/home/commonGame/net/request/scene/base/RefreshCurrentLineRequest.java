package com.home.commonGame.net.request.scene.base;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新当期线ID消息(generated by shine) */
public class RefreshCurrentLineRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.RefreshCurrentLine;
	
	public int lineID;
	
	public RefreshCurrentLineRequest()
	{
		_dataID=GameRequestType.RefreshCurrentLine;
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
		return "RefreshCurrentLineRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("lineID");
		writer.sb.append(':');
		writer.sb.append(this.lineID);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.lineID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.lineID);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.lineID=0;
	}
	
	/** 创建实例 */
	public static RefreshCurrentLineRequest create(int lineID)
	{
		RefreshCurrentLineRequest re=(RefreshCurrentLineRequest)BytesControl.createRequest(dataID);
		re.lineID=lineID;
		return re;
	}
	
}
