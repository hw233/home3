using ShineEngine;

/// <summary>
/// 怪物表(generated by shine)
/// </summary>
public class MonsterConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<MonsterConfig> _dic;
	
	/// <summary>
	/// 战斗单位ID
	/// </summary>
	public int fightUnitID;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 掉落方式
	/// </summary>
	public int dropType;
	
	/// <summary>
	/// 掉落判定方式
	/// </summary>
	public int dropDecideType;
	
	/// <summary>
	/// 掉落范围方式
	/// </summary>
	public int dropScopeType;
	
	/// <summary>
	/// 是否退回原点时回血
	/// </summary>
	public bool needRecoverAtBack;
	
	/// <summary>
	/// 是否关闭AOI激活策略
	/// </summary>
	public bool notUseAOIActive;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/** 名字原值 */
	private string _name;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static MonsterConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<MonsterConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<MonsterConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<MonsterConfig> getDic()
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
		
		this.fightUnitID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.dropType=stream.readInt();
		
		this.dropDecideType=stream.readInt();
		
		this.dropScopeType=stream.readInt();
		
		this.needRecoverAtBack=stream.readBoolean();
		
		this.notUseAOIActive=stream.readBoolean();
		
	}
	
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		if(_name==null)
			_name=name;
		name=LanguageConfig.getText(_name);
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.fightUnitID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.dropType);
		
		stream.writeInt(this.dropDecideType);
		
		stream.writeInt(this.dropScopeType);
		
		stream.writeBoolean(this.needRecoverAtBack);
		
		stream.writeBoolean(this.notUseAOIActive);
		
	}
	
}
