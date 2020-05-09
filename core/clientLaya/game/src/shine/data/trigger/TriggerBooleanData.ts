namespace Shine
{
	/** (generated by shine) */
	export class TriggerBooleanData extends TriggerObjData
	{
		/** 数据类型ID */
		public static dataID:number=ShineDataType.TriggerBoolean;
		
		public value:boolean;
		
		constructor()
		{
			super();
			this._dataID=ShineDataType.TriggerBoolean;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "TriggerBooleanData";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			super.toReadBytesFull(stream);
			
			var position:number=BytesReadStream.getReadBytes(stream);
			
			this.value=stream.readBoolean();
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			super.toWriteBytesFull(stream);
			
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeBoolean(this.value);
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.value=stream.readBoolean();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeBoolean(this.value);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof TriggerBooleanData))
				return;
			
			var mData:TriggerBooleanData=data as TriggerBooleanData;
			
			this.value=mData.value;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof TriggerBooleanData))
				return;
			
			var mData:TriggerBooleanData=data as TriggerBooleanData;
			
			this.value=mData.value;
			
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			if(!super.toDataEquals(data))
				return false;
			
			var mData:TriggerBooleanData=data as TriggerBooleanData;
			if(this.value!=mData.value)
				return false;
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			super.toWriteDataString(writer);
			
			writer.writeTabs();
			writer.sb.append("value");
			writer.sb.append(':');
			writer.sb.append(this.value);
			
			writer.writeEnter();
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}
