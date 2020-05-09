package com.home.commonData.trigger.base;

public abstract class GuideT extends BaseT
{
	//--function--//
	//--int--//
	/** 获取主引导步 */
	protected int getGuideMainStep(){return 0;}
	
	//--event--//
	/** 游戏开始 */
	protected void onGameStart(){}
	
	//--action--//
	
	/** 设置主引导步 */
	protected void setGuideMainStep(int value){}
	/** 显示UI(key:UI表主键) */
	protected void showUI(int key){}
	/** 隐藏UI(key:UI表主键) */
	protected void hideUI(int key){}
}