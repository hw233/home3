package com.home.commonBase.data.social.roleGroup;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.func.FuncToolData;
import com.home.commonBase.data.social.roleGroup.InviteRoleGroupReceiveData;
import com.home.commonBase.data.social.roleGroup.PlayerApplyRoleGroupSelfData;
import com.home.commonBase.data.social.roleGroup.PlayerRoleGroupSaveData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.collection.LongQueue;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 玩家身上的玩家群工具数据(generated by shine) */
public class PlayerRoleGroupToolData extends FuncToolData
{
	/** 群数据组 */
	public LongObjectMap<PlayerRoleGroupSaveData> groups;
	
	/** 操作中占位数(废弃) */
	public int operateNum;
	
	/** 申请记录字典 */
	public LongObjectMap<PlayerApplyRoleGroupSelfData> applyDic;
	
	/** 被邀请时是否可直接入群(无需同意) */
	public boolean canInviteInAbs;
	
	/** 创建玩家群操作计数 */
	public LongQueue createOperateNums;
	
	/** 被邀请记录字典 */
	public SList<InviteRoleGroupReceiveData> inviteList;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.PlayerRoleGroupTool;
	
	public PlayerRoleGroupToolData()
	{
		_dataID=BaseDataType.PlayerRoleGroupTool;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerRoleGroupToolData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int groupsLen=stream.readLen();
		if(this.groups!=null)
		{
			this.groups.clear();
			this.groups.ensureCapacity(groupsLen);
		}
		else
		{
			this.groups=new LongObjectMap<PlayerRoleGroupSaveData>(PlayerRoleGroupSaveData[]::new,groupsLen);
		}
		
		LongObjectMap<PlayerRoleGroupSaveData> groupsT=this.groups;
		for(int groupsI=groupsLen-1;groupsI>=0;--groupsI)
		{
			PlayerRoleGroupSaveData groupsV;
			BaseData groupsVT=stream.readDataFullNotNull();
			if(groupsVT!=null)
			{
				if(groupsVT instanceof PlayerRoleGroupSaveData)
				{
					groupsV=(PlayerRoleGroupSaveData)groupsVT;
				}
				else
				{
					groupsV=new PlayerRoleGroupSaveData();
					if(!(groupsVT.getClass().isAssignableFrom(PlayerRoleGroupSaveData.class)))
					{
						stream.throwTypeReadError(PlayerRoleGroupSaveData.class,groupsVT.getClass());
					}
					groupsV.shadowCopy(groupsVT);
				}
			}
			else
			{
				groupsV=null;
			}
			
			groupsT.put(groupsV.groupID,groupsV);
		}
		
		this.operateNum=stream.readInt();
		
		int applyDicLen=stream.readLen();
		if(this.applyDic!=null)
		{
			this.applyDic.clear();
			this.applyDic.ensureCapacity(applyDicLen);
		}
		else
		{
			this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(PlayerApplyRoleGroupSelfData[]::new,applyDicLen);
		}
		
		LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
		for(int applyDicI=applyDicLen-1;applyDicI>=0;--applyDicI)
		{
			PlayerApplyRoleGroupSelfData applyDicV;
			BaseData applyDicVT=stream.readDataFullNotNull();
			if(applyDicVT!=null)
			{
				if(applyDicVT instanceof PlayerApplyRoleGroupSelfData)
				{
					applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVT;
				}
				else
				{
					applyDicV=new PlayerApplyRoleGroupSelfData();
					if(!(applyDicVT.getClass().isAssignableFrom(PlayerApplyRoleGroupSelfData.class)))
					{
						stream.throwTypeReadError(PlayerApplyRoleGroupSelfData.class,applyDicVT.getClass());
					}
					applyDicV.shadowCopy(applyDicVT);
				}
			}
			else
			{
				applyDicV=null;
			}
			
			applyDicT.put(applyDicV.data.groupID,applyDicV);
		}
		
		this.canInviteInAbs=stream.readBoolean();
		
		int createOperateNumsLen=stream.readLen();
		if(this.createOperateNums!=null)
		{
			this.createOperateNums.clear();
			this.createOperateNums.ensureCapacity(createOperateNumsLen);
		}
		else
		{
			this.createOperateNums=new LongQueue(createOperateNumsLen);
		}
		
		LongQueue createOperateNumsT=this.createOperateNums;
		for(int createOperateNumsI=createOperateNumsLen-1;createOperateNumsI>=0;--createOperateNumsI)
		{
			long createOperateNumsV;
			createOperateNumsV=stream.readLong();
			
			createOperateNumsT.offer(createOperateNumsV);
		}
		
		int inviteListLen=stream.readLen();
		if(this.inviteList!=null)
		{
			this.inviteList.clear();
			this.inviteList.ensureCapacity(inviteListLen);
		}
		else
		{
			this.inviteList=new SList<InviteRoleGroupReceiveData>(InviteRoleGroupReceiveData[]::new,inviteListLen);
		}
		
		SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
		for(int inviteListI=inviteListLen-1;inviteListI>=0;--inviteListI)
		{
			InviteRoleGroupReceiveData inviteListV;
			BaseData inviteListVT=stream.readDataFullNotNull();
			if(inviteListVT!=null)
			{
				if(inviteListVT instanceof InviteRoleGroupReceiveData)
				{
					inviteListV=(InviteRoleGroupReceiveData)inviteListVT;
				}
				else
				{
					inviteListV=new InviteRoleGroupReceiveData();
					if(!(inviteListVT.getClass().isAssignableFrom(InviteRoleGroupReceiveData.class)))
					{
						stream.throwTypeReadError(InviteRoleGroupReceiveData.class,inviteListVT.getClass());
					}
					inviteListV.shadowCopy(inviteListVT);
				}
			}
			else
			{
				inviteListV=null;
			}
			
			inviteListT.add(inviteListV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.groups!=null)
		{
			stream.writeLen(this.groups.size());
			if(!this.groups.isEmpty())
			{
				Object[] groupsVValues=this.groups.getValues();
				for(int groupsVI=groupsVValues.length-1;groupsVI>=0;--groupsVI)
				{
					if(groupsVValues[groupsVI]!=null)
					{
						PlayerRoleGroupSaveData groupsV=(PlayerRoleGroupSaveData)groupsVValues[groupsVI];
						if(groupsV!=null)
						{
							stream.writeDataFullNotNull(groupsV);
						}
						else
						{
							nullObjError("groupsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("groups");
		}
		
		stream.writeInt(this.operateNum);
		
		if(this.applyDic!=null)
		{
			stream.writeLen(this.applyDic.size());
			if(!this.applyDic.isEmpty())
			{
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.length-1;applyDicVI>=0;--applyDicVI)
				{
					if(applyDicVValues[applyDicVI]!=null)
					{
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicVI];
						if(applyDicV!=null)
						{
							stream.writeDataFullNotNull(applyDicV);
						}
						else
						{
							nullObjError("applyDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("applyDic");
		}
		
		stream.writeBoolean(this.canInviteInAbs);
		
		if(this.createOperateNums!=null)
		{
			stream.writeLen(this.createOperateNums.size());
			if(!this.createOperateNums.isEmpty())
			{
				long[] createOperateNumsVValues=this.createOperateNums.getValues();
				int createOperateNumsVMark=this.createOperateNums.getMark();
				int createOperateNumsVStart=this.createOperateNums.getStart();
				for(int createOperateNumsVI=0,createOperateNumsVLen=this.createOperateNums.length();createOperateNumsVI<createOperateNumsVLen;++createOperateNumsVI)
				{
					long createOperateNumsV=createOperateNumsVValues[(createOperateNumsVI+createOperateNumsVStart)&createOperateNumsVMark];
					stream.writeLong(createOperateNumsV);
					
				}
			}
		}
		else
		{
			nullObjError("createOperateNums");
		}
		
		if(this.inviteList!=null)
		{
			stream.writeLen(this.inviteList.size());
			if(!this.inviteList.isEmpty())
			{
				Object[] inviteListVValues=this.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=this.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=(InviteRoleGroupReceiveData)inviteListVValues[inviteListVI];
					if(inviteListV!=null)
					{
						stream.writeDataFullNotNull(inviteListV);
					}
					else
					{
						nullObjError("inviteListV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("inviteList");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		int groupsLen=stream.readLen();
		if(this.groups!=null)
		{
			this.groups.clear();
			this.groups.ensureCapacity(groupsLen);
		}
		else
		{
			this.groups=new LongObjectMap<PlayerRoleGroupSaveData>(PlayerRoleGroupSaveData[]::new,groupsLen);
		}
		
		LongObjectMap<PlayerRoleGroupSaveData> groupsT=this.groups;
		for(int groupsI=groupsLen-1;groupsI>=0;--groupsI)
		{
			PlayerRoleGroupSaveData groupsV;
			groupsV=(PlayerRoleGroupSaveData)stream.readDataSimpleNotNull();
			
			groupsT.put(groupsV.groupID,groupsV);
		}
		
		this.operateNum=stream.readInt();
		
		int applyDicLen=stream.readLen();
		if(this.applyDic!=null)
		{
			this.applyDic.clear();
			this.applyDic.ensureCapacity(applyDicLen);
		}
		else
		{
			this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(PlayerApplyRoleGroupSelfData[]::new,applyDicLen);
		}
		
		LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
		for(int applyDicI=applyDicLen-1;applyDicI>=0;--applyDicI)
		{
			PlayerApplyRoleGroupSelfData applyDicV;
			applyDicV=(PlayerApplyRoleGroupSelfData)stream.readDataSimpleNotNull();
			
			applyDicT.put(applyDicV.data.groupID,applyDicV);
		}
		
		this.canInviteInAbs=stream.readBoolean();
		
		int createOperateNumsLen=stream.readLen();
		if(this.createOperateNums!=null)
		{
			this.createOperateNums.clear();
			this.createOperateNums.ensureCapacity(createOperateNumsLen);
		}
		else
		{
			this.createOperateNums=new LongQueue(createOperateNumsLen);
		}
		
		LongQueue createOperateNumsT=this.createOperateNums;
		for(int createOperateNumsI=createOperateNumsLen-1;createOperateNumsI>=0;--createOperateNumsI)
		{
			long createOperateNumsV;
			createOperateNumsV=stream.readLong();
			
			createOperateNumsT.offer(createOperateNumsV);
		}
		
		int inviteListLen=stream.readLen();
		if(this.inviteList!=null)
		{
			this.inviteList.clear();
			this.inviteList.ensureCapacity(inviteListLen);
		}
		else
		{
			this.inviteList=new SList<InviteRoleGroupReceiveData>(InviteRoleGroupReceiveData[]::new,inviteListLen);
		}
		
		SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
		for(int inviteListI=inviteListLen-1;inviteListI>=0;--inviteListI)
		{
			InviteRoleGroupReceiveData inviteListV;
			inviteListV=(InviteRoleGroupReceiveData)stream.readDataSimpleNotNull();
			
			inviteListT.add(inviteListV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.groups!=null)
		{
			stream.writeLen(this.groups.size());
			if(!this.groups.isEmpty())
			{
				Object[] groupsVValues=this.groups.getValues();
				for(int groupsVI=groupsVValues.length-1;groupsVI>=0;--groupsVI)
				{
					if(groupsVValues[groupsVI]!=null)
					{
						PlayerRoleGroupSaveData groupsV=(PlayerRoleGroupSaveData)groupsVValues[groupsVI];
						if(groupsV!=null)
						{
							stream.writeDataSimpleNotNull(groupsV);
						}
						else
						{
							nullObjError("groupsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("groups");
		}
		
		stream.writeInt(this.operateNum);
		
		if(this.applyDic!=null)
		{
			stream.writeLen(this.applyDic.size());
			if(!this.applyDic.isEmpty())
			{
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.length-1;applyDicVI>=0;--applyDicVI)
				{
					if(applyDicVValues[applyDicVI]!=null)
					{
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicVI];
						if(applyDicV!=null)
						{
							stream.writeDataSimpleNotNull(applyDicV);
						}
						else
						{
							nullObjError("applyDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("applyDic");
		}
		
		stream.writeBoolean(this.canInviteInAbs);
		
		if(this.createOperateNums!=null)
		{
			stream.writeLen(this.createOperateNums.size());
			if(!this.createOperateNums.isEmpty())
			{
				long[] createOperateNumsVValues=this.createOperateNums.getValues();
				int createOperateNumsVMark=this.createOperateNums.getMark();
				int createOperateNumsVStart=this.createOperateNums.getStart();
				for(int createOperateNumsVI=0,createOperateNumsVLen=this.createOperateNums.length();createOperateNumsVI<createOperateNumsVLen;++createOperateNumsVI)
				{
					long createOperateNumsV=createOperateNumsVValues[(createOperateNumsVI+createOperateNumsVStart)&createOperateNumsVMark];
					stream.writeLong(createOperateNumsV);
					
				}
			}
		}
		else
		{
			nullObjError("createOperateNums");
		}
		
		if(this.inviteList!=null)
		{
			stream.writeLen(this.inviteList.size());
			if(!this.inviteList.isEmpty())
			{
				Object[] inviteListVValues=this.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=this.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=(InviteRoleGroupReceiveData)inviteListVValues[inviteListVI];
					if(inviteListV!=null)
					{
						stream.writeDataSimpleNotNull(inviteListV);
					}
					else
					{
						nullObjError("inviteListV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("inviteList");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof PlayerRoleGroupToolData))
			return;
		
		PlayerRoleGroupToolData mData=(PlayerRoleGroupToolData)data;
		
		this.groups=mData.groups;
		this.operateNum=mData.operateNum;
		this.applyDic=mData.applyDic;
		this.canInviteInAbs=mData.canInviteInAbs;
		this.createOperateNums=mData.createOperateNums;
		this.inviteList=mData.inviteList;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof PlayerRoleGroupToolData))
			return;
		
		PlayerRoleGroupToolData mData=(PlayerRoleGroupToolData)data;
		
		if(mData.groups!=null)
		{
			if(this.groups!=null)
			{
				this.groups.clear();
				this.groups.ensureCapacity(mData.groups.size());
			}
			else
			{
				this.groups=new LongObjectMap<PlayerRoleGroupSaveData>(PlayerRoleGroupSaveData[]::new,mData.groups.size());
			}
			
			LongObjectMap<PlayerRoleGroupSaveData> groupsT=this.groups;
			if(!mData.groups.isEmpty())
			{
				Object[] groupsVValues=mData.groups.getValues();
				for(int groupsVI=groupsVValues.length-1;groupsVI>=0;--groupsVI)
				{
					if(groupsVValues[groupsVI]!=null)
					{
						PlayerRoleGroupSaveData groupsV=(PlayerRoleGroupSaveData)groupsVValues[groupsVI];
						PlayerRoleGroupSaveData groupsU;
						if(groupsV!=null)
						{
							groupsU=(PlayerRoleGroupSaveData)groupsV.clone();
						}
						else
						{
							groupsU=null;
							nullObjError("groupsU");
						}
						
						groupsT.put(groupsU.groupID,groupsU);
					}
				}
			}
		}
		else
		{
			this.groups=null;
			nullObjError("groups");
		}
		
		this.operateNum=mData.operateNum;
		
		if(mData.applyDic!=null)
		{
			if(this.applyDic!=null)
			{
				this.applyDic.clear();
				this.applyDic.ensureCapacity(mData.applyDic.size());
			}
			else
			{
				this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(PlayerApplyRoleGroupSelfData[]::new,mData.applyDic.size());
			}
			
			LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
			if(!mData.applyDic.isEmpty())
			{
				Object[] applyDicVValues=mData.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.length-1;applyDicVI>=0;--applyDicVI)
				{
					if(applyDicVValues[applyDicVI]!=null)
					{
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicVI];
						PlayerApplyRoleGroupSelfData applyDicU;
						if(applyDicV!=null)
						{
							applyDicU=(PlayerApplyRoleGroupSelfData)applyDicV.clone();
						}
						else
						{
							applyDicU=null;
							nullObjError("applyDicU");
						}
						
						applyDicT.put(applyDicU.data.groupID,applyDicU);
					}
				}
			}
		}
		else
		{
			this.applyDic=null;
			nullObjError("applyDic");
		}
		
		this.canInviteInAbs=mData.canInviteInAbs;
		
		if(mData.createOperateNums!=null)
		{
			if(this.createOperateNums!=null)
			{
				this.createOperateNums.clear();
				this.createOperateNums.ensureCapacity(mData.createOperateNums.size());
			}
			else
			{
				this.createOperateNums=new LongQueue(mData.createOperateNums.size());
			}
			
			LongQueue createOperateNumsT=this.createOperateNums;
			if(!mData.createOperateNums.isEmpty())
			{
				long[] createOperateNumsVValues=mData.createOperateNums.getValues();
				int createOperateNumsVMark=mData.createOperateNums.getMark();
				int createOperateNumsVStart=mData.createOperateNums.getStart();
				for(int createOperateNumsVI=0,createOperateNumsVLen=mData.createOperateNums.length();createOperateNumsVI<createOperateNumsVLen;++createOperateNumsVI)
				{
					long createOperateNumsV=createOperateNumsVValues[(createOperateNumsVI+createOperateNumsVStart)&createOperateNumsVMark];
					long createOperateNumsU;
					createOperateNumsU=createOperateNumsV;
					
					createOperateNumsT.offer(createOperateNumsU);
				}
			}
		}
		else
		{
			this.createOperateNums=null;
			nullObjError("createOperateNums");
		}
		
		if(mData.inviteList!=null)
		{
			if(this.inviteList!=null)
			{
				this.inviteList.clear();
				this.inviteList.ensureCapacity(mData.inviteList.size());
			}
			else
			{
				this.inviteList=new SList<InviteRoleGroupReceiveData>(InviteRoleGroupReceiveData[]::new,mData.inviteList.size());
			}
			
			SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
			if(!mData.inviteList.isEmpty())
			{
				Object[] inviteListVValues=mData.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=mData.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=(InviteRoleGroupReceiveData)inviteListVValues[inviteListVI];
					InviteRoleGroupReceiveData inviteListU;
					if(inviteListV!=null)
					{
						inviteListU=(InviteRoleGroupReceiveData)inviteListV.clone();
					}
					else
					{
						inviteListU=null;
						nullObjError("inviteListU");
					}
					
					inviteListT.add(inviteListU);
				}
			}
		}
		else
		{
			this.inviteList=null;
			nullObjError("inviteList");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		PlayerRoleGroupToolData mData=(PlayerRoleGroupToolData)data;
		if(mData.groups!=null)
		{
			if(this.groups==null)
				return false;
			if(this.groups.size()!=mData.groups.size())
				return false;
			LongObjectMap<PlayerRoleGroupSaveData> groupsR=mData.groups;
			if(!this.groups.isEmpty())
			{
				long groupsKFreeValue=this.groups.getFreeValue();
				long[] groupsKKeys=this.groups.getKeys();
				Object[] groupsVValues=this.groups.getValues();
				for(int groupsKI=groupsKKeys.length-1;groupsKI>=0;--groupsKI)
				{
					long groupsK=groupsKKeys[groupsKI];
					if(groupsK!=groupsKFreeValue)
					{
						PlayerRoleGroupSaveData groupsV=(PlayerRoleGroupSaveData)groupsVValues[groupsKI];
						PlayerRoleGroupSaveData groupsU=groupsR.get(groupsK);
						if(groupsU!=null)
						{
							if(groupsV==null)
								return false;
							if(!groupsV.dataEquals(groupsU))
								return false;
						}
						else
						{
							if(groupsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.groups!=null)
				return false;
		}
		
		if(this.operateNum!=mData.operateNum)
			return false;
		
		if(mData.applyDic!=null)
		{
			if(this.applyDic==null)
				return false;
			if(this.applyDic.size()!=mData.applyDic.size())
				return false;
			LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicR=mData.applyDic;
			if(!this.applyDic.isEmpty())
			{
				long applyDicKFreeValue=this.applyDic.getFreeValue();
				long[] applyDicKKeys=this.applyDic.getKeys();
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicKI=applyDicKKeys.length-1;applyDicKI>=0;--applyDicKI)
				{
					long applyDicK=applyDicKKeys[applyDicKI];
					if(applyDicK!=applyDicKFreeValue)
					{
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicKI];
						PlayerApplyRoleGroupSelfData applyDicU=applyDicR.get(applyDicK);
						if(applyDicU!=null)
						{
							if(applyDicV==null)
								return false;
							if(!applyDicV.dataEquals(applyDicU))
								return false;
						}
						else
						{
							if(applyDicV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.applyDic!=null)
				return false;
		}
		
		if(this.canInviteInAbs!=mData.canInviteInAbs)
			return false;
		
		if(mData.createOperateNums!=null)
		{
			if(this.createOperateNums==null)
				return false;
			if(this.createOperateNums.size()!=mData.createOperateNums.size())
				return false;
			LongQueue createOperateNumsT=this.createOperateNums;
			LongQueue createOperateNumsR=mData.createOperateNums;
			int createOperateNumsLen=createOperateNumsT.size();
			for(int createOperateNumsI=0;createOperateNumsI<createOperateNumsLen;++createOperateNumsI)
			{
				long createOperateNumsU=createOperateNumsT.get(createOperateNumsI);
				long createOperateNumsV=createOperateNumsR.get(createOperateNumsI);
				if(createOperateNumsU!=createOperateNumsV)
					return false;
				
			}
		}
		else
		{
			if(this.createOperateNums!=null)
				return false;
		}
		
		if(mData.inviteList!=null)
		{
			if(this.inviteList==null)
				return false;
			if(this.inviteList.size()!=mData.inviteList.size())
				return false;
			SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
			SList<InviteRoleGroupReceiveData> inviteListR=mData.inviteList;
			int inviteListLen=inviteListT.size();
			for(int inviteListI=0;inviteListI<inviteListLen;++inviteListI)
			{
				InviteRoleGroupReceiveData inviteListU=inviteListT.get(inviteListI);
				InviteRoleGroupReceiveData inviteListV=inviteListR.get(inviteListI);
				if(inviteListV!=null)
				{
					if(inviteListU==null)
						return false;
					if(!inviteListU.dataEquals(inviteListV))
						return false;
				}
				else
				{
					if(inviteListU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.inviteList!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("groups");
		writer.sb.append(':');
		writer.sb.append("Map<long,PlayerRoleGroupSaveData>");
		if(this.groups!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.groups.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.groups.isEmpty())
			{
				long groupsKFreeValue=this.groups.getFreeValue();
				long[] groupsKKeys=this.groups.getKeys();
				Object[] groupsVValues=this.groups.getValues();
				for(int groupsKI=groupsKKeys.length-1;groupsKI>=0;--groupsKI)
				{
					long groupsK=groupsKKeys[groupsKI];
					if(groupsK!=groupsKFreeValue)
					{
						PlayerRoleGroupSaveData groupsV=(PlayerRoleGroupSaveData)groupsVValues[groupsKI];
						writer.writeTabs();
						writer.sb.append(groupsK);
						
						writer.sb.append(':');
						if(groupsV!=null)
						{
							groupsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("PlayerRoleGroupSaveData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("operateNum");
		writer.sb.append(':');
		writer.sb.append(this.operateNum);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("applyDic");
		writer.sb.append(':');
		writer.sb.append("Map<long,PlayerApplyRoleGroupSelfData>");
		if(this.applyDic!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.applyDic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.applyDic.isEmpty())
			{
				long applyDicKFreeValue=this.applyDic.getFreeValue();
				long[] applyDicKKeys=this.applyDic.getKeys();
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicKI=applyDicKKeys.length-1;applyDicKI>=0;--applyDicKI)
				{
					long applyDicK=applyDicKKeys[applyDicKI];
					if(applyDicK!=applyDicKFreeValue)
					{
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicKI];
						writer.writeTabs();
						writer.sb.append(applyDicK);
						
						writer.sb.append(':');
						if(applyDicV!=null)
						{
							applyDicV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("PlayerApplyRoleGroupSelfData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("canInviteInAbs");
		writer.sb.append(':');
		writer.sb.append(this.canInviteInAbs);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("createOperateNums");
		writer.sb.append(':');
		writer.sb.append("Queue<long>");
		if(this.createOperateNums!=null)
		{
			LongQueue createOperateNumsT=this.createOperateNums;
			int createOperateNumsLen=createOperateNumsT.size();
			writer.sb.append('(');
			writer.sb.append(createOperateNumsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int createOperateNumsI=0;createOperateNumsI<createOperateNumsLen;++createOperateNumsI)
			{
				long createOperateNumsV=createOperateNumsT.get(createOperateNumsI);
				writer.writeTabs();
				writer.sb.append(createOperateNumsI);
				writer.sb.append(':');
				writer.sb.append(createOperateNumsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("inviteList");
		writer.sb.append(':');
		writer.sb.append("List<InviteRoleGroupReceiveData>");
		if(this.inviteList!=null)
		{
			SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
			int inviteListLen=inviteListT.size();
			writer.sb.append('(');
			writer.sb.append(inviteListLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int inviteListI=0;inviteListI<inviteListLen;++inviteListI)
			{
				InviteRoleGroupReceiveData inviteListV=inviteListT.get(inviteListI);
				writer.writeTabs();
				writer.sb.append(inviteListI);
				writer.sb.append(':');
				if(inviteListV!=null)
				{
					inviteListV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("InviteRoleGroupReceiveData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
		this.groups=new LongObjectMap<PlayerRoleGroupSaveData>(PlayerRoleGroupSaveData[]::new);
		this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(PlayerApplyRoleGroupSelfData[]::new);
		this.createOperateNums=new LongQueue();
		this.inviteList=new SList<InviteRoleGroupReceiveData>(InviteRoleGroupReceiveData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groups=null;
		this.operateNum=0;
		this.applyDic=null;
		this.canInviteInAbs=false;
		this.createOperateNums=null;
		this.inviteList=null;
	}
	
}
