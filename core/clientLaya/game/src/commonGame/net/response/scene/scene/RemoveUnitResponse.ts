namespace Shine
{
	/** 移除单位协议(generated by shine) */
	export class RemoveUnitResponse extends SceneSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.RemoveUnit;
		
		/** 实例ID */
		public instanceID:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.RemoveUnit;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RemoveUnitResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.instanceID=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
