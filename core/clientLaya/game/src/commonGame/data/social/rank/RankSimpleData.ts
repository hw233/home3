namespace Shine
{
	/** 简单排名数据(generated by shine) */
	export class RankSimpleData extends FuncToolData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.RankSimple;
		
		/** 排名(从1开始) */
		public rank:number;
		
		/** 排行值(如以后一个值不够用,再补,理论上应该是够的) */
		public value:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.RankSimple;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RankSimpleData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.rank=stream.readInt();
			
			this.value=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.rank);
			
			stream.writeLong(this.value);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof RankSimpleData))
				return;
			
			var mData:RankSimpleData=data as RankSimpleData;
			
			this.rank=mData.rank;
			this.value=mData.value;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof RankSimpleData))
				return;
			
			var mData:RankSimpleData=data as RankSimpleData;
			
			this.rank=mData.rank;
			
			this.value=mData.value;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}
