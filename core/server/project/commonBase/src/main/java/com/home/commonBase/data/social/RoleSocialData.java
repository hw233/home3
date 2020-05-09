package com.home.commonBase.data.social;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.constlist.generate.RoleShowDataPartType;
import com.home.commonBase.data.role.RoleShowChangeData;
import com.home.commonBase.data.role.RoleShowData;
import com.home.commonBase.data.scene.scene.SceneLocationData;
import com.home.commonBase.data.scene.scene.SceneLocationRoleShowChangeData;
import com.home.commonBase.global.BaseC;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.DateControl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色社交数据(generated by shine) */
public class RoleSocialData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.RoleSocial;
	
	/** 显示数据 */
	public RoleShowData showData;
	
	/** 上次在线时间(如已在线则为-1) */
	public long lastOnlineTime;
	
	/** 所在场景位置数据 */
	public SceneLocationData location;
	
	/** 是否在线 */
	public boolean isOnline;
	
	/** 自身使用的dirty标记 */
	public boolean dirty=false;
	
	/** 剩余保留时间 */
	public int lastKeepTime;
	
	public RoleSocialData()
	{
		_dataID=BaseDataType.RoleSocial;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RoleSocialData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData showDataT=stream.readDataFullNotNull();
		if(showDataT!=null)
		{
			if(showDataT instanceof RoleShowData)
			{
				this.showData=(RoleShowData)showDataT;
			}
			else
			{
				this.showData=new RoleShowData();
				if(!(showDataT.getClass().isAssignableFrom(RoleShowData.class)))
				{
					stream.throwTypeReadError(RoleShowData.class,showDataT.getClass());
				}
				this.showData.shadowCopy(showDataT);
			}
		}
		else
		{
			this.showData=null;
		}
		
		this.isOnline=stream.readBoolean();
		
		this.lastOnlineTime=stream.readLong();
		
		if(stream.readBoolean())
		{
			BaseData locationT=stream.readDataFullNotNull();
			if(locationT!=null)
			{
				if(locationT instanceof SceneLocationData)
				{
					this.location=(SceneLocationData)locationT;
				}
				else
				{
					this.location=new SceneLocationData();
					if(!(locationT.getClass().isAssignableFrom(SceneLocationData.class)))
					{
						stream.throwTypeReadError(SceneLocationData.class,locationT.getClass());
					}
					this.location.shadowCopy(locationT);
				}
			}
			else
			{
				this.location=null;
			}
		}
		else
		{
			this.location=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.showData!=null)
		{
			stream.writeDataFullNotNull(this.showData);
		}
		else
		{
			nullObjError("showData");
		}
		
		stream.writeBoolean(this.isOnline);
		
		stream.writeLong(this.lastOnlineTime);
		
		if(this.location!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.location);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.showData=(RoleShowData)stream.readDataSimpleNotNull();
		
		this.isOnline=stream.readBoolean();
		
		this.lastOnlineTime=stream.readLong();
		
		if(stream.readBoolean())
		{
			this.location=(SceneLocationData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.location=null;
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.showData!=null)
		{
			stream.writeDataSimpleNotNull(this.showData);
		}
		else
		{
			nullObjError("showData");
		}
		
		stream.writeBoolean(this.isOnline);
		
		stream.writeLong(this.lastOnlineTime);
		
		if(this.location!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.location);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof RoleSocialData))
			return;
		
		RoleSocialData mData=(RoleSocialData)data;
		
		this.showData=mData.showData;
		this.isOnline=mData.isOnline;
		this.lastOnlineTime=mData.lastOnlineTime;
		this.location=mData.location;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof RoleSocialData))
			return;
		
		RoleSocialData mData=(RoleSocialData)data;
		
		if(mData.showData!=null)
		{
			this.showData=(RoleShowData)mData.showData.clone();
		}
		else
		{
			this.showData=null;
			nullObjError("showData");
		}
		
		this.isOnline=mData.isOnline;
		
		this.lastOnlineTime=mData.lastOnlineTime;
		
		if(mData.location!=null)
		{
			this.location=(SceneLocationData)mData.location.clone();
		}
		else
		{
			this.location=null;
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		RoleSocialData mData=(RoleSocialData)data;
		if(mData.showData!=null)
		{
			if(this.showData==null)
				return false;
			if(!this.showData.dataEquals(mData.showData))
				return false;
		}
		else
		{
			if(this.showData!=null)
				return false;
		}
		
		if(this.isOnline!=mData.isOnline)
			return false;
		
		if(this.lastOnlineTime!=mData.lastOnlineTime)
			return false;
		
		if(mData.location!=null)
		{
			if(this.location==null)
				return false;
			if(!this.location.dataEquals(mData.location))
				return false;
		}
		else
		{
			if(this.location!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("showData");
		writer.sb.append(':');
		if(this.showData!=null)
		{
			this.showData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleShowData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isOnline");
		writer.sb.append(':');
		writer.sb.append(this.isOnline);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("lastOnlineTime");
		writer.sb.append(':');
		writer.sb.append(this.lastOnlineTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("location");
		writer.sb.append(':');
		if(this.location!=null)
		{
			this.location.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SceneLocationData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.showData=new RoleShowData();
		this.showData.initDefault();
	}
	
	/** 改变 */
	public void onChange(RoleShowChangeData data)
	{
		switch(data.type)
		{
			case RoleShowDataPartType.IsOnline:
			{
				this.isOnline=(data.arg0==1);
				//同时赋值两个
				this.lastOnlineTime=data.arg2;
			}
				break;
			case RoleShowDataPartType.LastOnlineTime:
			{
				this.lastOnlineTime=data.arg2;
			}
				break;
			case RoleShowDataPartType.Location:
			{
				this.location=((SceneLocationRoleShowChangeData)data).localtion;
			}
				break;
			default:
			{
				//传递
				showData.onChange(data);
			}
				break;
		}
	}
	
	/** 通过外线数据，粗略设置社交数据 */
	protected void setByShowDataOnline(RoleShowData showData)
	{
		this.showData=showData;
		isOnline=true;
		lastOnlineTime=-1;
	}
	
	/** 通过外显数据，创建粗略社交数据 */
	public static RoleSocialData createSocialDataByShowDataOnline(RoleShowData showData)
	{
		RoleSocialData re=BaseC.factory.createRoleSocialData();
		re.setByShowDataOnline(showData);
		return re;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.showData=null;
		this.isOnline=false;
		this.lastOnlineTime=0L;
		this.location=null;
	}
	
}
