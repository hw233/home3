package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;

/** 区域表(generated by shine) */
public class RegionConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<RegionConfig> _dic;
	
	/** id */
	public int id;
	
	/** 动作类型 */
	public int[][] actions;
	
	/** 是否客户端驱动 */
	public boolean isClientDrive;
	
	/** 是否是角色响应 */
	public boolean onlyCharacter;
	
	/** 是否响应任务 */
	public boolean needTaskEvent;
	
	/** 形状类型 */
	public int shapeType;
	
	/** 获取 */
	public static RegionConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<RegionConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<RegionConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.shapeType=stream.readInt();
		
		int actionsLen=stream.readLen();
		if(this.actions==null || this.actions.length!=actionsLen)
		{
			this.actions=new int[actionsLen][];
		}
		int[][] actionsT=this.actions;
		for(int actionsI=0;actionsI<actionsLen;++actionsI)
		{
			int[] actionsV;
			int actionsVLen=stream.readLen();
			actionsV=new int[actionsVLen];
			int[] actionsVT=actionsV;
			for(int actionsVI=0;actionsVI<actionsVLen;++actionsVI)
			{
				int actionsVV;
				actionsVV=stream.readInt();
				
				actionsVT[actionsVI]=actionsVV;
			}
			
			actionsT[actionsI]=actionsV;
		}
		
		this.isClientDrive=stream.readBoolean();
		
		this.onlyCharacter=stream.readBoolean();
		
		this.needTaskEvent=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.shapeType);
		
		if(this.actions!=null)
		{
			int[][] actionsT=this.actions;
			stream.writeLen(actionsT.length);
			for(int actionsVI=0,actionsVLen=actionsT.length;actionsVI<actionsVLen;++actionsVI)
			{
				int[] actionsV=actionsT[actionsVI];
				if(actionsV!=null)
				{
					int[] actionsVT=actionsV;
					stream.writeLen(actionsVT.length);
					for(int actionsVVI=0,actionsVVLen=actionsVT.length;actionsVVI<actionsVVLen;++actionsVVI)
					{
						int actionsVV=actionsVT[actionsVVI];
						stream.writeInt(actionsVV);
						
					}
				}
				else
				{
					nullObjError("actionsV");
				}
				
			}
		}
		else
		{
			nullObjError("actions");
		}
		
		stream.writeBoolean(this.isClientDrive);
		
		stream.writeBoolean(this.onlyCharacter);
		
		stream.writeBoolean(this.needTaskEvent);
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
}
