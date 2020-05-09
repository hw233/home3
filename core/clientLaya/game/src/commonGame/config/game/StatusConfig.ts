namespace Shine
{
	/** 状态类型表(generated by shine) */
	export class StatusConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:StatusConfig[];
		
		/** 状态id */
		public id:number;
		
		/** 名字 */
		public name:string;
		
		/** 显示名字 */
		public showName:string;
		
		/** 自己是否推送 */
		public needSendSelf:boolean;
		
		/** 显示名字原值 */
		private _showName:string;
		
		/** 获取 */
		public static get(id:number):StatusConfig
		{
			return id>=0 && id<this._dic.length ? this._dic[id] : null;
		}
		
		/** 设置字典 */
		public static setDic(dic:StatusConfig[]):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:StatusConfig[]):void
		{
			ObjectUtils.arrayPutAll(this._dic,dic);
		}
		
		/** 获取全部 */
		public static getDic():StatusConfig[]
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.name=stream.readUTF();
			
			this.showName=stream.readUTF();
			
			this.needSendSelf=stream.readBoolean();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			if(this._showName==null)
				this._showName=this.showName;
			this.showName=LanguageConfig.getText(this._showName);
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
