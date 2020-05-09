package com.home.commonBase.table.result;
import com.home.shine.table.BaseDBResult;

/** 拍卖行表(generated by shine) */
public class AuctionItemDBResult extends BaseDBResult
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
	protected void toReadValues()
	{
		instanceID=readLong();
		playerID=readLong();
		data=readBytes();
		sellTime=readLong();
		itemID=readInt();
		itemLevel=readInt();
		itemType=readInt();
		itemSecondType=readInt();
		itemNum=readInt();
		price=readInt();
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
	
}
