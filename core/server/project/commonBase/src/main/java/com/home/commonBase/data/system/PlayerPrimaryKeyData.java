package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.table.table.PlayerTable;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;
import com.home.shine.support.pool.StringBuilderPool;

/** 角色主键数据(generated by shine) */
public class PlayerPrimaryKeyData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.PlayerPrimaryKey;
	
	/** 角色ID */
	public long playerID;
	
	/** 名字 */
	public String name="";
	
	/** 用户ID */
	public long userID;
	
	/** 用户uid */
	public String uid="";
	
	/** 平台 */
	public String platform="";
	
	/** 源游戏服ID(登录时所在) */
	public int sourceGameID;
	
	/** 创建区ID(分区服用) */
	public int createAreaID;
	
	public PlayerPrimaryKeyData()
	{
		_dataID=BaseDataType.PlayerPrimaryKey;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerPrimaryKeyData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		this.name=stream.readUTF();
		
		this.userID=stream.readLong();
		
		this.uid=stream.readUTF();
		
		this.platform=stream.readUTF();
		
		this.createAreaID=stream.readInt();
		
		this.sourceGameID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		stream.writeUTF(this.name);
		
		stream.writeLong(this.userID);
		
		stream.writeUTF(this.uid);
		
		stream.writeUTF(this.platform);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeInt(this.sourceGameID);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.playerID=stream.readLong();
		
		this.name=stream.readUTF();
		
		this.userID=stream.readLong();
		
		this.uid=stream.readUTF();
		
		this.platform=stream.readUTF();
		
		this.createAreaID=stream.readInt();
		
		this.sourceGameID=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.playerID);
		
		stream.writeUTF(this.name);
		
		stream.writeLong(this.userID);
		
		stream.writeUTF(this.uid);
		
		stream.writeUTF(this.platform);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeInt(this.sourceGameID);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof PlayerPrimaryKeyData))
			return;
		
		PlayerPrimaryKeyData mData=(PlayerPrimaryKeyData)data;
		
		this.playerID=mData.playerID;
		this.name=mData.name;
		this.userID=mData.userID;
		this.uid=mData.uid;
		this.platform=mData.platform;
		this.createAreaID=mData.createAreaID;
		this.sourceGameID=mData.sourceGameID;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof PlayerPrimaryKeyData))
			return;
		
		PlayerPrimaryKeyData mData=(PlayerPrimaryKeyData)data;
		
		this.playerID=mData.playerID;
		
		this.name=mData.name;
		
		this.userID=mData.userID;
		
		this.uid=mData.uid;
		
		this.platform=mData.platform;
		
		this.createAreaID=mData.createAreaID;
		
		this.sourceGameID=mData.sourceGameID;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		PlayerPrimaryKeyData mData=(PlayerPrimaryKeyData)data;
		if(this.playerID!=mData.playerID)
			return false;
		
		if(!this.name.equals(mData.name))
			return false;
		
		if(this.userID!=mData.userID)
			return false;
		
		if(!this.uid.equals(mData.uid))
			return false;
		
		if(!this.platform.equals(mData.platform))
			return false;
		
		if(this.createAreaID!=mData.createAreaID)
			return false;
		
		if(this.sourceGameID!=mData.sourceGameID)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("name");
		writer.sb.append(':');
		writer.sb.append(this.name);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("userID");
		writer.sb.append(':');
		writer.sb.append(this.userID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("uid");
		writer.sb.append(':');
		writer.sb.append(this.uid);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("platform");
		writer.sb.append(':');
		writer.sb.append(this.platform);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("createAreaID");
		writer.sb.append(':');
		writer.sb.append(this.createAreaID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("sourceGameID");
		writer.sb.append(':');
		writer.sb.append(this.sourceGameID);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 获取描述信息 */
	public String getInfo()
	{
		StringBuilder sb=StringBuilderPool.create();
		writeInfo(sb);
		return StringBuilderPool.releaseStr(sb);
	}
	
	/** 写描述信息 */
	private void writeInfo(StringBuilder sb)
	{
		sb.append("uid:");
		sb.append(uid);
		sb.append(" playerID:");
		sb.append(playerID);
		sb.append(" 名字:");
		sb.append(name);
		sb.append(" 源服:");
		sb.append(sourceGameID);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.playerID=0L;
		this.name="";
		this.userID=0L;
		this.uid="";
		this.platform="";
		this.createAreaID=0;
		this.sourceGameID=0;
	}
	
}
