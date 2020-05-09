namespace Shine
{
	/** 角色接收聊天序号(generated by shine) */
	export class PlayerReceiveChatIndexRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.PlayerReceiveChatIndex;
		
		public index:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.PlayerReceiveChatIndex;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.index);
			
		}
		
		/** 创建实例 */
		public static createPlayerReceiveChatIndex(index:number):PlayerReceiveChatIndexRequest
		{
			var re:PlayerReceiveChatIndexRequest=new PlayerReceiveChatIndexRequest();
			re.index=index;
			return re;
		}
		
	}
}
