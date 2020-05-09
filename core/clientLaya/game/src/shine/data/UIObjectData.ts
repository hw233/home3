namespace Shine
{
	/** (generated by shine) */
	export class UIObjectData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=ShineDataType.UIObject;
		
		/** 名字 */
		public name:string;
		
		/** 类型 */
		public type:number;
		
		/** 样式 */
		public style:string;
		
		/** 子项组 */
		public children:SList<UIObjectData>=new SList<UIObjectData>();
		
		/** 整型参数组 */
		public intArgs:number[];
		
		/** 字符参数组 */
		public strArgs:string[];
		
		constructor()
		{
			super();
			this._dataID=ShineDataType.UIObject;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UIObjectData";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			this.name=stream.readUTF();
			
			this.type=stream.readInt();
			
			this.style=stream.readUTF();
			
			if(stream.readBoolean())
			{
				var childrenLen:number=stream.readLen();
				if(this.children!=null)
				{
					this.children.clear();
					this.children.ensureCapacity(childrenLen);
				}
				else
				{
					this.children=new SList<UIObjectData>();
				}
				
				var childrenT:SList<UIObjectData>=this.children;
				for(var childrenI:number=childrenLen-1;childrenI>=0;--childrenI)
				{
					var childrenV:UIObjectData;
					if(stream.readBoolean())
					{
						childrenV=new UIObjectData();
						childrenV.readBytesFull(stream);
					}
					else
					{
						childrenV=null;
					}
					
					childrenT.add(childrenV);
				}
			}
			else
			{
				this.children=null;
			}
			
			if(stream.readBoolean())
			{
				var intArgsLen:number=stream.readLen();
				this.intArgs=new Array<number>(intArgsLen);
				var intArgsT:number[]=this.intArgs;
				for(var intArgsI:number=0;intArgsI<intArgsLen;++intArgsI)
				{
					var intArgsV:number;
					intArgsV=stream.readInt();
					
					intArgsT[intArgsI]=intArgsV;
				}
			}
			else
			{
				this.intArgs=null;
			}
			
			if(stream.readBoolean())
			{
				var strArgsLen:number=stream.readLen();
				this.strArgs=new Array<string>(strArgsLen);
				var strArgsT:string[]=this.strArgs;
				for(var strArgsI:number=0;strArgsI<strArgsLen;++strArgsI)
				{
					var strArgsV:string;
					strArgsV=stream.readUTF();
					
					strArgsT[strArgsI]=strArgsV;
				}
			}
			else
			{
				this.strArgs=null;
			}
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeUTF(this.name);
			
			stream.writeInt(this.type);
			
			stream.writeUTF(this.style);
			
			if(this.children!=null)
			{
				stream.writeBoolean(true);
				stream.writeLen(this.children.size());
				if(!this.children.isEmpty())
				{
					for(var childrenVI=0,childrenVLen=this.children.length;childrenVI<childrenVLen;++childrenVI)
					{
						var childrenV:UIObjectData=this.children[childrenVI];
						if(childrenV!=null)
						{
							stream.writeBoolean(true);
							childrenV.writeBytesFull(stream);
						}
						else
						{
							stream.writeBoolean(false);
						}
						
					}
				}
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.intArgs!=null)
			{
				stream.writeBoolean(true);
				var intArgsT:number[]=this.intArgs;
				stream.writeLen(intArgsT.length);
				for(var intArgsVI=0,intArgsVLen=intArgsT.length;intArgsVI<intArgsVLen;++intArgsVI)
				{
					var intArgsV:number=intArgsT[intArgsVI];
					stream.writeInt(intArgsV);
					
				}
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.strArgs!=null)
			{
				stream.writeBoolean(true);
				var strArgsT:string[]=this.strArgs;
				stream.writeLen(strArgsT.length);
				for(var strArgsVI=0,strArgsVLen=strArgsT.length;strArgsVI<strArgsVLen;++strArgsVI)
				{
					var strArgsV:string=strArgsT[strArgsVI];
					stream.writeUTF(strArgsV);
					
				}
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.name=stream.readUTF();
			
			this.type=stream.readInt();
			
			this.style=stream.readUTF();
			
			if(stream.readBoolean())
			{
				var childrenLen:number=stream.readLen();
				if(this.children!=null)
				{
					this.children.clear();
					this.children.ensureCapacity(childrenLen);
				}
				else
				{
					this.children=new SList<UIObjectData>();
				}
				
				var childrenT:SList<UIObjectData>=this.children;
				for(var childrenI:number=childrenLen-1;childrenI>=0;--childrenI)
				{
					var childrenV:UIObjectData;
					if(stream.readBoolean())
					{
						childrenV=new UIObjectData();
						childrenV.readBytesSimple(stream);
					}
					else
					{
						childrenV=null;
					}
					
					childrenT.add(childrenV);
				}
			}
			else
			{
				this.children=null;
			}
			
			if(stream.readBoolean())
			{
				var intArgsLen:number=stream.readLen();
				this.intArgs=new Array<number>(intArgsLen);
				var intArgsT:number[]=this.intArgs;
				for(var intArgsI:number=0;intArgsI<intArgsLen;++intArgsI)
				{
					var intArgsV:number;
					intArgsV=stream.readInt();
					
					intArgsT[intArgsI]=intArgsV;
				}
			}
			else
			{
				this.intArgs=null;
			}
			
			if(stream.readBoolean())
			{
				var strArgsLen:number=stream.readLen();
				this.strArgs=new Array<string>(strArgsLen);
				var strArgsT:string[]=this.strArgs;
				for(var strArgsI:number=0;strArgsI<strArgsLen;++strArgsI)
				{
					var strArgsV:string;
					strArgsV=stream.readUTF();
					
					strArgsT[strArgsI]=strArgsV;
				}
			}
			else
			{
				this.strArgs=null;
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeUTF(this.name);
			
			stream.writeInt(this.type);
			
			stream.writeUTF(this.style);
			
			if(this.children!=null)
			{
				stream.writeBoolean(true);
				stream.writeLen(this.children.size());
				if(!this.children.isEmpty())
				{
					for(var childrenVI=0,childrenVLen=this.children.length;childrenVI<childrenVLen;++childrenVI)
					{
						var childrenV:UIObjectData=this.children[childrenVI];
						if(childrenV!=null)
						{
							stream.writeBoolean(true);
							childrenV.writeBytesSimple(stream);
						}
						else
						{
							stream.writeBoolean(false);
						}
						
					}
				}
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.intArgs!=null)
			{
				stream.writeBoolean(true);
				var intArgsT:number[]=this.intArgs;
				stream.writeLen(intArgsT.length);
				for(var intArgsVI=0,intArgsVLen=intArgsT.length;intArgsVI<intArgsVLen;++intArgsVI)
				{
					var intArgsV:number=intArgsT[intArgsVI];
					stream.writeInt(intArgsV);
					
				}
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.strArgs!=null)
			{
				stream.writeBoolean(true);
				var strArgsT:string[]=this.strArgs;
				stream.writeLen(strArgsT.length);
				for(var strArgsVI=0,strArgsVLen=strArgsT.length;strArgsVI<strArgsVLen;++strArgsVI)
				{
					var strArgsV:string=strArgsT[strArgsVI];
					stream.writeUTF(strArgsV);
					
				}
			}
			else
			{
				stream.writeBoolean(false);
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof UIObjectData))
				return;
			
			var mData:UIObjectData=data as UIObjectData;
			
			this.name=mData.name;
			this.type=mData.type;
			this.style=mData.style;
			this.children=mData.children;
			this.intArgs=mData.intArgs;
			this.strArgs=mData.strArgs;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof UIObjectData))
				return;
			
			var mData:UIObjectData=data as UIObjectData;
			
			this.name=mData.name;
			
			this.type=mData.type;
			
			this.style=mData.style;
			
			if(mData.children!=null)
			{
				if(this.children!=null)
				{
					this.children.clear();
					this.children.ensureCapacity(mData.children.size());
				}
				else
				{
					this.children=new SList<UIObjectData>();
				}
				
				var childrenT:SList<UIObjectData>=this.children;
				if(!mData.children.isEmpty())
				{
					for(var childrenVI=0,childrenVLen=mData.children.length;childrenVI<childrenVLen;++childrenVI)
					{
						var childrenV:UIObjectData=mData.children[childrenVI];
						var childrenU:UIObjectData;
						if(childrenV!=null)
						{
							childrenU=new UIObjectData();
							childrenU.copy(childrenV);
						}
						else
						{
							childrenU=null;
						}
						
						childrenT.add(childrenU);
					}
				}
			}
			else
			{
				this.children=null;
			}
			
			if(mData.intArgs!=null)
			{
				var intArgsR:number[]=mData.intArgs;
				var intArgsLen:number=intArgsR.length;
				this.intArgs=new Array<number>(intArgsLen);
				var intArgsT:number[]=this.intArgs;
				for(var intArgsI:number=0;intArgsI<intArgsLen;++intArgsI)
				{
					var intArgsV:number=intArgsR[intArgsI];
					var intArgsU:number;
					intArgsU=intArgsV;
					
					intArgsT[intArgsI]=intArgsU;
				}
			}
			else
			{
				this.intArgs=null;
			}
			
			if(mData.strArgs!=null)
			{
				var strArgsR:string[]=mData.strArgs;
				var strArgsLen:number=strArgsR.length;
				this.strArgs=new Array<string>(strArgsLen);
				var strArgsT:string[]=this.strArgs;
				for(var strArgsI:number=0;strArgsI<strArgsLen;++strArgsI)
				{
					var strArgsV:string=strArgsR[strArgsI];
					var strArgsU:string;
					strArgsU=strArgsV;
					
					strArgsT[strArgsI]=strArgsU;
				}
			}
			else
			{
				this.strArgs=null;
			}
			
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			var mData:UIObjectData=data as UIObjectData;
			if(this.name!=mData.name)
				return false;
			
			if(this.type!=mData.type)
				return false;
			
			if(this.style!=mData.style)
				return false;
			
			if(mData.children!=null)
			{
				if(this.children==null)
					return false;
				if(this.children.size()!=mData.children.size())
					return false;
				var childrenT:SList<UIObjectData>=this.children;
				var childrenR:SList<UIObjectData>=mData.children;
				var childrenLen:number=childrenT.size();
				for(var childrenI:number=0;childrenI<childrenLen;++childrenI)
				{
					var childrenU:UIObjectData=childrenT.get(childrenI);
					var childrenV:UIObjectData=childrenR.get(childrenI);
					if(childrenV!=null)
					{
						if(childrenU==null)
							return false;
						if(!childrenU.dataEquals(childrenV))
							return false;
					}
					else
					{
						if(childrenU!=null)
							return false;
					}
					
				}
			}
			else
			{
				if(this.children!=null)
					return false;
			}
			
			if(mData.intArgs!=null)
			{
				if(this.intArgs==null)
					return false;
				if(this.intArgs.length!=mData.intArgs.length)
					return false;
				var intArgsT:number[]=this.intArgs;
				var intArgsR:number[]=mData.intArgs;
				var intArgsLen:number=intArgsT.length;
				for(var intArgsI:number=0;intArgsI<intArgsLen;++intArgsI)
				{
					var intArgsU:number=intArgsT[intArgsI];
					var intArgsV:number=intArgsR[intArgsI];
					if(intArgsU!=intArgsV)
						return false;
					
				}
			}
			else
			{
				if(this.intArgs!=null)
					return false;
			}
			
			if(mData.strArgs!=null)
			{
				if(this.strArgs==null)
					return false;
				if(this.strArgs.length!=mData.strArgs.length)
					return false;
				var strArgsT:string[]=this.strArgs;
				var strArgsR:string[]=mData.strArgs;
				var strArgsLen:number=strArgsT.length;
				for(var strArgsI:number=0;strArgsI<strArgsLen;++strArgsI)
				{
					var strArgsU:string=strArgsT[strArgsI];
					var strArgsV:string=strArgsR[strArgsI];
					if(strArgsU!=strArgsV)
						return false;
					
				}
			}
			else
			{
				if(this.strArgs!=null)
					return false;
			}
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			writer.writeTabs();
			writer.sb.append("name");
			writer.sb.append(':');
			writer.sb.append(this.name);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("type");
			writer.sb.append(':');
			writer.sb.append(this.type);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("style");
			writer.sb.append(':');
			writer.sb.append(this.style);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("children");
			writer.sb.append(':');
			writer.sb.append("List<UIObjectData>");
			if(this.children!=null)
			{
				var childrenT:SList<UIObjectData>=this.children;
				var childrenLen:number=childrenT.size();
				writer.sb.append('(');
				writer.sb.append(childrenLen);
				writer.sb.append(')');
				writer.writeEnter();
				writer.writeLeftBrace();
				for(var childrenI:number=0;childrenI<childrenLen;++childrenI)
				{
					var childrenV:UIObjectData=childrenT.get(childrenI);
					writer.writeTabs();
					writer.sb.append(childrenI);
					writer.sb.append(':');
					if(childrenV!=null)
					{
						childrenV.writeDataString(writer);
					}
					else
					{
						writer.sb.append("UIObjectData=null");
					}
					
					writer.writeEnter();
				}
				writer.writeRightBrace();
			}
			else
			{
				writer.sb.append("=null");
			}
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("intArgs");
			writer.sb.append(':');
			writer.sb.append("Array<number>");
			if(this.intArgs!=null)
			{
				var intArgsT:number[]=this.intArgs;
				var intArgsLen:number=intArgsT.length;
				writer.sb.append('(');
				writer.sb.append(intArgsLen);
				writer.sb.append(')');
				writer.writeEnter();
				writer.writeLeftBrace();
				for(var intArgsI:number=0;intArgsI<intArgsLen;++intArgsI)
				{
					var intArgsV:number=intArgsT[intArgsI];
					writer.writeTabs();
					writer.sb.append(intArgsI);
					writer.sb.append(':');
					writer.sb.append(intArgsV);
					
					writer.writeEnter();
				}
				writer.writeRightBrace();
			}
			else
			{
				writer.sb.append("=null");
			}
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("strArgs");
			writer.sb.append(':');
			writer.sb.append("Array<string>");
			if(this.strArgs!=null)
			{
				var strArgsT:string[]=this.strArgs;
				var strArgsLen:number=strArgsT.length;
				writer.sb.append('(');
				writer.sb.append(strArgsLen);
				writer.sb.append(')');
				writer.writeEnter();
				writer.writeLeftBrace();
				for(var strArgsI:number=0;strArgsI<strArgsLen;++strArgsI)
				{
					var strArgsV:string=strArgsT[strArgsI];
					writer.writeTabs();
					writer.sb.append(strArgsI);
					writer.sb.append(':');
					writer.sb.append(strArgsV);
					
					writer.writeEnter();
				}
				writer.writeRightBrace();
			}
			else
			{
				writer.sb.append("=null");
			}
			
			writer.writeEnter();
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
