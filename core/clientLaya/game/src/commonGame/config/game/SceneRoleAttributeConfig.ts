namespace Shine
{
	/** 场景角色属性类型表(generated by shine) */
	export class SceneRoleAttributeConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SceneRoleAttributeConfig[];
		
		/** 属性id */
		public id:number;
		
		/** 名字 */
		public name:string;
		
		/** 显示名 */
		public showName:string;
		
		/** 方式 */
		public method:number;
		
		/** 推送角色自己方式 */
		public sendSelfType:number;
		
		/** 当前属性默认空满 */
		public isCurrentDefaultFull:boolean;
		
		/** 显示名原值 */
		private _showName:string;
		
		/** 获取 */
		public static get(id:number):SceneRoleAttributeConfig
		{
			return id>=0 && id<this._dic.length ? this._dic[id] : null;
		}
		
		/** 设置字典 */
		public static setDic(dic:SceneRoleAttributeConfig[]):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SceneRoleAttributeConfig[]):void
		{
			ObjectUtils.arrayPutAll(this._dic,dic);
		}
		
		/** 获取全部 */
		public static getDic():SceneRoleAttributeConfig[]
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
			
			this.method=stream.readInt();
			
			this.sendSelfType=stream.readInt();
			
			this.isCurrentDefaultFull=stream.readBoolean();
			
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
