namespace Shine
{
	/** 创建玩家群事务(generated by shine) */
	export class CreateRoleGroupWData extends AreaGlobalWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.CreateRoleGroupW;
		
		/** 功能id */
		public funcID:number;
		
		/** 创建者社交数据 */
		public data:RoleSocialData;
		
		/** 创建数据 */
		public createData:CreateRoleGroupData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.CreateRoleGroupW;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.funcID=stream.readInt();
			
			this.data=stream.readDataSimpleNotNull() as RoleSocialData;
			
			this.createData=stream.readDataSimpleNotNull() as CreateRoleGroupData;
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.funcID);
			
			stream.writeDataSimpleNotNull(this.data);
			
			stream.writeDataSimpleNotNull(this.createData);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof CreateRoleGroupWData))
				return;
			
			var mData:CreateRoleGroupWData=data as CreateRoleGroupWData;
			
			this.funcID=mData.funcID;
			this.data=mData.data;
			this.createData=mData.createData;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof CreateRoleGroupWData))
				return;
			
			var mData:CreateRoleGroupWData=data as CreateRoleGroupWData;
			
			this.funcID=mData.funcID;
			
			this.data=mData.data.clone() as RoleSocialData;
			
			this.createData=mData.createData.clone() as CreateRoleGroupData;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.data=new RoleSocialData();
			this.data.initDefault();
			this.createData=new CreateRoleGroupData();
			this.createData.initDefault();
		}
		
	}
}
