namespace Shine
{
	/** main背包卖出协议(generated by shine) */
	export class SellItemRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.SellItem;
		
		/** 格子序号 */
		public index:number;
		
		/** 数目 */
		public num:number;
		
		/** 道具ID(检验用) */
		public itemID:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.SellItem;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SellItemRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.index);
			
			stream.writeInt(this.num);
			
			stream.writeInt(this.itemID);
			
		}
		
		/** 创建实例 */
		public static createSellItem(index:number,num:number,itemID:number):SellItemRequest
		{
			var re:SellItemRequest=new SellItemRequest();
			re.index=index;
			re.num=num;
			re.itemID=itemID;
			return re;
		}
		
	}
}
