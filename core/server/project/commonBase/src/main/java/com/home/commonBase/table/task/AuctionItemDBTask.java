package com.home.commonBase.table.task;
import com.home.commonBase.table.result.AuctionItemDBResult;
import com.home.commonBase.table.table.AuctionItemTable;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.task.BaseDBTask;

/** 拍卖行表(generated by shine) */
public class AuctionItemDBTask extends BaseDBTask
{
	public long instanceID;
	
	/** 角色ID */
	public long playerID;
	
	/** 物品数据(其中的数目无用) */
	public byte[] data;
	
	/** 上架时间 */
	public long sellTime;
	
	/** 物品id */
	public int itemID;
	
	/** 物品等级 */
	public int itemLevel;
	
	/** 物品第二类型 */
	public int itemSecondType;
	
	/** 物品类型 */
	public int itemType;
	
	/** 物品单价 */
	public int price;
	
	/** 物品数目 */
	public int itemNum;
	
	@Override
	public BaseTable createTable()
	{
		return new AuctionItemTable();
	}
	
	@Override
	public BaseDBResult createResult()
	{
		return new AuctionItemDBResult();
	}
	
	@Override
	protected void toSetValues(boolean isInsert)
	{
		setLong(instanceID);
		setLong(playerID);
		setBytes(data);
		setLong(sellTime);
		setInt(itemID);
		setInt(itemLevel);
		setInt(itemType);
		setInt(itemSecondType);
		setInt(itemNum);
		setInt(price);
	}
	
	@Override
	public Object getPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return instanceID;
			case 1:
				return playerID;
			case 2:
				return itemID;
			case 3:
				return itemLevel;
			case 4:
				return itemType;
			case 5:
				return itemSecondType;
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
				setLong(instanceID);
			}
				break;
			case 1:
			{
				setLong(playerID);
			}
				break;
			case 2:
			{
				setInt(itemID);
			}
				break;
			case 3:
			{
				setInt(itemLevel);
			}
				break;
			case 4:
			{
				setInt(itemType);
			}
				break;
			case 5:
			{
				setInt(itemSecondType);
			}
				break;
		}
	}
	
}
