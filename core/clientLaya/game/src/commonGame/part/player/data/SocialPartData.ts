namespace Shine
{
	/** 角色社交数据(generated by shine) */
	export class SocialPartData extends BaseData
	{
		/** 聊天发送序号 */
		public chatSendIndex:number;
		
		/** 多频道组 */
		public multiChannels:SMap<number,SMap<number,ChatChannelData>>;
		
		/** 单一频道组 */
		public singleChannels:SMap<number,ChatChannelData>;
		
		/** 数据类型ID */
		public static dataID:number=PlayerPartDataType.Social;
		
		constructor()
		{
			super();
			this._dataID=PlayerPartDataType.Social;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SocialPartData";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			var singleChannelsLen:number=stream.readLen();
			if(this.singleChannels!=null)
			{
				this.singleChannels.clear();
				this.singleChannels.ensureCapacity(singleChannelsLen);
			}
			else
			{
				this.singleChannels=new SMap<number,ChatChannelData>(singleChannelsLen);
			}
			
			var singleChannelsT:SMap<number,ChatChannelData>=this.singleChannels;
			for(var singleChannelsI:number=singleChannelsLen-1;singleChannelsI>=0;--singleChannelsI)
			{
				var singleChannelsK:number;
				var singleChannelsV:ChatChannelData;
				singleChannelsK=stream.readInt();
				
				singleChannelsV=stream.readDataFullNotNull() as ChatChannelData;
				
				singleChannelsT.put(singleChannelsK,singleChannelsV);
			}
			
			var multiChannelsLen:number=stream.readLen();
			if(this.multiChannels!=null)
			{
				this.multiChannels.clear();
				this.multiChannels.ensureCapacity(multiChannelsLen);
			}
			else
			{
				this.multiChannels=new SMap<number,SMap<number,ChatChannelData>>(multiChannelsLen);
			}
			
			var multiChannelsT:SMap<number,SMap<number,ChatChannelData>>=this.multiChannels;
			for(var multiChannelsI:number=multiChannelsLen-1;multiChannelsI>=0;--multiChannelsI)
			{
				var multiChannelsK:number;
				var multiChannelsV:SMap<number,ChatChannelData>;
				multiChannelsK=stream.readInt();
				
				var multiChannelsVLen:number=stream.readLen();
				multiChannelsV=new SMap<number,ChatChannelData>(multiChannelsVLen);
				var multiChannelsVT:SMap<number,ChatChannelData>=multiChannelsV;
				for(var multiChannelsVI:number=multiChannelsVLen-1;multiChannelsVI>=0;--multiChannelsVI)
				{
					var multiChannelsVK:number;
					var multiChannelsVV:ChatChannelData;
					multiChannelsVK=stream.readLong();
					
					multiChannelsVV=stream.readDataFullNotNull() as ChatChannelData;
					
					multiChannelsVT.put(multiChannelsVK,multiChannelsVV);
				}
				
				multiChannelsT.put(multiChannelsK,multiChannelsV);
			}
			
			this.chatSendIndex=stream.readInt();
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeLen(this.singleChannels.size());
			if(!this.singleChannels.isEmpty())
			{
				for(var singleChannelsK of this.singleChannels.getKeys())
				{
					var singleChannelsV:ChatChannelData=this.singleChannels.get(singleChannelsK);
					stream.writeInt(singleChannelsK);
					
					stream.writeDataFullNotNull(singleChannelsV);
					
				}
			}
			
			stream.writeLen(this.multiChannels.size());
			if(!this.multiChannels.isEmpty())
			{
				for(var multiChannelsK of this.multiChannels.getKeys())
				{
					var multiChannelsV:SMap<number,ChatChannelData>=this.multiChannels.get(multiChannelsK);
					stream.writeInt(multiChannelsK);
					
					stream.writeLen(multiChannelsV.size());
					if(!multiChannelsV.isEmpty())
					{
						for(var multiChannelsVK of multiChannelsV.getKeys())
						{
							var multiChannelsVV:ChatChannelData=multiChannelsV.get(multiChannelsVK);
							stream.writeLong(multiChannelsVK);
							
							stream.writeDataFullNotNull(multiChannelsVV);
							
						}
					}
					
				}
			}
			
			stream.writeInt(this.chatSendIndex);
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			var singleChannelsLen:number=stream.readLen();
			if(this.singleChannels!=null)
			{
				this.singleChannels.clear();
				this.singleChannels.ensureCapacity(singleChannelsLen);
			}
			else
			{
				this.singleChannels=new SMap<number,ChatChannelData>(singleChannelsLen);
			}
			
			var singleChannelsT:SMap<number,ChatChannelData>=this.singleChannels;
			for(var singleChannelsI:number=singleChannelsLen-1;singleChannelsI>=0;--singleChannelsI)
			{
				var singleChannelsK:number;
				var singleChannelsV:ChatChannelData;
				singleChannelsK=stream.readInt();
				
				singleChannelsV=stream.readDataSimpleNotNull() as ChatChannelData;
				
				singleChannelsT.put(singleChannelsK,singleChannelsV);
			}
			
			var multiChannelsLen:number=stream.readLen();
			if(this.multiChannels!=null)
			{
				this.multiChannels.clear();
				this.multiChannels.ensureCapacity(multiChannelsLen);
			}
			else
			{
				this.multiChannels=new SMap<number,SMap<number,ChatChannelData>>(multiChannelsLen);
			}
			
			var multiChannelsT:SMap<number,SMap<number,ChatChannelData>>=this.multiChannels;
			for(var multiChannelsI:number=multiChannelsLen-1;multiChannelsI>=0;--multiChannelsI)
			{
				var multiChannelsK:number;
				var multiChannelsV:SMap<number,ChatChannelData>;
				multiChannelsK=stream.readInt();
				
				var multiChannelsVLen:number=stream.readLen();
				multiChannelsV=new SMap<number,ChatChannelData>(multiChannelsVLen);
				var multiChannelsVT:SMap<number,ChatChannelData>=multiChannelsV;
				for(var multiChannelsVI:number=multiChannelsVLen-1;multiChannelsVI>=0;--multiChannelsVI)
				{
					var multiChannelsVK:number;
					var multiChannelsVV:ChatChannelData;
					multiChannelsVK=stream.readLong();
					
					multiChannelsVV=stream.readDataSimpleNotNull() as ChatChannelData;
					
					multiChannelsVT.put(multiChannelsVK,multiChannelsVV);
				}
				
				multiChannelsT.put(multiChannelsK,multiChannelsV);
			}
			
			this.chatSendIndex=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLen(this.singleChannels.size());
			if(!this.singleChannels.isEmpty())
			{
				for(var singleChannelsK of this.singleChannels.getKeys())
				{
					var singleChannelsV:ChatChannelData=this.singleChannels.get(singleChannelsK);
					stream.writeInt(singleChannelsK);
					
					stream.writeDataSimpleNotNull(singleChannelsV);
					
				}
			}
			
			stream.writeLen(this.multiChannels.size());
			if(!this.multiChannels.isEmpty())
			{
				for(var multiChannelsK of this.multiChannels.getKeys())
				{
					var multiChannelsV:SMap<number,ChatChannelData>=this.multiChannels.get(multiChannelsK);
					stream.writeInt(multiChannelsK);
					
					stream.writeLen(multiChannelsV.size());
					if(!multiChannelsV.isEmpty())
					{
						for(var multiChannelsVK of multiChannelsV.getKeys())
						{
							var multiChannelsVV:ChatChannelData=multiChannelsV.get(multiChannelsVK);
							stream.writeLong(multiChannelsVK);
							
							stream.writeDataSimpleNotNull(multiChannelsVV);
							
						}
					}
					
				}
			}
			
			stream.writeInt(this.chatSendIndex);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof SocialPartData))
				return;
			
			var mData:SocialPartData=data as SocialPartData;
			
			this.singleChannels=mData.singleChannels;
			this.multiChannels=mData.multiChannels;
			this.chatSendIndex=mData.chatSendIndex;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof SocialPartData))
				return;
			
			var mData:SocialPartData=data as SocialPartData;
			
			if(this.singleChannels!=null)
			{
				this.singleChannels.clear();
				this.singleChannels.ensureCapacity(mData.singleChannels.size());
			}
			else
			{
				this.singleChannels=new SMap<number,ChatChannelData>(mData.singleChannels.size());
			}
			
			var singleChannelsT:SMap<number,ChatChannelData>=this.singleChannels;
			if(!mData.singleChannels.isEmpty())
			{
				for(var singleChannelsK of mData.singleChannels.getKeys())
				{
					var singleChannelsV:ChatChannelData=mData.singleChannels.get(singleChannelsK);
					var singleChannelsW:number;
					var singleChannelsU:ChatChannelData;
					singleChannelsW=singleChannelsK;
					
					singleChannelsU=singleChannelsV.clone() as ChatChannelData;
					
					singleChannelsT.put(singleChannelsW,singleChannelsU);
				}
			}
			
			if(this.multiChannels!=null)
			{
				this.multiChannels.clear();
				this.multiChannels.ensureCapacity(mData.multiChannels.size());
			}
			else
			{
				this.multiChannels=new SMap<number,SMap<number,ChatChannelData>>(mData.multiChannels.size());
			}
			
			var multiChannelsT:SMap<number,SMap<number,ChatChannelData>>=this.multiChannels;
			if(!mData.multiChannels.isEmpty())
			{
				for(var multiChannelsK of mData.multiChannels.getKeys())
				{
					var multiChannelsV:SMap<number,ChatChannelData>=mData.multiChannels.get(multiChannelsK);
					var multiChannelsW:number;
					var multiChannelsU:SMap<number,ChatChannelData>;
					multiChannelsW=multiChannelsK;
					
					multiChannelsU=new SMap<number,ChatChannelData>(multiChannelsV.size());
					var multiChannelsUT:SMap<number,ChatChannelData>=multiChannelsU;
					if(!multiChannelsV.isEmpty())
					{
						for(var multiChannelsUK of multiChannelsV.getKeys())
						{
							var multiChannelsUV:ChatChannelData=multiChannelsV.get(multiChannelsUK);
							var multiChannelsUW:number;
							var multiChannelsUU:ChatChannelData;
							multiChannelsUW=multiChannelsUK;
							
							multiChannelsUU=multiChannelsUV.clone() as ChatChannelData;
							
							multiChannelsUT.put(multiChannelsUW,multiChannelsUU);
						}
					}
					
					multiChannelsT.put(multiChannelsW,multiChannelsU);
				}
			}
			
			this.chatSendIndex=mData.chatSendIndex;
			
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			var mData:SocialPartData=data as SocialPartData;
			if(this.singleChannels==null)
				return false;
			if(this.singleChannels.size()!=mData.singleChannels.size())
				return false;
			var singleChannelsR:SMap<number,ChatChannelData>=mData.singleChannels;
			if(!this.singleChannels.isEmpty())
			{
				for(var singleChannelsK of this.singleChannels.getKeys())
				{
					var singleChannelsV:ChatChannelData=this.singleChannels.get(singleChannelsK);
					var singleChannelsU:ChatChannelData=singleChannelsR.get(singleChannelsK);
					if(singleChannelsV==null)
						return false;
					if(!singleChannelsV.dataEquals(singleChannelsU))
						return false;
					
				}
			}
			
			if(this.multiChannels==null)
				return false;
			if(this.multiChannels.size()!=mData.multiChannels.size())
				return false;
			var multiChannelsR:SMap<number,SMap<number,ChatChannelData>>=mData.multiChannels;
			if(!this.multiChannels.isEmpty())
			{
				for(var multiChannelsK of this.multiChannels.getKeys())
				{
					var multiChannelsV:SMap<number,ChatChannelData>=this.multiChannels.get(multiChannelsK);
					var multiChannelsU:SMap<number,ChatChannelData>=multiChannelsR.get(multiChannelsK);
					if(multiChannelsV==null)
						return false;
					if(multiChannelsV.size()!=multiChannelsU.size())
						return false;
					var multiChannelsVR:SMap<number,ChatChannelData>=multiChannelsU;
					if(!multiChannelsV.isEmpty())
					{
						for(var multiChannelsVK of multiChannelsV.getKeys())
						{
							var multiChannelsVV:ChatChannelData=multiChannelsV.get(multiChannelsVK);
							var multiChannelsVU:ChatChannelData=multiChannelsVR.get(multiChannelsVK);
							if(multiChannelsVV==null)
								return false;
							if(!multiChannelsVV.dataEquals(multiChannelsVU))
								return false;
							
						}
					}
					
				}
			}
			
			if(this.chatSendIndex!=mData.chatSendIndex)
				return false;
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			writer.writeTabs();
			writer.sb.append("singleChannels");
			writer.sb.append(':');
			writer.sb.append("Map<number,ChatChannelData>");
			writer.sb.append('(');
			writer.sb.append(this.singleChannels.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.singleChannels.isEmpty())
			{
				for(var singleChannelsK of this.singleChannels.getKeys())
				{
					var singleChannelsV:ChatChannelData=this.singleChannels.get(singleChannelsK);
					writer.writeTabs();
					writer.sb.append(singleChannelsK);
					
					writer.sb.append(':');
					singleChannelsV.writeDataString(writer);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("multiChannels");
			writer.sb.append(':');
			writer.sb.append("Map<number,SMap<number,ChatChannelData>>");
			writer.sb.append('(');
			writer.sb.append(this.multiChannels.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.multiChannels.isEmpty())
			{
				for(var multiChannelsK of this.multiChannels.getKeys())
				{
					var multiChannelsV:SMap<number,ChatChannelData>=this.multiChannels.get(multiChannelsK);
					writer.writeTabs();
					writer.sb.append(multiChannelsK);
					
					writer.sb.append(':');
					writer.sb.append("Map<number,ChatChannelData>");
					writer.sb.append('(');
					writer.sb.append(multiChannelsV.size());
					writer.sb.append(')');
					writer.writeEnter();
					writer.writeLeftBrace();
					if(!multiChannelsV.isEmpty())
					{
						for(var multiChannelsVK of multiChannelsV.getKeys())
						{
							var multiChannelsVV:ChatChannelData=multiChannelsV.get(multiChannelsVK);
							writer.writeTabs();
							writer.sb.append(multiChannelsVK);
							
							writer.sb.append(':');
							multiChannelsVV.writeDataString(writer);
							
							writer.writeEnter();
						}
					}
					writer.writeRightBrace();
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("chatSendIndex");
			writer.sb.append(':');
			writer.sb.append(this.chatSendIndex);
			
			writer.writeEnter();
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.singleChannels=new SMap<number,ChatChannelData>();
			this.multiChannels=new SMap<number,SMap<number,ChatChannelData>>();
		}
		
	}
}
