package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SMap;

/** 场景特效表(generated by shine) */
public class SceneEffectConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<SceneEffectConfig> _dic;
	
	/** id */
	public int id;
	
	/** 自动移除时间(未实现)(ms) */
	public int autoRemoveTime;
	
	/** 获取 */
	public static SceneEffectConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<SceneEffectConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<SceneEffectConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.autoRemoveTime=stream.readInt();
		
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
		
		stream.writeInt(this.autoRemoveTime);
		
	}
	
}
