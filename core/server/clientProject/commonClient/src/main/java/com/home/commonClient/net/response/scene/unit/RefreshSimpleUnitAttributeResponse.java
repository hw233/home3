package com.home.commonClient.net.response.scene.unit;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.commonClient.net.response.scene.base.SceneSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntIntMap;
import com.home.shine.support.pool.DataPool;

/** 刷新简版单位属性消息(generated by shine) */
public class RefreshSimpleUnitAttributeResponse extends SceneSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.RefreshSimpleUnitAttribute;
	
	public int instanceID;
	
	/** 改变的属性组 */
	public IntIntMap attributes;
	
	public RefreshSimpleUnitAttributeResponse()
	{
		_dataID=GameResponseType.RefreshSimpleUnitAttribute;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RefreshSimpleUnitAttributeResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		int attributesLen=stream.readLen();
		if(this.attributes!=null)
		{
			this.attributes.clear();
			this.attributes.ensureCapacity(attributesLen);
		}
		else
		{
			this.attributes=new IntIntMap(attributesLen);
		}
		
		IntIntMap attributesT=this.attributes;
		for(int attributesI=attributesLen-1;attributesI>=0;--attributesI)
		{
			int attributesK;
			int attributesV;
			attributesK=stream.readInt();
			
			attributesV=stream.readInt();
			
			attributesT.put(attributesK,attributesV);
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.instanceID=stream.readInt();
		
		int attributesLen=stream.readLen();
		if(this.attributes!=null)
		{
			this.attributes.clear();
			this.attributes.ensureCapacity(attributesLen);
		}
		else
		{
			this.attributes=new IntIntMap(attributesLen);
		}
		
		IntIntMap attributesT=this.attributes;
		for(int attributesI=attributesLen-1;attributesI>=0;--attributesI)
		{
			int attributesK;
			int attributesV;
			attributesK=stream.readInt();
			
			attributesV=stream.readInt();
			
			attributesT.put(attributesK,attributesV);
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("attributes");
		writer.sb.append(':');
		writer.sb.append("Map<int,int>");
		if(this.attributes!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.attributes.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				long[] attributesKTable=this.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						writer.writeTabs();
						writer.sb.append(attributesK);
						
						writer.sb.append(':');
						writer.sb.append(attributesV);
						
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
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.instanceID=0;
		this.attributes=null;
	}
	
}
