namespace Shine
{
	/** 技能几率表(generated by shine) */
	export class SkillProbConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,SkillProbConfig>;
		
		/** 几率id */
		public id:number;
		
		/** 几率值(千分位) */
		public value:number;
		
		/** 获取 */
		public static get(id:number):SkillProbConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,SkillProbConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,SkillProbConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,SkillProbConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.value=stream.readInt();
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
