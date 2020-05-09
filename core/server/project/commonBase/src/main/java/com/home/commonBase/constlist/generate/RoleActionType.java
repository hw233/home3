package com.home.commonBase.constlist.generate;

/** 角色行为类型(generated by shine) */
public class RoleActionType
{
	/** 主角添加固定属性 arg1:属性类型,arg2:属性值(当前属性) */
	public static final int HeroAddAttribute=1;
	
	/** 主角添加变量属性 arg1:属性类型,arg2:变量ID(当前属性) */
	public static final int HeroAddAttributeVar=2;
	
	/** 主角添加buff arg1:buffID arg2:buff等级 */
	public static final int HeroAddBuff=3;
	
	/** 添加货币 arg1:货币类型 arg2:数目 */
	public static final int AddCurrency=4;
	
	/** 添加奖励 arg1:奖励id */
	public static final int AddReward=5;
	
	/** 移除道具 arg1:道具id  arg2:道具数量 */
	public static final int RemoveItem=6;
	
	/** 长度 */
	public static int size=7;
	
}
