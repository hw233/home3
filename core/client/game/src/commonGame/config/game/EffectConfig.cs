using ShineEngine;

/// <summary>
/// 单位效果表(generated by shine)
/// </summary>
public class EffectConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<EffectConfig> _dic;
	
	/// <summary>
	/// effectID
	/// </summary>
	public int id;
	
	/// <summary>
	/// 是否一次性特效
	/// </summary>
	public bool isOnce;
	
	/// <summary>
	/// 是否朝向同步
	/// </summary>
	public bool isSyncDirection;
	
	/// <summary>
	/// 是否三段特效
	/// </summary>
	public bool isSME;
	
	/// <summary>
	/// 叠加上限
	/// </summary>
	public int plusMax;
	
	/// <summary>
	/// 资源
	/// </summary>
	public string source;
	
	/// <summary>
	/// 独立特效高度偏移
	/// </summary>
	public float heightOff;
	
	/// <summary>
	/// 资源(资源转)
	/// </summary>
	public int sourceT;
	
	/// <summary>
	/// 声音
	/// </summary>
	public string sound;
	
	/// <summary>
	/// 声音(资源转)
	/// </summary>
	public int soundT;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static EffectConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<EffectConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<EffectConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<EffectConfig> getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.isOnce=stream.readBoolean();
		
		this.isSME=stream.readBoolean();
		
		this.isSyncDirection=stream.readBoolean();
		
		this.plusMax=stream.readInt();
		
		this.source=stream.readUTF();
		
		this.sound=stream.readUTF();
		
		this.heightOff=stream.readFloat();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		sourceT=LoadControl.getResourceIDByName(source);
		soundT=LoadControl.getResourceIDByName(sound);
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeBoolean(this.isOnce);
		
		stream.writeBoolean(this.isSME);
		
		stream.writeBoolean(this.isSyncDirection);
		
		stream.writeInt(this.plusMax);
		
		stream.writeUTF(this.source);
		
		stream.writeUTF(this.sound);
		
		stream.writeFloat(this.heightOff);
		
	}
	
}
