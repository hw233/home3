package com.home.commonGame.net.request.func.rank;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncReGetSelfPageShowRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncReGetSelfPageShow;
	
	/** 页码 */
	public int page;
	
	/** 数据组 */
	public SList<BaseData> list;
	
	public FuncReGetSelfPageShowRequest()
	{
		_dataID=GameRequestType.FuncReGetSelfPageShow;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SList<BaseData> listTemp=list;
		if(listTemp!=null)
		{
			this.list=new SList<BaseData>(BaseData[]::new,listTemp.size());
			SList<BaseData> listT=this.list;
			if(!listTemp.isEmpty())
			{
				Object[] listVValues=listTemp.getValues();
				for(int listVI=0,listVLen=listTemp.length();listVI<listVLen;++listVI)
				{
					BaseData listV=(BaseData)listVValues[listVI];
					BaseData listU;
					if(listV!=null)
					{
						listU=(BaseData)listV.clone();
					}
					else
					{
						listU=null;
					}
					
					listT.add(listU);
				}
			}
		}
		else
		{
			this.list=null;
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncReGetSelfPageShowRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("page");
		writer.sb.append(':');
		writer.sb.append(this.page);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("list");
		writer.sb.append(':');
		writer.sb.append("List<BaseData>");
		if(this.list!=null)
		{
			SList<BaseData> listT=this.list;
			int listLen=listT.size();
			writer.sb.append('(');
			writer.sb.append(listLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int listI=0;listI<listLen;++listI)
			{
				BaseData listV=listT.get(listI);
				writer.writeTabs();
				writer.sb.append(listI);
				writer.sb.append(':');
				if(listV!=null)
				{
					listV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("BaseData=null");
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.page);
		
		if(this.list!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.list.size());
			if(!this.list.isEmpty())
			{
				Object[] listVValues=this.list.getValues();
				for(int listVI=0,listVLen=this.list.length();listVI<listVLen;++listVI)
				{
					BaseData listV=(BaseData)listVValues[listVI];
					if(listV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataFullNotNull(listV);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.page);
		
		if(this.list!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.list.size());
			if(!this.list.isEmpty())
			{
				Object[] listVValues=this.list.getValues();
				for(int listVI=0,listVLen=this.list.length();listVI<listVLen;++listVI)
				{
					BaseData listV=(BaseData)listVValues[listVI];
					if(listV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataSimpleNotNull(listV);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.page=0;
		if(this.list!=null)
		{
			if(!this.list.isEmpty())
			{
				Object[] listVValues=this.list.getValues();
				for(int listVI=0,listVLen=this.list.length();listVI<listVLen;++listVI)
				{
					BaseData listV=(BaseData)listVValues[listVI];
					if(listV!=null)
					{
						listV.release(pool);
						listV=null;
					}
					listVValues[listVI]=null;
				}
			}
			this.list.justClearSize();
		}
	}
	
	/** 创建实例 */
	public static FuncReGetSelfPageShowRequest create(int funcID,int page,SList<BaseData> list)
	{
		FuncReGetSelfPageShowRequest re=(FuncReGetSelfPageShowRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.page=page;
		re.list=list;
		return re;
	}
	
}
