namespace Shine
{
	/** 推送移除好友黑名单(generated by shine) */
	export class SendRemoveFriendBlackListResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.SendRemoveFriendBlackList;
		
		public playerID:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.SendRemoveFriendBlackList;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SendRemoveFriendBlackListResponse";
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
			this.me.friend.onRemoveBlackList(this.playerID);
		}
		
	}
}
