namespace Shine
{
	/** 职业表(generated by shine) */
	export class VocationConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:VocationConfig[];
		
		/** 职业id */
		public id:number;
		
		/** 获取 */
		public static get(id:number):VocationConfig
		{
			return id>=0 && id<this._dic.length ? this._dic[id] : null;
		}
		
		/** 设置字典 */
		public static setDic(dic:VocationConfig[]):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:VocationConfig[]):void
		{
			ObjectUtils.arrayPutAll(this._dic,dic);
		}
		
		/** 获取全部 */
		public static getDic():VocationConfig[]
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
