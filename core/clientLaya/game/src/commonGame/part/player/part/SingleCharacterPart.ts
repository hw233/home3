namespace Shine
{
	/** (generated by shine) */
	export class SingleCharacterPart extends CharacterPart
	{
		/** 数据 */
		private _sd:SingleCharacterPartData;
		
		public setData(data:BaseData):void
		{
			super.setData(data);
			
			this._sd=data as SingleCharacterPartData;
		}
		
		/** 获取数据 */
		public getPartData():SingleCharacterPartData
		{
			return this._sd;
		}
		
		protected createPartData():BaseData
		{
			return new SingleCharacterPartData();
		}
		
		/** 初始化(创建后刚调用,与dispose成对) */
		public init():void
		{
			super.init();
			
		}
		
		/** 析构(回池前调用,与init成对) */
		public dispose():void
		{
			super.dispose();
			
		}
		
		/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
		public afterReadData():void
		{
			super.afterReadData();
			
		}
		
		/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
		public construct():void
		{
			super.construct();
			
		}
		
		/** 构造数据前 */
		protected beforeMakeData():void
		{
			super.beforeMakeData();
			
		}
		
		/** 功能开启(id:功能ID) */
		public onFunctionOpen(id:number):void
		{
			super.onFunctionOpen(id);
			
		}
		
		/** 功能关闭(id:功能ID) */
		public onFunctionClose(id:number):void
		{
			super.onFunctionClose(id);
		}
		
		/** 配置表更新后(配置替换) */
		public onReloadConfig():void
		{
			super.onReloadConfig();
		}
		
	}
}
