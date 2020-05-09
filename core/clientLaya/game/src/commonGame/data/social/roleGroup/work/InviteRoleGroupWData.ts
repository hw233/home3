namespace Shine
{
	/** 邀请进入玩家群消息(generated by shine) */
	export class InviteRoleGroupWData extends PlayerFuncWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.InviteRoleGroupW;
		
		/** 邀请者 */
		public inviter:RoleShowData;
		
		/** 玩家群简版数据 */
		public simpleData:RoleGroupSimpleData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.InviteRoleGroupW;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.inviter=stream.readDataSimpleNotNull() as RoleShowData;
			
			if(stream.readBoolean())
			{
				this.simpleData=stream.readDataSimpleNotNull() as RoleGroupSimpleData;
			}
			else
			{
				this.simpleData=null;
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.inviter);
			
			if(this.simpleData!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.simpleData);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof InviteRoleGroupWData))
				return;
			
			var mData:InviteRoleGroupWData=data as InviteRoleGroupWData;
			
			this.inviter=mData.inviter;
			this.simpleData=mData.simpleData;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof InviteRoleGroupWData))
				return;
			
			var mData:InviteRoleGroupWData=data as InviteRoleGroupWData;
			
			this.inviter=mData.inviter.clone() as RoleShowData;
			
			if(mData.simpleData!=null)
			{
				this.simpleData=mData.simpleData.clone() as RoleGroupSimpleData;
			}
			else
			{
				this.simpleData=null;
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.inviter=new RoleShowData();
			this.inviter.initDefault();
		}
		
	}
}
