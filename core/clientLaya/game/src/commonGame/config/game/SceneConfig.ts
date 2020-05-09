namespace Shine
{
	/** 场景表(generated by shine) */
	export class SceneConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,SceneConfig>;
		
		/** id */
		public id:number;
		
		/** 名字 */
		public name:string;
		
		/** 所属副本ID */
		public battleID:number;
		
		/** 进入条件 */
		public enterConditions:number[][];
		
		/** 类型 */
		public type:number;
		
		/** 是否上线继续进入 */
		public isLoginEnter:boolean;
		
		/** 场景切入策略 */
		public switchType:number;
		
		/** 进入位置组 */
		public enterPosList:number[];
		
		/** 默认进入位置 */
		public defaultEnterPos:number;
		
		/** 所属地图id */
		public mapID:number;
		
		/** 触发器组ID */
		public triggerID:number;
		
		/** 资源(资源转) */
		public sourceT:number;
		
		/** 附加资源列表(资源转) */
		public sourceExListT:number[];
		
		/** 背景音乐(资源转) */
		public musicT:number;
		
		/** 名字原值 */
		private _name:string;
		
		/** 获取 */
		public static get(id:number):SceneConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,SceneConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,SceneConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,SceneConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.name=stream.readUTF();
			
			this.battleID=stream.readInt();
			
			var enterConditionsLen:number=stream.readLen();
			this.enterConditions=new Array<number[]>(enterConditionsLen);
			var enterConditionsT:number[][]=this.enterConditions;
			for(var enterConditionsI:number=0;enterConditionsI<enterConditionsLen;++enterConditionsI)
			{
				var enterConditionsV:number[];
				var enterConditionsVLen:number=stream.readLen();
				enterConditionsV=new Array<number>(enterConditionsVLen);
				var enterConditionsVT:number[]=enterConditionsV;
				for(var enterConditionsVI:number=0;enterConditionsVI<enterConditionsVLen;++enterConditionsVI)
				{
					var enterConditionsVV:number;
					enterConditionsVV=stream.readInt();
					
					enterConditionsVT[enterConditionsVI]=enterConditionsVV;
				}
				
				enterConditionsT[enterConditionsI]=enterConditionsV;
			}
			
			this.type=stream.readInt();
			
			this.isLoginEnter=stream.readBoolean();
			
			this.switchType=stream.readInt();
			
			var enterPosListLen:number=stream.readLen();
			this.enterPosList=new Array<number>(enterPosListLen);
			var enterPosListT:number[]=this.enterPosList;
			for(var enterPosListI:number=0;enterPosListI<enterPosListLen;++enterPosListI)
			{
				var enterPosListV:number;
				enterPosListV=stream.readInt();
				
				enterPosListT[enterPosListI]=enterPosListV;
			}
			
			this.defaultEnterPos=stream.readInt();
			
			this.triggerID=stream.readInt();
			
			this.mapID=stream.readInt();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			if(this._name==null)
				this._name=this.name;
			this.name=LanguageConfig.getText(this._name);
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
