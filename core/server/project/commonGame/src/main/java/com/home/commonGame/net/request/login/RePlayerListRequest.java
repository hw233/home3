package com.home.commonGame.net.request.login;
import com.home.commonBase.data.login.PlayerLoginData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 回复角色列表消息(generated by shine) */
public class RePlayerListRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.RePlayerList;
	
	/** 角色列表 */
	public SList<PlayerLoginData> roles;
	
	/** 服务器出生码 */
	public int serverBornCode;
	
	public RePlayerListRequest()
	{
		_dataID=GameRequestType.RePlayerList;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SList<PlayerLoginData> rolesTemp=roles;
		if(rolesTemp!=null)
		{
			this.roles=new SList<PlayerLoginData>(PlayerLoginData[]::new,rolesTemp.size());
			SList<PlayerLoginData> rolesT=this.roles;
			if(!rolesTemp.isEmpty())
			{
				Object[] rolesVValues=rolesTemp.getValues();
				for(int rolesVI=0,rolesVLen=rolesTemp.length();rolesVI<rolesVLen;++rolesVI)
				{
					PlayerLoginData rolesV=(PlayerLoginData)rolesVValues[rolesVI];
					PlayerLoginData rolesU;
					if(rolesV!=null)
					{
						rolesU=(PlayerLoginData)rolesV.clone();
					}
					else
					{
						rolesU=null;
						nullObjError("rolesU");
					}
					
					rolesT.add(rolesU);
				}
			}
		}
		else
		{
			this.roles=null;
			nullObjError("roles");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RePlayerListRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("roles");
		writer.sb.append(':');
		writer.sb.append("List<PlayerLoginData>");
		if(this.roles!=null)
		{
			SList<PlayerLoginData> rolesT=this.roles;
			int rolesLen=rolesT.size();
			writer.sb.append('(');
			writer.sb.append(rolesLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int rolesI=0;rolesI<rolesLen;++rolesI)
			{
				PlayerLoginData rolesV=rolesT.get(rolesI);
				writer.writeTabs();
				writer.sb.append(rolesI);
				writer.sb.append(':');
				if(rolesV!=null)
				{
					rolesV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("PlayerLoginData=null");
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
		writer.sb.append("serverBornCode");
		writer.sb.append(':');
		writer.sb.append(this.serverBornCode);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.roles!=null)
		{
			stream.writeLen(this.roles.size());
			if(!this.roles.isEmpty())
			{
				Object[] rolesVValues=this.roles.getValues();
				for(int rolesVI=0,rolesVLen=this.roles.length();rolesVI<rolesVLen;++rolesVI)
				{
					PlayerLoginData rolesV=(PlayerLoginData)rolesVValues[rolesVI];
					if(rolesV!=null)
					{
						stream.writeDataFullNotNull(rolesV);
					}
					else
					{
						nullObjError("rolesV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("roles");
		}
		
		stream.writeInt(this.serverBornCode);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.roles!=null)
		{
			stream.writeLen(this.roles.size());
			if(!this.roles.isEmpty())
			{
				Object[] rolesVValues=this.roles.getValues();
				for(int rolesVI=0,rolesVLen=this.roles.length();rolesVI<rolesVLen;++rolesVI)
				{
					PlayerLoginData rolesV=(PlayerLoginData)rolesVValues[rolesVI];
					if(rolesV!=null)
					{
						stream.writeDataSimpleNotNull(rolesV);
					}
					else
					{
						nullObjError("rolesV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("roles");
		}
		
		stream.writeInt(this.serverBornCode);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.roles=null;
		this.serverBornCode=0;
	}
	
	/** 创建实例 */
	public static RePlayerListRequest create(SList<PlayerLoginData> roles,int serverBornCode)
	{
		RePlayerListRequest re=(RePlayerListRequest)BytesControl.createRequest(dataID);
		re.roles=roles;
		re.serverBornCode=serverBornCode;
		return re;
	}
	
}
