package com.home.commonBase.part.player.data;
import com.home.commonBase.constlist.generate.PlayerPartDataType;
import com.home.commonBase.data.role.MUnitCacheData;
import com.home.commonBase.data.scene.base.PosDirData;
import com.home.commonBase.data.scene.scene.SceneEnterArgData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 场景模块(generated by shine) */
public class ScenePartData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=PlayerPartDataType.Scene;
	
	/** 当前场景进入参数数据 */
	public SceneEnterArgData currentSceneEnterArg;
	
	/** 所选线ID */
	public int lineID=-1;
	
	/** 上次所在主城ID */
	public int lastTownID=-1;
	
	/** 上次所在主城位置 */
	public PosDirData lastTownPosDir;
	
	/** 主城角色保存数据 */
	public MUnitCacheData lastTownSaveData;
	
	/** 当前场景位置 */
	public PosDirData currentScenePosDir;
	
	public ScenePartData()
	{
		_dataID=PlayerPartDataType.Scene;
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.lastTownID=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.lastTownPosDir=new PosDirData();
			this.lastTownPosDir.readBytesFull(stream);
		}
		else
		{
			this.lastTownPosDir=null;
		}
		
		this.lineID=stream.readInt();
		
		if(stream.readBoolean())
		{
			BaseData currentSceneEnterArgT=stream.readDataFullNotNull();
			if(currentSceneEnterArgT!=null)
			{
				if(currentSceneEnterArgT instanceof SceneEnterArgData)
				{
					this.currentSceneEnterArg=(SceneEnterArgData)currentSceneEnterArgT;
				}
				else
				{
					this.currentSceneEnterArg=new SceneEnterArgData();
					if(!(currentSceneEnterArgT.getClass().isAssignableFrom(SceneEnterArgData.class)))
					{
						stream.throwTypeReadError(SceneEnterArgData.class,currentSceneEnterArgT.getClass());
					}
					this.currentSceneEnterArg.shadowCopy(currentSceneEnterArgT);
				}
			}
			else
			{
				this.currentSceneEnterArg=null;
			}
		}
		else
		{
			this.currentSceneEnterArg=null;
		}
		
		if(stream.readBoolean())
		{
			this.currentScenePosDir=new PosDirData();
			this.currentScenePosDir.readBytesFull(stream);
		}
		else
		{
			this.currentScenePosDir=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData lastTownSaveDataT=stream.readDataFullNotNull();
			if(lastTownSaveDataT!=null)
			{
				if(lastTownSaveDataT instanceof MUnitCacheData)
				{
					this.lastTownSaveData=(MUnitCacheData)lastTownSaveDataT;
				}
				else
				{
					this.lastTownSaveData=new MUnitCacheData();
					if(!(lastTownSaveDataT.getClass().isAssignableFrom(MUnitCacheData.class)))
					{
						stream.throwTypeReadError(MUnitCacheData.class,lastTownSaveDataT.getClass());
					}
					this.lastTownSaveData.shadowCopy(lastTownSaveDataT);
				}
			}
			else
			{
				this.lastTownSaveData=null;
			}
		}
		else
		{
			this.lastTownSaveData=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.lastTownID);
		
		if(this.lastTownPosDir!=null)
		{
			stream.writeBoolean(true);
			this.lastTownPosDir.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.lineID);
		
		if(this.currentSceneEnterArg!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.currentSceneEnterArg);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.currentScenePosDir!=null)
		{
			stream.writeBoolean(true);
			this.currentScenePosDir.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.lastTownSaveData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.lastTownSaveData);
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
		this.lastTownID=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.lastTownPosDir=new PosDirData();
			this.lastTownPosDir.readBytesSimple(stream);
		}
		else
		{
			this.lastTownPosDir=null;
		}
		
		this.lineID=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.currentSceneEnterArg=(SceneEnterArgData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.currentSceneEnterArg=null;
		}
		
		if(stream.readBoolean())
		{
			this.currentScenePosDir=new PosDirData();
			this.currentScenePosDir.readBytesSimple(stream);
		}
		else
		{
			this.currentScenePosDir=null;
		}
		
		if(stream.readBoolean())
		{
			this.lastTownSaveData=(MUnitCacheData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.lastTownSaveData=null;
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.lastTownID);
		
		if(this.lastTownPosDir!=null)
		{
			stream.writeBoolean(true);
			this.lastTownPosDir.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.lineID);
		
		if(this.currentSceneEnterArg!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.currentSceneEnterArg);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.currentScenePosDir!=null)
		{
			stream.writeBoolean(true);
			this.currentScenePosDir.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.lastTownSaveData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.lastTownSaveData);
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
		if(!(data instanceof ScenePartData))
			return;
		
		ScenePartData mData=(ScenePartData)data;
		
		this.lastTownID=mData.lastTownID;
		this.lastTownPosDir=mData.lastTownPosDir;
		this.lineID=mData.lineID;
		this.currentSceneEnterArg=mData.currentSceneEnterArg;
		this.currentScenePosDir=mData.currentScenePosDir;
		this.lastTownSaveData=mData.lastTownSaveData;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof ScenePartData))
			return;
		
		ScenePartData mData=(ScenePartData)data;
		
		this.lastTownID=mData.lastTownID;
		
		if(mData.lastTownPosDir!=null)
		{
			this.lastTownPosDir=new PosDirData();
			this.lastTownPosDir.copy(mData.lastTownPosDir);
		}
		else
		{
			this.lastTownPosDir=null;
		}
		
		this.lineID=mData.lineID;
		
		if(mData.currentSceneEnterArg!=null)
		{
			this.currentSceneEnterArg=(SceneEnterArgData)mData.currentSceneEnterArg.clone();
		}
		else
		{
			this.currentSceneEnterArg=null;
		}
		
		if(mData.currentScenePosDir!=null)
		{
			this.currentScenePosDir=new PosDirData();
			this.currentScenePosDir.copy(mData.currentScenePosDir);
		}
		else
		{
			this.currentScenePosDir=null;
		}
		
		if(mData.lastTownSaveData!=null)
		{
			this.lastTownSaveData=(MUnitCacheData)mData.lastTownSaveData.clone();
		}
		else
		{
			this.lastTownSaveData=null;
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		ScenePartData mData=(ScenePartData)data;
		if(this.lastTownID!=mData.lastTownID)
			return false;
		
		if(mData.lastTownPosDir!=null)
		{
			if(this.lastTownPosDir==null)
				return false;
			if(!this.lastTownPosDir.dataEquals(mData.lastTownPosDir))
				return false;
		}
		else
		{
			if(this.lastTownPosDir!=null)
				return false;
		}
		
		if(this.lineID!=mData.lineID)
			return false;
		
		if(mData.currentSceneEnterArg!=null)
		{
			if(this.currentSceneEnterArg==null)
				return false;
			if(!this.currentSceneEnterArg.dataEquals(mData.currentSceneEnterArg))
				return false;
		}
		else
		{
			if(this.currentSceneEnterArg!=null)
				return false;
		}
		
		if(mData.currentScenePosDir!=null)
		{
			if(this.currentScenePosDir==null)
				return false;
			if(!this.currentScenePosDir.dataEquals(mData.currentScenePosDir))
				return false;
		}
		else
		{
			if(this.currentScenePosDir!=null)
				return false;
		}
		
		if(mData.lastTownSaveData!=null)
		{
			if(this.lastTownSaveData==null)
				return false;
			if(!this.lastTownSaveData.dataEquals(mData.lastTownSaveData))
				return false;
		}
		else
		{
			if(this.lastTownSaveData!=null)
				return false;
		}
		
		return true;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ScenePartData";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("lastTownID");
		writer.sb.append(':');
		writer.sb.append(this.lastTownID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("lastTownPosDir");
		writer.sb.append(':');
		if(this.lastTownPosDir!=null)
		{
			this.lastTownPosDir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosDirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("lineID");
		writer.sb.append(':');
		writer.sb.append(this.lineID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("currentSceneEnterArg");
		writer.sb.append(':');
		if(this.currentSceneEnterArg!=null)
		{
			this.currentSceneEnterArg.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SceneEnterArgData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("currentScenePosDir");
		writer.sb.append(':');
		if(this.currentScenePosDir!=null)
		{
			this.currentScenePosDir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosDirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("lastTownSaveData");
		writer.sb.append(':');
		if(this.lastTownSaveData!=null)
		{
			this.lastTownSaveData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("MUnitCacheData=null");
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
		this.lastTownID=0;
		this.lastTownPosDir=null;
		this.lineID=0;
		this.currentSceneEnterArg=null;
		this.currentScenePosDir=null;
		this.lastTownSaveData=null;
	}
	
}
