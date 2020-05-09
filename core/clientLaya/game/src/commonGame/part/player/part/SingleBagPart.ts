namespace Shine
{
	/** (generated by shine) */
	export class SingleBagPart extends BagPart
	{
		/** 数据 */
		private _sd:SingleBagPartData;
		
		/** 主背包 */
		private _mainBag:BaseItemContainerTool;
		
		public setData(data:BaseData):void
		{
			super.setData(data);
			
			this._sd=data as SingleBagPartData;
		}
		
		/** 获取数据 */
		public getPartData():SingleBagPartData
		{
			return this._sd;
		}
		
		protected createPartData():BaseData
		{
			return new SingleBagPartData();
		}
		
		/** 初始化(创建后刚调用,与dispose成对) */
		public init():void
		{
			super.init();
			
		}
		
		/** 析构(回池前调用,与init成对) */
		public dispose():void
		{
			super.dispose();
			
		}
		
		/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
		public afterReadData():void
		{
			super.afterReadData();
			
		}
		
		/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
		public construct():void
		{
			super.construct();
			
			if(CommonSetting.useDicBag)
			{
				this._mainBag=new PlayerItemDicContainerTool(FunctionType.MainBag);
			}
			else
			{
				Ctrl.errorLog("ts端暂不支持有格背包")
				//this._mainBag=new PlayerItemContainerTool(FunctionType.MainBag);
			}

			this.me.func.registFuncTool((this._mainBag as Object) as IPlayerFuncTool);
		}
		
		/** 构造数据前 */
		protected beforeMakeData():void
		{
			super.beforeMakeData();
			
		}
		
		/** 功能开启(id:功能ID) */
		public onFunctionOpen(id:number):void
		{
			super.onFunctionOpen(id);
			
		}
		
		/** 功能关闭(id:功能ID) */
		public onFunctionClose(id:number):void
		{
			super.onFunctionClose(id);
			
		}
		
		/** 获取主容器 */
		public getContainer():BaseItemContainerTool
		{
			return this._mainBag;
		}
		
		public getItem(index:number):ItemData
		{
			return this._mainBag.getItem(index);
		}
		
		public getIdItem(id:number):ItemData
		{
			return this._mainBag.getItemByID(id);
		}
		
		public hasFreeGrid(num:number):boolean
		{
			return this._mainBag.hasFreeGrid(num);
		}
		
		public hasItemPlaceData(data:ItemData):boolean
		{
			return this._mainBag.hasItemPlace(data);
		}
		
		public hasItemPlace(id:number,num:number):boolean
		{
			return this._mainBag.hasItemPlaceId(id,num);
		}
		
		public hasItemPlaceList(list:SList<ItemData>):boolean
		{
			return this._mainBag.hasItemPlaceList(list);
		}
		
		public getItemNum(itemID:number):number
		{
			return this._mainBag.getItemNum(itemID);
		}
		
		protected toAddItem(data:ItemData,way:number):boolean
		{
			return this._mainBag.addItemData(data,way);
		}
		
		protected toAddItemId(id:number,num:number,way:number):boolean
		{
			return this._mainBag.addItem(id,num,way);
		}
		
		protected toAddItemsList(list:SList<ItemData>,way:number):boolean
		{
			return this._mainBag.addItemsList(list,way);
		}
		
		protected toAddItems(list:DIntData[],way:number):boolean
		{
			return this._mainBag.addItems(list,way);
		}
		
		public containsItem(id:number,num:number):boolean
		{
			return this._mainBag.containsItemNum(id,num);
		}
		
		public removeItem(id:number,way:number):boolean
		{
			return this._mainBag.removeItem(id,1,way);
		}
		
		public removeItemByIndexAll(index:number,way:number):boolean
		{
			return this._mainBag.removeItemByIndexAll(index,way);
		}
		
		public removeItemByIndex(index:number,way:number):boolean
		{
			return this._mainBag.removeItemByIndex(index,1,way);
		}
		
		public cleanUp():void
		{
			if(!CommonSetting.useDicBag)
			{
				//(this._mainBag as (PlayerItemContainerTool)).cleanUp();
			}
		}
		
		public printBag():void
		{
			this._mainBag.printBag();
		}
		
		public useItemByID(id:number,arg:UseItemArgData):boolean
		{
			return this._mainBag.useItemByID(id,arg);
		}
		
		public useItemByIndex(index:number,arg:UseItemArgData):boolean
		{
			return this._mainBag.useItemByIndex(index,1,arg);
		}
		
		public useItemByIndexNum(index:number,num:number,arg:UseItemArgData):boolean
		{
			return this._mainBag.useItemByIndex(index,num,arg);
		}
		
		public getRedPointCount():number
		{
			return this._mainBag.getRedPointCount();
		}
		
		public removeRedPoint(index:number):void
		{
			this._mainBag.removeRedPoint(index);
		}
		
		public sellItem(index:number,num:number,itemID:number):boolean
		{
			var data:ItemData;
			
			if((data=this.getItem(index))==null)
				return false;
			
			if(data.id!=itemID)
				return false;
			
			if(this.removeItemByIndexNum(index,num,CallWayType.SellItem))
			{
				this.me.role.addCurrency(CurrencyType.Coin,data.config.sellPrice*num,CallWayType.SellItem);
				return true;
			}
			
			return false;
		}
		
	}
}
