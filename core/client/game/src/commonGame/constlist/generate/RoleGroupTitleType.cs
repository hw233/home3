using ShineEngine;

/// <summary>
/// 玩家群职位表(generated by shine)
/// </summary>
public class RoleGroupTitleType
{
	/// <summary>
	/// 群主
	/// </summary>
	public const int Leader=1;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=2;
	
	/// <summary>
	/// 是否可处理申请
	/// </summary>
	public static bool canOperateApply(int id)
	{
		return RoleGroupTitleConfig.get(id).canHandleApply;
	}
	
}
