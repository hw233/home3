package com.home.commonGame.net.request.func.roleGroup;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncPlayerRoleGroupSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更新成员职位(generated by shine) */
public class FuncRefeshTitleRoleGroupRequest extends FuncPlayerRoleGroupSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncRefeshTitleRoleGroup;
	
	/** 成员id */
	public long memberID;
	
	/** 职位 */
	public int title;
	
	public FuncRefeshTitleRoleGroupRequest()
	{
		_dataID=GameRequestType.FuncRefeshTitleRoleGroup;
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
		return "FuncRefeshTitleRoleGroupRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.memberID);
		
		stream.writeInt(this.title);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.memberID);
		
		stream.writeInt(this.title);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("memberID");
		writer.sb.append(':');
		writer.sb.append(this.memberID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("title");
		writer.sb.append(':');
		writer.sb.append(this.title);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.memberID=0L;
		this.title=0;
	}
	
	/** 创建实例 */
	public static FuncRefeshTitleRoleGroupRequest create(int funcID,long groupID,long memberID,int title)
	{
		FuncRefeshTitleRoleGroupRequest re=(FuncRefeshTitleRoleGroupRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.memberID=memberID;
		re.title=title;
		return re;
	}
	
}
