package com.home.commonBase.part.player.data;
import com.home.commonBase.constlist.generate.PlayerPartDataType;
import com.home.commonBase.data.mail.MailData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 邮件数据(generated by shine) */
public class MailPartData extends BaseData
{
	/** 邮件组 */
	public SList<MailData> mails;
	
	/** 上次游戏服邮件序号 */
	public int lastGameMailIndex;
	
	/** 数据类型ID */
	public static final int dataID=PlayerPartDataType.Mail;
	
	public MailPartData()
	{
		_dataID=PlayerPartDataType.Mail;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "MailPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int mailsLen=stream.readLen();
		if(this.mails!=null)
		{
			this.mails.clear();
			this.mails.ensureCapacity(mailsLen);
		}
		else
		{
			this.mails=new SList<MailData>(MailData[]::new,mailsLen);
		}
		
		SList<MailData> mailsT=this.mails;
		for(int mailsI=mailsLen-1;mailsI>=0;--mailsI)
		{
			MailData mailsV;
			BaseData mailsVT=stream.readDataFullNotNull();
			if(mailsVT!=null)
			{
				if(mailsVT instanceof MailData)
				{
					mailsV=(MailData)mailsVT;
				}
				else
				{
					mailsV=new MailData();
					if(!(mailsVT.getClass().isAssignableFrom(MailData.class)))
					{
						stream.throwTypeReadError(MailData.class,mailsVT.getClass());
					}
					mailsV.shadowCopy(mailsVT);
				}
			}
			else
			{
				mailsV=null;
			}
			
			mailsT.add(mailsV);
		}
		
		this.lastGameMailIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.mails!=null)
		{
			stream.writeLen(this.mails.size());
			if(!this.mails.isEmpty())
			{
				Object[] mailsVValues=this.mails.getValues();
				for(int mailsVI=0,mailsVLen=this.mails.length();mailsVI<mailsVLen;++mailsVI)
				{
					MailData mailsV=(MailData)mailsVValues[mailsVI];
					if(mailsV!=null)
					{
						stream.writeDataFullNotNull(mailsV);
					}
					else
					{
						nullObjError("mailsV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("mails");
		}
		
		stream.writeInt(this.lastGameMailIndex);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int mailsLen=stream.readLen();
		if(this.mails!=null)
		{
			this.mails.clear();
			this.mails.ensureCapacity(mailsLen);
		}
		else
		{
			this.mails=new SList<MailData>(MailData[]::new,mailsLen);
		}
		
		SList<MailData> mailsT=this.mails;
		for(int mailsI=mailsLen-1;mailsI>=0;--mailsI)
		{
			MailData mailsV;
			mailsV=(MailData)stream.readDataSimpleNotNull();
			
			mailsT.add(mailsV);
		}
		
		this.lastGameMailIndex=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.mails!=null)
		{
			stream.writeLen(this.mails.size());
			if(!this.mails.isEmpty())
			{
				Object[] mailsVValues=this.mails.getValues();
				for(int mailsVI=0,mailsVLen=this.mails.length();mailsVI<mailsVLen;++mailsVI)
				{
					MailData mailsV=(MailData)mailsVValues[mailsVI];
					if(mailsV!=null)
					{
						stream.writeDataSimpleNotNull(mailsV);
					}
					else
					{
						nullObjError("mailsV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("mails");
		}
		
		stream.writeInt(this.lastGameMailIndex);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof MailPartData))
			return;
		
		MailPartData mData=(MailPartData)data;
		
		this.mails=mData.mails;
		this.lastGameMailIndex=mData.lastGameMailIndex;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof MailPartData))
			return;
		
		MailPartData mData=(MailPartData)data;
		
		if(mData.mails!=null)
		{
			if(this.mails!=null)
			{
				this.mails.clear();
				this.mails.ensureCapacity(mData.mails.size());
			}
			else
			{
				this.mails=new SList<MailData>(MailData[]::new,mData.mails.size());
			}
			
			SList<MailData> mailsT=this.mails;
			if(!mData.mails.isEmpty())
			{
				Object[] mailsVValues=mData.mails.getValues();
				for(int mailsVI=0,mailsVLen=mData.mails.length();mailsVI<mailsVLen;++mailsVI)
				{
					MailData mailsV=(MailData)mailsVValues[mailsVI];
					MailData mailsU;
					if(mailsV!=null)
					{
						mailsU=(MailData)mailsV.clone();
					}
					else
					{
						mailsU=null;
						nullObjError("mailsU");
					}
					
					mailsT.add(mailsU);
				}
			}
		}
		else
		{
			this.mails=null;
			nullObjError("mails");
		}
		
		this.lastGameMailIndex=mData.lastGameMailIndex;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		MailPartData mData=(MailPartData)data;
		if(mData.mails!=null)
		{
			if(this.mails==null)
				return false;
			if(this.mails.size()!=mData.mails.size())
				return false;
			SList<MailData> mailsT=this.mails;
			SList<MailData> mailsR=mData.mails;
			int mailsLen=mailsT.size();
			for(int mailsI=0;mailsI<mailsLen;++mailsI)
			{
				MailData mailsU=mailsT.get(mailsI);
				MailData mailsV=mailsR.get(mailsI);
				if(mailsV!=null)
				{
					if(mailsU==null)
						return false;
					if(!mailsU.dataEquals(mailsV))
						return false;
				}
				else
				{
					if(mailsU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.mails!=null)
				return false;
		}
		
		if(this.lastGameMailIndex!=mData.lastGameMailIndex)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("mails");
		writer.sb.append(':');
		writer.sb.append("List<MailData>");
		if(this.mails!=null)
		{
			SList<MailData> mailsT=this.mails;
			int mailsLen=mailsT.size();
			writer.sb.append('(');
			writer.sb.append(mailsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int mailsI=0;mailsI<mailsLen;++mailsI)
			{
				MailData mailsV=mailsT.get(mailsI);
				writer.writeTabs();
				writer.sb.append(mailsI);
				writer.sb.append(':');
				if(mailsV!=null)
				{
					mailsV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("MailData=null");
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
		writer.sb.append("lastGameMailIndex");
		writer.sb.append(':');
		writer.sb.append(this.lastGameMailIndex);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.mails=new SList<MailData>(MailData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.mails=null;
		this.lastGameMailIndex=0;
	}
	
}
