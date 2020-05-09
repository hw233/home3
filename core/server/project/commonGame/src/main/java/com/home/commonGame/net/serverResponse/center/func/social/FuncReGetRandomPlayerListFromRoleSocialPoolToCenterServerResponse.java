package com.home.commonGame.net.serverResponse.center.func.social;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonGame.net.serverResponse.center.func.base.FuncPlayerToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerResponse extends FuncPlayerToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncReGetRandomPlayerListFromRoleSocialPoolToCenter;
	
	/** 回复数据组 */
	public SList<RoleSocialData> list;
	
	/** 获取参数(自行定义) */
	public int arg;
	
	public FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerResponse()
	{
		_dataID=ServerMessageType.FuncReGetRandomPlayerListFromRoleSocialPoolToCenter;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		int listLen=stream.readLen();
		if(this.list!=null)
		{
			this.list.clear();
			this.list.ensureCapacity(listLen);
		}
		else
		{
			this.list=new SList<RoleSocialData>(RoleSocialData[]::new,listLen);
		}
		
		SList<RoleSocialData> listT=this.list;
		for(int listI=listLen-1;listI>=0;--listI)
		{
			RoleSocialData listV;
			listV=(RoleSocialData)stream.readDataSimpleNotNull();
			
			listT.add(listV);
		}
		
		this.arg=stream.readInt();
		
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
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.social.onReGetRandomPlayerListFromRoleSocialPoolFromCenter(funcID,list,arg);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.list=null;
		this.arg=0;
	}
	
}
