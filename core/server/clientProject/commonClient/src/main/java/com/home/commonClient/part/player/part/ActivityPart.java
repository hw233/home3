package com.home.commonClient.part.player.part;
import com.home.commonBase.data.activity.ActivityData;
import com.home.commonBase.part.player.clientData.ActivityClientPartData;
import com.home.commonClient.part.player.base.PlayerBasePart;
import com.home.shine.data.BaseData;

/** 活动(generated by shine) */
public class ActivityPart extends PlayerBasePart
{
	/** 数据 */
	private ActivityClientPartData _d;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(ActivityClientPartData)data;
	}
	
	/** 获取数据 */
	public ActivityClientPartData getPartData()
	{
		return _d;
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		
	}
	
	/** 初始化(创建后刚调用,与dispose成对) */
	@Override
	public void init()
	{
		
	}
	
	/** 析构(回池前调用,与init成对) */
	@Override
	public void dispose()
	{
		
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		ActivityData[] values;
		ActivityData v;
		
		for(int i=(values=_d.datas.getValues()).length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				v.makeConfig();
			}
		}
	}
	
	/** 功能开启(id:功能ID) */
	@Override
	public void onFunctionOpen(int id)
	{
		
	}
	
	/** 功能关闭(id:功能ID) */
	@Override
	public void onFunctionClose(int id)
	{
		
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new ActivityClientPartData();
	}
	
}
