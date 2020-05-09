namespace Shine
{
	/** 区服客户端数据(generated by shine) */
	export class AreaClientData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.AreaClient;
		
		/** 游戏服ID */
		public areaID:number;
		
		/** 名字 */
		public name:string;
		
		/** 存在标记 */
		public mark:boolean;
		
		/** 负载值 */
		public load:number=0;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.AreaClient;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "AreaClientData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.areaID=stream.readInt();
			
			this.name=stream.readUTF();
			
			this.load=stream.readInt();
			
			this.mark=stream.readBoolean();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.areaID);
			
			stream.writeUTF(this.name);
			
			stream.writeInt(this.load);
			
			stream.writeBoolean(this.mark);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof AreaClientData))
				return;
			
			var mData:AreaClientData=data as AreaClientData;
			
			this.areaID=mData.areaID;
			this.name=mData.name;
			this.load=mData.load;
			this.mark=mData.mark;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof AreaClientData))
				return;
			
			var mData:AreaClientData=data as AreaClientData;
			
			this.areaID=mData.areaID;
			
			this.name=mData.name;
			
			this.load=mData.load;
			
			this.mark=mData.mark;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
