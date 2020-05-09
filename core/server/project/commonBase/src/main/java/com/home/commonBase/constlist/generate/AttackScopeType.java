package com.home.commonBase.constlist.generate;

/** 攻击范围类型(generated by shine) */
public class AttackScopeType
{
	/** 无目标 */
	public static final int None=0;
	
	/** 自身 */
	public static final int Self=1;
	
	/** 单体 */
	public static final int Single=2;
	
	/** 2D攻击矩形(act用)(arg0-3:x,y,width,height) */
	public static final int AttackRect=3;
	
	/** 自身圆形范围(arg0:半径,[arg1:高度]) */
	public static final int SelfCircle=11;
	
	/** 目标圆形范围(arg0:半径,[arg1:高度]) */
	public static final int TargetCircle=12;
	
	/** 自身矩形范围(arg0:长(纵向),arg1:宽(横向),[arg2:高度]) */
	public static final int SelfRect=13;
	
	/** 自身扇形范围(arg0:半径,arg1:扇角,[arg2:高度]) */
	public static final int SelfSector=14;
	
	/** 自身圆形范围内最近的几个目标(arg0:半径,arg1:目标数,[arg2:高度]) */
	public static final int SelfCircleNear=15;
	
	/** 自身圆形范围内随机的几个目标(arg0:半径,arg1:目标数,[arg2:高度]) */
	public static final int SelfCircleRandom=16;
	
	/** 自身圆形范围内最近的一个目标(arg0:半径,[arg1:高度]) */
	public static final int SelfNearest=17;
	
	/** 2D周身(act用)(arg0:半径,arg1:高度) */
	public static final int Around2D=21;
	
	/** 长度 */
	public static int size=22;
	
}
