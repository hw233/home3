package com.home.commonBase.data.social.team;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.roleGroup.CreateRoleGroupData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 创建队伍参数(generated by shine) */
public class CreateTeamData extends CreateRoleGroupData
{
	/** 目标id */
	public int targetID;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.CreateTeam;
	
	public CreateTeamData()
	{
		_dataID=BaseDataType.CreateTeam;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CreateTeamData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.targetID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.targetID);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.targetID=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.targetID);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof CreateTeamData))
			return;
		
		CreateTeamData mData=(CreateTeamData)data;
		
		this.targetID=mData.targetID;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof CreateTeamData))
			return;
		
		CreateTeamData mData=(CreateTeamData)data;
		
		this.targetID=mData.targetID;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		CreateTeamData mData=(CreateTeamData)data;
		if(this.targetID!=mData.targetID)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("targetID");
		writer.sb.append(':');
		writer.sb.append(this.targetID);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.targetID=0;
	}
	
}
