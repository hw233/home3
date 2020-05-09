package com.home.commonBase.data.item.auction;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.system.CountData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SQueue;
import com.home.shine.support.pool.DataPool;

/** 拍卖行物品记录数据(generated by shine) */
public class AuctionItemRecordData extends BaseData
{
	/** 物品id */
	public int id;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.AuctionItemRecord;
	
	/** 当前价格 */
	public int price;
	
	/** 天数记录组 */
	public SQueue<CountData> days;
	
	public AuctionItemRecordData()
	{
		_dataID=BaseDataType.AuctionItemRecord;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "AuctionItemRecordData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.price=stream.readInt();
		
		int daysLen=stream.readLen();
		if(this.days!=null)
		{
			this.days.clear();
			this.days.ensureCapacity(daysLen);
		}
		else
		{
			this.days=new SQueue<CountData>(CountData[]::new,daysLen);
		}
		
		SQueue<CountData> daysT=this.days;
		for(int daysI=daysLen-1;daysI>=0;--daysI)
		{
			CountData daysV;
			BaseData daysVT=stream.readDataFullNotNull();
			if(daysVT!=null)
			{
				if(daysVT instanceof CountData)
				{
					daysV=(CountData)daysVT;
				}
				else
				{
					daysV=new CountData();
					if(!(daysVT.getClass().isAssignableFrom(CountData.class)))
					{
						stream.throwTypeReadError(CountData.class,daysVT.getClass());
					}
					daysV.shadowCopy(daysVT);
				}
			}
			else
			{
				daysV=null;
			}
			
			daysT.offer(daysV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.price);
		
		if(this.days!=null)
		{
			stream.writeLen(this.days.size());
			if(!this.days.isEmpty())
			{
				Object[] daysVValues=this.days.getValues();
				int daysVMark=this.days.getMark();
				int daysVStart=this.days.getStart();
				for(int daysVI=0,daysVLen=this.days.length();daysVI<daysVLen;++daysVI)
				{
					CountData daysV=(CountData)daysVValues[(daysVI+daysVStart)&daysVMark];
					if(daysV!=null)
					{
						stream.writeDataFullNotNull(daysV);
					}
					else
					{
						nullObjError("daysV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("days");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		this.price=stream.readInt();
		
		int daysLen=stream.readLen();
		if(this.days!=null)
		{
			this.days.clear();
			this.days.ensureCapacity(daysLen);
		}
		else
		{
			this.days=new SQueue<CountData>(CountData[]::new,daysLen);
		}
		
		SQueue<CountData> daysT=this.days;
		for(int daysI=daysLen-1;daysI>=0;--daysI)
		{
			CountData daysV;
			daysV=(CountData)stream.readDataSimpleNotNull();
			
			daysT.offer(daysV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		stream.writeInt(this.price);
		
		if(this.days!=null)
		{
			stream.writeLen(this.days.size());
			if(!this.days.isEmpty())
			{
				Object[] daysVValues=this.days.getValues();
				int daysVMark=this.days.getMark();
				int daysVStart=this.days.getStart();
				for(int daysVI=0,daysVLen=this.days.length();daysVI<daysVLen;++daysVI)
				{
					CountData daysV=(CountData)daysVValues[(daysVI+daysVStart)&daysVMark];
					if(daysV!=null)
					{
						stream.writeDataSimpleNotNull(daysV);
					}
					else
					{
						nullObjError("daysV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("days");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof AuctionItemRecordData))
			return;
		
		AuctionItemRecordData mData=(AuctionItemRecordData)data;
		
		this.id=mData.id;
		this.price=mData.price;
		this.days=mData.days;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof AuctionItemRecordData))
			return;
		
		AuctionItemRecordData mData=(AuctionItemRecordData)data;
		
		this.id=mData.id;
		
		this.price=mData.price;
		
		if(mData.days!=null)
		{
			if(this.days!=null)
			{
				this.days.clear();
				this.days.ensureCapacity(mData.days.size());
			}
			else
			{
				this.days=new SQueue<CountData>(CountData[]::new,mData.days.size());
			}
			
			SQueue<CountData> daysT=this.days;
			if(!mData.days.isEmpty())
			{
				Object[] daysVValues=mData.days.getValues();
				int daysVMark=mData.days.getMark();
				int daysVStart=mData.days.getStart();
				for(int daysVI=0,daysVLen=mData.days.length();daysVI<daysVLen;++daysVI)
				{
					CountData daysV=(CountData)daysVValues[(daysVI+daysVStart)&daysVMark];
					CountData daysU;
					if(daysV!=null)
					{
						daysU=(CountData)daysV.clone();
					}
					else
					{
						daysU=null;
						nullObjError("daysU");
					}
					
					daysT.offer(daysU);
				}
			}
		}
		else
		{
			this.days=null;
			nullObjError("days");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		AuctionItemRecordData mData=(AuctionItemRecordData)data;
		if(this.id!=mData.id)
			return false;
		
		if(this.price!=mData.price)
			return false;
		
		if(mData.days!=null)
		{
			if(this.days==null)
				return false;
			if(this.days.size()!=mData.days.size())
				return false;
			SQueue<CountData> daysT=this.days;
			SQueue<CountData> daysR=mData.days;
			int daysLen=daysT.size();
			for(int daysI=0;daysI<daysLen;++daysI)
			{
				CountData daysU=daysT.get(daysI);
				CountData daysV=daysR.get(daysI);
				if(daysV!=null)
				{
					if(daysU==null)
						return false;
					if(!daysU.dataEquals(daysV))
						return false;
				}
				else
				{
					if(daysU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.days!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("price");
		writer.sb.append(':');
		writer.sb.append(this.price);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("days");
		writer.sb.append(':');
		writer.sb.append("Queue<CountData>");
		if(this.days!=null)
		{
			SQueue<CountData> daysT=this.days;
			int daysLen=daysT.size();
			writer.sb.append('(');
			writer.sb.append(daysLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int daysI=0;daysI<daysLen;++daysI)
			{
				CountData daysV=daysT.get(daysI);
				writer.writeTabs();
				writer.sb.append(daysI);
				writer.sb.append(':');
				if(daysV!=null)
				{
					daysV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("CountData=null");
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
		this.days=new SQueue<CountData>(CountData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.id=0;
		this.price=0;
		this.days=null;
	}
	
}
