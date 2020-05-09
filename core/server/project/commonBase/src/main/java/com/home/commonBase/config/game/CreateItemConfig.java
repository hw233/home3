package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.DIntData;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SMap;

/** 创建单个物品配置(不包含数量)(generated by shine) */
public class CreateItemConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<CreateItemConfig> _dic;
	
	/** 是否绑定(或拾取后绑定) */
	public boolean isBind;
	
	/** 道具id(基础) */
	public int itemID;
	
	/** id */
	public int id;
	
	/** 参数组(dint数组) */
	public DIntData[] dintArgs;
	
	/** 获取 */
	public static CreateItemConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<CreateItemConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<CreateItemConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.itemID=stream.readInt();
		
		this.isBind=stream.readBoolean();
		
		int dintArgsLen=stream.readLen();
		if(this.dintArgs==null || this.dintArgs.length!=dintArgsLen)
		{
			this.dintArgs=new DIntData[dintArgsLen];
		}
		DIntData[] dintArgsT=this.dintArgs;
		for(int dintArgsI=0;dintArgsI<dintArgsLen;++dintArgsI)
		{
			DIntData dintArgsV;
			dintArgsV=new DIntData();
			dintArgsV.readBytesSimple(stream);
			
			dintArgsT[dintArgsI]=dintArgsV;
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
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.itemID);
		
		stream.writeBoolean(this.isBind);
		
		if(this.dintArgs!=null)
		{
			DIntData[] dintArgsT=this.dintArgs;
			stream.writeLen(dintArgsT.length);
			for(int dintArgsVI=0,dintArgsVLen=dintArgsT.length;dintArgsVI<dintArgsVLen;++dintArgsVI)
			{
				DIntData dintArgsV=dintArgsT[dintArgsVI];
				if(dintArgsV!=null)
				{
					dintArgsV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("dintArgsV");
				}
				
			}
		}
		else
		{
			nullObjError("dintArgs");
		}
		
	}
	
}
