package com.home.commonClient.net.response.func.item;
import com.home.commonBase.data.item.ItemData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.commonClient.net.response.func.base.FuncSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送添加单个物品(generated by shine) */
public class FuncAddOneItemResponse extends FuncSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncAddOneItem;
	
	/** 途径 */
	public int way;
	
	/** 序号 */
	public int index;
	
	/** 物品数据 */
	public ItemData item;
	
	public FuncAddOneItemResponse()
	{
		_dataID=GameResponseType.FuncAddOneItem;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getBaseItemContainerTool(funcID).onAddItemByServer(index,item,way);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncAddOneItemResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.way=stream.readInt();
		
		this.index=stream.readInt();
		
		BaseData itemT=stream.readDataFullNotNull();
		if(itemT!=null)
		{
			if(itemT instanceof ItemData)
			{
				this.item=(ItemData)itemT;
			}
			else
			{
				this.item=new ItemData();
				if(!(itemT.getClass().isAssignableFrom(ItemData.class)))
				{
					stream.throwTypeReadError(ItemData.class,itemT.getClass());
				}
				this.item.shadowCopy(itemT);
			}
		}
		else
		{
			this.item=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.way=stream.readInt();
		
		this.index=stream.readInt();
		
		this.item=(ItemData)stream.readDataSimpleNotNull();
		
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
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("item");
		writer.sb.append(':');
		if(this.item!=null)
		{
			this.item.writeDataString(writer);
		}
		else
		{
			writer.sb.append("ItemData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.way=0;
		this.index=0;
		this.item=null;
	}
	
}
