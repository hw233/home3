package com.home.commonClient.net.response.item;
import com.home.commonBase.data.item.ItemData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 添加奖励消息(generated by shine) */
public class AddRewardResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.AddReward;
	
	/** 调用方式 */
	public int way;
	
	/** 等级 */
	public int level;
	
	/** 奖励次数 */
	public int num;
	
	/** 奖励ID */
	public int rewardID;
	
	/** 随机物品组结果 */
	public SList<ItemData> randomItemList;
	
	public AddRewardResponse()
	{
		_dataID=GameResponseType.AddReward;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "AddRewardResponse";
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.way=stream.readInt();
		
		this.rewardID=stream.readInt();
		
		this.level=stream.readInt();
		
		this.num=stream.readInt();
		
		if(stream.readBoolean())
		{
			int randomItemListLen=stream.readLen();
			if(this.randomItemList!=null)
			{
				this.randomItemList.clear();
				this.randomItemList.ensureCapacity(randomItemListLen);
			}
			else
			{
				this.randomItemList=new SList<ItemData>(ItemData[]::new,randomItemListLen);
			}
			
			SList<ItemData> randomItemListT=this.randomItemList;
			for(int randomItemListI=randomItemListLen-1;randomItemListI>=0;--randomItemListI)
			{
				ItemData randomItemListV;
				if(stream.readBoolean())
				{
					BaseData randomItemListVT=stream.readDataFullNotNull();
					if(randomItemListVT!=null)
					{
						if(randomItemListVT instanceof ItemData)
						{
							randomItemListV=(ItemData)randomItemListVT;
						}
						else
						{
							randomItemListV=new ItemData();
							if(!(randomItemListVT.getClass().isAssignableFrom(ItemData.class)))
							{
								stream.throwTypeReadError(ItemData.class,randomItemListVT.getClass());
							}
							randomItemListV.shadowCopy(randomItemListVT);
						}
					}
					else
					{
						randomItemListV=null;
					}
				}
				else
				{
					randomItemListV=null;
				}
				
				randomItemListT.add(randomItemListV);
			}
		}
		else
		{
			this.randomItemList=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.way=stream.readInt();
		
		this.rewardID=stream.readInt();
		
		this.level=stream.readInt();
		
		this.num=stream.readInt();
		
		if(stream.readBoolean())
		{
			int randomItemListLen=stream.readLen();
			if(this.randomItemList!=null)
			{
				this.randomItemList.clear();
				this.randomItemList.ensureCapacity(randomItemListLen);
			}
			else
			{
				this.randomItemList=new SList<ItemData>(ItemData[]::new,randomItemListLen);
			}
			
			SList<ItemData> randomItemListT=this.randomItemList;
			for(int randomItemListI=randomItemListLen-1;randomItemListI>=0;--randomItemListI)
			{
				ItemData randomItemListV;
				if(stream.readBoolean())
				{
					randomItemListV=(ItemData)stream.readDataSimpleNotNull();
				}
				else
				{
					randomItemListV=null;
				}
				
				randomItemListT.add(randomItemListV);
			}
		}
		else
		{
			this.randomItemList=null;
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("way");
		writer.sb.append(':');
		writer.sb.append(this.way);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("rewardID");
		writer.sb.append(':');
		writer.sb.append(this.rewardID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("level");
		writer.sb.append(':');
		writer.sb.append(this.level);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("num");
		writer.sb.append(':');
		writer.sb.append(this.num);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("randomItemList");
		writer.sb.append(':');
		writer.sb.append("List<ItemData>");
		if(this.randomItemList!=null)
		{
			SList<ItemData> randomItemListT=this.randomItemList;
			int randomItemListLen=randomItemListT.size();
			writer.sb.append('(');
			writer.sb.append(randomItemListLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int randomItemListI=0;randomItemListI<randomItemListLen;++randomItemListI)
			{
				ItemData randomItemListV=randomItemListT.get(randomItemListI);
				writer.writeTabs();
				writer.sb.append(randomItemListI);
				writer.sb.append(':');
				if(randomItemListV!=null)
				{
					randomItemListV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("ItemData=null");
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.way=0;
		this.rewardID=0;
		this.level=0;
		this.num=0;
		this.randomItemList=null;
	}
	
}
