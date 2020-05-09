package com.home.commonBase.part.gameGlobal.data;
import com.home.commonBase.constlist.generate.GameGlobalPartDataType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.pool.DataPool;

/** 社交数据(generated by shine) */
public class GameSocialPartData extends BaseData
{
	/** 角色社交数据字典 */
	public LongObjectMap<RoleSocialData> roleSocialDataDic;
	
	/** 数据类型ID */
	public static final int dataID=GameGlobalPartDataType.GameSocial;
	
	public GameSocialPartData()
	{
		_dataID=GameGlobalPartDataType.GameSocial;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "GameSocialPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int roleSocialDataDicLen=stream.readLen();
		if(this.roleSocialDataDic!=null)
		{
			this.roleSocialDataDic.clear();
			this.roleSocialDataDic.ensureCapacity(roleSocialDataDicLen);
		}
		else
		{
			this.roleSocialDataDic=new LongObjectMap<RoleSocialData>(RoleSocialData[]::new,roleSocialDataDicLen);
		}
		
		LongObjectMap<RoleSocialData> roleSocialDataDicT=this.roleSocialDataDic;
		for(int roleSocialDataDicI=roleSocialDataDicLen-1;roleSocialDataDicI>=0;--roleSocialDataDicI)
		{
			RoleSocialData roleSocialDataDicV;
			BaseData roleSocialDataDicVT=stream.readDataFullNotNull();
			if(roleSocialDataDicVT!=null)
			{
				if(roleSocialDataDicVT instanceof RoleSocialData)
				{
					roleSocialDataDicV=(RoleSocialData)roleSocialDataDicVT;
				}
				else
				{
					roleSocialDataDicV=new RoleSocialData();
					if(!(roleSocialDataDicVT.getClass().isAssignableFrom(RoleSocialData.class)))
					{
						stream.throwTypeReadError(RoleSocialData.class,roleSocialDataDicVT.getClass());
					}
					roleSocialDataDicV.shadowCopy(roleSocialDataDicVT);
				}
			}
			else
			{
				roleSocialDataDicV=null;
			}
			
			roleSocialDataDicT.put(roleSocialDataDicV.showData.playerID,roleSocialDataDicV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.roleSocialDataDic!=null)
		{
			stream.writeLen(this.roleSocialDataDic.size());
			if(!this.roleSocialDataDic.isEmpty())
			{
				Object[] roleSocialDataDicVValues=this.roleSocialDataDic.getValues();
				for(int roleSocialDataDicVI=roleSocialDataDicVValues.length-1;roleSocialDataDicVI>=0;--roleSocialDataDicVI)
				{
					if(roleSocialDataDicVValues[roleSocialDataDicVI]!=null)
					{
						RoleSocialData roleSocialDataDicV=(RoleSocialData)roleSocialDataDicVValues[roleSocialDataDicVI];
						if(roleSocialDataDicV!=null)
						{
							stream.writeDataFullNotNull(roleSocialDataDicV);
						}
						else
						{
							nullObjError("roleSocialDataDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("roleSocialDataDic");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int roleSocialDataDicLen=stream.readLen();
		if(this.roleSocialDataDic!=null)
		{
			this.roleSocialDataDic.clear();
			this.roleSocialDataDic.ensureCapacity(roleSocialDataDicLen);
		}
		else
		{
			this.roleSocialDataDic=new LongObjectMap<RoleSocialData>(RoleSocialData[]::new,roleSocialDataDicLen);
		}
		
		LongObjectMap<RoleSocialData> roleSocialDataDicT=this.roleSocialDataDic;
		for(int roleSocialDataDicI=roleSocialDataDicLen-1;roleSocialDataDicI>=0;--roleSocialDataDicI)
		{
			RoleSocialData roleSocialDataDicV;
			roleSocialDataDicV=(RoleSocialData)stream.readDataSimpleNotNull();
			
			roleSocialDataDicT.put(roleSocialDataDicV.showData.playerID,roleSocialDataDicV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.roleSocialDataDic!=null)
		{
			stream.writeLen(this.roleSocialDataDic.size());
			if(!this.roleSocialDataDic.isEmpty())
			{
				Object[] roleSocialDataDicVValues=this.roleSocialDataDic.getValues();
				for(int roleSocialDataDicVI=roleSocialDataDicVValues.length-1;roleSocialDataDicVI>=0;--roleSocialDataDicVI)
				{
					if(roleSocialDataDicVValues[roleSocialDataDicVI]!=null)
					{
						RoleSocialData roleSocialDataDicV=(RoleSocialData)roleSocialDataDicVValues[roleSocialDataDicVI];
						if(roleSocialDataDicV!=null)
						{
							stream.writeDataSimpleNotNull(roleSocialDataDicV);
						}
						else
						{
							nullObjError("roleSocialDataDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("roleSocialDataDic");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof GameSocialPartData))
			return;
		
		GameSocialPartData mData=(GameSocialPartData)data;
		
		this.roleSocialDataDic=mData.roleSocialDataDic;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof GameSocialPartData))
			return;
		
		GameSocialPartData mData=(GameSocialPartData)data;
		
		if(mData.roleSocialDataDic!=null)
		{
			if(this.roleSocialDataDic!=null)
			{
				this.roleSocialDataDic.clear();
				this.roleSocialDataDic.ensureCapacity(mData.roleSocialDataDic.size());
			}
			else
			{
				this.roleSocialDataDic=new LongObjectMap<RoleSocialData>(RoleSocialData[]::new,mData.roleSocialDataDic.size());
			}
			
			LongObjectMap<RoleSocialData> roleSocialDataDicT=this.roleSocialDataDic;
			if(!mData.roleSocialDataDic.isEmpty())
			{
				Object[] roleSocialDataDicVValues=mData.roleSocialDataDic.getValues();
				for(int roleSocialDataDicVI=roleSocialDataDicVValues.length-1;roleSocialDataDicVI>=0;--roleSocialDataDicVI)
				{
					if(roleSocialDataDicVValues[roleSocialDataDicVI]!=null)
					{
						RoleSocialData roleSocialDataDicV=(RoleSocialData)roleSocialDataDicVValues[roleSocialDataDicVI];
						RoleSocialData roleSocialDataDicU;
						if(roleSocialDataDicV!=null)
						{
							roleSocialDataDicU=(RoleSocialData)roleSocialDataDicV.clone();
						}
						else
						{
							roleSocialDataDicU=null;
							nullObjError("roleSocialDataDicU");
						}
						
						roleSocialDataDicT.put(roleSocialDataDicU.showData.playerID,roleSocialDataDicU);
					}
				}
			}
		}
		else
		{
			this.roleSocialDataDic=null;
			nullObjError("roleSocialDataDic");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		GameSocialPartData mData=(GameSocialPartData)data;
		if(mData.roleSocialDataDic!=null)
		{
			if(this.roleSocialDataDic==null)
				return false;
			if(this.roleSocialDataDic.size()!=mData.roleSocialDataDic.size())
				return false;
			LongObjectMap<RoleSocialData> roleSocialDataDicR=mData.roleSocialDataDic;
			if(!this.roleSocialDataDic.isEmpty())
			{
				long roleSocialDataDicKFreeValue=this.roleSocialDataDic.getFreeValue();
				long[] roleSocialDataDicKKeys=this.roleSocialDataDic.getKeys();
				Object[] roleSocialDataDicVValues=this.roleSocialDataDic.getValues();
				for(int roleSocialDataDicKI=roleSocialDataDicKKeys.length-1;roleSocialDataDicKI>=0;--roleSocialDataDicKI)
				{
					long roleSocialDataDicK=roleSocialDataDicKKeys[roleSocialDataDicKI];
					if(roleSocialDataDicK!=roleSocialDataDicKFreeValue)
					{
						RoleSocialData roleSocialDataDicV=(RoleSocialData)roleSocialDataDicVValues[roleSocialDataDicKI];
						RoleSocialData roleSocialDataDicU=roleSocialDataDicR.get(roleSocialDataDicK);
						if(roleSocialDataDicU!=null)
						{
							if(roleSocialDataDicV==null)
								return false;
							if(!roleSocialDataDicV.dataEquals(roleSocialDataDicU))
								return false;
						}
						else
						{
							if(roleSocialDataDicV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.roleSocialDataDic!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("roleSocialDataDic");
		writer.sb.append(':');
		writer.sb.append("Map<long,RoleSocialData>");
		if(this.roleSocialDataDic!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.roleSocialDataDic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.roleSocialDataDic.isEmpty())
			{
				long roleSocialDataDicKFreeValue=this.roleSocialDataDic.getFreeValue();
				long[] roleSocialDataDicKKeys=this.roleSocialDataDic.getKeys();
				Object[] roleSocialDataDicVValues=this.roleSocialDataDic.getValues();
				for(int roleSocialDataDicKI=roleSocialDataDicKKeys.length-1;roleSocialDataDicKI>=0;--roleSocialDataDicKI)
				{
					long roleSocialDataDicK=roleSocialDataDicKKeys[roleSocialDataDicKI];
					if(roleSocialDataDicK!=roleSocialDataDicKFreeValue)
					{
						RoleSocialData roleSocialDataDicV=(RoleSocialData)roleSocialDataDicVValues[roleSocialDataDicKI];
						writer.writeTabs();
						writer.sb.append(roleSocialDataDicK);
						
						writer.sb.append(':');
						if(roleSocialDataDicV!=null)
						{
							roleSocialDataDicV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("RoleSocialData=null");
						}
						
						writer.writeEnter();
					}
				}
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
		this.roleSocialDataDic=new LongObjectMap<RoleSocialData>(RoleSocialData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.roleSocialDataDic=null;
	}
	
}
