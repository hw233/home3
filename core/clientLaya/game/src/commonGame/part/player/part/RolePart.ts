namespace Shine
{
	/** 玩家(generated by shine) */
	export class RolePart extends PlayerBasePart
	{
		/** 数据 */
		private _d:RolePartData;
		
		/** 缓存角色显示数据 */
		private _selfRoleShowData:RoleShowData;
		
		protected _currenciesMax:number[];
		
		public setData(data:BaseData):void
		{
			super.setData(data);
			
			this._d=data as RolePartData;
		}
		
		/** 获取数据 */
		public getPartData():RolePartData
		{
			return this._d;
		}
		
		protected createPartData():BaseData
		{
			return new RolePartData();
		}
		
		/** 初始化(创建后刚调用,与dispose成对) */
		public init():void
		{
			
		}
		
		/** 析构(回池前调用,与init成对) */
		public dispose():void
		{
			
		}
		
		/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
		public afterReadData():void
		{
			
			//角色ID赋值
			this._selfRoleShowData=GameC.factory.createRoleShowData();
	
			this._d.currencies=ObjectUtils.ensureArrayLength(this._d.currencies,CurrencyType.size);
			this._d.currenciesMax=ObjectUtils.ensureArrayLength(this._d.currenciesMax,CurrencyType.size);
	
			this._currenciesMax=this._d.currenciesMax;
		}
		
		public afterReadDataSecond():void
		{
			this.makeRoleShowData(this._selfRoleShowData);
		}
		
		/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
		public construct():void
		{
			
		}
		
		/** 构造数据前 */
		protected beforeMakeData():void
		{
			
		}
		
		/** 功能开启(id:功能ID) */
		public onFunctionOpen(id:number):void
		{
			
		}
		
		/** 功能关闭(id:功能ID) */
		public onFunctionClose(id:number):void
		{
			
		}
		
		public getPlayerID():number
		{
			return this._d.playerID;
		}
		
		/** 账号id */
		public vocation():number
		{
			return this._d.vocation;
		}
		
		/** 等级 */
		public getSelfRoleShowData():RoleShowData
		{
			return this._selfRoleShowData;
		}
		
		/** 是否有足够货币 */
		public subCurrencyMax(type:number,value:number):void
		{
			this._currenciesMax[type]-=value;
		}
		
		/** 货币是否到达上限 */
		public addCurrency(type:number,value:number,way:number):void
		{
			if(value<=0)
				return;
	
			if(value<=0)
				return;
	
			var now:number=this._d.currencies[type];
			var max:number;
	
			if((max=this._currenciesMax[type])>0)
			{
				//达到上限
				if(now>=max)
				{
					return;
				}
	
				//本次可加值
				if(now+value>=max)
				{
					value=max-now;
				}
			}
	
			now=(this._d.currencies[type]+=value);
	
			this.toLogAddCurrency(type,value,way);
	
			this.me.dispatch(GameEventType.RefreshCurrency,type);
	
			//需要增加记录
			if(CommonSetting.isClientDriveLogic && CurrencyConfig.get(type).needAddRecord)
			{
				var v2:number=(this._d.totalAddCurrencies[type]+=value);
	
				//this.me.quest.taskEvent(TaskType.TotalAddCurrency,type,v2);
			}
			
			this.onAddCurrency(type,value);
		}
		
		/** 添加货币组 */
		public addCurrencies(list:DIntData[],way:number):void
		{
	
			for(var v of list)
			{
				this.addCurrency(v.key,v.value,way);
			}
		}
		
		/** 获取货币 */
		public getCurrency(type:number):number
		{
			return this._d.currencies[type];
		}
		
		/** 消耗货币 */
		public onRefreshCurrency(type:number,value:number):void
		{
			this._d.currencies[type] = value;
			this.me.dispatch(GameEventType.RefreshCurrency,type);
		}
		
		public getLevel():number
		{
			return this._d.level;
		}
		
		public addExp(value:number,way:number):void
		{
			if(value<=0)
				return;
	
			var level:number;
			//已达最大等级
			if((level=this._d.level) >= Global.levelMax)
			{
				return;
			}
	
			var v:number=(this._d.exp+=value);
	
			var expMax:number;
	
			if(v >= (expMax=RoleLevelConfig.get(level).expMax))
			{
				var oldLevel:number=level;
	
				while(true)
				{
					v-=expMax;
	
					if(++level == Global.levelMax)
					{
						v=0;
	
						break;
					}
	
					expMax=RoleLevelConfig.get(level).expMax;
	
					if(v<expMax)
						break;
				}
	
			//	this.onRefreshExp(v);
	
				this._d.level=level;
	
				this.me.onLevelUp(oldLevel);
			}
			else
			{
				//this.onRefreshExp(v);
			}
		}
		
		/** 刷新经验 */
		public onLevelUp(oldLevel:number):void
		{
			super.onLevelUp(oldLevel);
	
			this.me.dispatch(GameEventType.RoleLevelUp,oldLevel);
	
			//this.me.quest.taskEvent(TaskType.Level);
	
			//this.me.quest.questConditionChanged();
		}
		
		/** 刷新经验 */
		public levelUpByServer(level:number):void
		{
			var oldLevel:number = this._d.level;
			this._d.level = level;
			this.me.onLevelUp(oldLevel);
		}
		
		/** 更改名字消息 */
		public onChangeName(name:string):void
		{
			this._d.name=name;
			this.me.dispatch(GameEventType.RoleChangeName);
		}
		
		/** 添加货币日志(可复写做过滤) */
		protected toLogAddCurrency(type:number,value:number,way:number):void
		{
			//GameC.log.playerAddCurrency(this.me,type,value,way);
		}
		
		/** 消耗货币记录(可复写做过滤) */
		protected onAddCurrency(type:number,value:number):void
		{
	
		}
		
		/** 添加货币接口 */
		protected onCostCurrency(type:number,value:number):void
		{
	
		}
		
		/** 申请绑定平台 */
		public refreshPartRoleShowData(type:number,value:number,value1:string):void
		{
			var data:RoleShowChangeData=new RoleShowChangeData();
			data.type=type;
			data.arg0=value;
			data.arg1=value1;
			this.refreshPartRoleShowDataObj(data);
		}
		
		/** 刷新部分外显数据 RoleShowChangeData */
		public refreshPartRoleShowDataObj(data:RoleShowChangeData):void
		{
			// //先改自己的
			// this._selfRoleShowData.onChange(data);
	
			// var scene:Scene=GameC.scene.getScene();
	
			// //场景部分
			// Unit unit;
	
			// if(scene!=null && (unit=scene.hero)!=null)
			// {
			// 	//非社交部分
			// 	if(!RoleShowDataPartTypeConfig.get(data.type).isSocialPart)
			// 	{
			// 		RoleShowData roleShowData=unit.getUnitData().getCharacterIdentity().roleShowData;
	
			// 		roleShowData.onChange(data);
			// 	}
			// }
	
			// //社交部分
			// // me.social.refreshRoleSocialData(data);
		}
		
		/** 构造角色展示数据 */
		public makeRoleShowData(data:RoleShowData):void
		{
			data.playerID=this._d.playerID;
			data.createAreaID=this._d.createAreaID;
			data.name=this._d.name;

			data.sex=this._d.sex;
			data.level=this._d.level;
			data.vocation=this._d.vocation;
		}
		
		/** 创建角色展示数据 * */
		public createRoleShowData():RoleShowData
		{
			var data:RoleShowData=GameC.factory.createRoleShowData();
			this.makeRoleShowData(data);
			return data;
		}
		
		/** 更新战斗力(服务器) */
		public onSetFightForceBeServer(value:number):void
		{
			this._d.fightForce=value;

			this.me.dispatch(GameEventType.RefreshFightForce);
		}
		
		/** 获取战斗力 */
		public getFightForce():number
		{
			return this._d.fightForce;
		}
		
		/** 刷新经验 */
		public onRefreshExp(value:number):void
		{
			this._d.exp = value;
			this.me.dispatch(GameEventType.RefreshExp);
		}
		
		/** 是否有足够货币 */
		public hasCurrency(type:number,value:number):boolean
		{
			if(value<0)
				return false;

			return this._d.currencies[type] >= value;
		}
		
		public hasCurrencies(list:DIntData[],num:number=1):boolean
		{
			for(var i:number=0;i<list.length;i++)
			{
			
				if(!this.hasCurrency(list[i].key,list[i].value*num))
					return false;
			}

			return true;
		}
		
	}
}
