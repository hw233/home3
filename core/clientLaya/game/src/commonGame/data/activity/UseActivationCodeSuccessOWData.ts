namespace Shine
{
	/** 使用激活码成功(generated by shine) */
	export class UseActivationCodeSuccessOWData extends PlayerWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.UseActivationCodeSuccessOW;
		
		/** 码 */
		public code:string;
		
		/** 码id */
		public id:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.UseActivationCodeSuccessOW;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.code=stream.readUTF();
			
			this.id=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeUTF(this.code);
			
			stream.writeInt(this.id);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof UseActivationCodeSuccessOWData))
				return;
			
			var mData:UseActivationCodeSuccessOWData=data as UseActivationCodeSuccessOWData;
			
			this.code=mData.code;
			this.id=mData.id;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof UseActivationCodeSuccessOWData))
				return;
			
			var mData:UseActivationCodeSuccessOWData=data as UseActivationCodeSuccessOWData;
			
			this.code=mData.code;
			
			this.id=mData.id;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}
