namespace Shine
{
	/** 区域表(generated by shine) */
	export class RegionConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,RegionConfig>;
		
		/** id */
		public id:number;
		
		/** 形状类型 */
		public shapeType:number;
		
		/** 动作类型 */
		public actions:number[][];
		
		/** 是否客户端驱动 */
		public isClientDrive:boolean;
		
		/** 是否是角色响应 */
		public onlyCharacter:boolean;
		
		/** 获取 */
		public static get(id:number):RegionConfig
		{
			return this._dic.get(id);
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,RegionConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,RegionConfig>):void
		{
			this._dic=dic;
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,RegionConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.shapeType=stream.readInt();
			
			var actionsLen:number=stream.readLen();
			this.actions=new Array<number[]>(actionsLen);
			var actionsT:number[][]=this.actions;
			for(var actionsI:number=0;actionsI<actionsLen;++actionsI)
			{
				var actionsV:number[];
				var actionsVLen:number=stream.readLen();
				actionsV=new Array<number>(actionsVLen);
				var actionsVT:number[]=actionsV;
				for(var actionsVI:number=0;actionsVI<actionsVLen;++actionsVI)
				{
					var actionsVV:number;
					actionsVV=stream.readInt();
					
					actionsVT[actionsVI]=actionsVV;
				}
				
				actionsT[actionsI]=actionsV;
			}
			
			this.isClientDrive=stream.readBoolean();
			
			this.onlyCharacter=stream.readBoolean();
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
