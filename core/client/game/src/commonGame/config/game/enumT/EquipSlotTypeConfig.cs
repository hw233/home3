using ShineEngine;

/// <summary>
/// 装备槽位类型(generated by shine)
/// </summary>
public class EquipSlotTypeConfig:BaseConfig
{
	/** 存储集合 */
	private static EquipSlotTypeConfig[] _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 对应单位类型
	/// </summary>
	public int unitType;
	
	/// <summary>
	/// 是否默认开启
	/// </summary>
	public bool isOpen;
	
	/// <summary>
	/// 对应装备类型
	/// </summary>
	public int equipType;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static EquipSlotTypeConfig get(int id)
	{
		return id>=0 && id<_dic.Length ? _dic[id] : null;
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(EquipSlotTypeConfig[] dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(EquipSlotTypeConfig[] dic)
	{
		ObjectUtils.arrayPutAll(_dic,dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static EquipSlotTypeConfig[] getDic()
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
		
		this.equipType=stream.readInt();
		
		this.unitType=stream.readInt();
		
		this.isOpen=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.equipType);
		
		stream.writeInt(this.unitType);
		
		stream.writeBoolean(this.isOpen);
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
}
