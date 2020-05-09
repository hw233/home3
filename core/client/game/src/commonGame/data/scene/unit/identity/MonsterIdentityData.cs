using ShineEngine;

/// <summary>
/// 怪物身份数据(generated by shine)
/// </summary>
public class MonsterIdentityData:FightUnitIdentityData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.MonsterIdentity;
	
	public MonsterIdentityData()
	{
		_dataID=BaseDataType.MonsterIdentity;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "MonsterIdentityData";
	}
	
	public override int getFightUnitID()
	{
		return MonsterConfig.get(id).fightUnitID;
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
}
