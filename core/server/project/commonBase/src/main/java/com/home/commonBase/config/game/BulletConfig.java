package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SMap;

/** bullet表(generated by shine) */
public class BulletConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<BulletConfig> _dic;
	
	/** 子弹ID */
	public int id;
	
	/** 攻击ID */
	public int attackID;
	
	/** 最大有效距离 */
	public float maxEnableDistance;
	
	/** 达到最大影响目标后是否保留 */
	public boolean keepAtMaxHit;
	
	/** 是否记录数值 */
	public boolean needRecordValue;
	
	/** 打击间隔(ms) */
	public int hitDelay;
	
	/** 发射偏移(x,y) */
	public float[] castOff;
	
	/** 是否不可被吸收 */
	public boolean cantAbsorb;
	
	/** 获取 */
	public static BulletConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<BulletConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<BulletConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.attackID=stream.readInt();
		
		this.maxEnableDistance=stream.readFloat();
		
		this.needRecordValue=stream.readBoolean();
		
		this.keepAtMaxHit=stream.readBoolean();
		
		this.cantAbsorb=stream.readBoolean();
		
		this.hitDelay=stream.readInt();
		
		int castOffLen=stream.readLen();
		if(this.castOff==null || this.castOff.length!=castOffLen)
		{
			this.castOff=new float[castOffLen];
		}
		float[] castOffT=this.castOff;
		for(int castOffI=0;castOffI<castOffLen;++castOffI)
		{
			float castOffV;
			castOffV=stream.readFloat();
			
			castOffT[castOffI]=castOffV;
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
		
		stream.writeInt(this.attackID);
		
		stream.writeFloat(this.maxEnableDistance);
		
		stream.writeBoolean(this.needRecordValue);
		
		stream.writeBoolean(this.keepAtMaxHit);
		
		stream.writeBoolean(this.cantAbsorb);
		
		stream.writeInt(this.hitDelay);
		
		if(this.castOff!=null)
		{
			float[] castOffT=this.castOff;
			stream.writeLen(castOffT.length);
			for(int castOffVI=0,castOffVLen=castOffT.length;castOffVI<castOffVLen;++castOffVI)
			{
				float castOffV=castOffT[castOffVI];
				stream.writeFloat(castOffV);
				
			}
		}
		else
		{
			nullObjError("castOff");
		}
		
	}
	
}
