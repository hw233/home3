namespace Shine
{
	/** 发送被邀请时是否可直接入群的变化(generated by shine) */
	export class FuncSendChangeCanInviteInAbsRoleGroupResponse extends FuncSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncSendChangeCanInviteInAbsRoleGroup;
		
		/** 被邀请时是否可直接入群(无需同意) */
		public canInviteInAbs:boolean;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncSendChangeCanInviteInAbsRoleGroup;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.canInviteInAbs=stream.readBoolean();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
