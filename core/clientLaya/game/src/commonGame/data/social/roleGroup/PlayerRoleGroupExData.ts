namespace Shine
{
	/** 玩家群补充数据(不实时推送的部分)(generated by shine) */
	export class PlayerRoleGroupExData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.PlayerRoleGroupEx;
		
		/** 群id */
		public groupID:number;
		
		/** 经验值 */
		public exp:number;
		
		/** 成员组 */
		public members:SMap<number,PlayerRoleGroupMemberData>;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.PlayerRoleGroupEx;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.groupID=stream.readLong();
			
			this.exp=stream.readLong();
			
			var membersLen:number=stream.readLen();
			if(this.members!=null)
			{
				this.members.clear();
				this.members.ensureCapacity(membersLen);
			}
			else
			{
				this.members=new SMap<number,PlayerRoleGroupMemberData>(membersLen);
			}
			
			var membersT:SMap<number,PlayerRoleGroupMemberData>=this.members;
			for(var membersI:number=membersLen-1;membersI>=0;--membersI)
			{
				var membersV:PlayerRoleGroupMemberData;
				membersV=stream.readDataSimpleNotNull() as PlayerRoleGroupMemberData;
				
				membersT.put(membersV.playerID,membersV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.groupID);
			
			stream.writeLong(this.exp);
			
			stream.writeLen(this.members.size());
			if(!this.members.isEmpty())
			{
				for(var membersV of this.members.getValues())
				{
					stream.writeDataSimpleNotNull(membersV);
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof PlayerRoleGroupExData))
				return;
			
			var mData:PlayerRoleGroupExData=data as PlayerRoleGroupExData;
			
			this.groupID=mData.groupID;
			this.exp=mData.exp;
			this.members=mData.members;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof PlayerRoleGroupExData))
				return;
			
			var mData:PlayerRoleGroupExData=data as PlayerRoleGroupExData;
			
			this.groupID=mData.groupID;
			
			this.exp=mData.exp;
			
			if(this.members!=null)
			{
				this.members.clear();
				this.members.ensureCapacity(mData.members.size());
			}
			else
			{
				this.members=new SMap<number,PlayerRoleGroupMemberData>(mData.members.size());
			}
			
			var membersT:SMap<number,PlayerRoleGroupMemberData>=this.members;
			if(!mData.members.isEmpty())
			{
				for(var membersV of mData.members.getValues())
				{
					var membersU:PlayerRoleGroupMemberData;
					membersU=membersV.clone() as PlayerRoleGroupMemberData;
					
					membersT.put(membersU.playerID,membersU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.members=new SMap<number,PlayerRoleGroupMemberData>();
		}
		
	}
}
