namespace Shine
{
	/** 单位移动朝向消息(generated by shine) */
	export class UnitMoveDirResponse extends UnitSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.UnitMoveDir;
		
		/** 移动类型 */
		public type:number;
		
		/** 目标朝向 */
		public dir:DirData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.UnitMoveDir;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UnitMoveDirResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.type=stream.readInt();
			
			this.dir=new DirData();
			this.dir.readBytesSimple(stream);
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
