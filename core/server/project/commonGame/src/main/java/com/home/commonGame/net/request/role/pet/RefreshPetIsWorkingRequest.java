package com.home.commonGame.net.request.role.pet;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更新宠物是否出战消息(generated by shine) */
public class RefreshPetIsWorkingRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.RefreshPetIsWorking;
	
	public int index;
	
	public boolean isWorking;
	
	public RefreshPetIsWorkingRequest()
	{
		_dataID=GameRequestType.RefreshPetIsWorking;
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
		return "RefreshPetIsWorkingRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.index);
		
		stream.writeBoolean(this.isWorking);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.index);
		
		stream.writeBoolean(this.isWorking);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isWorking");
		writer.sb.append(':');
		writer.sb.append(this.isWorking);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
		this.isWorking=false;
	}
	
	/** 创建实例 */
	public static RefreshPetIsWorkingRequest create(int index,boolean isWorking)
	{
		RefreshPetIsWorkingRequest re=(RefreshPetIsWorkingRequest)BytesControl.createRequest(dataID);
		re.index=index;
		re.isWorking=isWorking;
		return re;
	}
	
}
