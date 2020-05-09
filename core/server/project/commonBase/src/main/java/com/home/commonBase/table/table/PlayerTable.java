package com.home.commonBase.table.table;
import com.home.commonBase.constlist.generate.BaseTableType;
import com.home.commonBase.data.login.PlayerLoginData;
import com.home.commonBase.data.system.PlayerPrimaryKeyData;
import com.home.commonBase.data.system.PlayerWorkData;
import com.home.commonBase.data.system.PlayerWorkListData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.global.CommonSetting;
import com.home.commonBase.table.result.PlayerDBResult;
import com.home.commonBase.table.task.PlayerDBTask;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.DateData;
import com.home.shine.support.collection.SList;
import com.home.shine.support.func.ObjectCall;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.DBConnect;
import com.home.shine.table.task.BaseDBTask;
import com.home.shine.thread.AbstractThread;
import com.home.shine.utils.ObjectUtils;

/** 角色表(generated by shine) */
public class PlayerTable extends BaseTable
{
	/** userID */
	public long userID;
	
	/** 创建日期 */
	public DateData createDate;
	
	/** 平台 */
	public String platform="";
	
	/** 原区ID */
	public int createAreaID;
	
	/** uid */
	public String uid="";
	
	/** 名字 */
	public String name="";
	
	/** source版本 */
	public int sourceVersion;
	
	/** app版本 */
	public int appVersion;
	
	/** 角色id */
	public long playerID;
	
	/** 上次保存时间 */
	public DateData saveDate;
	
	/** 数据 */
	public byte[] data;
	
	/** 登录数据 */
	public byte[] loginData;
	
	/** 离线事务数据 */
	public byte[] offlineData;
	
	/** 查询头 */
	private static final String _selectStr="select `playerID`,`name`,`userID`,`createAreaID`,`uid`,`platform`,`appVersion`,`sourceVersion`,`createDate`,`saveDate`,`loginData`,`data`,`offlineData` from `player`";
	
	/** 保留时间(s) */
	public int keepTime;
	
	/** 是否需要写库 */
	public boolean needWrite=true;
	
	/** 增 */
	private static final String _insertStr="insert into `player` (`playerID`,`name`,`userID`,`createAreaID`,`uid`,`platform`,`appVersion`,`sourceVersion`,`createDate`,`saveDate`,`loginData`,`data`,`offlineData` ) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	/** 删 */
	private static final String _deleteStr="delete from `player` where `playerID` = ?";
	
	/** 改 */
	private static final String _updateStr="update `player` set `playerID` = ?,`name` = ?,`userID` = ?,`createAreaID` = ?,`uid` = ?,`platform` = ?,`appVersion` = ?,`sourceVersion` = ?,`createDate` = ?,`saveDate` = ?,`loginData` = ?,`data` = ?,`offlineData` = ? where `playerID` = ?";
	
	/** 读取后的登录数据 */
	public PlayerLoginData loginDataT;
	
	/** 离线事务列表(DB读写) */
	public SList<PlayerWorkData> offlineWorkDataListT;
	
	/** 离线事务列表(主线程) */
	public SList<PlayerWorkData> offlineWorkDataListMain;
	
	/** 离线事务脏 */
	public boolean offlineWorkDirty=false;
	
	/** 查0 */
	private static final String _selectInStr0="select `playerID`,`name`,`userID`,`createAreaID`,`uid`,`platform`,`appVersion`,`sourceVersion`,`createDate`,`saveDate`,`loginData`,`data`,`offlineData` from `player` where `playerID` in (";
	
	/** 查1 */
	private static final String _selectInStr1="select `playerID`,`name`,`userID`,`createAreaID`,`uid`,`platform`,`appVersion`,`sourceVersion`,`createDate`,`saveDate`,`loginData`,`data`,`offlineData` from `player` where `name` in (";
	
	/** 查3 */
	private static final String _selectInStr3="select `playerID`,`name`,`userID`,`createAreaID`,`uid`,`platform`,`appVersion`,`sourceVersion`,`createDate`,`saveDate`,`loginData`,`data`,`offlineData` from `player` where `uid` in (";
	
	/** 查2 */
	private static final String _selectInStr2="select `playerID`,`name`,`userID`,`createAreaID`,`uid`,`platform`,`appVersion`,`sourceVersion`,`createDate`,`saveDate`,`loginData`,`data`,`offlineData` from `player` where `userID` = ? and `createAreaID` = ?;";
	
	public PlayerTable()
	{
		_dataID=BaseTableType.Player;
	}
	
	/** 查2 */
	public void refreshKeepTime()
	{
		keepTime=CommonSetting.playerTableKeepTime;
		//同时刷写标记
		needWrite=true;
	}
	
	@Override
	public String getInsertStr()
	{
		return _insertStr;
	}
	
	@Override
	public String getDeleteStr()
	{
		return _deleteStr;
	}
	
	@Override
	public String getUpdateStr()
	{
		return _updateStr;
	}
	
	@Override
	public String getSelectStr()
	{
		return _selectStr;
	}
	
