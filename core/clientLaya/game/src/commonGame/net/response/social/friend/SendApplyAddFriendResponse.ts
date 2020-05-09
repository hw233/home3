namespace Shine
{
	/** 推送申请添加好友消息(generated by shine) */
	export class SendApplyAddFriendResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.SendApplyAddFriend;
		
		/** 申请数据 */
		public applyData:ApplyAddFriendData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.SendApplyAddFriend;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SendApplyAddFriendResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.applyData=stream.readDataSimpleNotNull() as ApplyAddFriendData;
			
		}
		
		/** 执行 */
		protected execute():void
		{
			this.me.friend.onApplyAddFriend(this.applyData);
		}
		
	}
}
