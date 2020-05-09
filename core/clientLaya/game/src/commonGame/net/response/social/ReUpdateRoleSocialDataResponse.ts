namespace Shine
{
	/** 回复更新社交数据消息(generated by shine) */
	export class ReUpdateRoleSocialDataResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.ReUpdateRoleSocialData;
		
		/** 变化的社交数据字典 */
		public dic:SMap<number,RoleSocialData>;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.ReUpdateRoleSocialData;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ReUpdateRoleSocialDataResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			var dicLen:number=stream.readLen();
			if(this.dic!=null)
			{
				this.dic.clear();
				this.dic.ensureCapacity(dicLen);
			}
			else
			{
				this.dic=new SMap<number,RoleSocialData>(dicLen);
			}
			
			var dicT:SMap<number,RoleSocialData>=this.dic;
			for(var dicI:number=dicLen-1;dicI>=0;--dicI)
			{
				var dicV:RoleSocialData;
				dicV=stream.readDataSimpleNotNull() as RoleSocialData;
				
				dicT.put(dicV.showData.playerID,dicV);
			}
			
		}
		
		/** 执行 */
		protected execute():void
		{
			this.me.social.onUpdateRoleSocialDatas(this.dic);
		}
		
	}
}