	@Override
	public String getSelectInStrByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return _selectInStr0;
			case 1:
				return _selectInStr1;
			case 2:
				return _selectInStr2;
			case 3:
				return _selectInStr3;
		}
		
		return null;
	}
	
	@Override
	protected BaseDBTask createTask()
	{
		PlayerDBTask task=new PlayerDBTask();
		task.playerID=this.playerID;
		task.name=this.name;
		task.userID=this.userID;
		task.createAreaID=this.createAreaID;
		task.uid=this.uid;
		task.platform=this.platform;
		task.appVersion=this.appVersion;
		task.sourceVersion=this.sourceVersion;
		task.createDate=this.createDate;
		task.saveDate=this.saveDate;
		task.loginData=this.loginData;
		task.data=this.data;
		task.offlineData=this.offlineData;
		return task;
	}
	
	@Override
	public void readByResult(BaseDBResult result)
	{
		PlayerDBResult re=(PlayerDBResult)result;
		this.playerID=re.playerID;
		this.name=re.name;
		this.userID=re.userID;
		this.createAreaID=re.createAreaID;
		this.uid=re.uid;
		this.platform=re.platform;
		this.appVersion=re.appVersion;
		this.sourceVersion=re.sourceVersion;
		this.createDate=re.createDate;
		this.saveDate=re.saveDate;
		this.loginData=re.loginData;
		this.data=re.data;
		this.offlineData=re.offlineData;
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
	public void afterRead()
	{
		BytesReadStream stream=BytesReadStream.create();
		
		loginDataT=BaseC.factory.createPlayerLoginData();
		stream.setBuf(loginData);
		loginDataT.readBytesFull(stream);
		
		if(CommonSetting.offlineWorkUseTable)
		{
			stream.setBuf(offlineData);
			PlayerWorkListData data=new PlayerWorkListData();
			data.readBytesFull(stream);
			offlineWorkDataListT=data.list;
			
			offlineWorkDataListMain=new SList<>(PlayerWorkData[]::new);
			offlineWorkDataListMain.addAll(offlineWorkDataListT);
		}
	}
	
	/** 读取一组通过uid和createAreaID */
	public void loadByUserIDAndCreateAreaID(DBConnect connect,long userID,int createAreaID,ObjectCall<SList<BaseTable>> overCall,AbstractThread thread)
	{
		this.userID=userID;
		this.createAreaID=createAreaID;
		this.loadCustomKeys(connect,2,overCall,thread);
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		this.name=stream.readUTF();
		
		this.userID=stream.readLong();
		
		this.createAreaID=stream.readInt();
		
		this.uid=stream.readUTF();
		
		this.platform=stream.readUTF();
		
		this.appVersion=stream.readInt();
		
		this.sourceVersion=stream.readInt();
		
		this.createDate=new DateData();
		this.createDate.readBytesFull(stream);
		
		this.saveDate=new DateData();
		this.saveDate.readBytesFull(stream);
		
		int loginDataLen=stream.readLen();
		this.loginData=stream.readByteArr(loginDataLen);
		
		int dataLen=stream.readLen();
		this.data=stream.readByteArr(dataLen);
		
		int offlineDataLen=stream.readLen();
		this.offlineData=stream.readByteArr(offlineDataLen);
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		stream.writeUTF(this.name);
		
		stream.writeLong(this.userID);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeUTF(this.uid);
		
		stream.writeUTF(this.platform);
		
		stream.writeInt(this.appVersion);
		
		stream.writeInt(this.sourceVersion);
		
		if(this.createDate!=null)
		{
			this.createDate.writeBytesFull(stream);
		}
		else
		{
			nullObjError("createDate");
		}
		
		if(this.saveDate!=null)
		{
			this.saveDate.writeBytesFull(stream);
		}
		else
		{
			nullObjError("saveDate");
		}
		
		if(this.loginData!=null)
		{
			stream.writeLen(this.loginData.length);
			stream.writeByteArr(this.loginData);
		}
		else
		{
			nullObjError("loginData");
		}
		
		if(this.data!=null)
		{
			stream.writeLen(this.data.length);
			stream.writeByteArr(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		if(this.offlineData!=null)
		{
			stream.writeLen(this.offlineData.length);
			stream.writeByteArr(this.offlineData);
		}
		else
		{
			nullObjError("offlineData");
		}
		
		stream.endWriteObj();
	}
	
	public PlayerPrimaryKeyData createPrimaryKeyData()
	{
		PlayerPrimaryKeyData re=new PlayerPrimaryKeyData();
		re.playerID=playerID;
		re.userID=userID;
		re.name=name;
		re.uid=uid;
		re.userID=userID;
		re.createAreaID=createAreaID;
		re.platform=platform;
		return re;
	}
	
	/** 更新离线事务 */
	public boolean refreshOfflineWork()
	{
		if(offlineWorkDirty)
		{
			offlineWorkDirty=false;
			
			offlineWorkDataListT.clear();
			offlineWorkDataListT.addAll(offlineWorkDataListMain);
			
			return true;
		}
		
		return false;
	}
	
	/** 清空离线事务 */
	public void clearOfflineWork()
	{
		if(CommonSetting.offlineWorkUseTable)
		{
			if(offlineWorkDirty)
			{
				offlineWorkDirty=false;
				offlineWorkDataListT.clear();
				offlineWorkDataListMain.clear();
				offlineData=ObjectUtils.EmptyByteArr;
			}
		}
	}
	
}
