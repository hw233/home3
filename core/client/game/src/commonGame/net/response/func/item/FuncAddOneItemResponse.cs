using ShineEngine;

/// <summary>
/// 推送添加单个物品(generated by shine)
/// </summary>
public class FuncAddOneItemResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncAddOneItem;
	
	/// <summary>
	/// 途径
	/// </summary>
	public int way;
	
	/// <summary>
	/// 序号
	/// </summary>
	public int index;
	
	/// <summary>
	/// 物品数据
	/// </summary>
	public ItemData item;
	
	public FuncAddOneItemResponse()
	{
		_dataID=GameResponseType.FuncAddOneItem;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.func.getBaseItemContainerTool(funcID).onAddItemByServer(index,item,way);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncAddOneItemResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.way=stream.readInt();
		
		this.index=stream.readInt();
		
		BaseData itemT=stream.readDataFullNotNull();
		if(itemT!=null)
		{
			if(itemT is ItemData)
			{
				this.item=(ItemData)itemT;
			}
			else
			{
				this.item=new ItemData();
				if(!(itemT.GetType().IsAssignableFrom(typeof(ItemData))))
				{
					stream.throwTypeReadError(typeof(ItemData),itemT.GetType());
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
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.way=stream.readInt();
		
		this.index=stream.readInt();
		
		this.item=(ItemData)stream.readDataSimpleNotNull();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("way");
		writer.sb.Append(':');
		writer.sb.Append(this.way);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("index");
		writer.sb.Append(':');
		writer.sb.Append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("item");
		writer.sb.Append(':');
		if(this.item!=null)
		{
			this.item.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("ItemData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.way=0;
		this.index=0;
		this.item=null;
	}
	
}
