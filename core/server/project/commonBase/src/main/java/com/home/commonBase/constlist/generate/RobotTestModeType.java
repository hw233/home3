package com.home.commonBase.constlist.generate;

/** 机器人测试模式(generated by shine) */
public class RobotTestModeType
{
	/** 登录测试(只上线) */
	public static final int Login=1;
	
	/** 登录测试(上下线) */
	public static final int LoginOut=2;
	
	/** 登录挤号测试(开两个机器人进程进行测试) */
	public static final int LoginCrowed=3;
	
	/** 切换主城场景(上线后从给定场景中无限切换) */
	public static final int SwitchTown=4;
	
	/** 切换主城场景加登录上下线 */
	public static final int SwitchTownAndLoginOut=5;
	
	/** 切换主城场景加登录挤号 */
	public static final int SwitchTownAndLoginCrowed=6;
	
	/** 场景内随机找点移动 */
	public static final int RandomMove=7;
	
	/** 长度 */
	public static int size=8;
	
}
