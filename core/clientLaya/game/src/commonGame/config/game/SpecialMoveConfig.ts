namespace Shine
{
	/** 特殊移动表(generated by shine) */
	export class SpecialMoveConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,SpecialMoveConfig>;
		
		/** id */
		public id:number;
		
		/** 类型 */
		public type:number;
		
		/** 参数组 */
		public args:number[];
		
		/** 动作id */
		public motionID:number;
		
		/** 获取 */
		public static get(id:number):SpecialMoveConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,SpecialMoveConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,SpecialMoveConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,SpecialMoveConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.type=stream.readInt();
			
			var argsLen:number=stream.readLen();
			this.args=new Array<number>(argsLen);
			var argsT:number[]=this.args;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:number;
				argsV=stream.readFloat();
				
				argsT[argsI]=argsV;
			}
			
			this.motionID=stream.readInt();
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
