namespace Shine
{
	/** 添加单个物品数目消息(generated by shine) */
	export class FuncAddOneItemNumResponse extends FuncSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncAddOneItemNum;
		
		/** 途径 */
		public way:number;
		
		/** 序号 */
		public index:number;
		
		/** 数目 */
		public num:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncAddOneItemNum;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncAddOneItemNumResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.way=stream.readInt();
			
			this.index=stream.readInt();
			
			this.num=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			this.me.func.getBaseItemContainerTool(this.funcID).onAddItemNumByServer(this.index,this.num,this.way);
		}
		
	}
}
