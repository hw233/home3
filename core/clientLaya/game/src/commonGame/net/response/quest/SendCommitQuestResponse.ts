namespace Shine
{
	/** 推送交任务消息(generated by shine) */
	export class SendCommitQuestResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.SendCommitQuest;
		
		/** 任务id */
		public id:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.SendCommitQuest;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SendCommitQuestResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			Ctrl.print("完成了任务"+this.id)
			this.me.quest.onCommitQuest(this.id);
		}
		
	}
}
