package com.home.commonGame.net.request.role.munit;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.commonGame.net.request.role.munit.MUnitSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntIntMap;
import com.home.shine.support.pool.DataPool;

/** 控制单位刷新造型消息(generated by shine) */
public class MUnitRefreshAvatarRequest extends MUnitSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.MUnitRefreshAvatar;
	
	/** 模型ID */
	public int modelID;
	
	/** 改变组 */
	public IntIntMap parts;
	
	public MUnitRefreshAvatarRequest()
	{
		_dataID=GameRequestType.MUnitRefreshAvatar;
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
		return "MUnitRefreshAvatarRequest";
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
	public static MUnitRefreshAvatarRequest create(int mIndex,int modelID,IntIntMap parts)
	{
		MUnitRefreshAvatarRequest re=(MUnitRefreshAvatarRequest)BytesControl.createRequest(dataID);
		re.mIndex=mIndex;
		re.modelID=modelID;
		re.parts=parts;
		return re;
	}
	
}
