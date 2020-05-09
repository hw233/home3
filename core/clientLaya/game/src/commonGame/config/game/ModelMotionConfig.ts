namespace Shine
{
	/** 单位模型动作表(generated by shine) */
	export class ModelMotionConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,ModelMotionConfig>;
		
		/** 模型id */
		public id:number;
		
		/** 动作id */
		public motionID:number;
		
		/** 动作时间(ms)  */
		public motionTime:number;
		
		/** 绑点组 */
		public bindPoints:number[][];
		
		/** 获取 */
		public static get(id:number,motionID:number):ModelMotionConfig
		{
			return this._dic.get(id * 4294967296 + motionID);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,ModelMotionConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,ModelMotionConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,ModelMotionConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.motionID=stream.readInt();
			
			this.motionTime=stream.readInt();
			
			var bindPointsLen:number=stream.readLen();
			this.bindPoints=new Array<number[]>(bindPointsLen);
			var bindPointsT:number[][]=this.bindPoints;
			for(var bindPointsI:number=0;bindPointsI<bindPointsLen;++bindPointsI)
			{
				var bindPointsV:number[];
				var bindPointsVLen:number=stream.readLen();
				bindPointsV=new Array<number>(bindPointsVLen);
				var bindPointsVT:number[]=bindPointsV;
				for(var bindPointsVI:number=0;bindPointsVI<bindPointsVLen;++bindPointsVI)
				{
					var bindPointsVV:number;
					bindPointsVV=stream.readFloat();
					
					bindPointsVT[bindPointsVI]=bindPointsVV;
				}
				
				bindPointsT[bindPointsI]=bindPointsV;
			}
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
