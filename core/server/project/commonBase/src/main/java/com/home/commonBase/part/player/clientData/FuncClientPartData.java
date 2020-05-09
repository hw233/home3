package com.home.commonBase.part.player.clientData;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.constlist.generate.PlayerPartClientDataType;
import com.home.commonBase.data.func.FuncToolData;
import com.home.commonBase.data.item.EquipContainerData;
import com.home.commonBase.data.item.ItemContainerData;
import com.home.commonBase.data.item.ItemDicContainerData;
import com.home.commonBase.data.social.rank.RankSimpleData;
import com.home.commonBase.part.player.data.FuncPartData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.IntSet;
import com.home.shine.support.pool.DataPool;

/** 通用功能数据(generated by shine) */
public class FuncClientPartData extends BaseClientPartData
{
	/** 插件数据组(key1:funcToolType,key2:funcID) */
	public IntObjectMap<IntObjectMap<FuncToolData>> funcTools;
	
	/** 功能开启组 */
	public IntSet funcOpenSet;
	
	/** 数据类型ID */
	public static final int dataID=PlayerPartClientDataType.Func;
	
	public FuncClientPartData()
	{
		_dataID=PlayerPartClientDataType.Func;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		if(stream.readBoolean())
		{
			int funcToolsLen=stream.readLen();
			if(this.funcTools!=null)
			{
				this.funcTools.clear();
				this.funcTools.ensureCapacity(funcToolsLen);
			}
			else
			{
				this.funcTools=new IntObjectMap<IntObjectMap<FuncToolData>>(IntObjectMap[]::new,funcToolsLen);
			}
			
			IntObjectMap<IntObjectMap<FuncToolData>> funcToolsT=this.funcTools;
			for(int funcToolsI=funcToolsLen-1;funcToolsI>=0;--funcToolsI)
			{
				int funcToolsK;
				IntObjectMap<FuncToolData> funcToolsV;
				funcToolsK=stream.readInt();
				
				if(stream.readBoolean())
				{
					int funcToolsVLen=stream.readLen();
					funcToolsV=new IntObjectMap<FuncToolData>(FuncToolData[]::new,funcToolsVLen);
					IntObjectMap<FuncToolData> funcToolsVT=funcToolsV;
					for(int funcToolsVI=funcToolsVLen-1;funcToolsVI>=0;--funcToolsVI)
					{
						int funcToolsVK;
						FuncToolData funcToolsVV;
						funcToolsVK=stream.readInt();
						
						if(stream.readBoolean())
						{
							funcToolsVV=(FuncToolData)stream.readDataSimpleNotNull();
						}
						else
						{
							funcToolsVV=null;
						}
						
						funcToolsVT.put(funcToolsVK,funcToolsVV);
					}
				}
				else
				{
					funcToolsV=null;
				}
				
				funcToolsT.put(funcToolsK,funcToolsV);
			}
		}
		else
		{
			this.funcTools=null;
		}
		
		int funcOpenSetLen=stream.readLen();
		if(this.funcOpenSet!=null)
		{
			this.funcOpenSet.clear();
			this.funcOpenSet.ensureCapacity(funcOpenSetLen);
		}
		else
		{
			this.funcOpenSet=new IntSet(funcOpenSetLen);
		}
		
		IntSet funcOpenSetT=this.funcOpenSet;
		for(int funcOpenSetI=funcOpenSetLen-1;funcOpenSetI>=0;--funcOpenSetI)
		{
			int funcOpenSetV;
			funcOpenSetV=stream.readInt();
			
			funcOpenSetT.add(funcOpenSetV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.funcTools!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.funcTools.size());
			if(!this.funcTools.isEmpty())
			{
				int funcToolsKFreeValue=this.funcTools.getFreeValue();
				int[] funcToolsKKeys=this.funcTools.getKeys();
				Object[] funcToolsVValues=this.funcTools.getValues();
				for(int funcToolsKI=funcToolsKKeys.length-1;funcToolsKI>=0;--funcToolsKI)
				{
					int funcToolsK=funcToolsKKeys[funcToolsKI];
					if(funcToolsK!=funcToolsKFreeValue)
					{
						IntObjectMap<FuncToolData> funcToolsV=(IntObjectMap<FuncToolData>)funcToolsVValues[funcToolsKI];
						stream.writeInt(funcToolsK);
						
						if(funcToolsV!=null)
						{
							stream.writeBoolean(true);
							stream.writeLen(funcToolsV.size());
							if(!funcToolsV.isEmpty())
							{
								int funcToolsVKFreeValue=funcToolsV.getFreeValue();
								int[] funcToolsVKKeys=funcToolsV.getKeys();
								Object[] funcToolsVVValues=funcToolsV.getValues();
								for(int funcToolsVKI=funcToolsVKKeys.length-1;funcToolsVKI>=0;--funcToolsVKI)
								{
									int funcToolsVK=funcToolsVKKeys[funcToolsVKI];
									if(funcToolsVK!=funcToolsVKFreeValue)
									{
										FuncToolData funcToolsVV=(FuncToolData)funcToolsVVValues[funcToolsVKI];
										stream.writeInt(funcToolsVK);
										
										if(funcToolsVV!=null)
										{
											stream.writeBoolean(true);
											stream.writeDataSimpleNotNull(funcToolsVV);
										}
										else
										{
											stream.writeBoolean(false);
										}
										
									}
								}
							}
						}
						else
						{
							stream.writeBoolean(false);
						}
						
					}
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.funcOpenSet!=null)
		{
			stream.writeLen(this.funcOpenSet.size());
			if(!this.funcOpenSet.isEmpty())
			{
				int funcOpenSetVFreeValue=this.funcOpenSet.getFreeValue();
				int[] funcOpenSetVKeys=this.funcOpenSet.getKeys();
				for(int funcOpenSetVI=funcOpenSetVKeys.length-1;funcOpenSetVI>=0;--funcOpenSetVI)
				{
					int funcOpenSetV=funcOpenSetVKeys[funcOpenSetVI];
					if(funcOpenSetV!=funcOpenSetVFreeValue)
					{
						stream.writeInt(funcOpenSetV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("funcOpenSet");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof FuncClientPartData))
			return;
		
		FuncClientPartData mData=(FuncClientPartData)data;
		
		this.funcTools=mData.funcTools;
		this.funcOpenSet=mData.funcOpenSet;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof FuncClientPartData))
			return;
		
		FuncClientPartData mData=(FuncClientPartData)data;
		
		if(mData.funcTools!=null)
		{
			if(this.funcTools!=null)
			{
				this.funcTools.clear();
				this.funcTools.ensureCapacity(mData.funcTools.size());
			}
			else
			{
				this.funcTools=new IntObjectMap<IntObjectMap<FuncToolData>>(IntObjectMap[]::new,mData.funcTools.size());
			}
			
			IntObjectMap<IntObjectMap<FuncToolData>> funcToolsT=this.funcTools;
			if(!mData.funcTools.isEmpty())
			{
				int funcToolsKFreeValue=mData.funcTools.getFreeValue();
				int[] funcToolsKKeys=mData.funcTools.getKeys();
				Object[] funcToolsVValues=mData.funcTools.getValues();
				for(int funcToolsKI=funcToolsKKeys.length-1;funcToolsKI>=0;--funcToolsKI)
				{
					int funcToolsK=funcToolsKKeys[funcToolsKI];
					if(funcToolsK!=funcToolsKFreeValue)
					{
						IntObjectMap<FuncToolData> funcToolsV=(IntObjectMap<FuncToolData>)funcToolsVValues[funcToolsKI];
						int funcToolsW;
						IntObjectMap<FuncToolData> funcToolsU;
						funcToolsW=funcToolsK;
						
						if(funcToolsV!=null)
						{
							funcToolsU=new IntObjectMap<FuncToolData>(FuncToolData[]::new,funcToolsV.size());
							IntObjectMap<FuncToolData> funcToolsUT=funcToolsU;
							if(!funcToolsV.isEmpty())
							{
								int funcToolsUKFreeValue=funcToolsV.getFreeValue();
								int[] funcToolsUKKeys=funcToolsV.getKeys();
								Object[] funcToolsUVValues=funcToolsV.getValues();
								for(int funcToolsUKI=funcToolsUKKeys.length-1;funcToolsUKI>=0;--funcToolsUKI)
								{
									int funcToolsUK=funcToolsUKKeys[funcToolsUKI];
									if(funcToolsUK!=funcToolsUKFreeValue)
									{
										FuncToolData funcToolsUV=(FuncToolData)funcToolsUVValues[funcToolsUKI];
										int funcToolsUW;
										FuncToolData funcToolsUU;
										funcToolsUW=funcToolsUK;
										
										if(funcToolsUV!=null)
										{
											funcToolsUU=(FuncToolData)funcToolsUV.clone();
										}
										else
										{
											funcToolsUU=null;
										}
										
										funcToolsUT.put(funcToolsUW,funcToolsUU);
									}
								}
							}
						}
						else
						{
							funcToolsU=null;
						}
						
						funcToolsT.put(funcToolsW,funcToolsU);
					}
				}
			}
		}
		else
		{
			this.funcTools=null;
		}
		
		if(mData.funcOpenSet!=null)
		{
			if(this.funcOpenSet!=null)
			{
				this.funcOpenSet.clear();
				this.funcOpenSet.ensureCapacity(mData.funcOpenSet.size());
			}
			else
			{
				this.funcOpenSet=new IntSet(mData.funcOpenSet.size());
			}
			
			IntSet funcOpenSetT=this.funcOpenSet;
			if(!mData.funcOpenSet.isEmpty())
			{
				int funcOpenSetVFreeValue=mData.funcOpenSet.getFreeValue();
				int[] funcOpenSetVKeys=mData.funcOpenSet.getKeys();
				for(int funcOpenSetVI=funcOpenSetVKeys.length-1;funcOpenSetVI>=0;--funcOpenSetVI)
				{
					int funcOpenSetV=funcOpenSetVKeys[funcOpenSetVI];
					if(funcOpenSetV!=funcOpenSetVFreeValue)
					{
						int funcOpenSetU;
						funcOpenSetU=funcOpenSetV;
						
						funcOpenSetT.add(funcOpenSetU);
					}
				}
			}
		}
		else
		{
			this.funcOpenSet=null;
			nullObjError("funcOpenSet");
		}
		
	}
	
	/** 从服务器数据上复制数据(潜拷,因InitClient会copy) */
	@Override
	protected void toCopyFromServer(BaseData data)
	{
		super.toCopyFromServer(data);
		if(!(data instanceof FuncPartData))
			return;
		
		FuncPartData mData=(FuncPartData)data;
		
		this.funcTools=mData.funcTools;
		
		this.funcOpenSet=mData.funcOpenSet;
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncClientPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		if(stream.readBoolean())
		{
			int funcToolsLen=stream.readLen();
			if(this.funcTools!=null)
			{
				this.funcTools.clear();
				this.funcTools.ensureCapacity(funcToolsLen);
			}
			else
			{
				this.funcTools=new IntObjectMap<IntObjectMap<FuncToolData>>(IntObjectMap[]::new,funcToolsLen);
			}
			
			IntObjectMap<IntObjectMap<FuncToolData>> funcToolsT=this.funcTools;
			for(int funcToolsI=funcToolsLen-1;funcToolsI>=0;--funcToolsI)
			{
				int funcToolsK;
				IntObjectMap<FuncToolData> funcToolsV;
				funcToolsK=stream.readInt();
				
				if(stream.readBoolean())
				{
					int funcToolsVLen=stream.readLen();
					funcToolsV=new IntObjectMap<FuncToolData>(FuncToolData[]::new,funcToolsVLen);
					IntObjectMap<FuncToolData> funcToolsVT=funcToolsV;
					for(int funcToolsVI=funcToolsVLen-1;funcToolsVI>=0;--funcToolsVI)
					{
						int funcToolsVK;
						FuncToolData funcToolsVV;
						funcToolsVK=stream.readInt();
						
						if(stream.readBoolean())
						{
							BaseData funcToolsVVT=stream.readDataFullNotNull();
							if(funcToolsVVT!=null)
							{
								if(funcToolsVVT instanceof FuncToolData)
								{
									funcToolsVV=(FuncToolData)funcToolsVVT;
								}
								else
								{
									funcToolsVV=new FuncToolData();
									if(!(funcToolsVVT.getClass().isAssignableFrom(FuncToolData.class)))
									{
										stream.throwTypeReadError(FuncToolData.class,funcToolsVVT.getClass());
									}
									funcToolsVV.shadowCopy(funcToolsVVT);
								}
							}
							else
							{
								funcToolsVV=null;
							}
						}
						else
						{
							funcToolsVV=null;
						}
						
						funcToolsVT.put(funcToolsVK,funcToolsVV);
					}
				}
				else
				{
					funcToolsV=null;
				}
				
				funcToolsT.put(funcToolsK,funcToolsV);
			}
		}
		else
		{
			this.funcTools=null;
		}
		
		int funcOpenSetLen=stream.readLen();
		if(this.funcOpenSet!=null)
		{
			this.funcOpenSet.clear();
			this.funcOpenSet.ensureCapacity(funcOpenSetLen);
		}
		else
		{
			this.funcOpenSet=new IntSet(funcOpenSetLen);
		}
		
		IntSet funcOpenSetT=this.funcOpenSet;
		for(int funcOpenSetI=funcOpenSetLen-1;funcOpenSetI>=0;--funcOpenSetI)
		{
			int funcOpenSetV;
			funcOpenSetV=stream.readInt();
			
			funcOpenSetT.add(funcOpenSetV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.funcTools!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.funcTools.size());
			if(!this.funcTools.isEmpty())
			{
				int funcToolsKFreeValue=this.funcTools.getFreeValue();
				int[] funcToolsKKeys=this.funcTools.getKeys();
				Object[] funcToolsVValues=this.funcTools.getValues();
				for(int funcToolsKI=funcToolsKKeys.length-1;funcToolsKI>=0;--funcToolsKI)
				{
					int funcToolsK=funcToolsKKeys[funcToolsKI];
					if(funcToolsK!=funcToolsKFreeValue)
					{
						IntObjectMap<FuncToolData> funcToolsV=(IntObjectMap<FuncToolData>)funcToolsVValues[funcToolsKI];
						stream.writeInt(funcToolsK);
						
						if(funcToolsV!=null)
						{
							stream.writeBoolean(true);
							stream.writeLen(funcToolsV.size());
							if(!funcToolsV.isEmpty())
							{
								int funcToolsVKFreeValue=funcToolsV.getFreeValue();
								int[] funcToolsVKKeys=funcToolsV.getKeys();
								Object[] funcToolsVVValues=funcToolsV.getValues();
								for(int funcToolsVKI=funcToolsVKKeys.length-1;funcToolsVKI>=0;--funcToolsVKI)
								{
									int funcToolsVK=funcToolsVKKeys[funcToolsVKI];
									if(funcToolsVK!=funcToolsVKFreeValue)
									{
										FuncToolData funcToolsVV=(FuncToolData)funcToolsVVValues[funcToolsVKI];
										stream.writeInt(funcToolsVK);
										
										if(funcToolsVV!=null)
										{
											stream.writeBoolean(true);
											stream.writeDataFullNotNull(funcToolsVV);
										}
										else
										{
											stream.writeBoolean(false);
										}
										
									}
								}
							}
						}
						else
						{
							stream.writeBoolean(false);
						}
						
					}
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.funcOpenSet!=null)
		{
			stream.writeLen(this.funcOpenSet.size());
			if(!this.funcOpenSet.isEmpty())
			{
				int funcOpenSetVFreeValue=this.funcOpenSet.getFreeValue();
				int[] funcOpenSetVKeys=this.funcOpenSet.getKeys();
				for(int funcOpenSetVI=funcOpenSetVKeys.length-1;funcOpenSetVI>=0;--funcOpenSetVI)
				{
					int funcOpenSetV=funcOpenSetVKeys[funcOpenSetVI];
					if(funcOpenSetV!=funcOpenSetVFreeValue)
					{
						stream.writeInt(funcOpenSetV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("funcOpenSet");
		}
		
		stream.endWriteObj();
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		FuncClientPartData mData=(FuncClientPartData)data;
		if(mData.funcTools!=null)
		{
			if(this.funcTools==null)
				return false;
			if(this.funcTools.size()!=mData.funcTools.size())
				return false;
			IntObjectMap<IntObjectMap<FuncToolData>> funcToolsR=mData.funcTools;
			if(!this.funcTools.isEmpty())
			{
				int funcToolsKFreeValue=this.funcTools.getFreeValue();
				int[] funcToolsKKeys=this.funcTools.getKeys();
				Object[] funcToolsVValues=this.funcTools.getValues();
				for(int funcToolsKI=funcToolsKKeys.length-1;funcToolsKI>=0;--funcToolsKI)
				{
					int funcToolsK=funcToolsKKeys[funcToolsKI];
					if(funcToolsK!=funcToolsKFreeValue)
					{
						IntObjectMap<FuncToolData> funcToolsV=(IntObjectMap<FuncToolData>)funcToolsVValues[funcToolsKI];
						IntObjectMap<FuncToolData> funcToolsU=funcToolsR.get(funcToolsK);
						if(funcToolsU!=null)
						{
							if(funcToolsV==null)
								return false;
							if(funcToolsV.size()!=funcToolsU.size())
								return false;
							IntObjectMap<FuncToolData> funcToolsVR=funcToolsU;
							if(!funcToolsV.isEmpty())
							{
								int funcToolsVKFreeValue=funcToolsV.getFreeValue();
								int[] funcToolsVKKeys=funcToolsV.getKeys();
								Object[] funcToolsVVValues=funcToolsV.getValues();
								for(int funcToolsVKI=funcToolsVKKeys.length-1;funcToolsVKI>=0;--funcToolsVKI)
								{
									int funcToolsVK=funcToolsVKKeys[funcToolsVKI];
									if(funcToolsVK!=funcToolsVKFreeValue)
									{
										FuncToolData funcToolsVV=(FuncToolData)funcToolsVVValues[funcToolsVKI];
										FuncToolData funcToolsVU=funcToolsVR.get(funcToolsVK);
										if(funcToolsVU!=null)
										{
											if(funcToolsVV==null)
												return false;
											if(!funcToolsVV.dataEquals(funcToolsVU))
												return false;
										}
										else
										{
											if(funcToolsVV!=null)
												return false;
										}
										
									}
								}
							}
						}
						else
						{
							if(funcToolsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.funcTools!=null)
				return false;
		}
		
		if(mData.funcOpenSet!=null)
		{
			if(this.funcOpenSet==null)
				return false;
			if(this.funcOpenSet.size()!=mData.funcOpenSet.size())
				return false;
			IntSet funcOpenSetR=mData.funcOpenSet;
			if(!this.funcOpenSet.isEmpty())
			{
				int funcOpenSetVFreeValue=this.funcOpenSet.getFreeValue();
				int[] funcOpenSetVKeys=this.funcOpenSet.getKeys();
				for(int funcOpenSetVI=funcOpenSetVKeys.length-1;funcOpenSetVI>=0;--funcOpenSetVI)
				{
					int funcOpenSetV=funcOpenSetVKeys[funcOpenSetVI];
					if(funcOpenSetV!=funcOpenSetVFreeValue)
					{
						if(!funcOpenSetR.contains(funcOpenSetV))
							return false;
					}
				}
			}
		}
		else
		{
			if(this.funcOpenSet!=null)
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
		writer.sb.append("funcTools");
		writer.sb.append(':');
		writer.sb.append("Map<int,IntObjectMap<FuncToolData>>");
		if(this.funcTools!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.funcTools.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.funcTools.isEmpty())
			{
				int funcToolsKFreeValue=this.funcTools.getFreeValue();
				int[] funcToolsKKeys=this.funcTools.getKeys();
				Object[] funcToolsVValues=this.funcTools.getValues();
				for(int funcToolsKI=funcToolsKKeys.length-1;funcToolsKI>=0;--funcToolsKI)
				{
					int funcToolsK=funcToolsKKeys[funcToolsKI];
					if(funcToolsK!=funcToolsKFreeValue)
					{
						IntObjectMap<FuncToolData> funcToolsV=(IntObjectMap<FuncToolData>)funcToolsVValues[funcToolsKI];
						writer.writeTabs();
						writer.sb.append(funcToolsK);
						
						writer.sb.append(':');
						writer.sb.append("Map<int,FuncToolData>");
						if(funcToolsV!=null)
						{
							writer.sb.append('(');
							writer.sb.append(funcToolsV.size());
							writer.sb.append(')');
							writer.writeEnter();
							writer.writeLeftBrace();
							if(!funcToolsV.isEmpty())
							{
								int funcToolsVKFreeValue=funcToolsV.getFreeValue();
								int[] funcToolsVKKeys=funcToolsV.getKeys();
								Object[] funcToolsVVValues=funcToolsV.getValues();
								for(int funcToolsVKI=funcToolsVKKeys.length-1;funcToolsVKI>=0;--funcToolsVKI)
								{
									int funcToolsVK=funcToolsVKKeys[funcToolsVKI];
									if(funcToolsVK!=funcToolsVKFreeValue)
									{
										FuncToolData funcToolsVV=(FuncToolData)funcToolsVVValues[funcToolsVKI];
										writer.writeTabs();
										writer.sb.append(funcToolsVK);
										
										writer.sb.append(':');
										if(funcToolsVV!=null)
										{
											funcToolsVV.writeDataString(writer);
										}
										else
										{
											writer.sb.append("FuncToolData=null");
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
		writer.sb.append("funcOpenSet");
		writer.sb.append(':');
		writer.sb.append("Set<int>");
		if(this.funcOpenSet!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.funcOpenSet.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.funcOpenSet.isEmpty())
			{
				int funcOpenSetVFreeValue=this.funcOpenSet.getFreeValue();
				int[] funcOpenSetVKeys=this.funcOpenSet.getKeys();
				for(int funcOpenSetVI=funcOpenSetVKeys.length-1;funcOpenSetVI>=0;--funcOpenSetVI)
				{
					int funcOpenSetV=funcOpenSetVKeys[funcOpenSetVI];
					if(funcOpenSetV!=funcOpenSetVFreeValue)
					{
						writer.writeTabs();
						writer.sb.append(funcOpenSetV);
						
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
		
		this.funcOpenSet=new IntSet();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcTools=null;
		this.funcOpenSet=null;
	}
	
}
