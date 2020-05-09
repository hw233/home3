package com.home.commonBase.table.result;
import com.home.shine.data.DateData;
import com.home.shine.table.BaseDBResult;

/** 角色表(generated by shine) */
public class PlayerDBResult extends BaseDBResult
{
	/** 角色id */
	public long playerID;
	
	/** 名字 */
	public String name="";
	
	/** userID */
	public long userID;
	
	/** uid */
	public String uid="";
	
	/** 原区ID */
	public int createAreaID;
	
	/** 平台 */
	public String platform="";
	
	/** source版本 */
	public int sourceVersion;
	
	/** app版本 */
	public int appVersion;
	
	/** 创建日期 */
	public DateData createDate;
	
	/** 上次保存时间 */
	public DateData saveDate;
	
	/** 登录数据 */
	public byte[] loginData;
	
	/** 数据 */
	public byte[] data;
	
	/** 离线事务数据 */
	public byte[] offlineData;
	
	public PlayerDBResult()
	{
		
	}
	
	@Override
	protected void toReadValues()
	{
		playerID=readLong();
		name=readString();
		userID=readLong();
		createAreaID=readInt();
		uid=readString();
		platform=readString();
		appVersion=readInt();
		sourceVersion=readInt();
		createDate=readDate();
		saveDate=readDate();
		loginData=readBytes();
		data=readBytes();
		offlineData=readBytes();
	}
	
	@Override
	public Object getPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return playerID;
			case 1:
				return name;
			case 3:
				return uid;
		}
		
		return null;
	}
	
}
