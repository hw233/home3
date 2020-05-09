namespace Shine
{
	/** 单位聊天消息(generated by shine) */
	export class CUnitChatRequest extends CUnitRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.CUnitChat;
		
		/** 聊天数据 */
		public data:ChatData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.CUnitChat;
		}
		
		protected copyData():void
		{
			super.copyData();
			var dataTemp:ChatData=this.data;
			this.data=dataTemp.clone() as ChatData;
			
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "CUnitChatRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.data);
			
		}
		
		/** 创建实例 */
		public static createCUnitChat(instanceID:number,data:ChatData):CUnitChatRequest
		{
			var re:CUnitChatRequest=new CUnitChatRequest();
			re.instanceID=instanceID;
			re.data=data;
			return re;
		}
		
	}
}
