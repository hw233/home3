namespace Shine
{
	/** 移动物品消息(generated by shine) */
	export class FuncMoveItemRequest extends FuncRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncMoveItem;
		
		/** 从某格子 */
		public fromIndex:number;
		
		/** 到某格子 */
		public toIndex:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncMoveItem;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncMoveItemRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.fromIndex);
			
			stream.writeInt(this.toIndex);
			
		}
		
		/** 创建实例 */
		public static createFuncMoveItem(funcID:number,fromIndex:number,toIndex:number):FuncMoveItemRequest
		{
			var re:FuncMoveItemRequest=new FuncMoveItemRequest();
			re.funcID=funcID;
			re.fromIndex=fromIndex;
			re.toIndex=toIndex;
			return re;
		}
		
	}
}
