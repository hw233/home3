package com.home.commonBase.config.game.enumT;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.StringIntMap;

/** 客户端平台类型(generated by shine) */
public class ClientPlatformTypeConfig extends BaseConfig
{
	/** 存储集合 */
	private static ClientPlatformTypeConfig[] _dic;
	
	/** id */
	public int id;
	
	/** 名字 */
	public String name="";
	
	/** 获取 */
	public static ClientPlatformTypeConfig get(int id)
	{
		return id>=0 && id<_dic.length ? _dic[id] : null;
	}
	
	/** 设置字典 */
	public static void setDic(ClientPlatformTypeConfig[] dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static ClientPlatformTypeConfig[] getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.name=stream.readUTF();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.name);
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
	
	}
	
}
