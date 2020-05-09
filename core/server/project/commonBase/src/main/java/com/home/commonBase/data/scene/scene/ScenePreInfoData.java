package com.home.commonBase.data.scene.scene;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.role.RoleShowData;
import com.home.commonBase.data.scene.unit.UnitInfoData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 场景预备信息数据(generated by shine) */
public class ScenePreInfoData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.ScenePreInfo;
	
	/** 指定玩家组 */
	public RoleShowData[] signedPlayers;
	
	public ScenePreInfoData()
	{
		_dataID=BaseDataType.ScenePreInfo;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ScenePreInfoData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		if(stream.readBoolean())
		{
			int signedPlayersLen=stream.readLen();
			if(this.signedPlayers==null || this.signedPlayers.length!=signedPlayersLen)
			{
				this.signedPlayers=new RoleShowData[signedPlayersLen];
			}
			RoleShowData[] signedPlayersT=this.signedPlayers;
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV;
				if(stream.readBoolean())
				{
					BaseData signedPlayersVT=stream.readDataFullNotNull();
					if(signedPlayersVT!=null)
					{
						if(signedPlayersVT instanceof RoleShowData)
						{
							signedPlayersV=(RoleShowData)signedPlayersVT;
						}
						else
						{
							signedPlayersV=new RoleShowData();
							if(!(signedPlayersVT.getClass().isAssignableFrom(RoleShowData.class)))
							{
								stream.throwTypeReadError(RoleShowData.class,signedPlayersVT.getClass());
							}
							signedPlayersV.shadowCopy(signedPlayersVT);
						}
					}
					else
					{
						signedPlayersV=null;
					}
				}
				else
				{
					signedPlayersV=null;
				}
				
				signedPlayersT[signedPlayersI]=signedPlayersV;
			}
		}
		else
		{
			this.signedPlayers=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.signedPlayers!=null)
		{
			stream.writeBoolean(true);
			RoleShowData[] signedPlayersT=this.signedPlayers;
			stream.writeLen(signedPlayersT.length);
			for(int signedPlayersVI=0,signedPlayersVLen=signedPlayersT.length;signedPlayersVI<signedPlayersVLen;++signedPlayersVI)
			{
				RoleShowData signedPlayersV=signedPlayersT[signedPlayersVI];
				if(signedPlayersV!=null)
				{
					stream.writeBoolean(true);
					stream.writeDataFullNotNull(signedPlayersV);
				}
				else
				{
					stream.writeBoolean(false);
				}
				
			}
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
		if(stream.readBoolean())
		{
			int signedPlayersLen=stream.readLen();
			if(this.signedPlayers==null || this.signedPlayers.length!=signedPlayersLen)
			{
				this.signedPlayers=new RoleShowData[signedPlayersLen];
			}
			RoleShowData[] signedPlayersT=this.signedPlayers;
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV;
				if(stream.readBoolean())
				{
					signedPlayersV=(RoleShowData)stream.readDataSimpleNotNull();
				}
				else
				{
					signedPlayersV=null;
				}
				
				signedPlayersT[signedPlayersI]=signedPlayersV;
			}
		}
		else
		{
			this.signedPlayers=null;
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.signedPlayers!=null)
		{
			stream.writeBoolean(true);
			RoleShowData[] signedPlayersT=this.signedPlayers;
			stream.writeLen(signedPlayersT.length);
			for(int signedPlayersVI=0,signedPlayersVLen=signedPlayersT.length;signedPlayersVI<signedPlayersVLen;++signedPlayersVI)
			{
				RoleShowData signedPlayersV=signedPlayersT[signedPlayersVI];
				if(signedPlayersV!=null)
				{
					stream.writeBoolean(true);
					stream.writeDataSimpleNotNull(signedPlayersV);
				}
				else
				{
					stream.writeBoolean(false);
				}
				
			}
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
		if(!(data instanceof ScenePreInfoData))
			return;
		
		ScenePreInfoData mData=(ScenePreInfoData)data;
		
		this.signedPlayers=mData.signedPlayers;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof ScenePreInfoData))
			return;
		
		ScenePreInfoData mData=(ScenePreInfoData)data;
		
		if(mData.signedPlayers!=null)
		{
			RoleShowData[] signedPlayersR=mData.signedPlayers;
			int signedPlayersLen=signedPlayersR.length;
			if(this.signedPlayers==null || this.signedPlayers.length!=signedPlayersLen)
			{
				this.signedPlayers=new RoleShowData[signedPlayersLen];
			}
			RoleShowData[] signedPlayersT=this.signedPlayers;
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV=signedPlayersR[signedPlayersI];
				RoleShowData signedPlayersU;
				if(signedPlayersV!=null)
				{
					signedPlayersU=(RoleShowData)signedPlayersV.clone();
				}
				else
				{
					signedPlayersU=null;
				}
				
				signedPlayersT[signedPlayersI]=signedPlayersU;
			}
		}
		else
		{
			this.signedPlayers=null;
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		ScenePreInfoData mData=(ScenePreInfoData)data;
		if(mData.signedPlayers!=null)
		{
			if(this.signedPlayers==null)
				return false;
			if(this.signedPlayers.length!=mData.signedPlayers.length)
				return false;
			RoleShowData[] signedPlayersT=this.signedPlayers;
			RoleShowData[] signedPlayersR=mData.signedPlayers;
			int signedPlayersLen=signedPlayersT.length;
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersU=signedPlayersT[signedPlayersI];
				RoleShowData signedPlayersV=signedPlayersR[signedPlayersI];
				if(signedPlayersV!=null)
				{
					if(signedPlayersU==null)
						return false;
					if(!signedPlayersU.dataEquals(signedPlayersV))
						return false;
				}
				else
				{
					if(signedPlayersU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.signedPlayers!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("signedPlayers");
		writer.sb.append(':');
		writer.sb.append("Array<RoleShowData>");
		if(this.signedPlayers!=null)
		{
			RoleShowData[] signedPlayersT=this.signedPlayers;
			int signedPlayersLen=signedPlayersT.length;
			writer.sb.append('(');
			writer.sb.append(signedPlayersLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV=signedPlayersT[signedPlayersI];
				writer.writeTabs();
				writer.sb.append(signedPlayersI);
				writer.sb.append(':');
				if(signedPlayersV!=null)
				{
					signedPlayersV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("RoleShowData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.signedPlayers=null;
	}
	
}
