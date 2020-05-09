namespace Shine
{
	/** 建筑升级成功(generated by shine) */
	export class BuildingLevelUpingCompleteResponse extends UnitSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.BuildingLevelUpingComplete;
		
		/** 下一等级 */
		public level:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.BuildingLevelUpingComplete;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "BuildingLevelUpingCompleteResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.level=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
