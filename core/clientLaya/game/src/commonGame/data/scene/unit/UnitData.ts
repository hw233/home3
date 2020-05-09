namespace Shine
{
	/** 单位数据(generated by shine) */
	export class UnitData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.Unit;
		
		/** 流水ID */
		public instanceID:number;
		
		/** 通用数据 */
		public normal:UnitNormalData;
		
		/** 身份数据 */
		public identity:UnitIdentityData;
		
		/** 位置数据 */
		public pos:UnitPosData;
		
		/** 移动数据 */
		public move:UnitMoveData;
		
		/** 造型数据 */
		public avatar:UnitAvatarData;
		
		/** 战斗数据 */
		public fight:UnitFightData;
		
		/** 附加战斗数据 */
		public fightEx:UnitFightExData;
		
		/** 功能数据 */
		public func:UnitFuncData;
		
		/** AI数据 */
		public ai:UnitAIData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.Unit;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UnitData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.instanceID=stream.readInt();
			
			this.identity=stream.readDataSimpleNotNull() as UnitIdentityData;
			
			this.normal=stream.readDataSimpleNotNull() as UnitNormalData;
			
			if(stream.readBoolean())
			{
				this.pos=stream.readDataSimpleNotNull() as UnitPosData;
			}
			else
			{
				this.pos=null;
			}
			
			if(stream.readBoolean())
			{
				this.avatar=stream.readDataSimpleNotNull() as UnitAvatarData;
			}
			else
			{
				this.avatar=null;
			}
			
			if(stream.readBoolean())
			{
				this.move=stream.readDataSimpleNotNull() as UnitMoveData;
			}
			else
			{
				this.move=null;
			}
			
			if(stream.readBoolean())
			{
				this.fight=stream.readDataSimpleNotNull() as UnitFightData;
			}
			else
			{
				this.fight=null;
			}
			
			if(stream.readBoolean())
			{
				this.fightEx=stream.readDataSimpleNotNull() as UnitFightExData;
			}
			else
			{
				this.fightEx=null;
			}
			
			if(stream.readBoolean())
			{
				this.ai=stream.readDataSimpleNotNull() as UnitAIData;
			}
			else
			{
				this.ai=null;
			}
			
			if(stream.readBoolean())
			{
				this.func=stream.readDataSimpleNotNull() as UnitFuncData;
			}
			else
			{
				this.func=null;
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.instanceID);
			
			stream.writeDataSimpleNotNull(this.identity);
			
			stream.writeDataSimpleNotNull(this.normal);
			
			if(this.pos!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.pos);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.avatar!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.avatar);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.move!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.move);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.fight!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.fight);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.fightEx!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.fightEx);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.ai!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.ai);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			if(this.func!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.func);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof UnitData))
				return;
			
			var mData:UnitData=data as UnitData;
			
			this.instanceID=mData.instanceID;
			this.identity=mData.identity;
			this.normal=mData.normal;
			this.pos=mData.pos;
			this.avatar=mData.avatar;
			this.move=mData.move;
			this.fight=mData.fight;
			this.fightEx=mData.fightEx;
			this.ai=mData.ai;
			this.func=mData.func;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof UnitData))
				return;
			
			var mData:UnitData=data as UnitData;
			
			this.instanceID=mData.instanceID;
			
			this.identity=mData.identity.clone() as UnitIdentityData;
			
			this.normal=mData.normal.clone() as UnitNormalData;
			
			if(mData.pos!=null)
			{
				this.pos=mData.pos.clone() as UnitPosData;
			}
			else
			{
				this.pos=null;
			}
			
			if(mData.avatar!=null)
			{
				this.avatar=mData.avatar.clone() as UnitAvatarData;
			}
			else
			{
				this.avatar=null;
			}
			
			if(mData.move!=null)
			{
				this.move=mData.move.clone() as UnitMoveData;
			}
			else
			{
				this.move=null;
			}
			
			if(mData.fight!=null)
			{
				this.fight=mData.fight.clone() as UnitFightData;
			}
			else
			{
				this.fight=null;
			}
			
			if(mData.fightEx!=null)
			{
				this.fightEx=mData.fightEx.clone() as UnitFightExData;
			}
			else
			{
				this.fightEx=null;
			}
			
			if(mData.ai!=null)
			{
				this.ai=mData.ai.clone() as UnitAIData;
			}
			else
			{
				this.ai=null;
			}
			
			if(mData.func!=null)
			{
				this.func=mData.func.clone() as UnitFuncData;
			}
			else
			{
				this.func=null;
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.identity=new UnitIdentityData();
			this.identity.initDefault();
			this.normal=new UnitNormalData();
			this.normal.initDefault();
		}
		
	}
}
