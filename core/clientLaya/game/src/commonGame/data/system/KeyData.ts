namespace Shine
{
	/** key数据(generated by shine) */
	export class KeyData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.Key;
		
		/** 主键 */
		public key:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.Key;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "KeyData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.key=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.key);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof KeyData))
				return;
			
			var mData:KeyData=data as KeyData;
			
			this.key=mData.key;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof KeyData))
				return;
			
			var mData:KeyData=data as KeyData;
			
			this.key=mData.key;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
