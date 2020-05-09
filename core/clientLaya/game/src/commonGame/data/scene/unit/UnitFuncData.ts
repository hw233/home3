namespace Shine
{
	/** 单位功能数据(generated by shine) */
	export class UnitFuncData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.UnitFunc;
		
		/** 物品包数据 */
		public itemDic:ItemDicContainerData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.UnitFunc;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			if(stream.readBoolean())
			{
				this.itemDic=stream.readDataSimpleNotNull() as ItemDicContainerData;
			}
			else
			{
				this.itemDic=null;
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			if(this.itemDic!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.itemDic);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof UnitFuncData))
				return;
			
			var mData:UnitFuncData=data as UnitFuncData;
			
			this.itemDic=mData.itemDic;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof UnitFuncData))
				return;
			
			var mData:UnitFuncData=data as UnitFuncData;
			
			if(mData.itemDic!=null)
			{
				this.itemDic=mData.itemDic.clone() as ItemDicContainerData;
			}
			else
			{
				this.itemDic=null;
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
