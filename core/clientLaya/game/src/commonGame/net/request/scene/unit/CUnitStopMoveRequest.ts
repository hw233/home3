namespace Shine
{
	/** 客户端单位停止移动消息(generated by shine) */
	export class CUnitStopMoveRequest extends CUnitRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.CUnitStopMove;
		
		/** 停止的客户端位置 */
		public posDir:PosDirData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.CUnitStopMove;
		}
		
		protected copyData():void
		{
			super.copyData();
			var posDirTemp:PosDirData=this.posDir;
			this.posDir=new PosDirData();
			this.posDir.copy(posDirTemp);
			
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "CUnitStopMoveRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			this.posDir.writeBytesSimple(stream);
			
		}
		
		/** 创建实例 */
		public static createCUnitStopMove(instanceID:number,posDir:PosDirData):CUnitStopMoveRequest
		{
			var re:CUnitStopMoveRequest=new CUnitStopMoveRequest();
			re.instanceID=instanceID;
			re.posDir=posDir;
			return re;
		}
		
	}
}
