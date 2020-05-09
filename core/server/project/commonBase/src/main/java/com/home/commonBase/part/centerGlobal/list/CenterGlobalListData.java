package com.home.commonBase.part.centerGlobal.list;
import com.home.commonBase.constlist.generate.CenterGlobalListDataType;
import com.home.commonBase.part.centerGlobal.data.CenterActivityPartData;
import com.home.commonBase.part.centerGlobal.data.CenterFuncPartData;
import com.home.commonBase.part.centerGlobal.data.CenterMailPartData;
import com.home.commonBase.part.centerGlobal.data.CenterSocialPartData;
import com.home.commonBase.part.centerGlobal.data.CenterSystemPartData;
import com.home.commonBase.part.centerGlobal.data.CenterUnionPartData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 中心服全局数据(generated by shine) */
public class CenterGlobalListData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=CenterGlobalListDataType.CenterGlobal;
	
	/** 社交数据 */
	public CenterSocialPartData social;
	
	/** 通用功能数据 */
	public CenterFuncPartData func;
	
	/** 活动数据 */
	public CenterActivityPartData activity;
	
	/** 邮件数据 */
	public CenterMailPartData mail;
	
	/** 中心服宗门数据 */
	public CenterUnionPartData union;
	
	/** 系统数据 */
	public CenterSystemPartData system;
	
	public CenterGlobalListData()
	{
		_dataID=CenterGlobalListDataType.CenterGlobal;
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData systemT=stream.readDataFullNotNull();
		if(systemT!=null)
		{
			if(systemT instanceof CenterSystemPartData)
			{
				this.system=(CenterSystemPartData)systemT;
			}
			else
			{
				this.system=new CenterSystemPartData();
				if(!(systemT.getClass().isAssignableFrom(CenterSystemPartData.class)))
				{
					stream.throwTypeReadError(CenterSystemPartData.class,systemT.getClass());
				}
				this.system.shadowCopy(systemT);
			}
		}
		else
		{
			this.system=null;
		}
		
		BaseData socialT=stream.readDataFullNotNull();
		if(socialT!=null)
		{
			if(socialT instanceof CenterSocialPartData)
			{
				this.social=(CenterSocialPartData)socialT;
			}
			else
			{
				this.social=new CenterSocialPartData();
				if(!(socialT.getClass().isAssignableFrom(CenterSocialPartData.class)))
				{
					stream.throwTypeReadError(CenterSocialPartData.class,socialT.getClass());
				}
				this.social.shadowCopy(socialT);
			}
		}
		else
		{
			this.social=null;
		}
		
		BaseData funcT=stream.readDataFullNotNull();
		if(funcT!=null)
		{
			if(funcT instanceof CenterFuncPartData)
			{
				this.func=(CenterFuncPartData)funcT;
			}
			else
			{
				this.func=new CenterFuncPartData();
				if(!(funcT.getClass().isAssignableFrom(CenterFuncPartData.class)))
				{
					stream.throwTypeReadError(CenterFuncPartData.class,funcT.getClass());
				}
				this.func.shadowCopy(funcT);
			}
		}
		else
		{
			this.func=null;
		}
		
		BaseData activityT=stream.readDataFullNotNull();
		if(activityT!=null)
		{
			if(activityT instanceof CenterActivityPartData)
			{
				this.activity=(CenterActivityPartData)activityT;
			}
			else
			{
				this.activity=new CenterActivityPartData();
				if(!(activityT.getClass().isAssignableFrom(CenterActivityPartData.class)))
				{
					stream.throwTypeReadError(CenterActivityPartData.class,activityT.getClass());
				}
				this.activity.shadowCopy(activityT);
			}
		}
		else
		{
			this.activity=null;
		}
		
		BaseData mailT=stream.readDataFullNotNull();
		if(mailT!=null)
		{
			if(mailT instanceof CenterMailPartData)
			{
				this.mail=(CenterMailPartData)mailT;
			}
			else
			{
				this.mail=new CenterMailPartData();
				if(!(mailT.getClass().isAssignableFrom(CenterMailPartData.class)))
				{
					stream.throwTypeReadError(CenterMailPartData.class,mailT.getClass());
				}
				this.mail.shadowCopy(mailT);
			}
		}
		else
		{
			this.mail=null;
		}
		
		BaseData unionT=stream.readDataFullNotNull();
		if(unionT!=null)
		{
			if(unionT instanceof CenterUnionPartData)
			{
				this.union=(CenterUnionPartData)unionT;
			}
			else
			{
				this.union=new CenterUnionPartData();
				if(!(unionT.getClass().isAssignableFrom(CenterUnionPartData.class)))
				{
					stream.throwTypeReadError(CenterUnionPartData.class,unionT.getClass());
				}
				this.union.shadowCopy(unionT);
			}
		}
		else
		{
			this.union=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.system!=null)
		{
			stream.writeDataFullNotNull(this.system);
		}
		else
		{
			nullObjError("system");
		}
		
		if(this.social!=null)
		{
			stream.writeDataFullNotNull(this.social);
		}
		else
		{
			nullObjError("social");
		}
		
		if(this.func!=null)
		{
			stream.writeDataFullNotNull(this.func);
		}
		else
		{
			nullObjError("func");
		}
		
		if(this.activity!=null)
		{
			stream.writeDataFullNotNull(this.activity);
		}
		else
		{
			nullObjError("activity");
		}
		
		if(this.mail!=null)
		{
			stream.writeDataFullNotNull(this.mail);
		}
		else
		{
			nullObjError("mail");
		}
		
		if(this.union!=null)
		{
			stream.writeDataFullNotNull(this.union);
		}
		else
		{
			nullObjError("union");
		}
		
		stream.endWriteObj();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterGlobalListData";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.system=(CenterSystemPartData)stream.readDataSimpleNotNull();
		
		this.social=(CenterSocialPartData)stream.readDataSimpleNotNull();
		
		this.func=(CenterFuncPartData)stream.readDataSimpleNotNull();
		
		this.activity=(CenterActivityPartData)stream.readDataSimpleNotNull();
		
		this.mail=(CenterMailPartData)stream.readDataSimpleNotNull();
		
		this.union=(CenterUnionPartData)stream.readDataSimpleNotNull();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.system!=null)
		{
			stream.writeDataSimpleNotNull(this.system);
		}
		else
		{
			nullObjError("system");
		}
		
		if(this.social!=null)
		{
			stream.writeDataSimpleNotNull(this.social);
		}
		else
		{
			nullObjError("social");
		}
		
		if(this.func!=null)
		{
			stream.writeDataSimpleNotNull(this.func);
		}
		else
		{
			nullObjError("func");
		}
		
		if(this.activity!=null)
		{
			stream.writeDataSimpleNotNull(this.activity);
		}
		else
		{
			nullObjError("activity");
		}
		
		if(this.mail!=null)
		{
			stream.writeDataSimpleNotNull(this.mail);
		}
		else
		{
			nullObjError("mail");
		}
		
		if(this.union!=null)
		{
			stream.writeDataSimpleNotNull(this.union);
		}
		else
		{
			nullObjError("union");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof CenterGlobalListData))
			return;
		
		CenterGlobalListData mData=(CenterGlobalListData)data;
		
		this.system=mData.system;
		this.social=mData.social;
		this.func=mData.func;
		this.activity=mData.activity;
		this.mail=mData.mail;
		this.union=mData.union;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof CenterGlobalListData))
			return;
		
		CenterGlobalListData mData=(CenterGlobalListData)data;
		
		if(mData.system!=null)
		{
			this.system=(CenterSystemPartData)mData.system.clone();
		}
		else
		{
			this.system=null;
			nullObjError("system");
		}
		
		if(mData.social!=null)
		{
			this.social=(CenterSocialPartData)mData.social.clone();
		}
		else
		{
			this.social=null;
			nullObjError("social");
		}
		
		if(mData.func!=null)
		{
			this.func=(CenterFuncPartData)mData.func.clone();
		}
		else
		{
			this.func=null;
			nullObjError("func");
		}
		
		if(mData.activity!=null)
		{
			this.activity=(CenterActivityPartData)mData.activity.clone();
		}
		else
		{
			this.activity=null;
			nullObjError("activity");
		}
		
		if(mData.mail!=null)
		{
			this.mail=(CenterMailPartData)mData.mail.clone();
		}
		else
		{
			this.mail=null;
			nullObjError("mail");
		}
		
		if(mData.union!=null)
		{
			this.union=(CenterUnionPartData)mData.union.clone();
		}
		else
		{
			this.union=null;
			nullObjError("union");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		CenterGlobalListData mData=(CenterGlobalListData)data;
		if(mData.system!=null)
		{
			if(this.system==null)
				return false;
			if(!this.system.dataEquals(mData.system))
				return false;
		}
		else
		{
			if(this.system!=null)
				return false;
		}
		
		if(mData.social!=null)
		{
			if(this.social==null)
				return false;
			if(!this.social.dataEquals(mData.social))
				return false;
		}
		else
		{
			if(this.social!=null)
				return false;
		}
		
		if(mData.func!=null)
		{
			if(this.func==null)
				return false;
			if(!this.func.dataEquals(mData.func))
				return false;
		}
		else
		{
			if(this.func!=null)
				return false;
		}
		
		if(mData.activity!=null)
		{
			if(this.activity==null)
				return false;
			if(!this.activity.dataEquals(mData.activity))
				return false;
		}
		else
		{
			if(this.activity!=null)
				return false;
		}
		
		if(mData.mail!=null)
		{
			if(this.mail==null)
				return false;
			if(!this.mail.dataEquals(mData.mail))
				return false;
		}
		else
		{
			if(this.mail!=null)
				return false;
		}
		
		if(mData.union!=null)
		{
			if(this.union==null)
				return false;
			if(!this.union.dataEquals(mData.union))
				return false;
		}
		else
		{
			if(this.union!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("system");
		writer.sb.append(':');
		if(this.system!=null)
		{
			this.system.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CenterSystemPartData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("social");
		writer.sb.append(':');
		if(this.social!=null)
		{
			this.social.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CenterSocialPartData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("func");
		writer.sb.append(':');
		if(this.func!=null)
		{
			this.func.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CenterFuncPartData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("activity");
		writer.sb.append(':');
		if(this.activity!=null)
		{
			this.activity.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CenterActivityPartData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("mail");
		writer.sb.append(':');
		if(this.mail!=null)
		{
			this.mail.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CenterMailPartData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("union");
		writer.sb.append(':');
		if(this.union!=null)
		{
			this.union.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CenterUnionPartData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.system=null;
		this.social=null;
		this.func=null;
		this.activity=null;
		this.mail=null;
		this.union=null;
	}
	
}
