package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.DIntData;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SMap;

/** 初始化创建表(generated by shine) */
public class InitCreateConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<InitCreateConfig> _dic;
	
	/** 货币组 */
	public DIntData[] currency;
	
	/** 职业(主键) */
	public int vocation;
	
	/** 获取 */
	public static InitCreateConfig get(int vocation)
	{
		return _dic.get(vocation);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<InitCreateConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<InitCreateConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.vocation=stream.readInt();
		
		int currencyLen=stream.readLen();
		if(this.currency==null || this.currency.length!=currencyLen)
		{
			this.currency=new DIntData[currencyLen];
		}
		DIntData[] currencyT=this.currency;
		for(int currencyI=0;currencyI<currencyLen;++currencyI)
		{
			DIntData currencyV;
			currencyV=new DIntData();
			currencyV.readBytesSimple(stream);
			
			currencyT[currencyI]=currencyV;
		}
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.vocation);
		
		if(this.currency!=null)
		{
			DIntData[] currencyT=this.currency;
			stream.writeLen(currencyT.length);
			for(int currencyVI=0,currencyVLen=currencyT.length;currencyVI<currencyVLen;++currencyVI)
			{
				DIntData currencyV=currencyT[currencyVI];
				if(currencyV!=null)
				{
					currencyV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("currencyV");
				}
				
			}
		}
		else
		{
			nullObjError("currency");
		}
		
	}
	
}
