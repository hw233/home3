package com.home.commonBase.data.item;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.func.FuncToolData;
import com.home.commonBase.data.item.ItemData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.IntSet;
import com.home.shine.support.pool.DataPool;

/** 装备容器数据(generated by shine) */
public class EquipContainerData extends FuncToolData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.EquipContainer;
	
	/** 装备数据组(key:slot) */
	public IntObjectMap<ItemData> equips;
	
	/** 开启的格子组 */
	public IntSet openSlots;
	
	public EquipContainerData()
	{
		_dataID=BaseDataType.EquipContainer;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "EquipContainerData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int equipsLen=stream.readLen();
		if(this.equips!=null)
		{
			this.equips.clear();
			this.equips.ensureCapacity(equipsLen);
		}
		else
		{
			this.equips=new IntObjectMap<ItemData>(ItemData[]::new,equipsLen);
		}
		
		IntObjectMap<ItemData> equipsT=this.equips;
		for(int equipsI=equipsLen-1;equipsI>=0;--equipsI)
		{
			int equipsK;
			ItemData equipsV;
			equipsK=stream.readInt();
			
			BaseData equipsVT=stream.readDataFullNotNull();
			if(equipsVT!=null)
			{
				if(equipsVT instanceof ItemData)
				{
					equipsV=(ItemData)equipsVT;
				}
				else
				{
					equipsV=new ItemData();
					if(!(equipsVT.getClass().isAssignableFrom(ItemData.class)))
					{
						stream.throwTypeReadError(ItemData.class,equipsVT.getClass());
					}
					equipsV.shadowCopy(equipsVT);
				}
			}
			else
			{
				equipsV=null;
			}
			
			equipsT.put(equipsK,equipsV);
		}
		
		int openSlotsLen=stream.readLen();
		if(this.openSlots!=null)
		{
			this.openSlots.clear();
			this.openSlots.ensureCapacity(openSlotsLen);
		}
		else
		{
			this.openSlots=new IntSet(openSlotsLen);
		}
		
		IntSet openSlotsT=this.openSlots;
		for(int openSlotsI=openSlotsLen-1;openSlotsI>=0;--openSlotsI)
		{
			int openSlotsV;
			openSlotsV=stream.readInt();
			
			openSlotsT.add(openSlotsV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.equips!=null)
		{
			stream.writeLen(this.equips.size());
			if(!this.equips.isEmpty())
			{
				int equipsKFreeValue=this.equips.getFreeValue();
				int[] equipsKKeys=this.equips.getKeys();
				Object[] equipsVValues=this.equips.getValues();
				for(int equipsKI=equipsKKeys.length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=(ItemData)equipsVValues[equipsKI];
						stream.writeInt(equipsK);
						
						if(equipsV!=null)
						{
							stream.writeDataFullNotNull(equipsV);
						}
						else
						{
							nullObjError("equipsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("equips");
		}
		
		if(this.openSlots!=null)
		{
			stream.writeLen(this.openSlots.size());
			if(!this.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=this.openSlots.getFreeValue();
				int[] openSlotsVKeys=this.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						stream.writeInt(openSlotsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("openSlots");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		int equipsLen=stream.readLen();
		if(this.equips!=null)
		{
			this.equips.clear();
			this.equips.ensureCapacity(equipsLen);
		}
		else
		{
			this.equips=new IntObjectMap<ItemData>(ItemData[]::new,equipsLen);
		}
		
		IntObjectMap<ItemData> equipsT=this.equips;
		for(int equipsI=equipsLen-1;equipsI>=0;--equipsI)
		{
			int equipsK;
			ItemData equipsV;
			equipsK=stream.readInt();
			
			equipsV=(ItemData)stream.readDataSimpleNotNull();
			
			equipsT.put(equipsK,equipsV);
		}
		
		int openSlotsLen=stream.readLen();
		if(this.openSlots!=null)
		{
			this.openSlots.clear();
			this.openSlots.ensureCapacity(openSlotsLen);
		}
		else
		{
			this.openSlots=new IntSet(openSlotsLen);
		}
		
		IntSet openSlotsT=this.openSlots;
		for(int openSlotsI=openSlotsLen-1;openSlotsI>=0;--openSlotsI)
		{
			int openSlotsV;
			openSlotsV=stream.readInt();
			
			openSlotsT.add(openSlotsV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.equips!=null)
		{
			stream.writeLen(this.equips.size());
			if(!this.equips.isEmpty())
			{
				int equipsKFreeValue=this.equips.getFreeValue();
				int[] equipsKKeys=this.equips.getKeys();
				Object[] equipsVValues=this.equips.getValues();
				for(int equipsKI=equipsKKeys.length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=(ItemData)equipsVValues[equipsKI];
						stream.writeInt(equipsK);
						
						if(equipsV!=null)
						{
							stream.writeDataSimpleNotNull(equipsV);
						}
						else
						{
							nullObjError("equipsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("equips");
		}
		
		if(this.openSlots!=null)
		{
			stream.writeLen(this.openSlots.size());
			if(!this.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=this.openSlots.getFreeValue();
				int[] openSlotsVKeys=this.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						stream.writeInt(openSlotsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("openSlots");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof EquipContainerData))
			return;
		
		EquipContainerData mData=(EquipContainerData)data;
		
		this.equips=mData.equips;
		this.openSlots=mData.openSlots;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof EquipContainerData))
			return;
		
		EquipContainerData mData=(EquipContainerData)data;
		
		if(mData.equips!=null)
		{
			if(this.equips!=null)
			{
				this.equips.clear();
				this.equips.ensureCapacity(mData.equips.size());
			}
			else
			{
				this.equips=new IntObjectMap<ItemData>(ItemData[]::new,mData.equips.size());
			}
			
			IntObjectMap<ItemData> equipsT=this.equips;
			if(!mData.equips.isEmpty())
			{
				int equipsKFreeValue=mData.equips.getFreeValue();
				int[] equipsKKeys=mData.equips.getKeys();
				Object[] equipsVValues=mData.equips.getValues();
				for(int equipsKI=equipsKKeys.length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=(ItemData)equipsVValues[equipsKI];
						int equipsW;
						ItemData equipsU;
						equipsW=equipsK;
						
						if(equipsV!=null)
						{
							equipsU=(ItemData)equipsV.clone();
						}
						else
						{
							equipsU=null;
							nullObjError("equipsU");
						}
						
						equipsT.put(equipsW,equipsU);
					}
				}
			}
		}
		else
		{
			this.equips=null;
			nullObjError("equips");
		}
		
		if(mData.openSlots!=null)
		{
			if(this.openSlots!=null)
			{
				this.openSlots.clear();
				this.openSlots.ensureCapacity(mData.openSlots.size());
			}
			else
			{
				this.openSlots=new IntSet(mData.openSlots.size());
			}
			
			IntSet openSlotsT=this.openSlots;
			if(!mData.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=mData.openSlots.getFreeValue();
				int[] openSlotsVKeys=mData.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						int openSlotsU;
						openSlotsU=openSlotsV;
						
						openSlotsT.add(openSlotsU);
					}
				}
			}
		}
		else
		{
			this.openSlots=null;
			nullObjError("openSlots");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		EquipContainerData mData=(EquipContainerData)data;
		if(mData.equips!=null)
		{
			if(this.equips==null)
				return false;
			if(this.equips.size()!=mData.equips.size())
				return false;
			IntObjectMap<ItemData> equipsR=mData.equips;
			if(!this.equips.isEmpty())
			{
				int equipsKFreeValue=this.equips.getFreeValue();
				int[] equipsKKeys=this.equips.getKeys();
				Object[] equipsVValues=this.equips.getValues();
				for(int equipsKI=equipsKKeys.length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=(ItemData)equipsVValues[equipsKI];
						ItemData equipsU=equipsR.get(equipsK);
						if(equipsU!=null)
						{
							if(equipsV==null)
								return false;
							if(!equipsV.dataEquals(equipsU))
								return false;
						}
						else
						{
							if(equipsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.equips!=null)
				return false;
		}
		
		if(mData.openSlots!=null)
		{
			if(this.openSlots==null)
				return false;
			if(this.openSlots.size()!=mData.openSlots.size())
				return false;
			IntSet openSlotsR=mData.openSlots;
			if(!this.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=this.openSlots.getFreeValue();
				int[] openSlotsVKeys=this.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						if(!openSlotsR.contains(openSlotsV))
							return false;
					}
				}
			}
		}
		else
		{
			if(this.openSlots!=null)
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
		writer.sb.append("equips");
		writer.sb.append(':');
		writer.sb.append("Map<int,ItemData>");
		if(this.equips!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.equips.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.equips.isEmpty())
			{
				int equipsKFreeValue=this.equips.getFreeValue();
				int[] equipsKKeys=this.equips.getKeys();
				Object[] equipsVValues=this.equips.getValues();
				for(int equipsKI=equipsKKeys.length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=(ItemData)equipsVValues[equipsKI];
						writer.writeTabs();
						writer.sb.append(equipsK);
						
						writer.sb.append(':');
						if(equipsV!=null)
						{
							equipsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("ItemData=null");
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
		writer.writeTabs();
		writer.sb.append("openSlots");
		writer.sb.append(':');
		writer.sb.append("Set<int>");
		if(this.openSlots!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.openSlots.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=this.openSlots.getFreeValue();
				int[] openSlotsVKeys=this.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						writer.writeTabs();
						writer.sb.append(openSlotsV);
						
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
		super.initDefault();
		
		this.equips=new IntObjectMap<ItemData>(ItemData[]::new);
		this.openSlots=new IntSet();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.equips=null;
		this.openSlots=null;
	}
	
}
