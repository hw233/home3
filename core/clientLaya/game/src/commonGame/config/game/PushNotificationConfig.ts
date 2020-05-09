namespace Shine
{
	/** 推送表(generated by shine) */
	export class PushNotificationConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:PushNotificationConfig[];
		
		/** id */
		public id:number;
		
		/** 参数1 */
		public param1:number[];
		
		/** 标题 */
		public title:string;
		
		/** 文字 */
		public text:string;
		
		/** 标题原值 */
		private _title:string;
		
		/** 文字原值 */
		private _text:string;
		
		/** 获取 */
		public static get(id:number):PushNotificationConfig
		{
			return id>=0 && id<this._dic.length ? this._dic[id] : null;
		}
		
		/** 设置字典 */
		public static setDic(dic:PushNotificationConfig[]):void
		{
			this._dic=dic;
		}
		
		/** 获取全部 */
		public static getDic():PushNotificationConfig[]
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			var param1Len:number=stream.readLen();
			this.param1=new Array<number>(param1Len);
			var param1T:number[]=this.param1;
			for(var param1I:number=0;param1I<param1Len;++param1I)
			{
				var param1V:number;
				param1V=stream.readInt();
				
				param1T[param1I]=param1V;
			}
			
			this.title=stream.readUTF();
			
			this.text=stream.readUTF();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			if(this._title==null)
				this._title=this.title;
			this.title=LanguageConfig.getText(this._title);
			
			if(this._text==null)
				this._text=this.text;
			this.text=LanguageConfig.getText(this._text);
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.id);
			
			var param1T:number[]=this.param1;
			stream.writeLen(param1T.length);
			for(var param1VI=0,param1VLen=param1T.length;param1VI<param1VLen;++param1VI)
			{
				var param1V:number=param1T[param1VI];
				stream.writeInt(param1V);
				
			}
			
			stream.writeUTF(this.title);
			
			stream.writeUTF(this.text);
			
		}
		
	}
}
