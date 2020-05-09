namespace Shine
{
	/** 推送移除好友(generated by shine) */
	export class SendRemoveFriendResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.SendRemoveFriend;
		
		/** 角色ID */
		public playerID:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.SendRemoveFriend;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SendRemoveFriendResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.playerID=stream.readLong();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			this.me.friend.onRemoveFriend(this.playerID);
		}
		
	}
}
