namespace Shine
{
	/** 请求进入场景消息(generated by shine) */
	export class ApplyEnterSceneRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.ApplyEnterScene;
		
		/** 场景ID */
		public id:number;
		
		/** 线ID */
		public line:number=-1;
		
		/** 位置ID */
		public posID:number=-1;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.ApplyEnterScene;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ApplyEnterSceneRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.id);
			
			stream.writeInt(this.line);
			
			stream.writeInt(this.posID);
			
		}
		
		/** 创建实例 */
		public static createApplyEnterScene(id:number,line:number,posID:number):ApplyEnterSceneRequest
		{
			var re:ApplyEnterSceneRequest=new ApplyEnterSceneRequest();
			re.id=id;
			re.line=line;
			re.posID=posID;
			return re;
		}
		
	}
}
