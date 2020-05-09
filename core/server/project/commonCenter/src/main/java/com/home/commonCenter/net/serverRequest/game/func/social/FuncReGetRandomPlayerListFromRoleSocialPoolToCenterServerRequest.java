package com.home.commonCenter.net.serverRequest.game.func.social;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonCenter.net.serverRequest.game.func.base.FuncPlayerToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest extends FuncPlayerToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncReGetRandomPlayerListFromRoleSocialPoolToCenter;
	
	/** 回复数据组 */
	public SList<RoleSocialData> list;
	
	/** 获取参数(自行定义) */
	public int arg;
	
	public FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest()
	{
		_dataID=ServerMessageType.FuncReGetRandomPlayerListFromRoleSocialPoolToCenter;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SList<RoleSocialData> listTemp=list;
		if(listTemp!=null)
		{
			this.list=new SList<RoleSocialData>(RoleSocialData[]::new,listTemp.size());
			SList<RoleSocialData> listT=this.list;
			if(!listTemp.isEmpty())
			{
				Object[] listVValues=listTemp.getValues();
				for(int listVI=0,listVLen=listTemp.length();listVI<listVLen;++listVI)
				{
					RoleSocialData listV=(RoleSocialData)listVValues[listVI];
					RoleSocialData listU;
					if(listV!=null)
					{
						listU=(RoleSocialData)listV.clone();
					}
					else
					{
						listU=null;
						nullObjError("listU");
					}
					
					listT.add(listU);
				}
			}
		}
		else
		{
			this.list=null;
			nullObjError("list");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.list!=null)
		{
			stream.writeLen(this.list.size());
			if(!this.list.isEmpty())
			{
				Object[] listVValues=this.list.getValues();
				for(int listVI=0,listVLen=this.list.length();listVI<listVLen;++listVI)
				{
					RoleSocialData listV=(RoleSocialData)listVValues[listVI];
					if(listV!=null)
					{
						stream.writeDataSimpleNotNull(listV);
					}
					else
					{
						nullObjError("listV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("list");
		}
		
		stream.writeInt(this.arg);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("list");
		writer.sb.append(':');
		writer.sb.append("List<RoleSocialData>");
		if(this.list!=null)
		{
			SList<RoleSocialData> listT=this.list;
			int listLen=listT.size();
			writer.sb.append('(');
			writer.sb.append(listLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int listI=0;listI<listLen;++listI)
			{
				RoleSocialData listV=listT.get(listI);
				writer.writeTabs();
				writer.sb.append(listI);
				writer.sb.append(':');
				if(listV!=null)
				{
					listV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("RoleSocialData=null");
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
		writer.writeTabs();
		writer.sb.append("arg");
		writer.sb.append(':');
		writer.sb.append(this.arg);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		if(this.list!=null)
		{
			if(!this.list.isEmpty())
			{
				Object[] listVValues=this.list.getValues();
				for(int listVI=0,listVLen=this.list.length();listVI<listVLen;++listVI)
				{
					RoleSocialData listV=(RoleSocialData)listVValues[listVI];
					listV.release(pool);
					listV=null;
					listVValues[listVI]=null;
				}
			}
			this.list.justClearSize();
		}
		this.arg=0;
	}
	
	/** 创建实例 */
	public static FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest create(int funcID,SList<RoleSocialData> list,int arg)
	{
		FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest re=(FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.list=list;
		re.arg=arg;
		return re;
	}
	
}
