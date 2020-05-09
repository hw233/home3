package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.system.ServerInfoData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.serverConfig.BaseServerConfig;
import com.home.shine.serverConfig.GameServerConfig;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntList;
import com.home.shine.support.pool.DataPool;

/** 游戏服信息数据(generated by shine) */
public class GameServerInfoData extends ServerInfoData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.GameServerInfo;
	
	/** 是否辅助服(跨服) */
	public boolean isAssist;
	
	/** 承载的区服列表 */
	public IntList areaIDList;
	
	public GameServerInfoData()
	{
		_dataID=BaseDataType.GameServerInfo;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "GameServerInfoData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.isAssist=stream.readBoolean();
		
		int areaIDListLen=stream.readLen();
		if(this.areaIDList!=null)
		{
			this.areaIDList.clear();
			this.areaIDList.ensureCapacity(areaIDListLen);
		}
		else
		{
			this.areaIDList=new IntList(areaIDListLen);
		}
		
		IntList areaIDListT=this.areaIDList;
		for(int areaIDListI=areaIDListLen-1;areaIDListI>=0;--areaIDListI)
		{
			int areaIDListV;
			areaIDListV=stream.readInt();
			
			areaIDListT.add(areaIDListV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeBoolean(this.isAssist);
		
		if(this.areaIDList!=null)
		{
			stream.writeLen(this.areaIDList.size());
			if(!this.areaIDList.isEmpty())
			{
				int[] areaIDListVValues=this.areaIDList.getValues();
				for(int areaIDListVI=0,areaIDListVLen=this.areaIDList.length();areaIDListVI<areaIDListVLen;++areaIDListVI)
				{
					int areaIDListV=areaIDListVValues[areaIDListVI];
					stream.writeInt(areaIDListV);
					
				}
			}
		}
		else
		{
			nullObjError("areaIDList");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.isAssist=stream.readBoolean();
		
		int areaIDListLen=stream.readLen();
		if(this.areaIDList!=null)
		{
			this.areaIDList.clear();
			this.areaIDList.ensureCapacity(areaIDListLen);
		}
		else
		{
			this.areaIDList=new IntList(areaIDListLen);
		}
		
		IntList areaIDListT=this.areaIDList;
		for(int areaIDListI=areaIDListLen-1;areaIDListI>=0;--areaIDListI)
		{
			int areaIDListV;
			areaIDListV=stream.readInt();
			
			areaIDListT.add(areaIDListV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeBoolean(this.isAssist);
		
		if(this.areaIDList!=null)
		{
			stream.writeLen(this.areaIDList.size());
			if(!this.areaIDList.isEmpty())
			{
				int[] areaIDListVValues=this.areaIDList.getValues();
				for(int areaIDListVI=0,areaIDListVLen=this.areaIDList.length();areaIDListVI<areaIDListVLen;++areaIDListVI)
				{
					int areaIDListV=areaIDListVValues[areaIDListVI];
					stream.writeInt(areaIDListV);
					
				}
			}
		}
		else
		{
			nullObjError("areaIDList");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof GameServerInfoData))
			return;
		
		GameServerInfoData mData=(GameServerInfoData)data;
		
		this.isAssist=mData.isAssist;
		this.areaIDList=mData.areaIDList;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof GameServerInfoData))
			return;
		
		GameServerInfoData mData=(GameServerInfoData)data;
		
		this.isAssist=mData.isAssist;
		
		if(mData.areaIDList!=null)
		{
			if(this.areaIDList!=null)
			{
				this.areaIDList.clear();
				this.areaIDList.ensureCapacity(mData.areaIDList.size());
			}
			else
			{
				this.areaIDList=new IntList(mData.areaIDList.size());
			}
			
			IntList areaIDListT=this.areaIDList;
			if(!mData.areaIDList.isEmpty())
			{
				int[] areaIDListVValues=mData.areaIDList.getValues();
				for(int areaIDListVI=0,areaIDListVLen=mData.areaIDList.length();areaIDListVI<areaIDListVLen;++areaIDListVI)
				{
					int areaIDListV=areaIDListVValues[areaIDListVI];
					int areaIDListU;
					areaIDListU=areaIDListV;
					
					areaIDListT.add(areaIDListU);
				}
			}
		}
		else
		{
			this.areaIDList=null;
			nullObjError("areaIDList");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		GameServerInfoData mData=(GameServerInfoData)data;
		if(this.isAssist!=mData.isAssist)
			return false;
		
		if(mData.areaIDList!=null)
		{
			if(this.areaIDList==null)
				return false;
			if(this.areaIDList.size()!=mData.areaIDList.size())
				return false;
			IntList areaIDListT=this.areaIDList;
			IntList areaIDListR=mData.areaIDList;
			int areaIDListLen=areaIDListT.size();
			for(int areaIDListI=0;areaIDListI<areaIDListLen;++areaIDListI)
			{
				int areaIDListU=areaIDListT.get(areaIDListI);
				int areaIDListV=areaIDListR.get(areaIDListI);
				if(areaIDListU!=areaIDListV)
					return false;
				
			}
		}
		else
		{
			if(this.areaIDList!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("isAssist");
		writer.sb.append(':');
		writer.sb.append(this.isAssist);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("areaIDList");
		writer.sb.append(':');
		writer.sb.append("List<int>");
		if(this.areaIDList!=null)
		{
			IntList areaIDListT=this.areaIDList;
			int areaIDListLen=areaIDListT.size();
			writer.sb.append('(');
			writer.sb.append(areaIDListLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int areaIDListI=0;areaIDListI<areaIDListLen;++areaIDListI)
			{
				int areaIDListV=areaIDListT.get(areaIDListI);
				writer.writeTabs();
				writer.sb.append(areaIDListI);
				writer.sb.append(':');
				writer.sb.append(areaIDListV);
				
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
		super.initDefault();
		
		this.areaIDList=new IntList();
	}
	
	@Override
	public void readByConfig(BaseServerConfig config)
	{
		super.readByConfig(config);
		
		GameServerConfig gameServerConfig=(GameServerConfig)config;
		this.isAssist=gameServerConfig.isAssist;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.isAssist=false;
		this.areaIDList=null;
	}
	
}
