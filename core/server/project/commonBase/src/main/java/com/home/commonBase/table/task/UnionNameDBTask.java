package com.home.commonBase.table.task;
import com.home.commonBase.table.result.UnionNameDBResult;
import com.home.commonBase.table.table.UnionNameTable;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.task.BaseDBTask;

/** 工会名字表(generated by shine) */
public class UnionNameDBTask extends BaseDBTask
{
	/** 名字 */
	public String name="";
	
	/** 角色id */
	public long groupID;
	
	@Override
	public BaseTable createTable()
	{
		return new UnionNameTable();
	}
	
	@Override
	public BaseDBResult createResult()
	{
		return new UnionNameDBResult();
	}
	
	@Override
	protected void toSetValues(boolean isInsert)
	{
		setString(name);
		setLong(groupID);
	}
	
	@Override
	public Object getPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return name;
		}
		return null;
	}
	
	@Override
	protected void toSetPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
			{
				setString(name);
			}
				break;
		}
	}
	
}
