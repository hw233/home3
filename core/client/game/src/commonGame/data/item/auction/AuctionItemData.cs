using ShineEngine;

/// <summary>
/// 拍卖物品数据(generated by shine)
/// </summary>
public class AuctionItemData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.AuctionItem;
	
	/// <summary>
	/// 实例id
	/// </summary>
	public long instanceID;
	
	/// <summary>
	/// 角色ID
	/// </summary>
	public long playerID;
	
	/// <summary>
	/// 物品数据
	/// </summary>
	public ItemData data;
	
	/// <summary>
	/// 单价
	/// </summary>
	public int price;
	
	/// <summary>
	/// 上架时间
	/// </summary>
	public long sellTime;
	
	public AuctionItemData()
	{
		_dataID=BaseDataType.AuctionItem;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "AuctionItemData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.instanceID=stream.readLong();
		
		this.playerID=stream.readLong();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT is ItemData)
			{
				this.data=(ItemData)dataT;
			}
			else
			{
				this.data=new ItemData();
				if(!(dataT.GetType().IsAssignableFrom(typeof(ItemData))))
				{
					stream.throwTypeReadError(typeof(ItemData),dataT.GetType());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		this.sellTime=stream.readLong();
		
		this.price=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.instanceID);
		
		stream.writeLong(this.playerID);
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeLong(this.sellTime);
		
		stream.writeInt(this.price);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.instanceID=stream.readLong();
		
		this.playerID=stream.readLong();
		
		this.data=(ItemData)stream.readDataSimpleNotNull();
		
		this.sellTime=stream.readLong();
		
		this.price=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.instanceID);
		
		stream.writeLong(this.playerID);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeLong(this.sellTime);
		
		stream.writeInt(this.price);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is AuctionItemData))
			return;
		
		AuctionItemData mData=(AuctionItemData)data;
		
		this.instanceID=mData.instanceID;
		this.playerID=mData.playerID;
		this.data=mData.data;
		this.sellTime=mData.sellTime;
		this.price=mData.price;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is AuctionItemData))
			return;
		
		AuctionItemData mData=(AuctionItemData)data;
		
		this.instanceID=mData.instanceID;
		
		this.playerID=mData.playerID;
		
		if(mData.data!=null)
		{
			this.data=(ItemData)mData.data.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
		this.sellTime=mData.sellTime;
		
		this.price=mData.price;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		AuctionItemData mData=(AuctionItemData)data;
		if(this.instanceID!=mData.instanceID)
			return false;
		
		if(this.playerID!=mData.playerID)
			return false;
		
		if(mData.data!=null)
		{
			if(this.data==null)
				return false;
			if(!this.data.dataEquals(mData.data))
				return false;
		}
		else
		{
			if(this.data!=null)
				return false;
		}
		
		if(this.sellTime!=mData.sellTime)
			return false;
		
		if(this.price!=mData.price)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("instanceID");
		writer.sb.Append(':');
		writer.sb.Append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("playerID");
		writer.sb.Append(':');
		writer.sb.Append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("data");
		writer.sb.Append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("ItemData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("sellTime");
		writer.sb.Append(':');
		writer.sb.Append(this.sellTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("price");
		writer.sb.Append(':');
		writer.sb.Append(this.price);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.data=new ItemData();
		this.data.initDefault();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.instanceID=0L;
		this.playerID=0L;
		this.data=null;
		this.sellTime=0L;
		this.price=0;
	}
	
}
