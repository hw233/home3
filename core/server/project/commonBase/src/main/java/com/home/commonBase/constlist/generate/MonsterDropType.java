package com.home.commonBase.constlist.generate;

/** 怪物掉落类型(generated by shine) */
public class MonsterDropType
{
	/** 无掉落 */
	public static final int None=0;
	
	/** 直接添加(包满无法再添加) */
	public static final int Add=1;
	
	/** 直接添加(包满邮件) */
	public static final int AddAbs=2;
	
	/** 物品类掉落(真) */
	public static final int Drop=3;
	
	/** 物品类走掉落包(真) */
	public static final int DropBag=4;
	
	/** 物品类掉落(仅自己可见) */
	public static final int SelfDrop=5;
	
	/** 物品类走掉落包(仅自己可见) */
	public static final int SelfDropBag=6;
	
	/** 仅自己可见掉落包，绑定单位(尸体) */
	public static final int SelfDropBagBindUnit=7;
	
	/** 长度 */
	public static int size=8;
	
}
