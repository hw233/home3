namespace Shine
{
	/** (generated by shine) */
	export class ClientGetVersionResult extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=LoginHttpResponseResultType.ClientGetVersion;
		
		/** 版本数据(空为服务器并无此版本) */
		public version:ClientVersionData;
		
		/** 重定向的url */
		public redirectURL:string;
		
		constructor()
		{
			super();
			this._dataID=LoginHttpResponseResultType.ClientGetVersion;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			if(stream.readBoolean())
			{
				this.version=new ClientVersionData();
				this.version.readBytesSimple(stream);
			}
			else
			{
				this.version=null;
			}
			
			this.redirectURL=stream.readUTF();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			if(this.version!=null)
			{
				stream.writeBoolean(true);
				this.version.writeBytesSimple(stream);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			stream.writeUTF(this.redirectURL);
			
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			if(stream.readBoolean())
			{
				this.version=new ClientVersionData();
				this.version.readBytesFull(stream);
			}
			else
			{
				this.version=null;
			}
			
			this.redirectURL=stream.readUTF();
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			if(this.version!=null)
			{
				stream.writeBoolean(true);
				this.version.writeBytesFull(stream);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			stream.writeUTF(this.redirectURL);
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
	}
}
