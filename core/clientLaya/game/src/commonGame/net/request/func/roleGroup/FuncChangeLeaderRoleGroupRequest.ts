namespace Shine
{
	/** 禅让群主(generated by shine) */
	export class FuncChangeLeaderRoleGroupRequest extends FuncPlayerRoleGroupRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncChangeLeaderRoleGroup;
		
		/** 目标id */
		public playerID:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncChangeLeaderRoleGroup;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeLong(this.playerID);
			
		}
		
		/** 创建实例 */
		public static createFuncChangeLeaderRoleGroup(funcID:number,groupID:number,playerID:number):FuncChangeLeaderRoleGroupRequest
		{
			var re:FuncChangeLeaderRoleGroupRequest=new FuncChangeLeaderRoleGroupRequest();
			re.funcID=funcID;
			re.groupID=groupID;
			re.playerID=playerID;
			return re;
		}
		
	}
}
