package com.home.commonBase.data.social.chat;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.item.ItemData;
import com.home.commonBase.data.social.chat.ChatElementData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 物品聊天元素数据(generated by shine) */
public class ItemChatElementData extends ChatElementData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.ItemChatElement;
	
	/** 物品数据 */
	public ItemData data;
	
	public ItemChatElementData()
	{
		_dataID=BaseDataType.ItemChatElement;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ItemChatElementData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT instanceof ItemData)
			{
				this.data=(ItemData)dataT;
			}
			else
			{
				this.data=new ItemData();
				if(!(dataT.getClass().isAssignableFrom(ItemData.class)))
				{
					stream.throwTypeReadError(ItemData.class,dataT.getClass());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(ItemData)stream.readDataSimpleNotNull();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof ItemChatElementData))
			return;
		
		ItemChatElementData mData=(ItemChatElementData)data;
		
		this.data=mData.data;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof ItemChatElementData))
			return;
		
		ItemChatElementData mData=(ItemChatElementData)data;
		
		if(mData.data!=null)
		{
			this.data=(ItemData)mData.data.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		ItemChatElementData mData=(ItemChatElementData)data;
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
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("ItemData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
		this.data=new ItemData();
		this.data.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
}
