namespace Shine
{
	/** 子弹数据(generated by shine) */
	export class BulletData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.Bullet;
		
		/** 实例ID */
		public instanceID:number;
		
		/** id */
		public id:number;
		
		/** 等级 */
		public level:number;
		
		/** 技能目标数据 */
		public targetData:SkillTargetData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.Bullet;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "BulletData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.instanceID=stream.readInt();
			
			this.id=stream.readInt();
			
			this.level=stream.readInt();
			
			this.targetData=stream.readDataSimpleNotNull() as SkillTargetData;
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.instanceID);
			
			stream.writeInt(this.id);
			
			stream.writeInt(this.level);
			
			stream.writeDataSimpleNotNull(this.targetData);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof BulletData))
				return;
			
			var mData:BulletData=data as BulletData;
			
			this.instanceID=mData.instanceID;
			this.id=mData.id;
			this.level=mData.level;
			this.targetData=mData.targetData;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof BulletData))
				return;
			
			var mData:BulletData=data as BulletData;
			
			this.instanceID=mData.instanceID;
			
			this.id=mData.id;
			
			this.level=mData.level;
			
			this.targetData=mData.targetData.clone() as SkillTargetData;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.targetData=new SkillTargetData();
			this.targetData.initDefault();
		}
		
	}
}
