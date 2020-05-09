package com.home.commonBase.constlist.generate;

/** 子弹投掷类型(generated by shine) */
public class BulletCastType
{
	/** 立即 */
	public static final int Immediately=1;
	
	/** 固定时间,锁定目标单位 arg0:时间(ms) */
	public static final int LockTargetByTime=2;
	
	/** 固定时间,锁定目标地面 arg0:时间(ms) */
	public static final int LockGroundByTime=3;
	
	/** 固定速度追击,锁定目标单位 arg0:速度  */
	public static final int LockTargetBySpeed=4;
	
	/** 固定速度追击,锁定目标地面 arg0:速度  */
	public static final int LockGroundBySpeed=5;
	
	/** 直线碰撞 arg0:速度 arg1:最大距离 arg2:碰撞半径 [arg3:遇到障碍行为(0:无视,1:消失,2:反弹)] */
	public static final int HitStraight=6;
	
	/** 直线碰撞拓展 arg0:速度变量ID(千分位) arg1:最大距离变量ID(千分位) arg2:碰撞半径 [arg3:遇到障碍行为(0:无视,1:消失,2:反弹)] */
	public static final int HitStraightEx=7;
	
	/** 直线显示,纯客户端表现用 arg0:速度 arg1:最大距离 */
	public static final int StraightForShow=8;
	
	/** 自身范围碰撞圆形 arg0:时间(ms) arg1:碰撞半径 */
	public static final int HitSelfCircle=9;
	
	/** 自身范围碰撞矩形 arg0:时间(ms) arg1:碰撞长(纵向) arg2:碰撞宽(横向) */
	public static final int HitSelfRect=10;
	
	/** 长度 */
	public static int size=11;
	
}
