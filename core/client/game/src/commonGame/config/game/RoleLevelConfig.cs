using ShineEngine;

/// <summary>
/// 玩家等级表(generated by shine)
/// </summary>
public class RoleLevelConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<RoleLevelConfig> _dic;
	
	/// <summary>
	/// 等级
	/// </summary>
	public int level;
	
	/// <summary>
	/// 经验上限
	/// </summary>
	public long expMax;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static RoleLevelConfig get(int level)
	{
		return _dic.get(level);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<RoleLevelConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<RoleLevelConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<RoleLevelConfig> getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.level=stream.readInt();
		
		this.expMax=stream.readLong();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.level);
		
		stream.writeLong(this.expMax);
		
	}
	
}
