using ShineEngine;

/// <summary>
/// 获取成就奖励消息(generated by shine)
/// </summary>
public class GetAchievementRewardRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.GetAchievementReward;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	public GetAchievementRewardRequest()
	{
		_dataID=GameRequestType.GetAchievementReward;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "GetAchievementRewardRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("id");
		writer.sb.Append(':');
		writer.sb.Append(this.id);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.id=0;
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static GetAchievementRewardRequest create(int id)
	{
		GetAchievementRewardRequest re=(GetAchievementRewardRequest)BytesControl.createRequest(dataID);
		re.id=id;
		return re;
	}
	
}
