namespace Shine
{
	/** 添加掉落物品包绑定消息(generated by shine) */
	export class AddFieldItemBagBindResponse extends SceneSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.AddFieldItemBagBind;
		
		/** 掉落物品包绑定消息 */
		public data:FieldItemBagBindData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.AddFieldItemBagBind;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.data=stream.readDataSimpleNotNull() as FieldItemBagBindData;
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
