namespace Shine
{
	/** (generated by shine) */
	export class RolePartData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=PlayerPartDataType.Role;
		
		/** 角色ID */
		public playerID:number;
		
		/** 名字 */
		public name:string;
		
		/** 用户ID */
		public userID:number;
		
		/** 用户UID */
		public uid:string;
		
		/** 原区ID */
		public createAreaID:number;
		
		/** 平台 */
		public platform:string;
		
		/** 是否成人 */
		public isAdult:boolean;
		
		/** 性别 */
		public sex:number;
		
		/** 职业 */
		public vocation:number;
		
		/** 等级 */
		public level:number;
		
		/** 经验 */
		public exp:number;
		
		/** 货币组(货币) */
		public currencies:number[];
		
		/** 货币上限组 */
		public currenciesMax:number[];
		
		/** 当前战斗力 */
		public fightForce:number;
		
		/** 累计获得货币组(货币),累计消耗通过累计增加减去当前货币 */
		public totalAddCurrencies:number[];
		
		constructor()
		{
			super();
			this._dataID=PlayerPartDataType.Role;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RolePartData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.playerID=stream.readLong();
			
			this.name=stream.readUTF();
			
			this.userID=stream.readLong();
			
			this.uid=stream.readUTF();
			
			this.createAreaID=stream.readInt();
			
			this.platform=stream.readUTF();
			
			this.isAdult=stream.readBoolean();
			
			this.sex=stream.readInt();
			
			this.vocation=stream.readInt();
			
			this.level=stream.readInt();
			
			this.exp=stream.readLong();
			
			var currenciesLen:number=stream.readLen();
			this.currencies=new Array<number>(currenciesLen);
			var currenciesT:number[]=this.currencies;
			for(var currenciesI:number=0;currenciesI<currenciesLen;++currenciesI)
			{
				var currenciesV:number;
				currenciesV=stream.readLong();
				
				currenciesT[currenciesI]=currenciesV;
			}
			
			var currenciesMaxLen:number=stream.readLen();
			this.currenciesMax=new Array<number>(currenciesMaxLen);
			var currenciesMaxT:number[]=this.currenciesMax;
			for(var currenciesMaxI:number=0;currenciesMaxI<currenciesMaxLen;++currenciesMaxI)
			{
				var currenciesMaxV:number;
				currenciesMaxV=stream.readLong();
				
				currenciesMaxT[currenciesMaxI]=currenciesMaxV;
			}
			
			var totalAddCurrenciesLen:number=stream.readLen();
			this.totalAddCurrencies=new Array<number>(totalAddCurrenciesLen);
			var totalAddCurrenciesT:number[]=this.totalAddCurrencies;
			for(var totalAddCurrenciesI:number=0;totalAddCurrenciesI<totalAddCurrenciesLen;++totalAddCurrenciesI)
			{
				var totalAddCurrenciesV:number;
				totalAddCurrenciesV=stream.readLong();
				
				totalAddCurrenciesT[totalAddCurrenciesI]=totalAddCurrenciesV;
			}
			
			this.fightForce=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.playerID);
			
			stream.writeUTF(this.name);
			
			stream.writeLong(this.userID);
			
			stream.writeUTF(this.uid);
			
			stream.writeInt(this.createAreaID);
			
			stream.writeUTF(this.platform);
			
			stream.writeBoolean(this.isAdult);
			
			stream.writeInt(this.sex);
			
			stream.writeInt(this.vocation);
			
			stream.writeInt(this.level);
			
			stream.writeLong(this.exp);
			
			var currenciesT:number[]=this.currencies;
			stream.writeLen(currenciesT.length);
			for(var currenciesVI=0,currenciesVLen=currenciesT.length;currenciesVI<currenciesVLen;++currenciesVI)
			{
				var currenciesV:number=currenciesT[currenciesVI];
				stream.writeLong(currenciesV);
				
			}
			
			var currenciesMaxT:number[]=this.currenciesMax;
			stream.writeLen(currenciesMaxT.length);
			for(var currenciesMaxVI=0,currenciesMaxVLen=currenciesMaxT.length;currenciesMaxVI<currenciesMaxVLen;++currenciesMaxVI)
			{
				var currenciesMaxV:number=currenciesMaxT[currenciesMaxVI];
				stream.writeLong(currenciesMaxV);
				
			}
			
