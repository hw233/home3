namespace Shine
{
	/** 邮件移除红点(generated by shine) */
	export class MailRemoveRedPointRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.MailRemoveRedPoint;
		
		/** 邮件序号 */
		public index:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.MailRemoveRedPoint;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "MailRemoveRedPointRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.index);
			
		}
		
		/** 创建实例 */
		public static createMailRemoveRedPoint(index:number):MailRemoveRedPointRequest
		{
			var re:MailRemoveRedPointRequest=new MailRemoveRedPointRequest();
			re.index=index;
			return re;
		}
		
	}
}
