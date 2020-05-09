package com.home.commonBase.data.social.roleGroup;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.constlist.generate.RoleGroupChangeType;
import com.home.commonBase.data.system.KeyData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 玩家群简版数据(generated by shine) */
public class RoleGroupSimpleData extends KeyData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.RoleGroupSimple;
	
	/** 群id */
	public long groupID;
	
	/** 等级 */
	public int level;
	
	/** 群名 */
	public String name="";
	
	/** 成员数 */
	public int memberNum;
	
	/** 公告 */
	public String notice="";
	
	public RoleGroupSimpleData()
	{
		_dataID=BaseDataType.RoleGroupSimple;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RoleGroupSimpleData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.groupID=stream.readLong();
		
		this.level=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.notice=stream.readUTF();
		
		this.memberNum=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.groupID);
		
		stream.writeInt(this.level);
		
		stream.writeUTF(this.name);
		
		stream.writeUTF(this.notice);
		
		stream.writeInt(this.memberNum);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.groupID=stream.readLong();
		
		this.level=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.notice=stream.readUTF();
		
		this.memberNum=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.groupID);
		
		stream.writeInt(this.level);
		
		stream.writeUTF(this.name);
		
		stream.writeUTF(this.notice);
		
		stream.writeInt(this.memberNum);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof RoleGroupSimpleData))
			return;
		
		RoleGroupSimpleData mData=(RoleGroupSimpleData)data;
		
		this.groupID=mData.groupID;
		this.level=mData.level;
		this.name=mData.name;
		this.notice=mData.notice;
		this.memberNum=mData.memberNum;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof RoleGroupSimpleData))
			return;
		
		RoleGroupSimpleData mData=(RoleGroupSimpleData)data;
		
		this.groupID=mData.groupID;
		
		this.level=mData.level;
		
		this.name=mData.name;
		
		this.notice=mData.notice;
		
		this.memberNum=mData.memberNum;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		RoleGroupSimpleData mData=(RoleGroupSimpleData)data;
		if(this.groupID!=mData.groupID)
			return false;
		
		if(this.level!=mData.level)
			return false;
		
		if(!this.name.equals(mData.name))
			return false;
		
		if(!this.notice.equals(mData.notice))
			return false;
		
		if(this.memberNum!=mData.memberNum)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("groupID");
		writer.sb.append(':');
		writer.sb.append(this.groupID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("level");
		writer.sb.append(':');
		writer.sb.append(this.level);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("name");
		writer.sb.append(':');
		writer.sb.append(this.name);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("notice");
		writer.sb.append(':');
		writer.sb.append(this.notice);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("memberNum");
		writer.sb.append(':');
		writer.sb.append(this.memberNum);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	/** 执行改变 */
	public void onRoleGroupChange(RoleGroupChangeData data)
	{
		switch(data.type)
		{
			case RoleGroupChangeType.Name:
			{
				this.name=data.arg1;
			}
				break;
			case RoleGroupChangeType.Notice:
			{
				this.notice=data.arg1;
			}
				break;
			case RoleGroupChangeType.Level:
			{
				this.level=data.arg0;
			}
				break;
			case RoleGroupChangeType.MemberNum:
			{
				this.memberNum=data.arg0;
			}
				break;
		}
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groupID=0L;
		this.level=0;
		this.name="";
		this.notice="";
		this.memberNum=0;
	}
	
}