			var totalAddCurrenciesT:number[]=this.totalAddCurrencies;
			stream.writeLen(totalAddCurrenciesT.length);
			for(var totalAddCurrenciesVI=0,totalAddCurrenciesVLen=totalAddCurrenciesT.length;totalAddCurrenciesVI<totalAddCurrenciesVLen;++totalAddCurrenciesVI)
			{
				var totalAddCurrenciesV:number=totalAddCurrenciesT[totalAddCurrenciesVI];
				stream.writeLong(totalAddCurrenciesV);
				
			}
			
			stream.writeLong(this.fightForce);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof RolePartData))
				return;
			
			var mData:RolePartData=data as RolePartData;
			
			this.playerID=mData.playerID;
			this.name=mData.name;
			this.userID=mData.userID;
			this.uid=mData.uid;
			this.createAreaID=mData.createAreaID;
			this.platform=mData.platform;
			this.isAdult=mData.isAdult;
			this.sex=mData.sex;
			this.vocation=mData.vocation;
			this.level=mData.level;
			this.exp=mData.exp;
			this.currencies=mData.currencies;
			this.currenciesMax=mData.currenciesMax;
			this.totalAddCurrencies=mData.totalAddCurrencies;
			this.fightForce=mData.fightForce;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof RolePartData))
				return;
			
			var mData:RolePartData=data as RolePartData;
			
			this.playerID=mData.playerID;
			
			this.name=mData.name;
			
			this.userID=mData.userID;
			
			this.uid=mData.uid;
			
			this.createAreaID=mData.createAreaID;
			
			this.platform=mData.platform;
			
			this.isAdult=mData.isAdult;
			
			this.sex=mData.sex;
			
			this.vocation=mData.vocation;
			
			this.level=mData.level;
			
			this.exp=mData.exp;
			
			var currenciesR:number[]=mData.currencies;
			var currenciesLen:number=currenciesR.length;
			this.currencies=new Array<number>(currenciesLen);
			var currenciesT:number[]=this.currencies;
			for(var currenciesI:number=0;currenciesI<currenciesLen;++currenciesI)
			{
				var currenciesV:number=currenciesR[currenciesI];
				var currenciesU:number;
				currenciesU=currenciesV;
				
				currenciesT[currenciesI]=currenciesU;
			}
			
			var currenciesMaxR:number[]=mData.currenciesMax;
			var currenciesMaxLen:number=currenciesMaxR.length;
			this.currenciesMax=new Array<number>(currenciesMaxLen);
			var currenciesMaxT:number[]=this.currenciesMax;
			for(var currenciesMaxI:number=0;currenciesMaxI<currenciesMaxLen;++currenciesMaxI)
			{
				var currenciesMaxV:number=currenciesMaxR[currenciesMaxI];
				var currenciesMaxU:number;
				currenciesMaxU=currenciesMaxV;
				
				currenciesMaxT[currenciesMaxI]=currenciesMaxU;
			}
			
			var totalAddCurrenciesR:number[]=mData.totalAddCurrencies;
			var totalAddCurrenciesLen:number=totalAddCurrenciesR.length;
			this.totalAddCurrencies=new Array<number>(totalAddCurrenciesLen);
			var totalAddCurrenciesT:number[]=this.totalAddCurrencies;
			for(var totalAddCurrenciesI:number=0;totalAddCurrenciesI<totalAddCurrenciesLen;++totalAddCurrenciesI)
			{
				var totalAddCurrenciesV:number=totalAddCurrenciesR[totalAddCurrenciesI];
				var totalAddCurrenciesU:number;
				totalAddCurrenciesU=totalAddCurrenciesV;
				
				totalAddCurrenciesT[totalAddCurrenciesI]=totalAddCurrenciesU;
			}
			
			this.fightForce=mData.fightForce;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.currencies=new Array<number>(0);
			this.currenciesMax=new Array<number>(0);
			this.totalAddCurrencies=new Array<number>(0);
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			this.playerID=stream.readLong();
			
			this.name=stream.readUTF();
			
			this.userID=stream.readLong();
			
			this.uid=stream.readUTF();
			
			this.createAreaID=stream.readInt();
			
			this.platform=stream.readUTF();
			
			this.isAdult=stream.readBoolean();
			
			this.sex=stream.readInt();
			
			this.vocation=stream.readInt();
			
			this.level=stream.readInt();
			
			this.exp=stream.readLong();
			
			var currenciesLen:number=stream.readLen();
			this.currencies=new Array<number>(currenciesLen);
			var currenciesT:number[]=this.currencies;
			for(var currenciesI:number=0;currenciesI<currenciesLen;++currenciesI)
			{
				var currenciesV:number;
				currenciesV=stream.readLong();
				
				currenciesT[currenciesI]=currenciesV;
			}
			
			var currenciesMaxLen:number=stream.readLen();
			this.currenciesMax=new Array<number>(currenciesMaxLen);
			var currenciesMaxT:number[]=this.currenciesMax;
			for(var currenciesMaxI:number=0;currenciesMaxI<currenciesMaxLen;++currenciesMaxI)
			{
				var currenciesMaxV:number;
				currenciesMaxV=stream.readLong();
				
				currenciesMaxT[currenciesMaxI]=currenciesMaxV;
			}
			
			var totalAddCurrenciesLen:number=stream.readLen();
			this.totalAddCurrencies=new Array<number>(totalAddCurrenciesLen);
			var totalAddCurrenciesT:number[]=this.totalAddCurrencies;
			for(var totalAddCurrenciesI:number=0;totalAddCurrenciesI<totalAddCurrenciesLen;++totalAddCurrenciesI)
			{
				var totalAddCurrenciesV:number;
				totalAddCurrenciesV=stream.readLong();
				
				totalAddCurrenciesT[totalAddCurrenciesI]=totalAddCurrenciesV;
			}
			
			this.fightForce=stream.readLong();
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeLong(this.playerID);
			
			stream.writeUTF(this.name);
			
			stream.writeLong(this.userID);
			
			stream.writeUTF(this.uid);
			
			stream.writeInt(this.createAreaID);
			
			stream.writeUTF(this.platform);
			
			stream.writeBoolean(this.isAdult);
			
			stream.writeInt(this.sex);
			
			stream.writeInt(this.vocation);
			
			stream.writeInt(this.level);
			
			stream.writeLong(this.exp);
			
			var currenciesT:number[]=this.currencies;
			stream.writeLen(currenciesT.length);
			for(var currenciesVI=0,currenciesVLen=currenciesT.length;currenciesVI<currenciesVLen;++currenciesVI)
			{
				var currenciesV:number=currenciesT[currenciesVI];
				stream.writeLong(currenciesV);
				
			}
			
			var currenciesMaxT:number[]=this.currenciesMax;
			stream.writeLen(currenciesMaxT.length);
			for(var currenciesMaxVI=0,currenciesMaxVLen=currenciesMaxT.length;currenciesMaxVI<currenciesMaxVLen;++currenciesMaxVI)
			{
				var currenciesMaxV:number=currenciesMaxT[currenciesMaxVI];
				stream.writeLong(currenciesMaxV);
				
			}
			
			var totalAddCurrenciesT:number[]=this.totalAddCurrencies;
			stream.writeLen(totalAddCurrenciesT.length);
			for(var totalAddCurrenciesVI=0,totalAddCurrenciesVLen=totalAddCurrenciesT.length;totalAddCurrenciesVI<totalAddCurrenciesVLen;++totalAddCurrenciesVI)
			{
				var totalAddCurrenciesV:number=totalAddCurrenciesT[totalAddCurrenciesVI];
				stream.writeLong(totalAddCurrenciesV);
				
			}
			
			stream.writeLong(this.fightForce);
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			var mData:RolePartData=data as RolePartData;
			if(this.playerID!=mData.playerID)
				return false;
			
			if(this.name!=mData.name)
				return false;
			
			if(this.userID!=mData.userID)
				return false;
			
			if(this.uid!=mData.uid)
				return false;
			
			if(this.createAreaID!=mData.createAreaID)
				return false;
			
			if(this.platform!=mData.platform)
				return false;
			
			if(this.isAdult!=mData.isAdult)
				return false;
			
			if(this.sex!=mData.sex)
				return false;
			
			if(this.vocation!=mData.vocation)
				return false;
			
			if(this.level!=mData.level)
				return false;
			
			if(this.exp!=mData.exp)
				return false;
			
			if(this.currencies==null)
				return false;
			if(this.currencies.length!=mData.currencies.length)
				return false;
			var currenciesT:number[]=this.currencies;
			var currenciesR:number[]=mData.currencies;
			var currenciesLen:number=currenciesT.length;
			for(var currenciesI:number=0;currenciesI<currenciesLen;++currenciesI)
			{
				var currenciesU:number=currenciesT[currenciesI];
				var currenciesV:number=currenciesR[currenciesI];
				if(currenciesU!=currenciesV)
					return false;
				
			}
			
			if(this.currenciesMax==null)
				return false;
			if(this.currenciesMax.length!=mData.currenciesMax.length)
				return false;
			var currenciesMaxT:number[]=this.currenciesMax;
			var currenciesMaxR:number[]=mData.currenciesMax;
			var currenciesMaxLen:number=currenciesMaxT.length;
			for(var currenciesMaxI:number=0;currenciesMaxI<currenciesMaxLen;++currenciesMaxI)
			{
				var currenciesMaxU:number=currenciesMaxT[currenciesMaxI];
				var currenciesMaxV:number=currenciesMaxR[currenciesMaxI];
				if(currenciesMaxU!=currenciesMaxV)
					return false;
				
			}
			
			if(this.totalAddCurrencies==null)
				return false;
			if(this.totalAddCurrencies.length!=mData.totalAddCurrencies.length)
				return false;
			var totalAddCurrenciesT:number[]=this.totalAddCurrencies;
			var totalAddCurrenciesR:number[]=mData.totalAddCurrencies;
			var totalAddCurrenciesLen:number=totalAddCurrenciesT.length;
			for(var totalAddCurrenciesI:number=0;totalAddCurrenciesI<totalAddCurrenciesLen;++totalAddCurrenciesI)
			{
				var totalAddCurrenciesU:number=totalAddCurrenciesT[totalAddCurrenciesI];
				var totalAddCurrenciesV:number=totalAddCurrenciesR[totalAddCurrenciesI];
				if(totalAddCurrenciesU!=totalAddCurrenciesV)
					return false;
				
			}
			
			if(this.fightForce!=mData.fightForce)
				return false;
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			writer.writeTabs();
			writer.sb.append("playerID");
			writer.sb.append(':');
			writer.sb.append(this.playerID);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("name");
			writer.sb.append(':');
			writer.sb.append(this.name);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("userID");
			writer.sb.append(':');
			writer.sb.append(this.userID);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("uid");
			writer.sb.append(':');
			writer.sb.append(this.uid);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("createAreaID");
			writer.sb.append(':');
			writer.sb.append(this.createAreaID);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("platform");
			writer.sb.append(':');
			writer.sb.append(this.platform);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("isAdult");
			writer.sb.append(':');
			writer.sb.append(this.isAdult);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("sex");
			writer.sb.append(':');
			writer.sb.append(this.sex);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("vocation");
			writer.sb.append(':');
			writer.sb.append(this.vocation);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("level");
			writer.sb.append(':');
			writer.sb.append(this.level);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("exp");
			writer.sb.append(':');
			writer.sb.append(this.exp);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("currencies");
			writer.sb.append(':');
			writer.sb.append("Array<number>");
			var currenciesT:number[]=this.currencies;
			var currenciesLen:number=currenciesT.length;
			writer.sb.append('(');
			writer.sb.append(currenciesLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(var currenciesI:number=0;currenciesI<currenciesLen;++currenciesI)
			{
				var currenciesV:number=currenciesT[currenciesI];
				writer.writeTabs();
				writer.sb.append(currenciesI);
				writer.sb.append(':');
				writer.sb.append(currenciesV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("currenciesMax");
			writer.sb.append(':');
			writer.sb.append("Array<number>");
			var currenciesMaxT:number[]=this.currenciesMax;
			var currenciesMaxLen:number=currenciesMaxT.length;
			writer.sb.append('(');
			writer.sb.append(currenciesMaxLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(var currenciesMaxI:number=0;currenciesMaxI<currenciesMaxLen;++currenciesMaxI)
			{
				var currenciesMaxV:number=currenciesMaxT[currenciesMaxI];
				writer.writeTabs();
				writer.sb.append(currenciesMaxI);
				writer.sb.append(':');
				writer.sb.append(currenciesMaxV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("totalAddCurrencies");
			writer.sb.append(':');
			writer.sb.append("Array<number>");
			var totalAddCurrenciesT:number[]=this.totalAddCurrencies;
			var totalAddCurrenciesLen:number=totalAddCurrenciesT.length;
			writer.sb.append('(');
			writer.sb.append(totalAddCurrenciesLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(var totalAddCurrenciesI:number=0;totalAddCurrenciesI<totalAddCurrenciesLen;++totalAddCurrenciesI)
			{
				var totalAddCurrenciesV:number=totalAddCurrenciesT[totalAddCurrenciesI];
				writer.writeTabs();
				writer.sb.append(totalAddCurrenciesI);
				writer.sb.append(':');
				writer.sb.append(totalAddCurrenciesV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("fightForce");
			writer.sb.append(':');
			writer.sb.append(this.fightForce);
			
			writer.writeEnter();
		}
		
	}
}
