package com.home.commonGame.net.request.scene.unit;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.scene.base.SceneSRequest;
import com.home.commonGame.net.request.scene.base.UnitSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntIntMap;
import com.home.shine.support.pool.DataPool;

/** 刷新单位造型消息(generated by shine) */
public class RefreshUnitAvatarRequest extends UnitSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.RefreshUnitAvatar;
	
	/** 模型ID */
	public int modelID;
	
	/** 改变组 */
	public IntIntMap parts;
	
	public RefreshUnitAvatarRequest()
	{
		_dataID=GameRequestType.RefreshUnitAvatar;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		IntIntMap partsTemp=parts;
		if(partsTemp!=null)
		{
			this.parts=new IntIntMap(partsTemp.size());
			IntIntMap partsT=this.parts;
			if(!partsTemp.isEmpty())
			{
				int partsKFreeValue=partsTemp.getFreeValue();
				long[] partsKTable=partsTemp.getTable();
				long partsKEntry;
				for(int partsKI=partsKTable.length-1;partsKI>=0;--partsKI)
				{
					partsKEntry=partsKTable[partsKI];
					int partsK=(int)partsKEntry;
					if(partsK!=partsKFreeValue)
					{
						int partsV=(int)(partsKEntry>>>32);
						int partsW;
						int partsU;
						partsW=partsK;
						
						partsU=partsV;
						
						partsT.put(partsW,partsU);
					}
				}
			}
		}
		else
		{
			this.parts=null;
			nullObjError("parts");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RefreshUnitAvatarRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("modelID");
		writer.sb.append(':');
		writer.sb.append(this.modelID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("parts");
		writer.sb.append(':');
		writer.sb.append("Map<int,int>");
		if(this.parts!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.parts.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.parts.isEmpty())
			{
				int partsKFreeValue=this.parts.getFreeValue();
				long[] partsKTable=this.parts.getTable();
				long partsKEntry;
				for(int partsKI=partsKTable.length-1;partsKI>=0;--partsKI)
				{
					partsKEntry=partsKTable[partsKI];
					int partsK=(int)partsKEntry;
					if(partsK!=partsKFreeValue)
					{
						int partsV=(int)(partsKEntry>>>32);
						writer.writeTabs();
						writer.sb.append(partsK);
						
						writer.sb.append(':');
						writer.sb.append(partsV);
						
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.modelID);
		
		if(this.parts!=null)
		{
			stream.writeLen(this.parts.size());
			if(!this.parts.isEmpty())
			{
				int partsKFreeValue=this.parts.getFreeValue();
				long[] partsKTable=this.parts.getTable();
				long partsKEntry;
				for(int partsKI=partsKTable.length-1;partsKI>=0;--partsKI)
				{
					partsKEntry=partsKTable[partsKI];
					int partsK=(int)partsKEntry;
					if(partsK!=partsKFreeValue)
					{
						int partsV=(int)(partsKEntry>>>32);
						stream.writeInt(partsK);
						
						stream.writeInt(partsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("parts");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.modelID);
		
		if(this.parts!=null)
		{
			stream.writeLen(this.parts.size());
			if(!this.parts.isEmpty())
			{
				int partsKFreeValue=this.parts.getFreeValue();
				long[] partsKTable=this.parts.getTable();
				long partsKEntry;
				for(int partsKI=partsKTable.length-1;partsKI>=0;--partsKI)
				{
					partsKEntry=partsKTable[partsKI];
					int partsK=(int)partsKEntry;
					if(partsK!=partsKFreeValue)
					{
						int partsV=(int)(partsKEntry>>>32);
						stream.writeInt(partsK);
						
						stream.writeInt(partsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("parts");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.modelID=0;
		if(this.parts!=null)
		{
			this.parts.clear();
		}
	}
	
	/** 创建实例 */
	public static RefreshUnitAvatarRequest create(int instanceID,int modelID,IntIntMap parts)
	{
		RefreshUnitAvatarRequest re=(RefreshUnitAvatarRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.modelID=modelID;
		re.parts=parts;
		return re;
	}
	
}
