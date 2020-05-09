namespace Shine
{
	/** 修改群公告消息(generated by shine) */
	export class FuncChangeRoleGroupNoticeRequest extends FuncPlayerRoleGroupRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncChangeRoleGroupNotice;
		
		public notice:string;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncChangeRoleGroupNotice;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeUTF(this.notice);
			
		}
		
		/** 创建实例 */
		public static createFuncChangeRoleGroupNotice(funcID:number,groupID:number,notice:string):FuncChangeRoleGroupNoticeRequest
		{
			var re:FuncChangeRoleGroupNoticeRequest=new FuncChangeRoleGroupNoticeRequest();
			re.funcID=funcID;
			re.groupID=groupID;
			re.notice=notice;
			return re;
		}
		
	}
}
