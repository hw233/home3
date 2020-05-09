namespace Shine
{
	/** 初始化客户端消息(ClientListData)(此处需要使用copy,因工具已改为潜拷,为了逻辑层避开深拷问题)(generated by shine) */
	export class InitClientResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.InitClient;
		
		/** 配置热更数据 */
		public configHotfix:number[];
		
		/** 客户端列表数据 */
		public listData:BaseData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.InitClient;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "InitClientResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.listData=stream.readDataSimpleNotNull() as BaseData;
			
			if(stream.readBoolean())
			{
				var configHotfixLen:number=stream.readLen();
				this.configHotfix=new Array<number>(configHotfixLen);
				var configHotfixT:number[]=this.configHotfix;
				for(var configHotfixI:number=0;configHotfixI<configHotfixLen;++configHotfixI)
				{
					var configHotfixV:number;
					configHotfixV=stream.readByte();
					
					configHotfixT[configHotfixI]=configHotfixV;
				}
			}
			else
			{
				this.configHotfix=null;
			}
			
		}
		
		/** 执行 */
		protected execute():void
		{
			// GameC.config.loadHotfix(this.configHotfix);
			GameC.main.initClient(this.listData as PlayerListData,true);
		}
		
	}
}
