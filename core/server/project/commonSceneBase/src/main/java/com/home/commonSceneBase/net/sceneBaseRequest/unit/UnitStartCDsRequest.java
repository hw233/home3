package com.home.commonSceneBase.net.sceneBaseRequest.unit;
import com.home.commonBase.data.scene.base.CDData;
import com.home.commonSceneBase.constlist.generate.SceneBaseRequestType;
import com.home.commonSceneBase.net.sceneBaseRequest.base.UnitSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 单位开始CD组(generated by shine) */
public class UnitStartCDsRequest extends UnitSRequest
{
	/** 数据类型ID */
	public static final int dataID=SceneBaseRequestType.UnitStartCDs;
	
	/** 冷却组 */
	public SList<CDData> cds;
	
	public UnitStartCDsRequest()
	{
		_dataID=SceneBaseRequestType.UnitStartCDs;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SList<CDData> cdsTemp=cds;
		if(cdsTemp!=null)
		{
			this.cds=new SList<CDData>(CDData[]::new,cdsTemp.size());
			SList<CDData> cdsT=this.cds;
			if(!cdsTemp.isEmpty())
			{
				Object[] cdsVValues=cdsTemp.getValues();
				for(int cdsVI=0,cdsVLen=cdsTemp.length();cdsVI<cdsVLen;++cdsVI)
				{
					CDData cdsV=(CDData)cdsVValues[cdsVI];
					CDData cdsU;
					if(cdsV!=null)
					{
						cdsU=new CDData();
						cdsU.copy(cdsV);
					}
					else
					{
						cdsU=null;
						nullObjError("cdsU");
					}
					
					cdsT.add(cdsU);
				}
			}
		}
		else
		{
			this.cds=null;
			nullObjError("cds");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitStartCDsRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("cds");
		writer.sb.append(':');
		writer.sb.append("List<CDData>");
		if(this.cds!=null)
		{
			SList<CDData> cdsT=this.cds;
			int cdsLen=cdsT.size();
			writer.sb.append('(');
			writer.sb.append(cdsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int cdsI=0;cdsI<cdsLen;++cdsI)
			{
				CDData cdsV=cdsT.get(cdsI);
				writer.writeTabs();
				writer.sb.append(cdsI);
				writer.sb.append(':');
				if(cdsV!=null)
				{
					cdsV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("CDData=null");
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
		
		if(this.cds!=null)
		{
			stream.writeLen(this.cds.size());
			if(!this.cds.isEmpty())
			{
				Object[] cdsVValues=this.cds.getValues();
				for(int cdsVI=0,cdsVLen=this.cds.length();cdsVI<cdsVLen;++cdsVI)
				{
					CDData cdsV=(CDData)cdsVValues[cdsVI];
					if(cdsV!=null)
					{
						cdsV.writeBytesFull(stream);
					}
					else
					{
						nullObjError("cdsV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("cds");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.cds!=null)
		{
			stream.writeLen(this.cds.size());
			if(!this.cds.isEmpty())
			{
				Object[] cdsVValues=this.cds.getValues();
				for(int cdsVI=0,cdsVLen=this.cds.length();cdsVI<cdsVLen;++cdsVI)
				{
					CDData cdsV=(CDData)cdsVValues[cdsVI];
					if(cdsV!=null)
					{
						cdsV.writeBytesSimple(stream);
					}
					else
					{
						nullObjError("cdsV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("cds");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		if(this.cds!=null)
		{
			if(!this.cds.isEmpty())
			{
				Object[] cdsVValues=this.cds.getValues();
				for(int cdsVI=0,cdsVLen=this.cds.length();cdsVI<cdsVLen;++cdsVI)
				{
					CDData cdsV=(CDData)cdsVValues[cdsVI];
					cdsV.release(pool);
					cdsV=null;
					cdsVValues[cdsVI]=null;
				}
			}
			this.cds.justClearSize();
		}
	}
	
	/** 创建实例 */
	public static UnitStartCDsRequest create(int instanceID,SList<CDData> cds)
	{
		UnitStartCDsRequest re=(UnitStartCDsRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.cds=cds;
		return re;
	}
	
}
