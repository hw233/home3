namespace Shine
{
	/** 单位拉回消息(generated by shine) */
	export class ReCUnitPullBackResponse extends UnitSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.ReCUnitPullBack;
		
		/** 位置 */
		public posDir:PosDirData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.ReCUnitPullBack;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ReCUnitPullBackResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.posDir=new PosDirData();
			this.posDir.readBytesSimple(stream);
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
