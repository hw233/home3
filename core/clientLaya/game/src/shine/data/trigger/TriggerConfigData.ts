namespace Shine
{
	/** 单个trigger数据(generated by shine) */
	export class TriggerConfigData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=ShineDataType.TriggerConfig;
		
		/** id */
		public id:number;
		
		/** 名字 */
		public name:string;
		
		/** 组类型 */
		public groupType:number;
		
		/** 组ID */
		public groupID:number;
		
		/** 是否开启 */
		public isOpen:boolean;
		
		/** 事件优先级(默认0) */
		public priority:number;
		
		/** 事件组 */
		public events:TriggerFuncData[];
		
		/** 环境组 */
		public conditions:TriggerFuncData[];
		
		/** 动作组 */
		public actions:TriggerFuncData[];
		
		constructor()
		{
			super();
			this._dataID=ShineDataType.TriggerConfig;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "TriggerConfigData";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			this.id=stream.readInt();
			
			this.name=stream.readUTF();
			
			this.groupType=stream.readInt();
			
			this.groupID=stream.readInt();
			
			this.isOpen=stream.readBoolean();
			
			this.priority=stream.readInt();
			
			var eventsLen:number=stream.readLen();
			this.events=new Array<TriggerFuncData>(eventsLen);
			var eventsT:TriggerFuncData[]=this.events;
			for(var eventsI:number=0;eventsI<eventsLen;++eventsI)
			{
				var eventsV:TriggerFuncData;
				eventsV=stream.readDataFullNotNull() as TriggerFuncData;
				
				eventsT[eventsI]=eventsV;
			}
			
			var conditionsLen:number=stream.readLen();
			this.conditions=new Array<TriggerFuncData>(conditionsLen);
			var conditionsT:TriggerFuncData[]=this.conditions;
			for(var conditionsI:number=0;conditionsI<conditionsLen;++conditionsI)
			{
				var conditionsV:TriggerFuncData;
				conditionsV=stream.readDataFullNotNull() as TriggerFuncData;
				
				conditionsT[conditionsI]=conditionsV;
			}
			
			var actionsLen:number=stream.readLen();
			this.actions=new Array<TriggerFuncData>(actionsLen);
			var actionsT:TriggerFuncData[]=this.actions;
			for(var actionsI:number=0;actionsI<actionsLen;++actionsI)
			{
				var actionsV:TriggerFuncData;
				actionsV=stream.readDataFullNotNull() as TriggerFuncData;
				
				actionsT[actionsI]=actionsV;
			}
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeInt(this.id);
			
			stream.writeUTF(this.name);
			
			stream.writeInt(this.groupType);
			
			stream.writeInt(this.groupID);
			
			stream.writeBoolean(this.isOpen);
			
			stream.writeInt(this.priority);
			
			var eventsT:TriggerFuncData[]=this.events;
			stream.writeLen(eventsT.length);
			for(var eventsVI=0,eventsVLen=eventsT.length;eventsVI<eventsVLen;++eventsVI)
			{
				var eventsV:TriggerFuncData=eventsT[eventsVI];
				stream.writeDataFullNotNull(eventsV);
				
			}
			
			var conditionsT:TriggerFuncData[]=this.conditions;
			stream.writeLen(conditionsT.length);
			for(var conditionsVI=0,conditionsVLen=conditionsT.length;conditionsVI<conditionsVLen;++conditionsVI)
			{
				var conditionsV:TriggerFuncData=conditionsT[conditionsVI];
				stream.writeDataFullNotNull(conditionsV);
				
			}
			
			var actionsT:TriggerFuncData[]=this.actions;
			stream.writeLen(actionsT.length);
			for(var actionsVI=0,actionsVLen=actionsT.length;actionsVI<actionsVLen;++actionsVI)
			{
				var actionsV:TriggerFuncData=actionsT[actionsVI];
				stream.writeDataFullNotNull(actionsV);
				
			}
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.id=stream.readInt();
			
			this.name=stream.readUTF();
			
			this.groupType=stream.readInt();
			
			this.groupID=stream.readInt();
			
			this.isOpen=stream.readBoolean();
			
			this.priority=stream.readInt();
			
			var eventsLen:number=stream.readLen();
			this.events=new Array<TriggerFuncData>(eventsLen);
			var eventsT:TriggerFuncData[]=this.events;
			for(var eventsI:number=0;eventsI<eventsLen;++eventsI)
			{
				var eventsV:TriggerFuncData;
				eventsV=stream.readDataSimpleNotNull() as TriggerFuncData;
				
				eventsT[eventsI]=eventsV;
			}
			
			var conditionsLen:number=stream.readLen();
			this.conditions=new Array<TriggerFuncData>(conditionsLen);
			var conditionsT:TriggerFuncData[]=this.conditions;
			for(var conditionsI:number=0;conditionsI<conditionsLen;++conditionsI)
			{
				var conditionsV:TriggerFuncData;
				conditionsV=stream.readDataSimpleNotNull() as TriggerFuncData;
				
				conditionsT[conditionsI]=conditionsV;
			}
			
			var actionsLen:number=stream.readLen();
			this.actions=new Array<TriggerFuncData>(actionsLen);
			var actionsT:TriggerFuncData[]=this.actions;
			for(var actionsI:number=0;actionsI<actionsLen;++actionsI)
			{
				var actionsV:TriggerFuncData;
				actionsV=stream.readDataSimpleNotNull() as TriggerFuncData;
				
				actionsT[actionsI]=actionsV;
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.id);
			
			stream.writeUTF(this.name);
			
			stream.writeInt(this.groupType);
			
			stream.writeInt(this.groupID);
			
			stream.writeBoolean(this.isOpen);
			
			stream.writeInt(this.priority);
			
			var eventsT:TriggerFuncData[]=this.events;
			stream.writeLen(eventsT.length);
			for(var eventsVI=0,eventsVLen=eventsT.length;eventsVI<eventsVLen;++eventsVI)
			{
				var eventsV:TriggerFuncData=eventsT[eventsVI];
				stream.writeDataSimpleNotNull(eventsV);
				
			}
			
			var conditionsT:TriggerFuncData[]=this.conditions;
			stream.writeLen(conditionsT.length);
			for(var conditionsVI=0,conditionsVLen=conditionsT.length;conditionsVI<conditionsVLen;++conditionsVI)
			{
				var conditionsV:TriggerFuncData=conditionsT[conditionsVI];
				stream.writeDataSimpleNotNull(conditionsV);
				
			}
			
			var actionsT:TriggerFuncData[]=this.actions;
			stream.writeLen(actionsT.length);
			for(var actionsVI=0,actionsVLen=actionsT.length;actionsVI<actionsVLen;++actionsVI)
			{
				var actionsV:TriggerFuncData=actionsT[actionsVI];
				stream.writeDataSimpleNotNull(actionsV);
				
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof TriggerConfigData))
				return;
			
			var mData:TriggerConfigData=data as TriggerConfigData;
			
			this.id=mData.id;
			this.name=mData.name;
			this.groupType=mData.groupType;
			this.groupID=mData.groupID;
			this.isOpen=mData.isOpen;
			this.priority=mData.priority;
			this.events=mData.events;
			this.conditions=mData.conditions;
			this.actions=mData.actions;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof TriggerConfigData))
				return;
			
			var mData:TriggerConfigData=data as TriggerConfigData;
			
			this.id=mData.id;
			
			this.name=mData.name;
			
			this.groupType=mData.groupType;
			
			this.groupID=mData.groupID;
			
			this.isOpen=mData.isOpen;
			
			this.priority=mData.priority;
			
			var eventsR:TriggerFuncData[]=mData.events;
			var eventsLen:number=eventsR.length;
			this.events=new Array<TriggerFuncData>(eventsLen);
			var eventsT:TriggerFuncData[]=this.events;
			for(var eventsI:number=0;eventsI<eventsLen;++eventsI)
			{
				var eventsV:TriggerFuncData=eventsR[eventsI];
				var eventsU:TriggerFuncData;
				eventsU=eventsV.clone() as TriggerFuncData;
				
				eventsT[eventsI]=eventsU;
			}
			
			var conditionsR:TriggerFuncData[]=mData.conditions;
			var conditionsLen:number=conditionsR.length;
			this.conditions=new Array<TriggerFuncData>(conditionsLen);
			var conditionsT:TriggerFuncData[]=this.conditions;
			for(var conditionsI:number=0;conditionsI<conditionsLen;++conditionsI)
			{
				var conditionsV:TriggerFuncData=conditionsR[conditionsI];
				var conditionsU:TriggerFuncData;
				conditionsU=conditionsV.clone() as TriggerFuncData;
				
				conditionsT[conditionsI]=conditionsU;
			}
			
			var actionsR:TriggerFuncData[]=mData.actions;
			var actionsLen:number=actionsR.length;
			this.actions=new Array<TriggerFuncData>(actionsLen);
			var actionsT:TriggerFuncData[]=this.actions;
			for(var actionsI:number=0;actionsI<actionsLen;++actionsI)
			{
				var actionsV:TriggerFuncData=actionsR[actionsI];
				var actionsU:TriggerFuncData;
				actionsU=actionsV.clone() as TriggerFuncData;
				
				actionsT[actionsI]=actionsU;
			}
			
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			var mData:TriggerConfigData=data as TriggerConfigData;
			if(this.id!=mData.id)
				return false;
			
			if(this.name!=mData.name)
				return false;
			
			if(this.groupType!=mData.groupType)
				return false;
			
			if(this.groupID!=mData.groupID)
				return false;
			
			if(this.isOpen!=mData.isOpen)
				return false;
			
			if(this.priority!=mData.priority)
				return false;
			
			if(this.events==null)
				return false;
			if(this.events.length!=mData.events.length)
				return false;
			var eventsT:TriggerFuncData[]=this.events;
			var eventsR:TriggerFuncData[]=mData.events;
			var eventsLen:number=eventsT.length;
			for(var eventsI:number=0;eventsI<eventsLen;++eventsI)
			{
				var eventsU:TriggerFuncData=eventsT[eventsI];
				var eventsV:TriggerFuncData=eventsR[eventsI];
				if(eventsU==null)
					return false;
				if(!eventsU.dataEquals(eventsV))
					return false;
				
			}
			
			if(this.conditions==null)
				return false;
			if(this.conditions.length!=mData.conditions.length)
				return false;
			var conditionsT:TriggerFuncData[]=this.conditions;
			var conditionsR:TriggerFuncData[]=mData.conditions;
			var conditionsLen:number=conditionsT.length;
			for(var conditionsI:number=0;conditionsI<conditionsLen;++conditionsI)
			{
				var conditionsU:TriggerFuncData=conditionsT[conditionsI];
				var conditionsV:TriggerFuncData=conditionsR[conditionsI];
				if(conditionsU==null)
					return false;
				if(!conditionsU.dataEquals(conditionsV))
					return false;
				
			}
			
			if(this.actions==null)
				return false;
			if(this.actions.length!=mData.actions.length)
				return false;
			var actionsT:TriggerFuncData[]=this.actions;
			var actionsR:TriggerFuncData[]=mData.actions;
			var actionsLen:number=actionsT.length;
			for(var actionsI:number=0;actionsI<actionsLen;++actionsI)
			{
				var actionsU:TriggerFuncData=actionsT[actionsI];
				var actionsV:TriggerFuncData=actionsR[actionsI];
				if(actionsU==null)
					return false;
				if(!actionsU.dataEquals(actionsV))
					return false;
				
			}
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			writer.writeTabs();
			writer.sb.append("id");
			writer.sb.append(':');
			writer.sb.append(this.id);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("name");
			writer.sb.append(':');
			writer.sb.append(this.name);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("groupType");
			writer.sb.append(':');
			writer.sb.append(this.groupType);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("groupID");
			writer.sb.append(':');
			writer.sb.append(this.groupID);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("isOpen");
			writer.sb.append(':');
			writer.sb.append(this.isOpen);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("priority");
			writer.sb.append(':');
			writer.sb.append(this.priority);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("events");
			writer.sb.append(':');
			writer.sb.append("Array<TriggerFuncData>");
			var eventsT:TriggerFuncData[]=this.events;
			var eventsLen:number=eventsT.length;
			writer.sb.append('(');
			writer.sb.append(eventsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(var eventsI:number=0;eventsI<eventsLen;++eventsI)
			{
				var eventsV:TriggerFuncData=eventsT[eventsI];
				writer.writeTabs();
				writer.sb.append(eventsI);
				writer.sb.append(':');
				eventsV.writeDataString(writer);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("conditions");
			writer.sb.append(':');
			writer.sb.append("Array<TriggerFuncData>");
			var conditionsT:TriggerFuncData[]=this.conditions;
			var conditionsLen:number=conditionsT.length;
			writer.sb.append('(');
			writer.sb.append(conditionsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(var conditionsI:number=0;conditionsI<conditionsLen;++conditionsI)
			{
				var conditionsV:TriggerFuncData=conditionsT[conditionsI];
				writer.writeTabs();
				writer.sb.append(conditionsI);
				writer.sb.append(':');
				conditionsV.writeDataString(writer);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("actions");
			writer.sb.append(':');
			writer.sb.append("Array<TriggerFuncData>");
			var actionsT:TriggerFuncData[]=this.actions;
			var actionsLen:number=actionsT.length;
			writer.sb.append('(');
			writer.sb.append(actionsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(var actionsI:number=0;actionsI<actionsLen;++actionsI)
			{
				var actionsV:TriggerFuncData=actionsT[actionsI];
				writer.writeTabs();
				writer.sb.append(actionsI);
				writer.sb.append(':');
				actionsV.writeDataString(writer);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.events=new Array<TriggerFuncData>(0);
			this.conditions=new Array<TriggerFuncData>(0);
			this.actions=new Array<TriggerFuncData>(0);
		}
		
	}
}
